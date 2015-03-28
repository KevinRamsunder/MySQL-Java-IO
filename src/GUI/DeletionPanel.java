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

import SQL.DeleteSQL;
import Utils.IO;

public class DeletionPanel {

   private JPanel panel;

   // all buttons in deletion panel
   private JButton deleteCourse;
   private JButton deleteInstructor;
   private JButton deleteInstitution;
   private JButton deleteTerm;

   public DeletionPanel() {
      createPanel();

      // Set buttons
      setCourse();
      setInstructor();
      setInstitution();
      setTerm();
   }

   public JPanel getJPanel() {
      return panel;
   }

   private void createPanel() {
      panel = new JPanel(); // create panel
      panel.setBounds(110, 3, 150, 250); // set dimension
      panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); // setdesign

      FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout(); // set layout
      flowLayout_1.setVgap(15); // set title
      panel.add(new JLabel("Deletion")); // set label
   }

   private void setCourse() {
      deleteCourse = new JButton("by course name");
      deleteCourse.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(deleteCourse);

      // Link SQL operation
      deleteCourse.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            // get id from user
            String id = IO.queryUser("Enter course name:");

            try {
               DeleteSQL.deleteCourses(id);
            } catch (SQLException e) {
               IO.displayGUI(e.getLocalizedMessage());
            }
         }
      });
   }

   private void setInstructor() {
      deleteInstructor = new JButton("by instructor");
      deleteInstructor.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(deleteInstructor);

      // Link SQL Operation
      deleteInstructor.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // get instructor from user
            String instructor = IO.queryUser("Enter instructor name:");

            try {
               DeleteSQL.deleteInstructor(instructor);
            } catch (SQLException e1) {
               System.out.println(e1.getLocalizedMessage());
            }
         }
      });
   }

   private void setInstitution() {
      deleteInstitution = new JButton("by institution");
      deleteInstitution.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(deleteInstitution);

      // Link SQL operation
      deleteInstitution.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // get institution from user
            String institution = IO.queryUser("Enter institution name:");

            try {
               DeleteSQL.deleteInstitution(institution);
            } catch (SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }

   private void setTerm() {
      deleteTerm = new JButton("by term");
      deleteTerm.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(deleteTerm);

      // Link SQL Operation
      deleteTerm.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // / get term from user
            String term = IO.queryUser("Enter term name:");

            try {
               DeleteSQL.deleteTerm(term);
            } catch (SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }
}