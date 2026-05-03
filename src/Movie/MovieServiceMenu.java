package Movie;

import Movie.Genre.GenreService;

import java.util.Scanner;

public class MovieServiceMenu {
    private Scanner scanner;

    public MovieServiceMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_movies_service_menu(){
        System.out.println();

        System.out.println("===What would you like to do?===");
        System.out.println("See list of genres          (1)");
        System.out.println("Add new movie               (2)");
        System.out.println("Delete movie from the stock (3)");
        System.out.println("Go back                     (4)");
        System.out.print("Your choice: ");

        int choose_service = scanner.nextInt();

        switch(choose_service){
            case 1:
                GenreService genre_list = new GenreService(scanner);
                genre_list.genre_list();
                break;
            case 2:
                MovieService add_movie = new MovieService(scanner);
                add_movie.add_new_movie();
                break;
            case 3:
                System.out.println("Are you sure that you want to change your movie`s list? (y/n)");
                scanner.nextLine();
                char confirm_choice = scanner.nextLine().charAt(0);
                switch (confirm_choice){
                    case 'y':
                        MovieService deleteMovie = new MovieService(scanner);
                        deleteMovie.delete_movie();
                        break;
                    case 'n':
                        System.out.println("We are going back to the menu!");
                        break;
                    default:
                        System.out.println("Please type correct answer!");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("There no such a choice!");
        }

    }
}
