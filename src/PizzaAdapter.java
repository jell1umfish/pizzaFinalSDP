
// Adapter Pattern

class PizzaAdapter implements PaymentStrategy {
    private PizzaOven pizzaOven;
    private String pizzaType;

    public PizzaAdapter(PizzaOven pizzaOven, String pizzaType) {
        this.pizzaOven=pizzaOven;
        this.pizzaType =pizzaType;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " for a pizza " + pizzaType);
        pizzaOven.bakePizza(pizzaType);
    }
}