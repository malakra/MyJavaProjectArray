import FoodServicePackage.FoodService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoodService service = new FoodService();
        Scanner scanner = new Scanner(System.in);
        boolean status = true;

        while (status) {
            System.out.println("1. menyunu goster");
            System.out.println("2. sebeti goster");
            System.out.println("3. sifaris ele");
            System.out.println("4. teze yemek elave ele");
            System.out.println("0. cixis");
            System.out.print("seciminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                service.showMenu();
            } else if (choice == 2) {
                service.showBasket();
            } else if (choice == 3) {
                System.out.print("yemeyin ID i yaz: ");
                int id = scanner.nextInt();
                service.orderFood(id);
            } else if (choice == 4) {
                System.out.print("yemeyin adi: ");
                String name = scanner.nextLine();
                System.out.print("yemeyin qiymeti: ");
                double price = scanner.nextDouble();
                service.addFoodToMenu(name, price);
            } else if (choice == 0) {
                status = false;
                System.out.println("proqramdan cixildi. Nus olsun!");
            } else {
                System.out.println("sehv secim elediz! tezden yoxla .");
            }
        }
        scanner.close();
    }
}
