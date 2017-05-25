package gui;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.util.ArrayList;


public class Window extends JFrame {
  public Window(String name){

    ArrayList<ArrayList<String>> list = createExemple(); //Simple example

    //Sets simple values for ou window
    this.setTitle(name);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Adds our panel to the window, in the center of it
    JLabel label = new JLabel("Une liste:");
    label.setBorder(new EmptyBorder(10, 10, 0, 0));
    this.add(label, BorderLayout.NORTH);
    this.add(new PanelList(list, 1));

    //Set the correct size for our window and show it (might be usefull)
    this.pack();
    this.setVisible(true);
  }

  public void setPanel(JPanel panel){
    this.getContentPane().removeAll();
    this.add(panel);
    this.revalidate();
    this.repaint();
    this.pack();
  }

  // TODO: This methods is "useless" and is due to be removed
  private static ArrayList<ArrayList<String>> createExemple(){
    ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

    ArrayList<String> el = new ArrayList<String>();
    el.add("Jean-Baptiste Valladeau");
    el.add("jbvallad");
    list.add(el);

    el = new ArrayList();
    el.add("Jean Machin");
    el.add("jmachin");
    list.add(el);

    return(list);
  }
}
