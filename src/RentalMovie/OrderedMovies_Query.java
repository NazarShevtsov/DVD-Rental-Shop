package RentalMovie;

import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderedMovies_Query {

    public List<RentalMovie> show_ordered_movie_list(){
        List<RentalMovie> ordered_list = new ArrayList<>();

        String sql = "SELECT clients.client_first_name, clients.client_last_name, " +
                "movies.movie_title, movies.movie_year, rentals.id_order, rentals.rented_due_to\n" +
                "FROM clients\n" +
                "INNER JOIN rentals\n" +
                "ON clients.id_client = rentals.id_client \n" +
                "INNER JOIN movies \n" +
                "ON movies.id_movie = rentals.id_movie";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                RentalMovie ordered_movie = new RentalMovie(
                        result.getInt("id_order"),
                        result.getString("client_first_name"),
                        result.getString("client_last_name"),
                        result.getString("movie_title"),
                        result.getInt("movie_year"),
                        result.getDate("rented_due_to").toLocalDate()
                );
                ordered_list.add(ordered_movie);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ordered_list;
    }

    public List<RentalMovie> check_movie_title(String movie_title){
        List<RentalMovie> checked_titles = new ArrayList<>();

        String sql = "SELECT id_movie, movie_title, movie_year FROM movies WHERE movie_title LIKE ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setString(1, movie_title);

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                RentalMovie movie = new RentalMovie(
                        result.getInt("id_movie"),
                        result.getString("movie_title"),
                        result.getInt("movie_year")
                );
                checked_titles.add(movie);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return checked_titles;
    }

    public void add_new_order(RentalMovie newOrder){

        String sql = "INSERT INTO rentals(id_movie, id_client, rented_due_to) VALUES(?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1,newOrder.id_movie);
            prepst.setInt(2,newOrder.id_client);
            prepst.setDate(3, Date.valueOf(newOrder.rent_date));

            int rows = prepst.executeUpdate();

            if (rows > 0){
                System.out.println("New order was added!");
            }else{
                System.out.println("No order was added!");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete_rental(int id_order){
        String sql = "DELETE FROM rentals WHERE id_order = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1, id_order);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("Rental was deleted!");
            }else{
                System.out.println("No rental was deleted!");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
