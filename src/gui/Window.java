package gui;

import gui.panels.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Window extends JFrame {
  public Window(String name){

    ArrayList<ArrayList<String>> list = createExemple(); //Simple example

    //Sets simple values for ou window
    this.setTitle(name);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Adds our panel to the window, in the center of it
    this.add(new ManagerPanel());

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

    el = new ArrayList<String>();
    el.add("Jean Machin");
    el.add("jmachin");
    list.add(el);

    return(list);
  }
}
