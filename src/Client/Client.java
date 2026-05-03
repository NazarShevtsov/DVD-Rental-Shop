package Client;

import java.time.LocalDate;

public class Client {
    public int id_client;
    public String client_first_name;
    public String client_last_name;
    LocalDate client_birth_date;
    String client_phone;
    String client_email;

    //Constructor for selecting clients
    public Client(
            int id_client,
            String client_first_name,
            String client_last_name,
            LocalDate client_birth_date,
            String client_phone,
            String client_email
    ){
        this.id_client = id_client;
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
        this.client_birth_date = client_birth_date;
        this.client_phone = client_phone;
        this.client_email = client_email;
    }

    // Constructor for adding new client
    public Client(
            String client_first_name,
            String client_last_name,
            LocalDate client_birth_date,
            String client_phone,
            String client_email
    ){
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
        this.client_birth_date = client_birth_date;
        this.client_phone = client_phone;
        this.client_email = client_email;
    }

    //Constructor for deleting client
    public Client(
            String client_first_name,
            String client_last_name
    ){
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
    }

}
