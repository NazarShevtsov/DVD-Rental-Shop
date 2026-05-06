package Movie;

import Movie.Genre.GenreMenu;

import java.util.Scanner;

public class MovieMenu {
    private Scanner scanner;

    public MovieMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void movie_menu(){
        int choice_menu;

        do{
            System.out.println();
            System.out.println("===What would you like to do?===");
            System.out.println("Manage my genres            (1)");
            System.out.println("See list of movies          (2)");
            System.out.println("Add new movie               (3)");
            System.out.println("Delete movie from the stock (4)");
            System.out.println("Go back                     (5)");
            System.out.print("Your choice: ");

            choice_menu = scanner.nextInt();
            scanner.nextLine();

            switch (choice_menu){
                case 1:
                    GenreMenu genreMenu = new GenreMenu(scanner);
                    genreMenu.show_genre_menu();
                    break;
                case 2:
                    MovieService showMovies = new MovieService(scanner);
                    showMovies.show_movies_list();
                    break;
                case 3:
                    MovieService addMovie = new MovieService(scanner);
                    addMovie.add_new_movie();
                    break;
                case 4:
                    MovieService deleteMovie = new MovieService(scanner);
                    deleteMovie.delete_movie();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("There are no such choice!");
            }

        }while(choice_menu != 5);
    }
}
