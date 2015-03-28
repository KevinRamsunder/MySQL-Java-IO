package SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Course.Course;
import SQL.SQLGenerators.InsertQueryGenerator;
import Utils.LogSQL;

/** Class responsible for inserting courses into MySQL database */

public class InsertSQL extends SQL {

   /** Add a course object to the database */
   public static void addCourse(Course course) throws SQLException {
      // Get the query
      String query = InsertQueryGenerator.addCourse;
      PreparedStatement insert = connection.prepareStatement(query);

      // Initialize PreparedStatement with given attributes
      insert.setString(1, course.getInstitution());
      insert.setString(2, course.getTerm());
      insert.setString(3, course.getCourseName());
      insert.setString(4, course.getCourseID());
      insert.setString(5, course.getInstructor());
      insert.setString(6, course.getTime());
      insert.setString(7, course.getClassCapacity());
      insert.setString(8, course.getCurrentEnrollment());
      insert.setString(9, course.getAvailableSeats());

      LogSQL.log(insert); // log
      execute(insert); // execute
   }

   /** Execute and log PreparedStatement */
   private static void execute(PreparedStatement insert) throws SQLException {
      //LogSQL.log(insert);
      insert.executeUpdate();
   }
}