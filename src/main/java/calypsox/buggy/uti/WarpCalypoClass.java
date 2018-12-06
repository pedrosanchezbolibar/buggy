package calypsox.buggy.uti;

import java.lang.reflect.Method;

import com.calypso.tk.bo.BOTransfer;

public class WarpCalypoClass {

    private static final String SKIP_METHOD = "getKey getClass getSourceTable getSourceClass getLockId";

    public static void main(final String[] args) {
	int count = 0;
	final Class clazz = BOTransfer.class;
	for (final Method method : clazz.getMethods()) {
	    if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
		if (!SKIP_METHOD.contains(method.getName())) {
		    final StringBuilder sb = new StringBuilder("public ");
		    sb.append(method.getReturnType().getSimpleName());
		    sb.append(' ');
		    sb.append(method.getName());
		    sb.append("() { \n\treturn ");
		    sb.append(clazz.getSimpleName().toLowerCase());
		    sb.append('.');
		    sb.append(method.getName());
		    sb.append("();\r}");

		    System.out.println(sb);
		    count++;
		}
	    }
	}
	System.err.println(count);
    }

}
