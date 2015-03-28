package SQL.SQLGenerators;

/** Holds SQL commands associated with modifying data in MySQL DB */

public abstract class ModifyQueryGenerator {

   /**
    * update SQL command for adding a student to a class. SET
    * currentEnrollment++, and update availableSeats and
    * lastTimeEnrollmentChanged timestamp.
    */
   private static final String addID = "/**MODIFY Add a student to course*/";
   private static final String addingStudent = addID + "UPDATE course SET currentEnrollment = currentEnrollment + 1, availableSeats = CASE  WHEN classCapacity-currentEnrollment < 0 THEN 0  ELSE classCapacity-currentEnrollment END, lastTimeEnrollmentChanged = NULL";

   /** add a student to the class that matches the given courseID parameter */
   public static final String addStudentToClass = addingStudent + " WHERE (courseID = ? AND availableSeats > 0);";

   
   
   /**
    * update SQL command for dropping a student from a class. SET
    * currentEnrollment--,and update availableSeats and
    * lastTimeEnrollmentChanged timestamp.
    */
   private static final String subID = "/**MODIFY Remove a student from course*/";
   private static final String removeStudent = subID + "UPDATE course SET currentEnrollment = currentEnrollment - 1, availableSeats = CASE WHEN (classCapacity-currentEnrollment) < 0 THEN 0 ELSE classCapacity-currentEnrollment END, lastTimeEnrollmentChanged = NULL";

   /** drop a student from the class that matches the given courseID parameter */
   public static final String dropStudentFromClass = removeStudent + " WHERE (courseID = ?);";

   
    
   /**
    * update sql command for increasing the class capacity. 
    * SET classCapacity += (PARAMETER).
    */
   private static final String seatsID = "/**MODIFY Add seats to course*/";
   private static final String addSeats = seatsID + "UPDATE course SET classCapacity = classCapacity + ?,  availableSeats = CASE  WHEN (classCapacity - currentEnrollment) < 0 THEN 0  ELSE classCapacity - currentEnrollment END";

   /** Increase the class capacity by the given parameter */
   public static final String addSeatsToClass = addSeats + " WHERE courseID = ?;";
}
