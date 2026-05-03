package RentalMovie;

import Client.Client;
import Client.Client_Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OrderedMoviesService {
    private Scanner scanner;

    public OrderedMoviesService(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_ordered_movies(){
        System.out.println("This is a list ordered movies:");
        System.out.println();

        OrderedMovies_Query orderedMovies_query = new OrderedMovies_Query();
        List<RentalMovie> ordered_list = orderedMovies_query.show_ordered_movie_list();

        for(RentalMovie r : ordered_list){
            System.out.println("Rental Nr " + r.id_order);
            System.out.println("Client: " + r.client_first_name + " " + r.client_second_name);
            System.out.println("Ordered movie: " + r.movie_title + " (" + r.movie_year + ")");
            System.out.println("Due to: " + r.rent_date);
            System.out.println();
        }

        OrderedMoviesMenu orderedMoviesMenu = new OrderedMoviesMenu(scanner);
        orderedMoviesMenu.show_orders_menu();

        scanner.nextLine();
        System.out.print("Would you like to go back? (Press Enter)");
        scanner.nextLine();
    }

    public void add_new_order(){
        scanner.nextLine();

        System.out.print("Enter client first name: ");
        String first_name = scanner.nextLine();

        System.out.print("Enter client last name: ");
        String last_name = scanner.nextLine();

        Client checkClient = new Client(first_name, last_name);
        Client_Query findClient = new Client_Query();
        List<Client> checked_clients = findClient.find_client(checkClient);

        int rows_duplicate_client = checked_clients.size();
        int id_client;

        if (rows_duplicate_client > 1){

            System.out.println();
            System.out.println("Who made the order?");
            for(Client client : checked_clients){
                System.out.println(client.id_client + " " + client.client_first_name + " " + client.client_last_name);
            }

            System.out.println();
            System.out.print("Client id: ");
            id_client = scanner.nextInt();

        }else{
            id_client = checked_clients.get(0).id_client;
        }

        System.out.print("Enter ordered movie: ");
        String title = scanner.nextLine();

        OrderedMovies_Query checkTitle = new OrderedMovies_Query();
        List<RentalMovie> movies_list = checkTitle.check_movie_title(title);

        int rows_duplicate_movie = movies_list.size();
        int id_movie;

        if (rows_duplicate_movie > 1){

            System.out.println();
            System.out.println("Which movie was ordered?");

            for(RentalMovie r : movies_list){
                System.out.println(r.id_movie + " " + r.movie_title + " (" + r.movie_year + ")");
            }

            System.out.println();
            System.out.print("Movie id: ");
            id_movie = scanner.nextInt();
        }else{
            id_movie = movies_list.get(0).id_movie;
        }
        scanner.nextLine();

        System.out.print("Enter date due movie is rented (yyyy-mm-dd): ");
        LocalDate rent_when = LocalDate.parse(scanner.nextLine());

        RentalMovie newOrder = new RentalMovie(id_movie, id_client, rent_when);
        OrderedMovies_Query addNewOrder = new OrderedMovies_Query();
        addNewOrder.add_new_order(newOrder);
    }

    public void delete_rental(){
        System.out.println("There a list of all rental");

        OrderedMovies_Query orderedMovies_query = new OrderedMovies_Query();
        List<RentalMovie> ordered_list = orderedMovies_query.show_ordered_movie_list();

        for(RentalMovie r : ordered_list){
            System.out.println("Rental Nr " + r.id_order);
            System.out.println("Client: " + r.client_first_name + " " + r.client_second_name);
            System.out.println("Ordered movie: " + r.movie_title + " (" + r.movie_year + ")");
            System.out.println("Due to: " + r.rent_date);
            System.out.println();
        }

        System.out.println();

        System.out.print("Enter number of rental to delete: ");
        int id_order = scanner.nextInt();

        OrderedMovies_Query deleteRental_query = new OrderedMovies_Query();
        deleteRental_query.delete_rental(id_order);
    }
}
