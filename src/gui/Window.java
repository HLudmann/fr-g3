import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.util.ArrayList;


public class Window extends JFrame {
  public Window(String name, ArrayList<ArrayList<String>> list){

    //Sets simple values for ou window
    this.setTitle(name);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Adds a correct layout for the content
    this.setLayout(new BorderLayout());

    //Adds our panel to the window, in the center of it
    JLabel label = new JLabel("Une liste:");
    label.setBorder(new EmptyBorder(10, 10, 0, 0));
    this.add(label, BorderLayout.NORTH);
    this.add(new PanelList(list, 1), BorderLayout.CENTER);

    //Set the correct size for our window and show it (might be usefull)
    this.pack();
    this.setVisible(true);
  }

  public void setPanel(JPanel panel){
    this.getContentPane().removeAll();
    this.add(panel, BorderLayout.CENTER);
    this.pack();
  }
}
