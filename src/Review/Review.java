package Review;

import java.time.LocalDate;

public class Review {
    int id_review;
    int id_movie;
    int id_client;
    String client_first_name;
    String client_last_name;
    String movie_title;
    int movie_year;
    String review;
    LocalDate review_date;

    public Review(
            int id_review,
            int id_movie,
            int id_client,
            String review,
            LocalDate review_date
    ){
        this.id_review = id_review;
        this.id_movie = id_movie;
        this.id_client = id_client;
        this.review = review;
        this.review_date =review_date;
    }

    public Review(
            int id_review,
            String client_first_name,
            String client_last_name,
            String movie_title,
            int movie_year,
            String review,
            LocalDate review_date
    ){
        this.id_review = id_review;
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
        this.movie_title = movie_title;
        this.movie_year = movie_year;
        this.review = review;
        this.review_date =review_date;
    }

    //Constructor for adding new review
    public Review(
            int id_movie,
            int id_client,
            String review,
            LocalDate review_date
    ){
        this.id_movie = id_movie;
        this.id_client = id_client;
        this.review = review;
        this.review_date =review_date;
    }
}
