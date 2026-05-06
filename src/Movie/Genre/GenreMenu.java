package Movie.Genre;

import java.util.Scanner;

public class GenreMenu {

    private Scanner scanner;

    public GenreMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_genre_menu(){
        int choice_genre_menu;

        do{
            System.out.println();

            System.out.println("===What would you like to do with genres?===");
            System.out.println("Show genres list         (1)");
            System.out.println("Add a new genre          (2)");
            System.out.println("Go back                  (3)");
            System.out.print("Your choice: ");

            choice_genre_menu = scanner.nextInt();

            switch (choice_genre_menu){
                case 1:
                    GenreService showGenres = new GenreService(scanner);
                    showGenres.show_genre_list();
                    break;
                case 2:
                    GenreService addGenre = new GenreService(scanner);
                    addGenre.add_new_genre();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("There are no such choice!");

            }
        }while(choice_genre_menu != 3);
    }
}
