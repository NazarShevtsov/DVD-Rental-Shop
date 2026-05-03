package Movie.Genre;

public class Genre {
    int id_genre;
    String genre_name;

    //Constructor for selecting genres
    public Genre(
            int id_genre,
            String genre_name
    ){
        this.id_genre = id_genre;
        this.genre_name = genre_name;
    }

    //Constructor for adding genre
    public Genre(
            String genre_name
    ){
        this.genre_name = genre_name;
    }
}
