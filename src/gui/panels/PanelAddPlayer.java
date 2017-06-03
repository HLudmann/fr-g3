package gui.panels;

import gui.buttons.SendDataButton;
import gui.buttons.GoBackButton;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PanelAddPlayer extends JPanel{

  private GridLayout gl;
  private JTextField firstNameInput;
  private JTextField lastNameInput;
  private JTextField usernameInput;
  private JPasswordField passwordInput;
  private JFormattedTextField valueInput;

  public PanelAddPlayer() {

    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();
    this.gl.setColumns(2);
    this.gl.setRows(6);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.firstNameInput = new JTextField();
    this.lastNameInput = new JTextField();
    this.usernameInput = new JTextField();
    this.passwordInput = new JPasswordField();
    this.valueInput = new JFormattedTextField(NumberFormat.getIntegerInstance());

    this.add(new JLabel("Nom: "));
    this.add(this.firstNameInput);
    this.add(new JLabel("Prenom: "));
    this.add(this.lastNameInput);
    this.add(new JLabel("Pseudo: "));
    this.add(this.usernameInput);
    this.add(new JLabel("Mot de passe: "));
    this.add(this.passwordInput);
    this.add(new JLabel("Solde initial: "));
    this.add(this.valueInput);
    this.add(new GoBackButton("Retour", 1, 1));
    this.add(new SendDataButton("Envoyer", 1, 2));

  }
}
