package Review;

import java.util.Scanner;

public class ReviewMenu {
    private Scanner scanner;

    public ReviewMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_review_menu(){
        int choice_review_menu;

        do {
            System.out.println();

            System.out.println("===What would you like to do with reviews?===");

            System.out.println();

            System.out.println("Show all reviews     (1)");
            System.out.println("Add new review       (2)");
            System.out.println("Delete a review      (3)");
            System.out.println("Go back              (4)");
            System.out.print("Your choice: ");

            choice_review_menu = scanner.nextInt();

            switch (choice_review_menu) {
                case 1:
                    ReviewService showReviews = new ReviewService(scanner);
                    showReviews.show_reviews();
                    break;
                case 2:
                    ReviewService addNewReview = new ReviewService(scanner);
                    addNewReview.add_new_review();
                    break;
                case 3:
                    System.out.println("Are you sure that you want to change review list? (y/n)");
                    scanner.nextLine();
                    char confirm_choice = scanner.nextLine().charAt(0);
                    switch (confirm_choice) {
                        case 'y':
                            ReviewService deleteReview = new ReviewService(scanner);
                            deleteReview.delete_review();
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
                    System.out.println("There is no such choice!");
            }
        }while(choice_review_menu != 4);
    }
}
