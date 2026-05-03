package Client;

import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Client_Query {

    public List<Client> show_client_list(){
        List<Client> clients = new ArrayList<>();

        String sql = "SELECT * FROM clients";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)) {

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                Client client = new Client(
                        result.getInt("id_client"),
                        result.getString("client_first_name"),
                        result.getString("client_last_name"),
                        result.getDate("client_birth_date").toLocalDate(),
                        result.getString("client_phone"),
                        result.getString("client_email")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public List<Client> find_client(Client findClient){
        List<Client> clients_list = new ArrayList<>();

        String sql = "SELECT * FROM clients " +
                "WHERE client_first_name = ? and client_last_name = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setString(1, findClient.client_first_name);
            prepst.setString(2, findClient.client_last_name);

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                Client founded_client = new Client(
                        result.getInt("id_client"),
                        result.getString("client_first_name"),
                        result.getString("client_last_name"),
                        result.getDate("client_birth_date").toLocalDate(),
                        result.getString("client_phone"),
                        result.getString("client_email")
                );
                clients_list.add(founded_client);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return clients_list;
    }

    public void add_new_client(Client addClient){
        String sql = "INSERT INTO clients " +
                "(client_first_name, client_last_name, client_birth_date, client_phone, client_email)\n" +
                "VALUES(?, ?, ?, ?, ?)";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

                prepst.setString(1, addClient.client_first_name);
                prepst.setString(2, addClient.client_last_name);
                prepst.setDate(3, Date.valueOf(addClient.client_birth_date));
                prepst.setString(4, addClient.client_phone);
                prepst.setString(5, addClient.client_email);

                int rows = prepst.executeUpdate();

                if(rows > 0){
                    System.out.println("New client was added!");
                }else{
                    System.out.println("No new client was added!");
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_client(int choose_id){
        String sql = "DELETE FROM clients WHERE id_client = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1, choose_id);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("Client was deleted from database!");
            }else{
                System.out.println("No client was deleted!");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
