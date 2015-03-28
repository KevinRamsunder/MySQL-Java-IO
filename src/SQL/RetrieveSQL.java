package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.SQLGenerators.RetrieveQueryGenerator;
import Utils.LogSQL;
import Utils.ResultSetProcessor;

/** Class responsible for retrieving information from MySQL database */

public class RetrieveSQL extends SQL {

   /** Print the entire table */
   public static void getAllRows() throws SQLException {
      // Get the query and execute
      String query = RetrieveQueryGenerator.getAllRows;
      PreparedStatement retrieve = connection.prepareStatement(query);

      LogSQL.log(retrieve); // log
      execute(retrieve); // execute
   }

   /** Print rows that contain the instructor passed in the parameter */
   public static void getInstructor(String instructor) throws SQLException {
      // Get the query
      String query = RetrieveQueryGenerator.getInstructor;
      PreparedStatement retrieve = connection.prepareStatement(query);

      // Initialize PreparedStatement with given attribute
      retrieve.setString(1, '%' + instructor + '%');

      LogSQL.log(retrieve, instructor); // log
      execute(retrieve); // execute
   }

   /** Print rows of courses that have more currentStudents than availableSeats */
   public static void getOverTalliedClasses() throws SQLException {
      // Get the query and execute
      String query = RetrieveQueryGenerator.getOverTalliedClasses;
      PreparedStatement retrieve = connection.prepareStatement(query);

      LogSQL.log(retrieve); // log
      execute(retrieve); // execute
   }

   public static void getClassesFromTerm(String term) throws SQLException {
      // Get the query
      String query = RetrieveQueryGenerator.getClassesFromTerm;
      PreparedStatement retrieve = connection.prepareStatement(query);

      // Add term to query
      retrieve.setString(1, '%' + term + '%');

      LogSQL.log(retrieve, term); // log
      execute(retrieve); // execute
   }

   /** Print rows of courses that have availableSeats */
   public static void getOpenClasses() throws SQLException {
      // Get the query and execute
      String query = RetrieveQueryGenerator.getOpenClasses;
      PreparedStatement retrieve = connection.prepareStatement(query);

      LogSQL.log(retrieve); // log
      execute(retrieve);// execute
   }

   /** Print rows of courses that have no availableSeats */
   public static void getClosedClasses() throws SQLException {
      // Get the query and execute
      String query = RetrieveQueryGenerator.getClosedClasses;
      PreparedStatement retrieve = connection.prepareStatement(query);

      LogSQL.log(retrieve); // log
      execute(retrieve); // execute
   }

   /** Print row that contains the course with the given ID */
   public static void getClassByID(int id) throws SQLException {
      // Get the query
      String query = RetrieveQueryGenerator.getClassByID;
      PreparedStatement retrieve = connection.prepareStatement(query);

      // add class ID to PreparedStatement
      retrieve.setInt(1, id);

      LogSQL.log(retrieve, id); // log
      execute(retrieve); // execute
   }

   /** Execute, and process resultSet */
   private static void execute(PreparedStatement retrieve) throws SQLException {
      ResultSet result = retrieve.executeQuery();
      ResultSetProcessor.print(result);
   }
}