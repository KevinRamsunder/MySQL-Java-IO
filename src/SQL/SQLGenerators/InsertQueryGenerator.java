package SQL.SQLGenerators;

/** Holds SQL commands associated with insertion to MySQL DB */

public abstract class InsertQueryGenerator {

   /** Denote which columns you will be inserting into */
   private static final String categories = "INSERT INTO course(institution, term, courseName, courseID, instructor, time, classCapacity, currentEnrollment, availableSeats, lastTimeEnrollmentChanged)";
   
   /** Insert Course, add each attribute as parameters */
   public static final String addCourse = categories + "\r\n   values (?,?,?,?,?,?,?,?,?,null);";
}
