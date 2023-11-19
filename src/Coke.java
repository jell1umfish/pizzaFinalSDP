class Coke extends Drink {
    public Coke(){
        description = "Coke";
    }
    @Override
    public double cost() {
        return 500;
    }
}