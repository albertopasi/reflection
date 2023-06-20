package it.unipd.dei.eis.reflect.ui;

import java.awt.*;

public class UIComponent1 {

    private Color color;

    public void setColor(Color color) {
        this.color = color;
        System.out.println("Color " + color.getClass() + " set in component "+this.getClass().getName());
    }

    public Color getColor() {
        return this.color;
    }

    public void reduceTransparency() {
        reduceTransparency(0.8d);
    }

    private void reduceTransparency(double amount) {

    }

}
