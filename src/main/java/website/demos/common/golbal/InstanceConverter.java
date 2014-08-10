package website.demos.common.golbal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import website.demos.common.exceptions.CommonSystemException;


public class InstanceConverter {

	private static final String PERFIX_GET_PROPERTY = "get";
	private static final String PERFIX_SET_PROPERTY = "set";

	public static <TSource, TTarget> TTarget assignProperties(TSource source, TTarget target) throws CommonSystemException {
		if (source == null || target == null) {
			throw new CommonSystemException("Source and target can't be null!");
		}
		Method[] sourceMethods = source.getClass().getMethods();
		Method[] targetMethods = target.getClass().getMethods();
		for (Method sourceMethod : sourceMethods) {
			for (Method targetMethod : targetMethods) {
				if (sourceMethod.getName().startsWith(PERFIX_GET_PROPERTY)
						&& targetMethod.getName().startsWith(PERFIX_SET_PROPERTY)
						&& sourceMethod.getName().substring(PERFIX_GET_PROPERTY.length())
								.equals(targetMethod.getName().substring(PERFIX_SET_PROPERTY.length()))) {
					try {
						targetMethod.invoke(target, sourceMethod.invoke(source));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
						throw new CommonSystemException("Some error happened on assign property '" + sourceMethod.getName() + "' to '"
								+ targetMethod.getName() + "'!", ex);
					}
				}
			}
		}
		return target;
	}
}
