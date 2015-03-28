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

import SQL.InsertSQL;
import Utils.IO;
import Course.Course;

public class InsertPanel {

   private JPanel panel;

   // all buttons in insert panel
   private JButton insert;

   public InsertPanel() {
      createPanel();
      setInsert();
   }

   public JPanel getJPanel() {
      return panel;
   }

   public void createPanel() {
      panel = new JPanel();
      panel.setBounds(324, 3, 107, 256);
      panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
      flowLayout_3.setVgap(15);
      panel.add(new JLabel("Insertion"));
   }
   
   public void setInsert() {
      insert = new JButton("Insertion");
      insert.setFont(new Font("Arial", Font.PLAIN, 11));
      panel.add(insert);
      
      //set sql op
      insert.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // Query user for course information.. there is a lot 
            StringBuilder builder = new StringBuilder();
            builder.append(IO.queryUser("Enter institution") + ',');
            builder.append(IO.queryUser("Enter term")+ ',');
            builder.append(IO.queryUser("Enter course name")+ ',');
            builder.append(IO.queryUser("Enter course id")+ ',');
            builder.append(IO.queryUser("Enter instructor")+ ',');
            builder.append(IO.queryUser("Enter time")+ ',');
            builder.append(IO.queryUser("Enter class capacity")+ ',');
            builder.append(IO.queryUser("Enter current enrollment")+ ',');
            builder.append(IO.queryUser("Enter available seats")+ ',');
            
            try {
               InsertSQL.addCourse(new Course(builder.toString()));
            } catch (SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      });
   }
}