package Movie.Genre;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Genre_Query {

    public List<Genre> show_genres_list(){
        List<Genre> genres = new ArrayList<>();

        String sql = "SELECT * FROM genres";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){
            ResultSet result = prepst.executeQuery();
            while(result.next()){
                Genre genre = new Genre(
                        result.getInt("id_genre"),
                        result.getString("genre_name")
                );
                genres.add(genre);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return genres;
    }

    public void add_new_genre(Genre genre){
        String sql = "INSERT INTO genres(genre_name) VALUES(?)";

        try(Connection con = DatabaseConnection.getConnection();
        PreparedStatement prepst = con.prepareStatement(sql)){
            prepst.setString(1, genre.genre_name);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("New genre was added!");
            }else{
                System.out.println("No new genre was added!");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int search_genre_id(String movie_genre){
        String sql = "SELECT id_genre FROM genres WHERE genre_name ILIKE ?";

        int id_genre = 0;

        try(Connection con = DatabaseConnection.getConnection();
        PreparedStatement prepst = con.prepareStatement(sql)){
            prepst.setString(1, movie_genre);
            ResultSet result = prepst.executeQuery();
            if(result.next()){
                id_genre = result.getInt("id_genre");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return id_genre;
    }
}
