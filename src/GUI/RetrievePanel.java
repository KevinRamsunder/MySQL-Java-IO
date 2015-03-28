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

import SQL.RetrieveSQL;
import Utils.IO;

/** Class contains retrieve functions */

public class RetrievePanel {

   private JPanel panel;

   // all buttons in retrieve panel
   private JButton getAllRows;
   private JButton getFromTerm;
   private JButton getFromInstr;
   private JButton getOvertallied;
   private JButton getOpenClasses;
   private JButton getClosedClasses;
   private JButton getByID;

   public RetrievePanel() {
      createPanel();

      // Create buttons
      setRowButton();
      setTermButton();
      setOverTallied();
      setOpen();
      setClosed();
      setInstr();
      setID();

   }

   public JPanel getJPanel() {
      return panel;
   }

   private void createPanel() {
      panel = new JPanel(); // create panel
      panel.setBounds(3, 3, 150, 250); // set dimensions
      panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); // set design
      
      FlowLayout flowLayout = (FlowLayout) panel.getLayout(); // set layout
      flowLayout.setAlignOnBaseline(true); // set title
      panel.add(new JLabel("Retrieval"));
   }

   private void setRowButton() {
      getAllRows = new JButton("All Rows");
      getAllRows.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getAllRows);

      // Link SQL operation
      getAllRows.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RetrieveSQL.getAllRows();
            } catch (SQLException e) {
               IO.displayGUI(e.getLocalizedMessage());
            }
         }
      });
   }

   private void setTermButton() {
      getFromTerm = new JButton("from Term");
      getFromTerm.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getFromTerm);

      // Link SQL operation
      getFromTerm.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // Get term from user
            String term = IO.queryUser("Enter Term: ");

            try {
               RetrieveSQL.getClassesFromTerm(term);
            } catch (SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }

   private void setOverTallied() {
      getOvertallied = new JButton("Overtallied Classes");
      getOvertallied.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getOvertallied);

      // Link SQL operation
      getOvertallied.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RetrieveSQL.getOverTalliedClasses();
            } catch (SQLException e) {
               IO.displayGUI(e.getLocalizedMessage());
            }
         }
      });
   }

   private void setOpen() {
      getOpenClasses = new JButton("Open Classes");
      getOpenClasses.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getOpenClasses);

      // Link SQL operation
      getOpenClasses.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RetrieveSQL.getOpenClasses();
            } catch (SQLException e) {
               IO.displayGUI(e.getLocalizedMessage());
            }
         }
      });
   }

   private void setClosed() {
      getClosedClasses = new JButton("Closed Classes");
      getClosedClasses.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getClosedClasses);

      // Link SQL operation
      getClosedClasses.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RetrieveSQL.getClosedClasses();
            } catch (SQLException e) {
               IO.displayGUI(e.getLocalizedMessage());
            }
         }
      });
   }

   private void setInstr() {
      getFromInstr = new JButton("by Instructor");
      getFromInstr.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getFromInstr);

      // Link SQL operation
      getFromInstr.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // Get instructor from user
            String instructor = IO.queryUser("Enter Instructor: ");
            try {
               RetrieveSQL.getInstructor(instructor);
            } catch (SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }
   
   private void setID() {
      getByID = new JButton("by Class ID");
      getByID.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(getByID);
      
      getByID.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // Get id from user
            String id = IO.queryUser("Enter class ID");
            
            try {
               RetrieveSQL.getClassByID(Integer.parseInt(id));
            } catch (NumberFormatException | SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
            
         }
      });
   }
}