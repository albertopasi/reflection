package it.unipd.dei.eis.gofpatterns.factory;

public abstract class AbstractPizza implements Pizza {


    public abstract void prepare();

    @Override
    public void bake() {
        System.out.println("[bake] Pizza is in the oven");
    }

    @Override
    public void cut() {
        System.out.println("[cut] Cutting the pizza");
    }

    @Override
    public void box() {
        System.out.println("[box] Pizza in the box");
    }

    public String toString() {
        return "Pizza type: " + this.getClass().getSimpleName();
    }
}
