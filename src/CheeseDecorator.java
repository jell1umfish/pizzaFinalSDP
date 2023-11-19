
// Decorator Pattern

class CheeseDecorator extends Pizza {
    private Pizza pizza;

    public CheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + " with added Cheese";
    }

    public double cost() {
        return pizza.cost() + 200;
    }
}