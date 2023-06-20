package it.unipd.dei.eis.gofpatterns.factory;

public class PizzeriaEIS {

    PizzaFactory pizzaFactory;

    public PizzeriaEIS() {
        pizzaFactory = PizzaFactory.getInstance();
    }


    public Pizza orderPizza(String type) throws UnsupportedPizzaException {


        Pizza pizza = pizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // mvn clean install
    // java -cp target/eis2223-1.0-SNAPSHOT.jar it.unipd.dei.eis.gofpatterns.factory.PizzeriaEIS Bufala
    // java -cp target/eis2223-1.0-SNAPSHOT.jar it.unipd.dei.eis.gofpatterns.factory.PizzeriaEIS "Bufala;Asparagi;Margherita;Parmigiana;Bufala"
    public static void main(String[] argv) {

        PizzeriaEIS ps = new PizzeriaEIS();

        Pizza p;

        String[] pizzaOrders;

        // si possono specificare più pizze usando il punto e virgola come segue:
        // Bufala;Margherita;Parmigiana;Bufala;Asparagi;Asparagi
        if (argv[0].contains(";")) {
            pizzaOrders = argv[0].split(";");
        } else { // nel caso si specifichi una sola pizza
            pizzaOrders = new String[]{argv[0]};
        }

        for (String pizzaOrder : pizzaOrders) {
            try {
                p = ps.orderPizza(pizzaOrder);
                System.out.println(p.toString() + "\n");
            } catch (UnsupportedPizzaException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
