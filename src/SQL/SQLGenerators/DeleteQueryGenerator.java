package SQL.SQLGenerators;

/** Holds SQL commands associated with deletion from MySQL DB */

public abstract class DeleteQueryGenerator {

   /** Delete courses that have a title similar to the given parameter. */
   private static final String coursesID = "/**DELETE Courses with names*/";
   public static final String deleteCourse = coursesID + "DELETE FROM course WHERE courseName LIKE ? and courseID != 0;";

   
   /** Delete courses that the given instructor teaches */
   private static final String instrID = "/**DELETE Courses with instructors*/";
   public static final String deleteInstructor = instrID + "DELETE FROM course WHERE instructor LIKE ? and courseID != 0;";

   
   /** Delete courses that are held at the given institution */
   private static final String instID = "/**DELETE Courses from institution*/";
   public static final String deleteInstitution = instID + "DELETE FROM course WHERE institution LIKE ? and courseID != 0;";

   
   /** Delete courses that take place in a given term */
   private static final String termID = "/**DELETE Courses from term*/";
   public static final String deleteTerm = termID + "DELETE FROM course WHERE term LIKE ? and courseID != 0;";
}