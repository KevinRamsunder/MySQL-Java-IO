package SQL.SQLGenerators;

/** Holds SQL commands associated with retrieval from MySQL DB */

public abstract class RetrieveQueryGenerator {

   /** selectAll query generates the entire table */
   private static final String getAllRowsID = "/**RETRIEVE Get all courses*/";
   public static final String getAllRows = getAllRowsID + "SELECT * FROM course;";
   
   
   /** print courses from this term */
   private static final String getClassesFromTermID = "/**RETRIEVE Get courses from term*/";
   public static final String getClassesFromTerm = getClassesFromTermID + "SELECT * FROM course WHERE term LIKE ?;";
   

   /** selectAttribute query generates the given attribute */
   private static final String getInstructorID = "/**RETRIEVE Get courses taught by instructor:*/";
   public static final String getInstructor = getInstructorID + "SELECT * FROM course WHERE instructor LIKE ?;";
   
   
   /** print over tallied classes */
   private static final String getOTid = "/**RETRIEVE Get over tallied courses*/";
   public static final String getOverTalliedClasses = getOTid + "SELECT * FROM course WHERE classCapacity < currentEnrollment;";
   
   
   /** print open classes */
   private static final String openID = "/**RETRIEVE Get all open classes*/";
   public static final String getOpenClasses = openID + "SELECT * FROM course WHERE availableSeats > 0;";
   
   
   /** print closed classes */
   private static final String closedID = "/**RETRIEVE Get all closed classes*/";
   public static final String getClosedClasses = closedID + "SELECT * FROM course WHERE availableSeats = 0;";
   
   
   /** Print the class that has this id */
   private static final String idID = "/**RETRIEVE Get course with ID*/";
   public static final String getClassByID = idID+ "SELECT * FROM course WHERE courseID = ?;";
}