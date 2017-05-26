package gui.panels;

import gui.buttons.SendDataButton;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PanelAddCompetitor extends JPanel{

  private GridLayout gl;
  private JTextField firstNameInput;
  private JTextField lastNameInput;
  private JFormattedTextField idInput;

  public PanelAddCompetitor() {

    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();
    this.gl.setColumns(2);
    this.gl.setRows(4);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.firstNameInput = new JTextField();
    this.lastNameInput = new JTextField();
    this.idInput = new JFormattedTextField(NumberFormat.getIntegerInstance());

    this.add(new JLabel("Nom: "));
    this.add(this.firstNameInput);
    this.add(new JLabel("Prenom: "));
    this.add(this.lastNameInput);
    this.add(new JLabel("Identifiant: "));
    this.add(this.idInput);
    this.add(new JLabel(""));
    this.add(new SendDataButton("Envoyer", 1, 2));

  }
}
