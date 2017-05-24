import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class PanelPasswordEdit extends JPanel{

  JPasswordField passwordInput;
  GridLayout gl;

  public PanelPasswordEdit(String id){

    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();

    this.gl.setColumns(2);
    this.gl.setRows(2);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.add(new JLabel("Entrez le nouveau mot de passe:"));
    this.passwordInput = new JPasswordField();
    this.add(this.passwordInput);
    this.add(new JLabel(""));
    this.add(new SendDataButton("Envoyer", 1, 1));

  }
}