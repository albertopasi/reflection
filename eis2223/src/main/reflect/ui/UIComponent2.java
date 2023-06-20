package it.unipd.dei.eis.reflect.ui;

import java.awt.*;

public class UIComponent2 {

    public void setColor(Color color){
        System.out.println("Color " + color.getClass() + " set in component "+this.getClass().getName());
    }

}
