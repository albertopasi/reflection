package it.unipd.dei.eis.reflect;

import it.unipd.dei.eis.reflect.ui.UIComponent1;
import it.unipd.dei.eis.reflect.ui.UIComponent2;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

public class E05DynamicInvocation {

    public static void main(String[] args) {

        Vector v = new Vector();
        v.add(1);
        v.add(3);

        try {
            // get the "get" method
            Method g = v.getClass().getMethod("get", int.class);

            System.out.println("Method name: " + g.getName());
            System.out.println("Class: " + g.getClass());
            System.out.println("Declaring class: " + g.getDeclaringClass());
            System.out.println("Exception types:");
            for (Class e : g.getExceptionTypes()) {
                System.out.println("- " + e.getName());
            }
            System.out.println("Parameter types:");
            for (Class pt : g.getParameterTypes()) {
                System.out.println("- " + pt.getName());
            }
            System.out.println("Return type: " + g.getReturnType());
            System.out.println("Result of the method invocation: " + g.invoke(v, 1));
            System.out.println("");

            System.out.println("Add method invocation");
            Method a = v.getClass().getMethod("add", Object.class);
            Object result = a.invoke(v, 17);
            System.out.println("class: " + result.getClass().getName() + " | value: " + result);
            System.out.println();

            System.out.println("Size method invocation");
            Method s = v.getClass().getMethod("size", null); // non ha parametri quindi specifico null
            result = s.invoke(v, null);
            System.out.println("class: " + result.getClass().getName() + " | value: " + result);
            System.out.println();

            // Anche se due classi hanno un metodo con lo stessa signature, non posso reperirne uno e usarlo
            // con un'istanza dell'altra classe.

            UIComponent1 uic1 = new UIComponent1();
            Method sc = uic1.getClass().getMethod("setColor", Color.class);
            sc.invoke(uic1, Color.WHITE);

            UIComponent2 uic2 = new UIComponent2();
            sc.invoke(uic2, Color.WHITE);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

}
