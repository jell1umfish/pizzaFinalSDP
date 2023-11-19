class Customer implements OrderObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(name + "! Your order is ready: " + order.getDescription());
    }
}
