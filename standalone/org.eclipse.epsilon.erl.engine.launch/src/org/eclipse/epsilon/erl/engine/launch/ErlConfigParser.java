package org.eclipse.epsilon.erl.engine.launch;

import static org.eclipse.epsilon.emc.emf.EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI;
import static org.eclipse.epsilon.emc.emf.EmfModel.PROPERTY_MODEL_URI;
import static org.eclipse.epsilon.eol.models.CachedModel.PROPERTY_CACHED;
import static org.eclipse.epsilon.eol.models.Model.PROPERTY_NAME;
import static org.eclipse.epsilon.eol.models.Model.PROPERTY_READONLOAD;
import static org.eclipse.epsilon.eol.models.Model.PROPERTY_STOREONDISPOSAL;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import org.apache.commons.cli.Option;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.launch.ConfigParser;

/**
 * A default config getter which effectively allows main method inheritance.
 * Uses reflection to find appropriate constructors and module interface to pass to parseModule method.
 * Please note: The constructors of this class must be inherited in R!
 * 
 * @author Sina Madani
 */
public class ErlConfigParser<M extends IErlModule, R extends ErlRunConfiguration<M>> extends ConfigParser implements Function<String[], R> {
	
	/**
	 * Allows the caller to invoke any subclass of IErlModule.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void main(String[] args) throws ClassNotFoundException {
		
		class InstantiableERC extends ErlRunConfiguration {
			public InstantiableERC(Path erlFile, StringProperties properties, IModel model,
					Optional<Boolean> showResults, Optional<Boolean> profileExecution, Optional<IErlModule> erlModule,
					Optional<Integer> configID, Optional<Path> scratchFile) {
				super(erlFile, properties, model, showResults, profileExecution, erlModule, configID, scratchFile);
				
			}
			protected IErlModule getDefaultModule() {
				throw new IllegalStateException("Must provide -module argument!");
			}
		}
		
		if (args.length > 0) {
			new ErlConfigParser(IErlModule.class, InstantiableERC.class).apply(args).run();
		}
	}
	
	// Variables to be parsed
	public Optional<M> module;
	public IModel model;
	public StringProperties properties;
	public R runConfig;
	
	protected final Class<R> configClass;
	protected final Class<? extends M> moduleClass;
	protected String moduleName, lang, moduleOpt = "module";
	
	/**
	 * @param args command-line arguments.
	 * @param configClass the subclass of ErlRunConfiguration.
	 * @param moduleClass the interface of the appropriate module (must be a subclass of IErlModule).
	 */
	public ErlConfigParser(Class<? extends M> moduleClass, Class<R> configurationClass) {
		super();
		this.moduleClass = moduleClass;
		this.configClass = configurationClass;
		
		moduleName = moduleClass.getSimpleName();
		lang = moduleName.substring(1, moduleName.indexOf("Module"));
		
		requiredUsage += "  [absolute path to model] "+nL
					   + "  [absolute path to metamodel] "+nL;
		optionalUsage += "  [module] [argtype=argvalue]s..."+nL;
		
		options.addOption(Option.builder(moduleOpt)
			.hasArg()
			.desc("Specify the module and arguments to the "+lang+"Module in key-value pairs. "
				+ "Please note: the arguments type must be a fully qualified class and the class must have a String constructor "
				+ "which is used to parse the provided argument."
			)
			.optionalArg(false)
			.hasArgs()
			.valueSeparator()
			.build()
		);
	}
	
	@Override
	protected void parseArgs(String[] args) throws Exception {
		super.parseArgs(args);
		
		model = getIModelFromPath(args[2]);
		properties = makeProperties(args[1], args[2]);
		
		module = cmdLine.hasOption(moduleOpt) ?
			Optional.of(parseModule(cmdLine.getOptionValues(moduleOpt))) :
			Optional.empty();
			
		runConfig = instantiate(
			configClass,
			script,
			properties,
			model,
			showResults,
			profileExecution,
			module,
			id,
			outputFile
		);
	}

	@Override
	public final R apply(String[] args) {
		accept(args);
		return runConfig;
	}
	
	public static IModel getIModelFromPath(String filepath) throws IllegalArgumentException {
		String ext = FileUtil.getExtension(filepath).toLowerCase();
		switch (ext) {
			case "xmi": case "ecore": case "genmodel": case "emf": case "model":
				return new EmfModel();
			default: throw new IllegalArgumentException("Unknown model type for extension '"+ext+"'");
		}
	}
	
	public static StringProperties makeProperties(String modelPath, String metamodelPath) {
		StringProperties properties = new StringProperties();
		properties.put(PROPERTY_READONLOAD, true);
		properties.put(PROPERTY_CACHED, true);
		properties.put(PROPERTY_STOREONDISPOSAL, true);
		
		try {
			Path modelFile = Paths.get(modelPath);
			
			if (!modelFile.toFile().isFile())
				throw new IllegalArgumentException("is not a file.");
			
			properties.put(PROPERTY_NAME, FileUtil.removeExtension(modelFile.getFileName().toString()));
			properties.put(PROPERTY_MODEL_URI, modelFile.toUri().toString());
		}
		catch (NullPointerException | IllegalArgumentException ex) {
			System.err.println("Invalid model path '"+modelPath+"': "+ex.getMessage());
		}
		
		try {
			Path metamodelFile = Paths.get(metamodelPath);
			
			if (!metamodelFile.toFile().isFile())
				throw new IllegalArgumentException("is not a file.");
			
			properties.put(PROPERTY_FILE_BASED_METAMODEL_URI, metamodelFile.toUri().toString());
		}
		catch (NullPointerException | IllegalArgumentException ex) {
			System.err.println("Invalid metamodel path '"+metamodelPath+"': "+ex.getMessage());
		}
		
		return properties;
	}
	
	public static <M extends IErlModule, R extends ErlRunConfiguration<M>> R instantiate(
			Class<R> subClazz,
			Path script,
			StringProperties properties,
			IModel model,
			Optional<Boolean> showResults,
			Optional<Boolean> profileExecution,
			Optional<M> module,
			Optional<Integer> id,
			Optional<Path> outputFile
		) {
			try {
				return subClazz.getConstructor(
					Path.class,
					StringProperties.class,
					IModel.class,
					Optional.class,
					Optional.class,
					Optional.class,
					Optional.class,
					Optional.class
				)
				.newInstance(
					script,
					properties,
					model,
					showResults,
					profileExecution,
					module,
					id,
					outputFile
				);
			}
			catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
				throw new IllegalArgumentException("Can't instantiate '"+subClazz.getName()+"': "+ex.getMessage());
			}
	}
	
	/**
	 * Attempts to parse a module from command-line arguments, based on assumptions on Epsilon's conventional naming schemes and package structure.
	 * The names are based on the class name of the return type; so for example for IErlModule, it will use "ERL" as the language and look
	 * for the appropriate modules and contexts based on this name.
	 * 
	 * @param args the name of the module (following org.eclipse.epsilon.) followed by an even-arity array with arguments to provide to the context constructor,
	 * where every even numbered argument (including 0) is the class (type) and every odd numbered argument is the value.
	 * Note: only types with a String constructor are valid.
	 * @param profile - whether to look for a profilable module implementation in a subpackage "profiling.Profilable"+[moduleName].
	 */
	@SuppressWarnings("unchecked")
	protected static <R extends IErlModule> R parseModule(String[] args) throws IllegalArgumentException {
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