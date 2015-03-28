package GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import SQL.ModifySQL;
import Utils.IO;

public class ModifyPanel {
   private JPanel panel;

   // all buttons in modify panel
   private JButton addStudent;
   private JButton dropStudent;
   private JButton addSeats;

   public ModifyPanel() {
      createPanel();

      // Create buttons
      setAddStudent();
      setDropStudent();
      setAddSeatToClasses();
   }

   public JPanel getJPanel() {
      return panel;
   }

   private void createPanel() {
      panel = new JPanel(); // create panel
      panel.setBounds(217, 3, 107, 256); // set dimensions
      panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); // setDesign
      FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout(); // setLayout
      flowLayout_2.setVgap(15); // set spacing
      panel.add(new JLabel("Modify")); // set Label
   }

   private void setAddStudent() {
      addStudent = new JButton("Add Student");
      addStudent.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(addStudent);

      // Link SQL operation
      addStudent.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            // query user
            String courseID = IO
                  .queryUser("Enter Course ID to add student to:");

            try {
               ModifySQL.addStudentToClass(Integer.parseInt(courseID));
            } catch (NumberFormatException | SQLException e) {
               IO.displayGUI(e.getLocalizedMessage());
            }
         }
      });
   }

   private void setDropStudent() {
      dropStudent = new JButton("Remove Student");
      dropStudent.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(dropStudent);

      // Link SQL operation
      dropStudent.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // query user
            String id = IO.queryUser("Enter Course ID to drop student from:");

            try {
               ModifySQL.dropStudentFromClass(Integer.parseInt(id));
            } catch (NumberFormatException | SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }

   private void setAddSeatToClasses() {
      addSeats = new JButton("Add Seats to Class");
      addSeats.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(addSeats);

      // Link SQL OP
      addSeats.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // query user
            String id = IO.queryUser("Enter Course ID to drop student from:");
            String seats = IO.queryUser("Add how many seats?");
            
            try {
               ModifySQL.addMoreSeatsToClass(Integer.parseInt(id), Integer.parseInt(seats));
            } catch (NumberFormatException | SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }
}