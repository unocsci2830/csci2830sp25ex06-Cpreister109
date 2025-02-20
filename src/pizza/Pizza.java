package pizza;

import java.util.ArrayList;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.toppings.MeatTopping;
import pizza.toppings.PizzaTopping;

public class Pizza implements MenuItem {
    private PizzaCrust crust;
    private PizzaSauce sauce;
    private ArrayList<PizzaTopping> toppings;
    private ArrayList<MenuItem> selectionList;

    public Pizza(PizzaCrust crust, PizzaSauce sauce, ArrayList<PizzaTopping> toppings) {
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppings;
        this.selectionList = new ArrayList<>();

        selectionList.add(crust);
        selectionList.add(sauce);
        selectionList.addAll(toppings);
    }

    public PizzaCrust getCrust() {
        return crust;
    }

    public PizzaSauce getSauce() {
        return sauce;
    }

    public ArrayList<PizzaTopping> get() {
        return toppings;
    }

    @Override
    public Double getPrice() {
        Double totalPrice = 0.0;
        for (MenuItem item : selectionList) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }

    public void displayPizza() {
        System.out.println("Your Custom Pizza: ");
        for (MenuItem item : selectionList) {
            if (item instanceof MeatTopping) {
                System.out.println(((MeatTopping) item).toNiceString() + " | " + item.getPrice());
            } else {
                System.out.println(item.toString() + " | " + item.getPrice());
            }
        }

        System.out.println("Total Cost of your Pizza: " + getPrice());
    }
}
