package Client;

import java.util.Scanner;

public class ClientServiceMenu {
    private Scanner scanner;

    public ClientServiceMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void show_client_service_menu(){

        System.out.println("===What would you like to do?===");
        System.out.println("Add a new client (1)");
        System.out.println("Delete a client  (2)");
        System.out.println("Go back          (3)");
        System.out.print("Your choice: ");

        int client_service_choice = scanner.nextInt();
        scanner.nextLine();

        switch(client_service_choice){
            case 1:
                ClientService addClient = new ClientService(scanner);
                addClient.add_new_client();
                break;
            case 2:
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
            case 3:
                break;
            default:
                System.out.println("There no such a choice!");
        }

    }
}
