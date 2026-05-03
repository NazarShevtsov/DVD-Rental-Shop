package RentalMovie;

import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WishList_Query {

    public List<RentalMovie> show_wish_list(){
        List<RentalMovie> wish_list = new ArrayList<>();

        String sql = "SELECT clients.client_first_name, clients.client_last_name, " +
                "movies.movie_title, movies.movie_year, wish_list.id_order, wish_list.rent_when\n" +
                "FROM clients\n" +
                "INNER JOIN wish_list\n" +
                "ON clients.id_client = wish_list.id_client \n" +
                "INNER JOIN movies \n" +
                "ON movies.id_movie = wish_list.id_movie";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                RentalMovie wished_movie = new RentalMovie(
                        result.getInt("id_order"),
                        result.getString("client_first_name"),
                        result.getString("client_last_name"),
                        result.getString("movie_title"),
                        result.getInt("movie_year"),
                        result.getDate("rent_when").toLocalDate()
                );
                wish_list.add(wished_movie);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return wish_list;
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

    public void add_new_wish(RentalMovie newWish){

        String sql = "INSERT INTO wish_list(id_movie, id_client, rent_when) VALUES(?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1,newWish.id_movie);
            prepst.setInt(2,newWish.id_client);
            prepst.setDate(3, Date.valueOf(newWish.rent_date));

            int rows = prepst.executeUpdate();

            if (rows > 0){
                System.out.println("New wish was added!");
            }else{
                System.out.println("No wish was added!");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete_wish(int id_order){
        String sql = "DELETE FROM wish_list WHERE id_order = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1, id_order);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("Wished movie was deleted!");
            }else{
                System.out.println("No wished movie was deleted!");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
