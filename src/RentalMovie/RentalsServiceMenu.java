package RentalMovie;

import java.util.Scanner;

public class RentalsServiceMenu {
    private Scanner scanner;

    public RentalsServiceMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_rentals_menu(){
        int choice_menu;
        do {
            System.out.println();

            System.out.println("===What would you like to do with rentals?===");

            System.out.println();

            System.out.println("Show ordered movies         (1)");
            System.out.println("Show 'wish-list' movies     (2)");
            System.out.println("Go back                     (3)");
            System.out.print("Your choice: ");

            choice_menu = scanner.nextInt();

            switch (choice_menu) {
                case 1:
                    OrderedMoviesService orderedMoviesService = new OrderedMoviesService(scanner);
                    orderedMoviesService.show_ordered_movies();
                    break;
                case 2:
                    WishListService wishListService = new WishListService(scanner);
                    wishListService.show_wish_list();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("There are no such choice!");
            }
        }while(choice_menu != 3);

    }

}
