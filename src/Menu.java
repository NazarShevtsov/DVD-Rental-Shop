import Client.ClientService;
import Movie.MovieService;
import RentalMovie.RentalsServiceMenu;
import Review.ReviewMenu;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

    public void showMenu(){
        int choice;

        do{
            System.out.println();
            System.out.println();

            System.out.println("Hi! Welcome to DVD RentalShop!");
            System.out.println("===What would you like to do?===");

            System.out.println();

            System.out.println("Manage my clients      (1)");
            System.out.println("Manage my movies stock (2)");
            System.out.println("Manage orders          (3)");
            System.out.println("To see reviews         (4)");

            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    ClientService clientService = new ClientService(scanner);
                    clientService.clients_list();
                    break;

                case 2:
                    MovieService movieService = new MovieService(scanner);
                    movieService.movies_list();
                    break;
                case 3:
                    RentalsServiceMenu rentalsServiceMenu = new RentalsServiceMenu(scanner);
                    rentalsServiceMenu.show_rentals_menu();
                    break;
                case 4:
                    ReviewMenu reviewMenu = new ReviewMenu(scanner);
                    reviewMenu.show_review_menu();
                    break;
                default:
                    System.out.println("There are no such option!");
            }
        }while(choice != 0);
    }
}
