package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Nie można wczytać db.properties", e);
        }
    }

    public static String getUrl() {
        return props.getProperty("db.url");
    }

    public static String getUser() {
        return props.getProperty("db.user");
    }

    public static String getPassword() {
        return props.getProperty("db.password");
    }
}
