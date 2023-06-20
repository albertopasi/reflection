package it.unipd.dei.eis.gofpatterns.factory;

public class PizzaFactory {

    private static PizzaFactory instance;

    public static PizzaFactory getInstance(){
        if (instance == null){
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza createPizza(String pizzaType) throws UnsupportedPizzaException {

        if (pizzaType.equalsIgnoreCase("Asparagi")){
            return new Asparagi();
        } else if (pizzaType.equalsIgnoreCase("Bufala")){
            return new Bufala();
        } else if (pizzaType.equalsIgnoreCase("Margherita")){
            return new Margherita();
        } else if (pizzaType.equalsIgnoreCase("Parmigiana")){
            return new Parmigiana();
        }

        throw new UnsupportedPizzaException("Pizza type "+pizzaType+" not supported yet!");

    }
}
