package Review;

import database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Reviews_Query {

    public List<Review> show_reviews(){
        List<Review> reviews_list = new ArrayList<>();

        String sql = "SELECT reviews.id_review, clients.client_first_name, clients.client_last_name,\n" +
                "movies.movie_title, movies.movie_year, reviews.review, reviews.review_date\n" +
                "FROM reviews\n" +
                "INNER JOIN clients\n" +
                "ON reviews.id_client = clients.id_client\n" +
                "INNER JOIN movies\n" +
                "ON reviews.id_movie = movies.id_movie";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            ResultSet result = prepst.executeQuery();
            while(result.next()){
                Review review = new Review(
                        result.getInt("id_review"),
                        result.getString("client_first_name"),
                        result.getString("client_last_name"),
                        result.getString("movie_title"),
                        result.getInt("movie_year"),
                        result.getString("review"),
                        result.getDate("review_date").toLocalDate()
                );
                reviews_list.add(review);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return reviews_list;
    }

    public void add_new_review(Review addReview){
        String sql = "INSERT INTO reviews(id_movie, id_client, review, review_date)" +
                "VALUES(?, ?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1,addReview.id_movie);
            prepst.setInt(2,addReview.id_client);
            prepst.setString(3, addReview.review);
            prepst.setDate(4, Date.valueOf(addReview.review_date));

            int row = prepst.executeUpdate();

            if(row > 0){
                System.out.println("New review was added!");
            }else{
                System.out.println("No review was added!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_review(int id_review){
        String sql = "DELETE FROM reviews WHERE id_review = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement prepst = con.prepareStatement(sql)){

            prepst.setInt(1, id_review);

            int rows = prepst.executeUpdate();

            if(rows > 0){
                System.out.println("Review was deleted!");
            }else{
                System.out.println("No review was deleted!");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
