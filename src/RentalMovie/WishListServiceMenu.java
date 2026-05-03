package RentalMovie;

import java.util.Scanner;

public class WishListServiceMenu {
    private Scanner scanner;

    public WishListServiceMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_wish_list_menu(){
        System.out.println();

        System.out.println("===What would you like to do?===");
        System.out.println("Add new wished movie            (1)");
        System.out.println("Delete a wished movie           (2)");
        System.out.println("Go back                         (3)");
        System.out.print("Your choice: ");

        int choice_wish_list = scanner.nextInt();

        switch (choice_wish_list){
            case 1:
                WishListService addNewWish = new WishListService(scanner);
                addNewWish.add_new_wish();
                break;
            case 2:
                System.out.println("Are you sure that you want to change wish list? (y/n)");
                scanner.nextLine();
                char confirm_choice = scanner.nextLine().charAt(0);
                switch (confirm_choice){
                    case 'y':
                        WishListService deleteWish = new WishListService(scanner);
                        deleteWish.delete_wished_movie();
                        break;
                    case 'n':
                        System.out.println("We are going back to the menu!");
                        break;
                    default:
                        System.out.println("Please type correct answer!");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("There are no such choice!");
        }
    }
}
