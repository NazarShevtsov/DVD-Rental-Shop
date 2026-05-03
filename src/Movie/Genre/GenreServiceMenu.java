package Movie.Genre;

import java.util.Scanner;

public class GenreServiceMenu {
    private Scanner scanner;

    public GenreServiceMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_genre_menu(){
        System.out.println();

        System.out.println("===What would you like to do?===");
        System.out.println("Add a new genre          (1)");
        System.out.println("Go back                  (2)");
        System.out.print("Your choice: ");

        int genre_choice = scanner.nextInt();

        switch (genre_choice){
            case 1:
                GenreService addNewGenre = new GenreService(scanner);
                addNewGenre.add_new_genre();
                break;
            case 2:
                break;
            default:
                System.out.println("There no such a choice!");
        }
    }
}
