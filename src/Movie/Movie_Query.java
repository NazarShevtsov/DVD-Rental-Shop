package Movie;

import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Movie_Query {

    public List<Movie> show_movies_list(){
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movies";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                Movie movie = new Movie(
                        result.getInt("id_movie"),
                        result.getString("movie_title"),
                        result.getInt("movie_year"),
                        result.getString("movie_country"),
                        result.getDouble("movie_price"),
                        result.getInt("id_genre")
                );
                movies.add(movie);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return movies;
    }

    public List<Movie> find_movie(Movie findMovie){
        List<Movie> movies_list = new ArrayList<>();

        String sql = "SELECT * FROM movies WHERE movie_title = ? AND movie_year = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setString(1, findMovie.movie_title);
            prepst.setInt(2, findMovie.movie_year);

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                Movie founded_movie = new Movie(
                        result.getInt("id_movie"),
                        result.getString("movie_title"),
                        result.getInt("movie_year"),
                        result.getString("movie_country"),
                        result.getDouble("movie_price"),
                        result.getInt("id_genre")
                );
                movies_list.add(founded_movie);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return movies_list;
    }

    public void add_new_movie(Movie addMovie){
        String sql = "INSERT INTO movies(movie_title, movie_year, movie_country, movie_price, id_genre)" +
                "VALUES(?, ?, ?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setString(1,addMovie.movie_title);
            prepst.setInt(2, addMovie.movie_year);
            prepst.setString(3, addMovie.movie_country);
            prepst.setDouble(4, addMovie.movie_price);
            prepst.setInt(5, addMovie.id_genre);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("New movie was added to stock!");
            }else{
                System.out.println("No movie was added!");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete_movie(int choose_id){
        String sql = "DELETE FROM movies WHERE id_movie = ?";

        try(Connection con = DatabaseConnection.getConnection();
        PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1, choose_id);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("Movie was deleted from your stock!");
            }else{
                System.out.println("No movie was deleted!");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
