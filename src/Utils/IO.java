package Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Course.Course;

/** Class responsible for reading and writing to input, output files */

public class IO {

   private static Scanner inStream;
   private static PrintWriter outStream;

   /** Initialize file streams and set the first characters */
   public static void openStream(String fileIn, String fileOut) {
      try {
         inStream = new Scanner(new FileReader(fileIn));
         // 'true' flag passed to FOS to append to log file
         outStream = new PrintWriter(new FileOutputStream(fileOut, true));
      } catch (FileNotFoundException e) {
         IO.displayGUI(e.getLocalizedMessage());
      }
   }

   /** Get input from user with GUI */
   public static String queryUser(String message) {
      return JOptionPane.showInputDialog(null, message);
   }

   /** Display message to user with GUI */
   public static void displayGUI(String message) {
      JOptionPane.showMessageDialog(null, message);
   }

   /** Log results to log file */
   public static void log(String message) {
      System.out.print(message);
      outStream.write(message);
   }

   /** Prompt user for input and output files with a GUI */
   public static void chooseFiles() {
      openStream(setInputFile(), setOutputFile());
   }

   private static String setInputFile() {
      // browser for file
      JFileChooser explorer = new JFileChooser();
      explorer.setDialogTitle("Choose Input File");

      // set the type of file you are looking for
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Text arguments", "txt");
      explorer.setFileFilter(filter);

      // get file from explorer
      int chosenFile = explorer.showOpenDialog(null);

      // if file was not chosen, quit
      if (chosenFile != JFileChooser.APPROVE_OPTION) {
         IO.displayGUI("You did not choose an input file.\nTerminating.");
         System.exit(0);
      }

      // else return the file
      return explorer.getSelectedFile().getAbsolutePath();
   }
   
   private static String setOutputFile() {
      // browser for file
      JFileChooser explorer = new JFileChooser();
      explorer.setDialogTitle("Choose Output File");

      // set the type of file you are looking for
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Text arguments", "txt");
      explorer.setFileFilter(filter);

      // get file from explorer
      int chosenFile = explorer.showOpenDialog(null);

      // if file was not chosen, quit
      if (chosenFile != JFileChooser.APPROVE_OPTION) {
         IO.displayGUI("You did not choose an output file.\nTerminating.");
         System.exit(0);
      }

      // else return the file
      return explorer.getSelectedFile().getAbsolutePath();
   }

   /** Write resultSet to CSV file for easy, DB-type access */
   public static void writeToCSV(String filename, String results) {
      PrintWriter fileOutput = null;
      try {
         // Create a new file for each retrieve function call
         fileOutput = new PrintWriter(new FileOutputStream(filename));
         fileOutput.write(results);
         fileOutput.close();
      } catch (FileNotFoundException e) {
         IO.displayGUI(e.getLocalizedMessage());
      }
   }

   /** Get data from input file */
   public static HashMap<Integer, Course> getCoursesFromInput() {
      int index = 0;
      HashMap<Integer, Course> courses = new HashMap<Integer, Course>();

      while (inStream.hasNext()) {
         // validate INSERT command
         if (inStream.next().equals("INSERT")) {
            courses.put(index++, new Course(inStream.nextLine()));
         }
      }

      return courses;
   }

   /** Close file streams */
   public static void closeStream() {
      try {
         inStream.close();
         outStream.close();
      } catch (Exception e) {
         IO.displayGUI("Error saving files.");
      }
   }
}
