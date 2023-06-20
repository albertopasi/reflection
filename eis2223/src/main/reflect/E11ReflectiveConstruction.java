package it.unipd.dei.eis.reflect;

import it.unipd.dei.eis.reflect.eisflix.Video;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class E11ReflectiveConstruction {

    public static void main(String[] args) {

        try {

            Video video1 = Video.class.newInstance(); // deprecated

            Constructor videoConstructor = Video.class.getConstructor(new Class[]{String.class, int.class});
            Video video2 = (Video) videoConstructor.newInstance("Super 8", (60 + 52) * 60);

            Video[] videos = { video1, video2 };

            System.out.println("Videos:");
            for (Video v : videos){
                System.out.printf("- \"%s\" (%d')%n", v.getTitle(),v.getDurationInMinutes());
            }


        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }


}
