package gui;

import gui.panels.*;
import userInterface.*;
import personSystem.*;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.IncorrectString;

@SuppressWarnings("serial")
public class Window extends JFrame {

  private VisitorInterface interfaceUsed;
  private ArrayList<JPanel> history = new ArrayList<JPanel>();
  private JPanel currentPanel;

  public Window(String name){

    ArrayList<ArrayList<String>> list = createExemple(); //Simple example

    //Sets simple values for ou window
    this.setTitle(name);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Adds our panel to the window, in the center of it
    MainInterface managerPanel = new MainInterface();
    this.currentPanel = managerPanel;
    this.add(managerPanel);

    //Set the correct size for our window and show it (might be usefull)
    this.pack();
    this.setVisible(true);
  }

  public void setPanel(JPanel panel){
    this.history.add(this.currentPanel);

    this.getContentPane().removeAll();
    this.add(panel);
    this.revalidate();
    this.repaint();
    this.pack();

    this.history.add(currentPanel);
    this.currentPanel = panel;
  }

  public void goBack(){
    if (history.size() != 0){
      JPanel panel = this.history.get(this.history.size() -1);

      this.getContentPane().removeAll();
      this.add(panel);
      this.revalidate();
      this.repaint();
      this.pack();

      this.history.remove(panel);
      this.currentPanel = panel;
    }
  }
}
