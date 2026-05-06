package Client;

import java.util.Scanner;

public class ClientMenu {
    private Scanner scanner;

    public ClientMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void client_menu(){
        int choice_menu;

        do {
            System.out.println();
            System.out.println("===What would you like to do with clients?===");
            System.out.println("Show clients list (1)");
            System.out.println("Add a new client  (2)");
            System.out.println("Delete a client   (3)");
            System.out.println("Go back           (4)");
            System.out.print("Your choice: ");

            choice_menu = scanner.nextInt();
            scanner.nextLine();

            switch (choice_menu) {
                case 1:
                    ClientService showList = new ClientService(scanner);
                    showList.show_clients_list();
                    break;
                case 2:
                    ClientService addClient = new ClientService(scanner);
                    addClient.add_new_client();
                    break;
                case 3:
                    System.out.println("Are you sure that you want to change your client`s list? (y/n)");
                    char confirm_choice = scanner.nextLine().charAt(0);
                    switch (confirm_choice){
                        case 'y':
                            ClientService deleteClient = new ClientService(scanner);
                            deleteClient.delete_client();
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
                    System.out.println("There are no such choice!");
            }
        }while(choice_menu != 4);
    }
}
