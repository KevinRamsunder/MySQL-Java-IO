package SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import SQL.SQLGenerators.ModifyQueryGenerator;
import Utils.LogSQL;

/** Class responsible for modifying enrollment info in the MySQL database */

public class ModifySQL extends SQL {

   /** Add a student to the course with the given ID */
   public static void addStudentToClass(int classID) throws SQLException {
      // Get the query
      String query = ModifyQueryGenerator.addStudentToClass;
      PreparedStatement modify = connection.prepareStatement(query);

      // Add class ID to PreparedStatement
      modify.setInt(1, classID);

      LogSQL.log(modify, classID); // log
      execute(modify); // execute
   }

   /** Remove a student to the course with the given ID */
   public static void dropStudentFromClass(int classID) throws SQLException {
      // Get the query
      String query = ModifyQueryGenerator.dropStudentFromClass;
      PreparedStatement modify = connection.prepareStatement(query);

      // Add class ID to PreparedStatement
      modify.setInt(1, classID);

      LogSQL.log(modify, classID); // log
      execute(modify); // execute
   }

   /** Increase the amount of the class Capacity */
   public static void addMoreSeatsToClass(int classID, int seats)
         throws SQLException {
      // Do not make class capacity smaller
      if (seats <= 0) {
         System.out.println("Most add positive number of seats.");
         return;
      }

      // Get the query
      String query = ModifyQueryGenerator.addSeatsToClass;
      PreparedStatement modify = connection.prepareStatement(query);

      // Add class ID, and how many seats to PreparedStatement
      modify.setInt(1, seats);
      modify.setInt(2, classID);

      // this message is for logging purposes
      String logMessage = Integer.valueOf(classID) + ", "
            + Integer.valueOf(seats) + " seats.";

      LogSQL.log(modify, logMessage); // log
      execute(modify); // execute
   }

   /** Execute PreparedStatement */
   private static void execute(PreparedStatement modify) throws SQLException {
      modify.executeUpdate();
   }
}