package Course;

/** Class which extracts and contains input data for each course */

public class Course {

   private String institution;
   private String term;
   private String courseName;
   private String courseID;
   private String instructor;
   private String time;
   private String classCapacity;
   private String currentEnrollment;
   private String availableSeats;
   private String timestamp;

   /** Split values based on comma delimiter and
    * assign values to variables accordingly
    */
   public Course(String values) {
      String[] stringArray = values.split(",");
      institution = stringArray[0];
      term = stringArray[1];
      courseName = stringArray[2];
      courseID = stringArray[3];
      instructor = stringArray[4];
      time = stringArray[5];
      classCapacity = stringArray[6];
      currentEnrollment = stringArray[7];
      availableSeats = stringArray[8];
      timestamp = "null";
      
      sanitizeInput(); // clear excess whitespace
   }

   /** Clear excess whitespace from each field which may
    *  cause unformatted data entering the database.
    *  
    *  Also, format out the containing parentheses of the set. 
    */
   public void sanitizeInput() {
      institution = institution.trim();
      term = term.trim();
      courseName = courseName.trim();
      courseID = courseID.trim();
      instructor = instructor.trim();
      time = time.trim();
      classCapacity = classCapacity.trim();
      currentEnrollment = currentEnrollment.trim();
      availableSeats = availableSeats.trim();
      timestamp = timestamp.trim();

      // remove leading left paren if found
      if (institution.startsWith("(")) {
         institution = institution.substring(1);
      }

      // remove trailing right paren if found
      if (timestamp.endsWith(");")) {
         timestamp = timestamp.substring(0, time.length() - 2);
      }
   }

   /** Return a string based on this course's information */
   public String print() {
      StringBuilder builder = new StringBuilder();

      builder.append(institution + " ");
      builder.append("term" + " ");
      builder.append(courseName + " ");
      builder.append(courseID + " ");
      builder.append(instructor + " ");
      builder.append(time + " ");
      builder.append(classCapacity + " ");
      builder.append(currentEnrollment + " ");
      builder.append(availableSeats + " ");
      builder.append(timestamp);

      return builder.toString();
   }

   /** Getter methods */
   
   public String getInstitution() {
      return institution;
   }

   public String getTerm() {
      return term;
   }

   public String getCourseName() {
      return courseName;
   }

   public String getCourseID() {
      return courseID;
   }

   public String getInstructor() {
      return instructor;
   }

   public String getTime() {
      return time;
   }

   public String getClassCapacity() {
      return classCapacity;
   }

   public String getCurrentEnrollment() {
      return currentEnrollment;
   }

   public String getAvailableSeats() {
      return availableSeats;
   }

   public String getTimestamp() {
      return timestamp;
   }
}