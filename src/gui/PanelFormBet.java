import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Dimension;
import java.util.ArrayList;
import java.text.NumberFormat;
import javax.swing.BoxLayout;

public class PanelFormBet extends JPanel {
  public PanelFormBet(){

    //Aesthetic borders
    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    JComboBox betSelect = new JComboBox();
    betSelect.addItem("Pari podium");
    betSelect.addItem("Pari simple");

    JFormattedTextField value = new JFormattedTextField(NumberFormat.getIntegerInstance());

    JLabel betSelectLabel = new JLabel("Type: ");
    JLabel betValueLabel = new JLabel("Montant: ");

    JPanel betSelectPanel = new JPanel();
    betSelectPanel.add(betSelectLabel);
    betSelectPanel.add(betSelect);

    JPanel betValuePanel = new JPanel();
    betValuePanel.add(betValueLabel);
    betValuePanel.add(value);

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    this.add(betSelectPanel);
    this.add(betValuePanel);
  }
}
