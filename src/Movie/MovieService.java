package Movie;

import Movie.Genre.Genre_Query;

import java.util.List;
import java.util.Scanner;

public class MovieService {
    private Scanner scanner;

    public MovieService(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_movies_list(){
        System.out.println();
        System.out.println("This is a list of your movie`s stock:");

        Movie_Query movie_query = new Movie_Query();
        List<Movie> movies = movie_query.show_movies_list();

        for(Movie m : movies){
            System.out.println(m.movie_title + " (" + m.movie_year + ")");
        }

    }

    public void add_new_movie(){

        System.out.print("Enter movie title: ");
        String movie_title = scanner.nextLine();

        System.out.print("Enter movie year: ");
        int movie_year = scanner.nextInt();

        System.out.print("Enter movie country: ");
        String movie_country = scanner.nextLine();

        scanner.nextLine();

        System.out.print("Enter movie price (ex. 1,99): ");
        String price = scanner.nextLine();
        price = price.replace(",", ".");
        double movie_price = Double.parseDouble(price);

        System.out.print("Enter movie genre: ");
        String movie_genre = scanner.nextLine();

        Genre_Query search_id = new Genre_Query();
        int id_genre = search_id.search_genre_id(movie_genre);

        if(id_genre != 0){
            Movie addMovie = new Movie(movie_title,movie_year,movie_country,movie_price,id_genre);

            Movie_Query addNewMovie = new Movie_Query();
            addNewMovie.add_new_movie(addMovie);
        }else{
            System.out.println("There are no such genre! Please add a new genre firstly!");
        }

    }

    public void delete_movie(){
        System.out.print("Enter movie title: ");
        String movie_title = scanner.nextLine();

        System.out.print("Enter movie year: ");
        int movie_year = scanner.nextInt();

        Movie findMovie = new Movie(movie_title, movie_year);

        Movie_Query find_movie = new Movie_Query();
        List<Movie> movie_list = find_movie.find_movie(findMovie);

        int rows_duplicated = movie_list.size();

        if(rows_duplicated > 1){
            System.out.println("Which one you want to delete?");
            for(Movie m : movie_list){
                System.out.println(m.id_movie + ". " + m.movie_title + " (" + m.movie_year + ")");
            }

            int choose_id = scanner.nextInt();

            Movie_Query deleteMovie = new Movie_Query();
            deleteMovie.delete_movie(choose_id);
        }else{
            int id_movie = movie_list.get(0).id_movie;

            Movie_Query deleteMovie = new Movie_Query();
            deleteMovie.delete_movie(id_movie);
        }
    }

}
