package RentalMovie;

import java.time.LocalDate;

public class RentalMovie {
    int id_order;
    public int id_movie;
    int id_client;
    LocalDate rent_date;
    String client_first_name;
    String client_second_name;
    public String movie_title;
    public int movie_year;

    public RentalMovie(
            int id_order,
            int id_movie,
            int id_client,
            LocalDate rent_date
    ){
        this.id_order = id_order;
        this.id_movie = id_movie;
        this.id_client = id_client;
        this.rent_date = rent_date;
    }

    //Constructor for selecting ordered and wished movies
    public RentalMovie(
            int id_order,
            String client_first_name,
            String client_second_name,
            String movie_title,
            int movie_year,
            LocalDate rent_date
    ){
        this.id_order = id_order;
        this.client_first_name = client_first_name;
        this.client_second_name = client_second_name;
        this.movie_title = movie_title;
        this.movie_year = movie_year;
        this.rent_date = rent_date;
    }

    //Constructor if there are movies with same title but different years
    public RentalMovie(
            int id_movie,
            String movie_title,
            int movie_year
    ){
        this.id_movie = id_movie;
        this.movie_title = movie_title;
        this.movie_year = movie_year;
    }

    //Constructor for adding new order and deleting
    public RentalMovie(
            int id_movie,
            int id_client,
            LocalDate rent_date
    ){
        this.id_movie = id_movie;
        this.id_client = id_client;
        this.rent_date = rent_date;
    }
}
