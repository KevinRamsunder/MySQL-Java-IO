package GUI;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SQL.SQL;
import Utils.IO;

/** Main GUI */

public class PhaseOneGUI {

   private JFrame jframe;
   private JPanel contentPane;

   public PhaseOneGUI() {
      // create GUI and set visible
      initFrames();

   }

   /** set up visual from gui */
   private void initFrames() {
      setFrame();
      setCloseAction();
      this.addToFrame(new RetrievePanel().getJPanel());
      this.addToFrame(new DeletionPanel().getJPanel());
      this.addToFrame(new ModifyPanel().getJPanel());
      this.addToFrame(new InsertPanel().getJPanel());
      jframe.setVisible(true);
   }

   /** add jframes to main frame */
   public void addToFrame(JPanel panel) {
      this.contentPane.add(panel);
   }

   /** initialize main jframe */
   private void setFrame() {
      jframe = new JFrame();
      jframe.setTitle("MySQL Database Operations"); // set title
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close op
      jframe.setBounds(100, 100, 550, 300); // set dimensions
      jframe.setLocationRelativeTo(null); // set position on screen
      contentPane = new JPanel(); // create panel
      contentPane.setBorder(new EmptyBorder(3, 3, 3, 3)); // set design
      jframe.setContentPane(contentPane); // add panel
      contentPane.setLayout(new GridLayout(0, 4, 5, 5)); // set layout
   }

   /** Close all streams once the JFrame is closed */
   private void setCloseAction() {
      // Create new listener
      WindowListener deconstructor = new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            try {
               SQL.closeMySQL(); // close SQL connection
               IO.closeStream(); // close file connection
            } catch (SQLException e1) {
               IO.displayGUI(e1.getLocalizedMessage());
            }
         }
      };

      // add listener to jframe
      jframe.addWindowListener(deconstructor);
   }
}