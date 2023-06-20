package it.unipd.dei.eis.reflect.eisflix;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

public class VideoSerialization {

    // based on Listing 2.1 in Java Reflection in Action
    public static Field[] getObjectFields(Object obj) {

        Class cls = obj.getClass();

        List fieldList = new LinkedList();

        while (cls != null) {
            Field[] f = cls.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                if (!Modifier.isStatic(f[i].getModifiers())) {
                    fieldList.add(f[i]);
                }
            }
            cls = cls.getSuperclass();
        }

        return (Field[]) fieldList.toArray(new Field[fieldList.size()]);

    }

    public static void appendField(String fieldName, Object fieldValue, StringBuilder sb) {
        sb.append("<" + fieldName + ">");
        sb.append(fieldValue);
        sb.append("</" + fieldName + ">");
    }


    public static void serializeHelper(StringBuilder sb, Object obj) {

        String objClassName = obj.getClass().getSimpleName().toLowerCase();

        System.out.printf("...processing object of class %s%n", objClassName);

        sb.append("<" + objClassName + ">");

        Field[] fields = getObjectFields(obj);

        for (Field field : fields) {

            System.out.printf("...processing field %s%n", field);

            try {

                if (field.getType().isArray()) {

                    System.out.printf("---> field is array %s%n", field);

                    String fieldName = field.getName();

                    sb.append("<" + fieldName + ">");

                    Object arrayObj = field.get(obj);
                    int size = Array.getLength(arrayObj);
                    for (int i = 0; i < size; i++) {
                        Object itemObj = Array.get(arrayObj, i);
                        if (String[].class.isInstance(arrayObj) || itemObj.getClass().isPrimitive()) {
                            appendField("item", itemObj, sb);
                        } else {
                            serializeHelper(sb, itemObj);
                        }

                    }

                    sb.append("</" + fieldName + ">");

                } else {

                    String fieldName = field.getName();
                    Object fieldValue = field.get(obj);

                    appendField(fieldName, fieldValue, sb);
                }
            } catch (IllegalAccessException e) {
                System.err.println("Error when accessing field " + field.getName());
            }

        }

        sb.append("</" + objClassName + ">");

    }


}
