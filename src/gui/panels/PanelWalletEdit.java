package gui.panels;

import gui.buttons.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PanelWalletEdit extends JPanel{

  JFormattedTextField valueInput;
  GridLayout gl;

  public PanelWalletEdit(String id){

    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();

    this.gl.setColumns(2);
    this.gl.setRows(2);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.add(new JLabel("Nouveau solde :"));
    this.valueInput = new JFormattedTextField(NumberFormat.getIntegerInstance());
    this.add(this.valueInput);
    this.add(new GoBackButton("Retour", 1, 1));
    this.add(new SendDataButton("Envoyer", 1, 1));

  }
}
