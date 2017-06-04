package gui.panels;

import gui.Window;

import gui.buttons.SendDataButton;
import gui.buttons.GoBackButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class PanelEndCompetition extends JPanel{

  private GridLayout gl;
  private JComboBox<String> firstWinner;
  private JComboBox<String> secondWinner;
  private JComboBox<String> thirdWinner;


  public PanelEndCompetition(JPanel panel) {

    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();
    this.gl.setColumns(2);
    this.gl.setRows(5);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.firstWinner = new JComboBox<String>();
    this.secondWinner = new JComboBox<String>();
    this.thirdWinner = new JComboBox<String>();

    this.add(new JLabel("Gagnant N°1 : "));
    this.add(this.firstWinner);
    this.add(new JLabel("Gagnant N°2 : "));
    this.add(this.secondWinner);
    this.add(new JLabel("Gagnant N°3 : "));
    this.add(this.thirdWinner);
    this.add(new GoBackButton("Retour", 1, 1));
    this.add(new SendDataButton("Envoyer", 1, 3));

  }
}
