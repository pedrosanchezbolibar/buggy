package calypsox.buggy.uti;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import org.hibernate.mapping.Map;

import antlr.collections.List;

public class WarpCalypoClass {

    public static final Class<?> clazz = com.calypso.tk.product.Swaption.class;

    private static final String SKIP_METHOD = "getKey getClass getSourceTable getSourceClass getLockId getClassName getAllocatedLongSeed";

    public static void main(final String[] args) {
        int count = 0;

        for (final Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                final String methodName = method.getName();
                final String newMethodName = methodName.replaceAll("LongId", "Id");
                if (methodName.startsWith("get") && method.getParameterTypes().length == 0) {
                    if (!SKIP_METHOD.contains(method.getName())) {

                        Class<?> returnType = method.getReturnType();
                        if (returnType == Hashtable.class || returnType == HashMap.class) {
                            returnType = Map.class;
                        } else if (returnType == Vector.class) {
                            returnType = List.class;
                        }

                        if ("getBookId".equals(methodName)) {
                            System.out.println(generateGetAT(method, "ATBook"));
                        } else if ("getTransferId".equals(methodName)) {
                            System.out.println(generateGetAT(method, "ATTransfer"));
                        } else if ("getTradeId".equals(methodName)) {
                            System.out.println(generateGetAT(method, "ATTrade"));
                        } else if ("getLegalEntityId".equals(methodName)) {
                            System.out.println(generateGetAT(method, "ATLegalEntity"));
                        } else {
                            final StringBuilder sb = new StringBuilder("public ");
                            sb.append(returnType.getSimpleName());
                            sb.append(' ');
                            sb.append(newMethodName);
                            sb.append("() { \n\treturn ");
                            sb.append(clazz.getSimpleName().toLowerCase());
                            sb.append('.');
                            sb.append(methodName);
                            sb.append("();\r}");

                            System.out.println(sb);
                        }
                        count++;
                    }
                }
            }
        }
        System.err.println(count);
    }

    private static String generateGetAT(final Method method, final String atClass) {
        final StringBuilder sb = new StringBuilder("public ");
        sb.append(atClass);
        sb.append(' ');
        sb.append(method.getName().replaceAll("Id", ""));
        sb.append("() { \n\treturn new ");
        sb.append(atClass);
        sb.append('(');
        sb.append(method.getDeclaringClass().getSimpleName().toLowerCase());
        sb.append('.');
        sb.append(method.getName());
        sb.append("());\r}");

        return sb.toString();
    }

}
