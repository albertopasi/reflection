package it.unipd.dei.eis.reflect.ui;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class E06UIFix {

    public static Method getSupportedMethod(Class cls, String name, Class[] paramTypes) throws NoSuchMethodException {

        if (cls == null) {
            System.out.println("cls is null [caso base]");
            throw new NoSuchMethodException();
        } else {
            System.out.println(cls.getName());
        }
        try {
            return cls.getDeclaredMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            System.out.println("==> Considero la superclasse");
            return getSupportedMethod(cls.getSuperclass(), name, paramTypes); // verifica la presenza del metodo nella superclasse
        }

    }

    public static void setObjectColor(Object obj, Color color) {

        Class cls = obj.getClass();

        try {

//            Method method = cls.getMethod("setColor", new Class[]{Color.class});

            Method method = getSupportedMethod(cls, "setColor", new Class[]{Color.class});

            method.invoke(obj, new Object[]{color});

        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(cls.getName() + " does not support the method setColor(Color)");
        } catch (IllegalAccessException ex) {
            throw new IllegalArgumentException(
                    "Insufficient access permissions to call setColor(:Color) in class " + cls.getName());
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {

        Color color = Color.RED;

        Object[] components = {
                new UIComponent1(),
                new UIComponent5()
        };

        for (Object c : components) {
            try {
                setObjectColor(c, color);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }

    }

}
