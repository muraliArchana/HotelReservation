package api;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

     public static Scanner scanner;
   // AdminMenu adminMenu=new AdminMenu();
    static int menuItem;
    public  static void displayMainMenu()
    {
        while(true) {

            try {
                System.out.println("Please select an option from Main menu\n1. Find and Reserve a Room \n2. See my Reservation\n" +
                        "3. Create an account \n4. Admin menu \n5. Exit");
                scanner = new Scanner(System.in);
                menuItem = scanner.nextInt();
                switch (menuItem) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.println("Please enter FirstName");
                        String firstName=scanner.nextLine();
                        System.out.println("Please enter Last Name");
                        String lastName=scanner.nextLine();
                        System.out.println("Please enter Email address");
                        String email=scanner.nextLine();

                        HotelResource.getInstance().createACustomer(email,firstName,lastName);
                        break;
                    case 4:
                        AdminMenu.displayAdminMenu();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option! Please select number between 1-5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option ! Please select a number");
                continue;

            }

        }

    }
}
