package Movie.Genre;

import java.util.List;
import java.util.Scanner;

public class GenreService {
    public Scanner scanner;

    public GenreService(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_genre_list(){
        System.out.println();
        System.out.println("This is a list of genres:");

        Genre_Query genre_query = new Genre_Query();
        List<Genre> genre_list = genre_query.show_genres_list();

        for(Genre g : genre_list){
            System.out.println(g.genre_name);
        }
    }

    public void add_new_genre(){
        System.out.print("Enter a name of genre: ");
        scanner.nextLine();
        String genre_name = scanner.nextLine();

        Genre genre = new Genre(genre_name);

        Genre_Query addNewGenre = new Genre_Query();
        addNewGenre.add_new_genre(genre);
    }
}
