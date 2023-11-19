class Coffee extends Drink {
    public Coffee(){
        description = "Coffee";
    }
    @Override
    public double cost() {
        return 500;
    }
}