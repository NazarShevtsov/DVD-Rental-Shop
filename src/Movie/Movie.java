package Movie;

public class Movie {
    int id_movie;
    String movie_title;
    int movie_year;
    String movie_country;
    double movie_price;
    int id_genre;

    //Constructor for selecting movies
    public Movie(
            int id_movie,
            String movie_title,
            int movie_year,
            String movie_country,
            double movie_price,
            int id_genre
    ){
        this.id_movie = id_movie;
        this.movie_title = movie_title;
        this.movie_year = movie_year;
        this.movie_country = movie_country;
        this.movie_price = movie_price;
        this.id_genre = id_genre;
    }

    //Constructor for adding new movies
    public Movie(
            String movie_title,
            int movie_year,
            String movie_country,
            double movie_price,
            int id_genre
    ){
        this.movie_title = movie_title;
        this.movie_year = movie_year;
        this.movie_country = movie_country;
        this.movie_price = movie_price;
        this.id_genre = id_genre;
    }

    //Constructor for deleting movie
    public Movie(
            String movie_title,
            int movie_year
    ){
        this.movie_title = movie_title;
        this.movie_year = movie_year;
    }
}
