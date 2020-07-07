package Impls.JsonConverter;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JsonConverter {


    public static String convertField(Field field, Object object, StringBuilder fieldStringBuilder) throws IllegalAccessException, IntrospectionException, InvocationTargetException, NoSuchMethodException {
        field.setAccessible(true);

        Class<?> clazz = field.getType();
        if (clazz.isPrimitive() || clazz.equals(String.class)) {
            fieldStringBuilder.append(field.getName());
            fieldStringBuilder.append(":");
            fieldStringBuilder.append(field.get(object));
        } else {
            if (clazz.isArray()) {
                fieldStringBuilder.append("[");
                Object[] arr = (Object[])field.get(object);
                int i = 0;
                for (Field field1 : clazz.getFields()) {
                    if (i != 0) {
                        fieldStringBuilder.append(",");
                    }
                    convertField(field1, object, fieldStringBuilder);
                    i++;

                }

                fieldStringBuilder.append("]");

            } else {
                int i = 0;
                fieldStringBuilder.append("{");
                for (Field field1 : clazz.getFields()) {
                    if (i != 0) {
                        fieldStringBuilder.append(",");
                    }

                    Method fieldGetter = object.getClass().getMethod("getAddress");
/*                    PropertyDescriptor pd = new PropertyDescriptor(field1.getName(), object.getClass());
                    Method getter = pd.getReadMethod();*/
                    Object newObject = fieldGetter.invoke(object);
       /*             PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(clazz.getName(), object.getClass());
                    Object newObject = objPropertyDescriptor.getReadMethod().invoke(object);*/
                    convertField(field1, newObject, fieldStringBuilder);
                    i++;

                }
                fieldStringBuilder.append("}");
            }

        }
        return fieldStringBuilder.toString();
    }

    public static String convert(Object object) throws IllegalAccessException, IntrospectionException, InvocationTargetException, NoSuchMethodException {

        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = object.getClass().getFields();

        stringBuilder.append("{");
        int i = 0;
        for (Field field : fields) {
            if (i != 0){
                stringBuilder.append(",");
            }
            stringBuilder.append(convertField(field, object, new StringBuilder()));
            i++;
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
