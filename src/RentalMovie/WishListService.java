package RentalMovie;

import Client.Client;
import Client.Client_Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class WishListService {
    private Scanner scanner;

    public WishListService(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_wish_list(){
        System.out.println("This is a list of movies desired to rent:");
        System.out.println();

        WishList_Query wishList_query = new WishList_Query();
        List<RentalMovie> wish_list = wishList_query.show_wish_list();

        for(RentalMovie r : wish_list){
            System.out.println("Wish Nr " + r.id_order);
            System.out.println("Client: " + r.client_first_name + " " + r.client_second_name);
            System.out.println("Ordered movie: " + r.movie_title + " (" + r.movie_year + ")");
            System.out.println("When: " + r.rent_date);
            System.out.println();
        }

        WishListServiceMenu wishListMenu = new WishListServiceMenu(scanner);
        wishListMenu.show_wish_list_menu();
    }

    public void add_new_wish(){
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

        WishList_Query checkTitle = new WishList_Query();
        List<RentalMovie> movies_list = checkTitle.check_movie_title(title);

        int rows_duplicate_movie = movies_list.size();
        int id_movie;

        if (rows_duplicate_movie > 1){

            System.out.println();
            System.out.println("Which movie wish to order?");

            for(RentalMovie r : movies_list){
                System.out.println(r.id_movie + " " + r.movie_title + " (" + r.movie_year + ")");
            }

            System.out.println();
            System.out.print("Movie id: ");
            id_movie = scanner.nextInt();
        }else{
            id_movie = movies_list.get(0).id_movie;
        }

        System.out.print("Enter date when client want to rent (yyyy-mm-dd): ");
        LocalDate rent_when = LocalDate.parse(scanner.nextLine());

        RentalMovie newWish = new RentalMovie(id_movie, id_client, rent_when);
        WishList_Query addNewWish = new WishList_Query();
        addNewWish.add_new_wish(newWish);
    }

    public void delete_wished_movie(){
        System.out.println("There a list of all wished movies");

        WishList_Query wishList_query = new WishList_Query();
        List<RentalMovie> wish_list = wishList_query.show_wish_list();

        for(RentalMovie r : wish_list){
            System.out.println("Wish Nr " + r.id_order);
            System.out.println("Client: " + r.client_first_name + " " + r.client_second_name);
            System.out.println("Ordered movie: " + r.movie_title + " (" + r.movie_year + ")");
            System.out.println("Due to: " + r.rent_date);
            System.out.println();
        }

        System.out.println();

        System.out.print("Enter number of wish to delete: ");
        int id_order = scanner.nextInt();

        WishList_Query deleteWish_query = new WishList_Query();
        deleteWish_query.delete_wish(id_order);
    }
}
