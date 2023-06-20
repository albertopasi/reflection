package it.unipd.dei.eis.reflect;

public class E10DynamicLoading {

    public static void main(String[] args) {

        try {

            Class cls = Class.forName("java.lang.String");
            System.out.println(cls.getName());

            cls = Class.forName("it.unipd.dei.eis.reflect.eisflix.Movie");
            System.out.println(cls.getName());

            // la prossima riga lancia un'eccezione non esistendo la classe
//            cls = Class.forName("it.unipd.dei.eis.l03.eisflix.Series");
//            System.out.println(cls.getName());

            // la prossima riga lancia un'eccezione perché la stringa per la classe non è corretta
//            cls = Class.forName("java.lang.String[]");
//            System.out.println(cls.getName());

            cls = Class.forName("[Ljava.lang.String;");
            System.out.println(cls.getName());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
