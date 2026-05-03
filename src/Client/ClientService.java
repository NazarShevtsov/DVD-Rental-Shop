package Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClientService {
    private Scanner scanner;

    public ClientService(Scanner scanner){
        this.scanner = scanner;
    }

    public void clients_list(){
        System.out.println();
        System.out.println("This is a list of your clients:");

        Client_Query client_query = new Client_Query();
        List<Client> clients = client_query.show_client_list();

        for(Client c : clients){
            System.out.println(c.client_first_name + " " + c.client_last_name);
        }

        System.out.println();
        System.out.println();

        ClientServiceMenu client_menu = new ClientServiceMenu(scanner);
        client_menu.show_client_service_menu();


        System.out.print("Would you like to go back? (Press Enter)");
        scanner.nextLine();
    }

    public void add_new_client(){
        System.out.print("First name: ");
        String first_name = scanner.nextLine();

        System.out.print("Last name: ");
        String last_name = scanner.nextLine();

        System.out.print("Birth date (yyyy-mm-dd): ");
        LocalDate birth_date = LocalDate.parse(scanner.nextLine());

        System.out.print("Phone number (+48 123 456 789): ");
        String phone_num = scanner.nextLine();

        System.out.print("Email (example@example.com): ");
        String email = scanner.nextLine();
        System.out.println();

        Client addClient = new Client(first_name,last_name,birth_date,phone_num,email);

        Client_Query addNewClient = new Client_Query();
        addNewClient.add_new_client(addClient);
    }

    public void delete_client(){
        System.out.print("Enter client`s first name: ");
        String first_name = scanner.nextLine();

        System.out.print("Enter client`s last name: ");
        String last_name = scanner.nextLine();
        System.out.println();

        Client findClient = new Client(first_name, last_name);

        Client_Query findClientList = new Client_Query();
        List<Client> founded_clients = findClientList.find_client(findClient);

        int rows_duplicate = founded_clients.size();

        if(rows_duplicate > 1){
            System.out.println("Choose which one to delete!");
            for(Client c : founded_clients){
                System.out.println(c.id_client + " " + c.client_first_name + " " + c.client_last_name);
            }
            System.out.println();

            System.out.print("Your choice: ");
            int choose_id = scanner.nextInt();

            Client_Query deleteClient = new Client_Query();
            deleteClient.delete_client(choose_id);
        }else{
            int client_id = founded_clients.get(0).id_client;

            Client_Query deleteClient = new Client_Query();
            deleteClient.delete_client(client_id);
        }
    }
}
