package it.unipd.dei.eis.l13;

import it.unipd.dei.eis.l13.ui.UIComponent1;
import it.unipd.dei.eis.l13.ui.UIComponent2;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class E02UI {

    public static void setObjectColor(Object obj, Color color) {

        // esamino l'oggetto per ottenerne la classe (introspezione)
        Class cls = obj.getClass();

        try {
            // esamino la classe per ottenere il metodo setColor (introspezione)
            // Potremmo usare anche Color.class perché sappiamo il nome della classe; si tratta di un Class literal
            Method method = cls.getMethod("setColor", new Class[]{Color.class});
            // invoco sull'oggetto il metodo trovato
            // esempio di Dynamic invocation: metodo invocato senza essere specificato a compile time
            method.invoke(obj, new Object[]{color});

        } catch (NoSuchMethodException ex) {
            // eccezione nel caso in cui la classe non supporti il metodo setColor
            throw new IllegalArgumentException(cls.getName() + " does not support the method setColor(Color)");
        } catch (IllegalAccessException ex) {
            // eccezione nel caso in cui il metodo setColor non possa essere invocato
            throw new IllegalArgumentException(
                    "Insufficient access permissions to call setColor(:Color) in class " + cls.getName());
        } catch (InvocationTargetException ex) {
            // eccezione nel caso setColor lanci un'eccezione; usiamo RuntimeException per semplicità
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {

        Color color = Color.RED;

        Object[] components = {
                new UIComponent1(),
                new UIComponent2(),
//                new UIComponent3()
        };
        // se rimuovete il commento alla riga 48 lancia un'eccezione
        // UIComponent3 non ha un metodo "setColor" ma "setTheColor"

        for (Object c : components) {
            try {
                // non potete usare direttamente il metodo setColor(Color c) perché c è un Object
                // e non abbiamo un'interfaccia comune, e.g., UIComponentInterface per i diversi UIComponent
                // c.setColor(color);
                setObjectColor(c, color);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }

    }

}

