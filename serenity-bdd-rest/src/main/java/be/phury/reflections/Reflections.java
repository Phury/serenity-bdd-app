package be.phury.reflections;

import java.lang.reflect.Method;


public class Reflections {

	@SuppressWarnings("unchecked")
	public static <T> Class<? extends T> getClassExtending(String name, Class<T> typeOf) {
		try {
			return (Class<? extends T>) Class.forName(name);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T getInstanceOf(String name, Class<T> typeOf) {
		try {
			
			Class<? extends T> classExtending = getClassExtending(name, typeOf);
			return classExtending.newInstance();
			
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static Method getFirstMethodMatchingName(Object obj, String methodName) {
		for (Method m : obj.getClass().getDeclaredMethods()) {
			if (m.getName().equals(methodName)) return m;
		}
		throw new RuntimeException("method {} not found" + methodName);
	}
}
