package Review;

import Client.Client;
import Client.Client_Query;
import RentalMovie.RentalMovie;
import RentalMovie.WishList_Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReviewService {
    private Scanner scanner;

    public ReviewService(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_reviews(){
        System.out.println("These are all reviews for now");
        System.out.println();

        Reviews_Query reviewsQuery = new Reviews_Query();
        List<Review> reviews_list = reviewsQuery.show_reviews();

        for(Review r : reviews_list){
            System.out.println("Review Nr " + r.id_review);
            System.out.println("Client: " + r.client_first_name + " " + r.client_last_name);
            System.out.println("Movie: " + r.movie_title + " (" + r.movie_year + ")");
            System.out.println("Date: " + r.review_date);
            System.out.println("Review: " + r.review);
            System.out.println();
        }
    }

    public void add_new_review(){
        scanner.nextLine();
        System.out.print("Enter client first name: ");
        String first_name = scanner.nextLine();

        System.out.print("Enter client last name: ");
        String last_name = scanner.nextLine();

        Client findClient = new Client(first_name, last_name);
        Client_Query client_query = new Client_Query();

        List<Client> founded_clients = client_query.find_client(findClient);

        int rows_duplicate_client = founded_clients.size();
        int id_client;

        if (rows_duplicate_client > 1){

            System.out.println();
            System.out.println("Who is writing a review?");
            for(Client client : founded_clients){
                System.out.println(client.id_client + " " + client.client_first_name + " " + client.client_last_name);
            }

            System.out.println();
            System.out.print("Client id: ");
            id_client = scanner.nextInt();

        }else{
            id_client = founded_clients.get(0).id_client;
        }

        System.out.print("Enter movie for review: ");
        String title = scanner.nextLine();

        WishList_Query checkTitle = new WishList_Query();
        List<RentalMovie> movies_list = checkTitle.check_movie_title(title);

        int rows_duplicate_movie = movies_list.size();
        int id_movie;

        if (rows_duplicate_movie > 1){

            System.out.println();
            System.out.println("Which movie is review?");

            for(RentalMovie r : movies_list){
                System.out.println(r.id_movie + " " + r.movie_title + " (" + r.movie_year + ")");
            }

            System.out.println();
            System.out.print("Movie id: ");
            id_movie = scanner.nextInt();
        }else{
            id_movie = movies_list.get(0).id_movie;
        }

        LocalDate review_date = LocalDate.now();

        scanner.nextLine();
        System.out.print("Enter your review (max 255 symbols): ");
        String review = scanner.nextLine();

        Review addReview = new Review(id_movie, id_client, review, review_date);
        Reviews_Query reviews_query = new Reviews_Query();
        reviews_query.add_new_review(addReview);

    }

    public void delete_review(){
        show_reviews();

        System.out.print("Enter number review to delete: ");
        int id_review = scanner.nextInt();

        Reviews_Query reviewsQuery = new Reviews_Query();
        reviewsQuery.delete_review(id_review);

    }
}
