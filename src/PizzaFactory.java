
// Factory Pattern of Pizza class

class PizzaFactory {
    public Pizza createPizza(String type) {
        switch (type) {
            case "Margherita":
                return new Margherita();
            case "Pepperoni":
                return new Pepperoni();

            case "Spicy":
                return new Spicy();

            default:
                System.out.println("We don't have this type of pizza");
        }
        return null;
    }
}