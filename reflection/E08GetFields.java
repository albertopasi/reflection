package it.unipd.dei.eis.l13;

import it.unipd.dei.eis.l13.eisflix.Movie;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

public class E08GetFields {

    // Basato su Listing 2.1 del libro Java Reflection in Action
    public static Field[] getObjectFields(Object obj) {

        Class cls = obj.getClass();

        List fieldList = new LinkedList();

        while (cls != null) {

            Field[] f = cls.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                fieldList.add(f[i]);
            }
            cls = cls.getSuperclass();
        }

        return (Field[]) fieldList.toArray(new Field[fieldList.size()]);

    }


    public static void main(String[] args) {

        Movie movie = new Movie("Back to the Future", (60 + 56) * 60, new String[]{"Scifi", "Comedy"});

        Field[] movieFields = getObjectFields(movie);

        for (Field movieField : movieFields) {

            System.out.printf("Field %s%n", movieField.getName());
            System.out.printf("- type: %s%n", movieField.getType());
            System.out.printf("- isArray? %b%n", movieField.getType().isArray());
            System.out.printf("- can access field in object? %b%n", movieField.canAccess(movie));
            System.out.printf("- declaring class: %s%n", movieField.getDeclaringClass());
            System.out.printf("- modifiers: %d%n", movieField.getModifiers());
            System.out.printf("- isPublic? %b%n", Modifier.isPublic(movieField.getModifiers()));
            System.out.printf("- isProtected? %b%n", Modifier.isProtected(movieField.getModifiers()));
            System.out.printf("- isPrivate? %b%n", Modifier.isPrivate(movieField.getModifiers()));
            System.out.printf("- isStatic? %b%n", Modifier.isStatic(movieField.getModifiers()));
            System.out.println();

        }

    }

}