package RentalMovie;

import java.util.Scanner;

public class OrderedMoviesMenu {
    private Scanner scanner;

    public OrderedMoviesMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_orders_menu(){
        System.out.println();

        System.out.println("===What would you like to do?===");
        System.out.println("Add new order            (1)");
        System.out.println("Delete an order          (2)");
        System.out.println("Go back                  (3)");
        System.out.print("Your choice: ");

        int choice_ordered_movies = scanner.nextInt();

        switch (choice_ordered_movies){
            case 1:
                OrderedMoviesService addOrder = new OrderedMoviesService(scanner);
                addOrder.add_new_order();
                break;
            case 2:
                System.out.println("Are you sure that you want to change orders list? (y/n)");
                scanner.nextLine();
                char confirm_choice = scanner.nextLine().charAt(0);
                switch (confirm_choice){
                    case 'y':
                        OrderedMoviesService deleteRental = new OrderedMoviesService(scanner);
                        deleteRental.delete_rental();
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
