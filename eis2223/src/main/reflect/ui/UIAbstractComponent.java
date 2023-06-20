package it.unipd.dei.eis.reflect.ui;

import java.awt.*;

public abstract class UIAbstractComponent {

    protected Color color;

    protected void setColor(Color color) {
        this.color = color;
        System.out.println("Color " + color.getClass() + " set in component "+this.getClass().getName());
    }

    public Color getColor() {
        return this.color;
    }

}
