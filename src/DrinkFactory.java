

// Factory Pattern of Drink class


class DrinkFactory{
    public Drink createDrink(String type){
        switch (type) {
            case "Coke":
                return new Coke();
            case "Coffee":
                return new Coffee();

            case "Tea":
                return new Tea();

            default:
                System.out.println("We don't have this type of drink");
        }
        return null;
    }
}