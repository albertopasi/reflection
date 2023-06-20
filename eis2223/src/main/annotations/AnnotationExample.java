package it.unipd.dei.eis.annotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {

    @Override
    @Info(revision = 2, comments = "this is a comment for the toString method")
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @Info(revision = 1, comments = "this is a comment for the oldMethod")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Info(revision = 1, comments = "this is a comment for the genericsTest method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

}