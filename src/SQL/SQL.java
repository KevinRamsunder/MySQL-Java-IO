package SQL;

import java.sql.*;

import User.UserInformation;
import Utils.LogSQL;

/** Class responsible for initiating connection with database */

public abstract class SQL {

   // Connection used for all SQL operations
   protected static Connection connection;

   /** Initiate connection with MySQL DB */
   public static void startMySQL() throws SQLException {
      LogSQL.log("Connecting to database...");
      connection = getConnection();
   }
   
   /** Close connection with MySQL DB */
   public static void closeMySQL() throws SQLException {
      LogSQL.log("Closing connection...");
      connection.close();
   }

   /** return initialized connection based on user info and host url */
   private static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(UserInformation.url,
            UserInformation.user, UserInformation.pass);
   }
}