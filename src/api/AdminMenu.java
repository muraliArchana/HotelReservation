package api;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {

     static Scanner scanner;
     static int menuItems;

    public static void displayAdminMenu() {

            try {
                System.out.println("Please select an option from Admin menu\n1. See all Customers \n2. See all Rooms\n" +
                        "3. See all Reservations \n4. Add a Room \n5. Back to Main menu");
                scanner = new Scanner(System.in);
                menuItems = scanner.nextInt();
                switch (menuItems) {
                    case 1:
                        System.out.println(AdminResource.getInstance().getAllCustomers());
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        MainMenu.displayMainMenu();
                        break;
                    default:
                        System.out.println("Invalid option! Please select number between 1-5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option ! Please select a number");

            }
            scanner.close();
            }

}
