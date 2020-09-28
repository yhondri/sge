import entity.Product;

import java.sql.*;
import java.util.List;
import java.util.TimeZone;

public class MysqlManager {
    private final String dataBaseURL = "jdbc:mysql://localhost:3306/SGE?serverTimezone="+TimeZone.getDefault().getID();
    private Connection connection;
    private final String tableName = "product_product";

    public void openConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dataBaseURL, "root", "");
    }

    public void closeConecction() throws SQLException {
        connection.close();
    }

    public void insert(List<Product> productList) throws SQLException {
        String deleteQuery = "DELETE FROM " + tableName;
        PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
        deleteStmt.execute();

        // the mysql insert statement
        String query = "INSERT INTO " + tableName + " (id, default_code, active, barcode, volume, weight)"
                + " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);

        for (Product product : productList) {
            // create the mysql insert preparedstatement
            preparedStmt.setInt(1, product.getId());
            preparedStmt.setBoolean(2, product.getDefaultCode());
            preparedStmt.setBoolean(3, product.isActive());
            preparedStmt.setString(4, product.getBarcode());
            preparedStmt.setDouble(5, product.getVolume());
            preparedStmt.setDouble(6, product.getWeight());
            preparedStmt.addBatch();
        }

        // Insert multiple rows
        preparedStmt.executeBatch();
    }




    private void inst(List<Product> productList) throws SQLException {
        Statement statement = connection.createStatement();

        // the mysql insert statement
        String query = "INSERT INTO " + tableName + " (id, default_code, active, product_tmpl_id, barcode, volume, weight, message_last_post, activity_date_deadline, create_uid, create_date, write_uid, write_date)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);

        for (Product product : productList) {
            // create the mysql insert preparedstatement
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, "0");
            preparedStmt.setBoolean(3, true);
            preparedStmt.setInt(4, 0);
            preparedStmt.setString(5, "0001");
            preparedStmt.setInt(6, 0);
            preparedStmt.setInt(7, 0);
            preparedStmt.setDate(8, new Date(1588416989));
            preparedStmt.setDate(9, new Date(1588416989));
            preparedStmt.setInt(10, 0);
            preparedStmt.setDate(11, new Date(1588416989));
            preparedStmt.setInt(12, 0);
            preparedStmt.setDate(13, new Date(1588416989));
            preparedStmt.addBatch();
        }

        // Insert multiple rows
        preparedStmt.executeBatch();
    }


    public void testInsert() throws SQLException {
        Statement statement = connection.createStatement();

        // the mysql insert statement
        String query = "INSERT INTO " + tableName + " (id, default_code, active, product_tmpl_id, barcode, volume, weight, message_last_post, activity_date_deadline, create_uid, create_date, write_uid, write_date)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1, 0);
        preparedStmt.setString (2, "0");
        preparedStmt.setBoolean(3, true);
        preparedStmt.setInt (4, 0);
        preparedStmt.setString (5, "0001");
        preparedStmt.setInt (6, 0);
        preparedStmt.setInt (7, 0);
        preparedStmt.setDate   (8, new Date(1588416989));
        preparedStmt.setDate   (9, new Date(1588416989));
        preparedStmt.setInt (10, 0);
        preparedStmt.setDate   (11, new Date(1588416989));
        preparedStmt.setInt (12, 0);
        preparedStmt.setDate   (13, new Date(1588416989));

        // execute the preparedstatement
        preparedStmt.execute();
    }

}
