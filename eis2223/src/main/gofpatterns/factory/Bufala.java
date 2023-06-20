package it.unipd.dei.eis.gofpatterns.factory;

public class Bufala extends AbstractPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("[prepare] preparing a Bufala");
    }

}
