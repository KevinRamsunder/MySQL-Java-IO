package SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import SQL.SQLGenerators.DeleteQueryGenerator;
import Utils.LogSQL;

/** Class responsible for deleting items from MySQL database */

public class DeleteSQL extends SQL {

   /** Delete courses in the database that contain this course */
   public static void deleteCourses(String course) throws SQLException {
      // Get the query
      String query = DeleteQueryGenerator.deleteCourse;
      PreparedStatement delete = connection.prepareStatement(query);

      // Delete courses that begin with the given course name
      delete.setString(1, course + "%");

      LogSQL.log(delete, course); // log
      execute(delete); // execute
   }

   /** Delete courses in the database that contain this instructor */
   public static void deleteInstructor(String instructor) throws SQLException {
      // Get the query
      String query = DeleteQueryGenerator.deleteInstructor;
      PreparedStatement delete = connection.prepareStatement(query);

      // Delete courses that are taught by the given instructor
      delete.setString(1, '%' + instructor + '%');

      LogSQL.log(delete, instructor); // log
      execute(delete); // execute
   }

   /** Delete courses in the database that are taught at the given institution */
   public static void deleteInstitution(String institution) throws SQLException {
      // Get the query
      String query = DeleteQueryGenerator.deleteInstitution;
      PreparedStatement delete = connection.prepareStatement(query);

      // Delete courses that are taught at the given institution
      delete.setString(1, institution);

      LogSQL.log(delete, institution); // log 
      execute(delete); // execute
   }

   /** Delete courses in the database that are taught during the given term */
   public static void deleteTerm(String term) throws SQLException {
      // Get the query
      String query = DeleteQueryGenerator.deleteTerm;
      PreparedStatement delete = connection.prepareStatement(query);

      // Delete courses that are taught during the given term
      delete.setString(1, term);
      
      LogSQL.log(delete, term); // log
      execute(delete); // execute
   }

   /** Execute delete PreparedStatement */
   private static void execute(PreparedStatement delete) throws SQLException {
      delete.executeUpdate();
   }
}