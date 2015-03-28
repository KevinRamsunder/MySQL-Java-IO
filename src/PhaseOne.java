import java.sql.SQLException;
import java.util.HashMap;

import Course.Course;
import GUI.PhaseOneGUI;
import SQL.DeleteSQL;
import SQL.InsertSQL;
import SQL.SQL;
import Utils.IO;

public class PhaseOne {

   /**
    * Main method for program. First open file and SQL connection streams, then
    * start the GUI for user interaction.
    */

   public static void main(String[] args) {
      // Check number of arguments, prompt user if necessary
      // if enough arguments are provided, open file stream
      processArguments(args);

      try {
         // Open SQL connection
         SQL.startMySQL();

         // clear MySQL database
         DeleteSQL.deleteInstitution("QNS01");

         // Add every course inside input file
         HashMap<Integer, Course> courses = getCourses();
         for (Course course : courses.values()) {
            InsertSQL.addCourse(course);
         }

         // Open GUI
         new PhaseOneGUI();

      } catch (SQLException e) {
         // display readable error to user
         IO.displayGUI(e.getLocalizedMessage());
      }
   }

   /**
    * Prompt user with GUI for selecting files is arguments are not provided.
    */
   private static void processArguments(String[] args) {
      if (args.length < 2) {
         IO.displayGUI(args.length + " arguments provided.\nPlease provide input and output files through the GUI.");
         IO.chooseFiles(); // choose files with GUI
      } else {
         // Open file streams
         IO.openStream(args[0], args[1]);
      }
   }

   /** Get data to insert from input file */
   private static HashMap<Integer, Course> getCourses() {
      return IO.getCoursesFromInput(); // get courses from file
   }
}