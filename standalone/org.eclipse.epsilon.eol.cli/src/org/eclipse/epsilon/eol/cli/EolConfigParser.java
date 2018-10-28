/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.cli;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.cli.Option;
import org.eclipse.epsilon.common.cli.ConfigParser;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;

/**
 * A default config getter which effectively allows main method inheritance.
 * Uses reflection to find appropriate constructors and module interface to pass to parseModule method.
 * Please note: The constructors of this class must be inherited in R!
 * <br/>
 * Note that this needn't be subclassed to use it,
 * you can just add the required projects to the classpath
 * and call it with appropriate arguments, but you must provide
 * a module with the -module option.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolConfigParser<M extends IEolModule, R extends IEolRunConfiguration<M, ?>> extends ConfigParser<R> {

	/**
	 * Allows the caller to invoke any subclass of IEolModule.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ClassNotFoundException {
		if (args.length > 0) {
			
			if (args[0].toUpperCase().startsWith("CONFIG")) {
				Class<?> configClass = Class.forName(args[0].substring("CONFIG:".length()));
				String[] adjustedArgs = Arrays.copyOfRange(args, 1, args.length);
				new EolConfigParser(configClass).apply(adjustedArgs).run();
			}
			else {
				new EolConfigParser(getRunConfigurationForScript(args[0])).apply(args).run();
			}
			
		}
	}
	
	
	// Variables to be parsed
	public Optional<M> module;
	public Map<IModel, StringProperties> modelsAndProperties;
	public Map<String, String> scriptParameters;
	
	protected final Class<R> configClass;
	private final String
		moduleOpt = "module",
		modelsOpt = "models",
		scriptParamsOpt = "parameters";
	
	/**
	 * @param args command-line arguments.
	 * @param configClass the subclass of ErlRunConfiguration.
	 * @param moduleClass the interface of the appropriate module (must be a subclass of IEolModule).
	 */
	public EolConfigParser(Class<R> configurationClass) {
		super();
		this.configClass = configurationClass;
		
		requiredUsage += "-models [model class]#[model properties];"+nL;
		optionalUsage += "  [module] [argtype=argvalue]s..."+nL;
		
		options.addOption(Option.builder(moduleOpt)
			.hasArg()
			.desc("Specify the module and arguments to the module in key-value pairs. "
				+ "Please note: the arguments type must be a fully qualified class and the class must have a String constructor"
				+ "which is used to parse the provided argument."
			)
			.optionalArg(false)
			.hasArgs()
			.valueSeparator()
			.build()
		);
		
		options.addOption(Option.builder(modelsOpt)
			.hasArgs()
			.desc("Specify the models and properties. The format first specifies the concrete Java class to"
				+ "be instantiated (fully qualified name after org.eclipse.epsilon.emc.), followed by #,"
				+ "followed by comma-separated key=value properties. For example: "
				+ "emf.EmfModel#name=modelName,cached=true;plainxml.PlainXmlModel#name=model2. "
				+ "This example specifies an EMF and a PlainXML model with their names as properties."
			)
			.valueSeparator(';')
			.build()
		);
		
		options.addOption(Option.builder(scriptParamsOpt)
			.hasArgs()
			.desc("Specify parameters to the script in comma-separated key=value pairs. Note that "
				+ "the type of variable passed will always be a String."
			)
			.optionalArg(true)
			.valueSeparator(',')
			.build()
		);
	}
	
	@Override
	protected void parseArgs(String[] args) throws Exception {
		super.parseArgs(args);
		
		module = cmdLine.hasOption(moduleOpt) ?
			Optional.of(parseModule(cmdLine.getOptionValues(moduleOpt))) :
			Optional.empty();
			
		modelsAndProperties = cmdLine.hasOption(modelsOpt) ?
			parseModelParameters(cmdLine.getOptionValues(modelsOpt)) :
			Collections.emptyMap();
		
		scriptParameters = cmdLine.hasOption(scriptParamsOpt) ?
			parseScriptParameters(cmdLine.getOptionValues(scriptParamsOpt)) :
			Collections.emptyMap();
			
		runConfig = instantiate(
			configClass,
			script,
			modelsAndProperties,
			module,
			scriptParameters,
			showResults,
			profileExecution,
			id,
			outputFile
		);
	}
	
	public static Map<IModel, StringProperties> parseModelParameters(String[] arguments) throws Exception {
		Map<IModel, StringProperties> modelMap = new HashMap<>(arguments.length);
		
		for (String arg : arguments) {
			String[] modelPropertyEntry = arg.split("#");
			if (modelPropertyEntry.length != 2)
				continue;
			
			IModel model = (IModel) Class.forName("org.eclipse.epsilon.emc."+modelPropertyEntry[0])
				.getDeclaredConstructor()
				.newInstance();
			
			StringProperties properties = new StringProperties();
			for (String propertyToken : modelPropertyEntry[1].split(",")) {
				String[] propEntry = propertyToken.split("=");
				assert propEntry.length == 2;
				properties.put(propEntry[0], propEntry[1]);
			}
			
			modelMap.put(model, properties);
		}

		return modelMap;
	}
	
	public static Map<String, String> parseScriptParameters(String[] arguments) {
		return Arrays.stream(arguments)
			.map(param -> {
				String[] entry = param.split("=");
				String key, value;
				
				if (entry.length != 2) {
					key = ""; value = "";
				}
				else {
					key = entry[0]; value = entry[1];
				}
				
				return new AbstractMap.SimpleEntry<>(key, value);
			})
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}
	
	public static <M extends IEolModule, R extends IEolRunConfiguration<M, ?>> R instantiate(
			Class<R> subClazz,
			Path script,
			Map<IModel, StringProperties> modelsAndProperties,
			Optional<M> module,
			Map<String, ?> scriptParameters,
			Optional<Boolean> showResults,
			Optional<Boolean> profileExecution,
			Optional<Integer> id,
			Optional<Path> outputFile
		) {
			try {
				return subClazz.getConstructor(
					Path.class,
					Map.class,
					Optional.class,
					Optional.class,
					Optional.class,
					Optional.class,
					Optional.class,
					Optional.class
				)
				.newInstance(
					script,
					modelsAndProperties,
					module,
					Optional.of(scriptParameters),
					showResults,
					profileExecution,
					id,
					outputFile
				);
			}
			catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
				ex.printStackTrace();
				throw new IllegalArgumentException("Can't instantiate '"+subClazz.getName()+"': "+ex.getMessage());
			}
	}
	
	/**
	 * Attempts to parse a module from command-line arguments, based on assumptions on Epsilon's conventional naming schemes and package structure.
	 * The names are based on the class name of the return type; so for example for IEolModule, it will use "ERL" as the language and look
	 * for the appropriate modules and contexts based on this name.
	 * 
	 * @param args the name of the module (following org.eclipse.epsilon.) followed by an even-arity array with arguments to provide to the context constructor,
	 * where every even numbered argument (including 0) is the class (type) and every odd numbered argument is the value.
	 * Note: only types with a String constructor are valid.
	 * @param profile - whether to look for a profilable module implementation in a subpackage "profiling.Profilable"+[moduleName].
	 */
	@SuppressWarnings("unchecked")
	protected static <R extends IEolModule> R parseModule(String[] args) throws IllegalArgumentException {
		String basePkg = "org.eclipse.epsilon.";
		try {
			if (args.length == 0)
				throw new IllegalArgumentException("Must provide a module name.");
			int additionals = args.length-1;
			if (additionals % 2 != 0)
				throw new IllegalArgumentException("Must provide the types and arguments for module.");
			int arrSize = additionals/2;
			Class<?>[] moduleArgTypes = new Class[arrSize];
			Object[] parsedArgs = new Object[arrSize];
			
			for (int l = 0, a = 0; l < arrSize*2; l += 2, a++) {
				Class<?>[] type = getType(args[l+1]);
				Class<?> constructType = type.length == 2 ? type[1] : type[0];
				moduleArgTypes[a] = type[0];
				parsedArgs[a] = constructType.getConstructor(String.class).newInstance(args[l+2]);
			}

			Class<?> moduleClass = Class.forName(basePkg+args[0]);

			try {
				return (R) moduleClass.getDeclaredConstructor(moduleArgTypes).newInstance(parsedArgs);
			}
			catch (IllegalAccessException ex) {
				System.err.println("WARNING: Could not find appropriate constructor for supplied parameters. Proceeding with defaults.");
				System.err.println(ex.getMessage());
				return (R) moduleClass.getConstructor().newInstance();
			}
		}
		catch (Exception ex) {
			throw new IllegalArgumentException("Could not find or instantiate the module: "+ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	static Class<? extends IEolRunConfiguration<?, ?>> getRunConfigurationForScript(String scriptPath) {
		String ext = FileUtil.getExtension(scriptPath).toLowerCase();
		String pkg = ext.equals("egx") ? "egl" : ext;
		String className = "org.eclipse.epsilon."+pkg+".launch."+StringUtil.firstToUpper(ext)+"RunConfiguration";
		
		try {
			return (Class<? extends IEolRunConfiguration<?, ?>>) Class.forName(className);
		}
		catch (ClassNotFoundException cnfx) {
			
			class InstantiableEOC extends IEolRunConfiguration<EolModule, Object> {
				public InstantiableEOC(Path eolFile, Map<IModel, StringProperties> modelsAndProperties, Optional<EolModule> eolModule, Optional<Map<String, ?>> parameters, Optional<Boolean> showResults, Optional<Boolean> profileExecution, Optional<Integer> configID, Optional<Path> scratchFile) {
					super(eolFile, modelsAndProperties, eolModule, parameters, showResults, profileExecution, configID, scratchFile);
				}
				@Override
				protected EolModule getDefaultModule() {
					return new EolModule();
				}
			}
			
			return InstantiableEOC.class;
		}
	}
	
	private static Class<?>[] getType(String specifiedType) throws ClassNotFoundException {
		final String pkg = "java.lang.";
		switch (specifiedType) {
			case "int": case "Integer": case pkg+"Integer":
				return new Class[]{Integer.TYPE, Integer.class};
			case "boolean": case "bool": case "Boolean": case pkg+"Boolean":
				return new Class[]{Boolean.TYPE, Boolean.class};
			case "double": case "Double": case pkg+"Double":
				return new Class[]{Double.TYPE, Double.class};
			case "float": case "Float": case pkg+"Float":
				return new Class[]{Float.TYPE, Float.class};
			case "long": case "Long": case pkg+"Long":
				return new Class[]{Long.TYPE, Long.class};
			case "byte": case "Byte": case pkg+"Byte":
				return new Class[]{Byte.TYPE, Byte.class};
			case "char": case "Character": case pkg+"Character":
				return new Class[]{Character.TYPE, Character.class};
			case "String": case "string": case pkg+"String":
				return new Class[]{String.class};
			default:
				return new Class[]{Class.forName(specifiedType)};
		}
	}
}