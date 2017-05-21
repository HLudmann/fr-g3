import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import java.util.ArrayList;


public class WindowList extends JFrame {
  public WindowList(String name, ArrayList<ArrayList<String>> list){

    //Sets simple values for ou window
    this.setTitle(name);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Adds a correct layout for the content
    this.setLayout(new BorderLayout());

    //Adds our panel to the window, in the center of it
    this.add(new PanelList(list, 1), BorderLayout.CENTER);
    this.add(new JLabel("Une liste:"), BorderLayout.NORTH);

    //Set the correct size for our window and show it (might be usefull)
    this.pack();
    this.setVisible(true);
  }
}
