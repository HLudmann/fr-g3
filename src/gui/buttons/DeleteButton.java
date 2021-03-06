package gui.buttons;

import gui.*;
import gui.panels.PanelAddPlayer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DeleteButton extends JButton implements MouseListener{
  private String name;
  private String data; // The data related to the entry, and that will be send if needed to the backend
  private int type; // The function from the backend that we need to interact with
  private int id; // The button id, not really needed tbh


  public DeleteButton(String str, int id, int type, String data) {
    super(str);

    this.name = str;
    this.id = id;
    this.data = data;
    this.type = type;

    this.addMouseListener(this);
  }

  //Send the correct instruction based on the type provided
  public void mouseClicked(MouseEvent event) {
    Window window = (Window) SwingUtilities.getAncestorOfClass(JFrame.class, this);
    switch(type){
      case 1:
        break;
      case 2:
        System.out.println("data: " + this.data + " type: " + this.type);
        break;
      case 3:
        System.out.println("data: " + this.data + " type: " + this.type);
        break;
    }
  }

  //Javax needs this soooo ...
  public void mouseEntered(MouseEvent event) {}

  public void mouseExited(MouseEvent event) {}

  public void mousePressed(MouseEvent event) {}

  public void mouseReleased(MouseEvent event) {}
}
