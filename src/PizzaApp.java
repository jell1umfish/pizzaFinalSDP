import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class PizzaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaFactory pizzaFactory = new PizzaFactory();
        DrinkFactory drinkFactory = new DrinkFactory();

        System.out.println("Welcome to the our pizzeria!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Order pizza and drink");
            System.out.println("2. Exit");
            System.out.print("Select an option:\n");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("\nPizza Menu:");
                System.out.println("1. Margherita");
                System.out.println("2. Pepperoni");
                System.out.println("3. Spicy");

                System.out.print("Select a pizza type:\n");

                int pizzaChoice = scanner.nextInt();
                System.out.println("Do you want to add cheese? it costs 200 tenge\n" +
                        "1.Yes!\n" +
                        "2.No!");
                int YN= scanner.nextInt();
                System.out.println("\nDrink Menu:");
                System.out.println("1. Coke");
                System.out.println("2. Coffee");
                System.out.println("3. Tea");
                System.out.print("Select a drink type:\n");
                int drinkChoice = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();
                Pizza pizza = null;
                String pizzaType = "";
                Drink drink = null;
                String drinkType="";
                switch (pizzaChoice) {
                    case 1:
                        if(YN==1) {
                            pizza = new CheeseDecorator(pizzaFactory.createPizza("Margherita"));
                            pizzaType = "Margherita";
                            break;
                        }else if (YN==2){
                            pizza = pizzaFactory.createPizza("Margherita");
                            pizzaType = "Margherita";
                            break;
                        }else{
                            System.out.println("error");
                        }
                    case 2:
                        if(YN==1) {
                            pizza = new CheeseDecorator(pizzaFactory.createPizza("Pepperoni"));
                            pizzaType = "Pepperoni";
                            break;
                        }else if (YN==2){
                            pizza = pizzaFactory.createPizza("Pepperoni");
                            pizzaType = "Pepperoni";
                            break;
                        }else{
                            System.out.println("error");
                        }
                    case 3:
                        if(YN==1) {
                            pizza = new CheeseDecorator(pizzaFactory.createPizza("Spicy"));
                            pizzaType = "Spicy";
                            break;
                        }else if (YN==2){
                            pizza = pizzaFactory.createPizza("Spicy");
                            pizzaType = "Spicy";
                            break;
                        }else{
                            System.out.println("error");
                        }
                    default:
                        System.out.println("Invalid pizza selection.");
                        continue;
                }
                switch (drinkChoice) {
                    case 1:
                        drink = drinkFactory.createDrink("Coke");
                        drinkType = "Coke";
                        break;
                    case 2:
                        drink = drinkFactory.createDrink("Coffee");
                        drinkType = "Coffee";
                        break;
                    case 3:
                        drink = drinkFactory.createDrink("Tea");
                        drinkType = "Tea";
                        break;
                    default:
                        System.out.println("Invalid drink selection.");
                        continue;
                }
                System.out.println("Ordering " + pizzaType +" and "+ drinkType + " for " + customerName);
                Order order = new Order();
                order.addObserver(new Customer(customerName));
                order.setDescription(pizza.getDescription());
                order.setDescription(drink.getDescription());
                int costOFPizzaAndDrink = (int) (pizza.cost()+drink.cost());
                System.out.println("Total cost: " + costOFPizzaAndDrink+" tenge");
                // Payment
                System.out.println("\nPayment Options:");
                System.out.println("1. Credit Card");
                System.out.println("2. Cash");
                System.out.print("Select a payment method: ");
                int paymentChoice = scanner.nextInt();
                PaymentStrategy paymentStrategy = null;
                switch (paymentChoice) {
                    case 1:
                        System.out.print("Enter credit card number: ");
                        String cardNumber = scanner.next();
                        paymentStrategy = new CreditCardPayment(cardNumber, customerName);
                        break;
                    case 2:
                        paymentStrategy = new CashPayment();
                        break;
                    default:
                        System.out.println("Invalid payment selection.");
                        continue;
                }
                paymentStrategy.pay((int) pizza.cost()+(int)drink.cost());
                System.out.println("Thank you for your order!");

            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

