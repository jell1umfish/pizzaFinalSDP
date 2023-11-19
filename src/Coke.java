class Coke extends Drink {
    public Coke(){
        description = "Coca-cola";
    }
    @Override
    public double cost() {
        return 500;
    }
}