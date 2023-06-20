package it.unipd.dei.eis.reflect;

import it.unipd.dei.eis.reflect.ui.UIComponent1;
import it.unipd.dei.eis.reflect.ui.UIComponent4;

import java.lang.reflect.Method;

public class E03GetMethods {

    public static void printMethods(Object obj) {

        Class cls = obj.getClass();
        System.out.println("Classe " + cls.getName());

        System.out.println("\ngetMethods()");
        for (Method method : cls.getMethods()) {
            System.out.println(method);
        }

        System.out.println("\ngetDeclaredMethods()");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }
        System.out.println("\n***********\n");

        // metodi ereditati non si vedranno!

    }

    public static void main(String[] args) {

        Object[] components = {
                new UIComponent1(),
                new UIComponent4()
        };

        for (Object c : components) {
            printMethods(c);
        }

    }

}