package FoodServicePackage;

import FoodPackage.Food;

public class FoodService {
    private Food[] foods = {
            new Food(1, "Burger", 7.50),
            new Food(2, "Pizza", 12.00),
            new Food(3, "Salat", 9.00),
            new Food(4, "Kartof Fri", 3.00),
            new Food(5, "Doner", 4.00),
            new Food(6, "Kabab", 11.50),
            new Food(7, "Sorba", 3.50),
            new Food(8, "Su", 1.00)
    };

    private Food[] basket = new Food[0];

    public void showMenu() {
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i]);
        }
    }

    public void showBasket() {
        if (basket.length == 0) {
            System.out.println("sepetiniz bosdu.");
            return;
        }

        double total = 0;
        for (int i = 0; i < basket.length; i++) {
            System.out.println(basket[i]);
            total = total + basket[i].getPrice();
        }
        System.out.println("umumi pul : " + total + " man");
    }

    public void addFoodToMenu(String name, double price) {
        int lastIndex = foods.length - 1;
        int newId = foods[lastIndex].getId() + 1;

        Food[] newFoods = new Food[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            newFoods[i] = foods[i];
        }

        newFoods[newFoods.length - 1] = new Food(newId, name, price);
        foods = newFoods;
        System.out.println("yemek menyuya elave oldu.");
    }

    public void orderFood(int id) {
        Food found = null;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].getId() == id) {
                found = foods[i];
                break;
            }
        }

        if (found == null) {
            System.out.println("sehv ID! belə bir yemek yoxdu.");
            return;
        }

        Food[] newBasket = new Food[basket.length + 1];
        for (int i = 0; i < basket.length; i++) {
            newBasket[i] = basket[i];
        }

        newBasket[newBasket.length - 1] = found;
        basket = newBasket;
        System.out.println("  " + found.getName() + " sepete elave oldu.");
    }
}
