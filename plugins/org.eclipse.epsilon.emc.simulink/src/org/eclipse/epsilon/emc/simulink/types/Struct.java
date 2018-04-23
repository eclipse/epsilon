package org.eclipse.epsilon.emc.simulink.types;

import java.lang.reflect.Method;
import java.util.Set;

public class Struct {

	private static final String STRUCT_MATLAB_CLASS = "com.mathworks.matlab.types.Struct";
	
	private static final String CONTAINS_KEY_METHOD = "containsKey";
	private static final String CONTAINS_VALUE_METHOD = "containsValue";
	private static final String EQUALS_METHOD = "equals";
	private static final String GET_METHOD = "get";
	private static final String ENTRY_SET_METHOD = "entrySet";
	private static final String HASH_CODE_METHOD = "hashCode";
	private static final String IS_EMPTY_METHOD = "isEmpty";
	private static final String KEY_SET_METHOD = "keySet";
	private static final String SIZE_METHOD = "size";
	private static final String VALUES_METHOD = "values";

	private static Class<?> struct_class;

	protected Object struct;

	public static boolean is(Object obj) {
		return (getMatlabClass() == null) ? false : getMatlabClass().isInstance(obj);  
	}
	
	private static Class<?> getMatlabClass() {
		if (struct_class == null) {
			try {
				struct_class = ClassLoader.getSystemClassLoader().loadClass(STRUCT_MATLAB_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return struct_class;
	}
	
	
	public Struct(Object struct) {
		if (is(struct)) {
			this.struct = struct;
			init();
		}
	}

	// containsKey(Object key) Returns true if this map contains a mapping for the
	// specified key.
	protected Method containsKeyMethod;

	// containsValue(Object value) Returns true if this map maps one or more keys to
	// the specified value.
	protected Method containsValueMethod;

	// equals(Object o) Compares the specified object with this map for equality.
	protected Method equalsMethod;

	// get(Object key) Returns the value to which the specified key is mapped, or
	// null if this map contains no mapping for the key.
	protected Method getMethod;

	// entrySet() Returns a Set view of the mappings contained in this map.
	protected Method entrySetMethod;

	// hashCode() Returns the hash code value for this map.
	protected Method hashCodeMethod;

	// isEmpty() Returns true if this map contains no key-value mappings.
	protected Method isEmptyMethod;

	// keySet() Returns a Set view of the keys contained in this map.
	protected Method keySetMethod;

	// size() Returns the number of key-value mappings in this map.
	protected Method sizeMethod;

	// values() Returns a Collection view of the values contained in this map.
	protected Method valuesMethod;

	private void init() {
		Class<?> clazz = getMatlabClass();
		try {
			containsKeyMethod = containsKeyMethod == null ? clazz.getDeclaredMethod(CONTAINS_KEY_METHOD, Object.class) : null;
			containsValueMethod = containsValueMethod == null ? clazz.getDeclaredMethod(CONTAINS_VALUE_METHOD, Object.class) : null;
			equalsMethod = equalsMethod == null ? clazz.getDeclaredMethod(EQUALS_METHOD, Object.class) : null;
			getMethod = getMethod == null ? clazz.getDeclaredMethod(GET_METHOD, Object.class) : null;
			entrySetMethod = entrySetMethod == null ? clazz.getDeclaredMethod(ENTRY_SET_METHOD) : null;
			hashCodeMethod = hashCodeMethod == null ? clazz.getDeclaredMethod(HASH_CODE_METHOD) : null;
			isEmptyMethod = isEmptyMethod == null ? clazz.getDeclaredMethod(IS_EMPTY_METHOD) : null;
			keySetMethod = keySetMethod == null ? clazz.getDeclaredMethod(KEY_SET_METHOD) : null;
			sizeMethod = sizeMethod == null ? clazz.getDeclaredMethod(SIZE_METHOD) : null;
			valuesMethod = valuesMethod == null ? clazz.getDeclaredMethod(VALUES_METHOD) : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean containsKey(Object key) {
		try {
			return (Boolean) containsKeyMethod.invoke(struct, key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Boolean containsValue(Object value) {
		try {
			return (Boolean) containsValueMethod.invoke(struct, value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean equals(Object obj) {
		try {
			return (boolean) equalsMethod.invoke(struct, obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Object get(Object key) {
		try {
			return (Object) getMethod.invoke(struct, key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Set<?> entrySet() {
		try {
			return (Set<?>) entrySetMethod.invoke(struct);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int hashCode() {
		try {
			return (Integer) hashCodeMethod.invoke(struct);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public Boolean isEmpty() {
		try {
			return (Boolean) isEmptyMethod.invoke(struct);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	public Set<?> keySet() {
		try {
			return (Set<?>) keySetMethod.invoke(struct);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Integer size() {
		try {
			return (Integer) sizeMethod.invoke(struct);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Set<?> values() {
		try {
			return (Set<?>) valuesMethod.invoke(struct);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "Struct: [" +  entrySet().toString() + "]";
	}

}
