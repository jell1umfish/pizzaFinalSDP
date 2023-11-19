class Tea extends Drink {
    public Tea(){
        description = "Tea";
    }
    @Override
    public double cost() {
        return 500;
    }
}
