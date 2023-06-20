package it.unipd.dei.eis.gofpatterns.factory;

public class Asparagi extends AbstractPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("[prepare] preparing an Asparagi");
    }

}
