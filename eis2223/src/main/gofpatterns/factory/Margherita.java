package it.unipd.dei.eis.gofpatterns.factory;

public class Margherita extends AbstractPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("[prepare] preparing a Margherita");
    }
}
