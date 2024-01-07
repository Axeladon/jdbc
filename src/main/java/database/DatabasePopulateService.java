package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService implements QueryReader {
    public static void main(String[] args) {
        try (
                Connection connection = Database.getInstance().getConnection();
                Statement statement = connection.createStatement()
        ) {
            String query = new DatabasePopulateService().readQueryFromFile("sql/populate_db.sql");
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
