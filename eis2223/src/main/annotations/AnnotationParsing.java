package it.unipd.dei.eis.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsing {

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationParsing.class.getClassLoader()
                    .loadClass(("it.unipd.dei.eis.annotations.AnnotationExample")).getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(it.unipd.dei.eis.annotations.Info.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation a : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + a);
                        }
                        Info i = method.getAnnotation(Info.class);
                        System.out.println("Method "+method.getName()+" with revision "+i.revision());

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println();
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
