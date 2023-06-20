package it.unipd.dei.eis.l13;

import it.unipd.dei.eis.l13.ui.UIComponent6;
import it.unipd.dei.eis.l13.ui.UIComponent7;

public class E07Gerarchia {

    public static void printMethods(Object obj) {

        Class cls = obj.getClass();
        System.out.println("Classe " + cls.getName());

        System.out.println("Interfacce:");
        for (Class i : cls.getInterfaces()) {
            System.out.println("- "+i);
        }

        System.out.println("Superclasse: " + cls.getSuperclass());

        System.out.println("Is assignable from UIComponent6? " + cls.isAssignableFrom(UIComponent6.class));
        System.out.println("Is assignable from UIComponent7? " + cls.isAssignableFrom(UIComponent7.class));

        System.out.println("Is instance of "+cls.getName()+"? " + cls.isInstance(obj));

        System.out.println();

    }

    public static void main(String[] args) {

        Object[] components = {
                new UIComponent6(),
                new UIComponent7()
        };

        for (Object c : components) {
            printMethods(c);
        }


    }

}