package it.unipd.dei.eis.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Vector;

public class E04RappresentazioneTipi {

    // Rappresentazione di tipi primitivi, interfacce e array
    public static void main(String[] args) {

        // Tipi primitivi non sono oggetti
        // In Java classe per rappresentare ciascuno dei dati primitivi

        // consideriamo la classe java.util.Vector
        // https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

        Vector v = new Vector();
        v.add(1);

        Class cls = v.getClass();

        System.out.println("Class name " + cls.getName());

        try {

            // sebbene int sia un tipo primitivo, esiste il class object corrispondente
            Method m = cls.getMethod("get", int.class);
            Object e = m.invoke(v,0);
            System.out.println("e="+e);

            System.out.println("Is int primitive? " + int.class.isPrimitive());

            System.out.println("Is Collection an interface? " + Collection.class.isInterface());

            int[] a = {1, 2, 3};

            System.out.println("Is a an array? " + a.getClass().isArray());
            System.out.println("a component type: " + a.getClass().getComponentType());
            System.out.println();

            int[][] b = new int[3][3];
            System.out.println("Is b an array? " + b.getClass().isArray());
            System.out.println("b component type: " + b.getClass().getComponentType());

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e); // very bad practice
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e); // very bad practice
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e); // very bad practice
        }

    }

}
