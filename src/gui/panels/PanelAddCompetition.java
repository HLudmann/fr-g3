package gui.panels;

import gui.Window;

import gui.buttons.SendDataButton;
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
public class PanelAddCompetition extends JPanel{

  private GridLayout gl;
  private JTextField competitionNameInput;
  private JTextField competitionDateInput;
  private JButton addCompButton;
  private ArrayList<JFormattedTextField> listComp;


  public PanelAddCompetition() {

    this.listComp = new ArrayList<JFormattedTextField>();
    this.listComp.add(new JFormattedTextField(NumberFormat.getIntegerInstance()));

    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();
    this.gl.setColumns(2);
    this.gl.setRows(5);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.competitionNameInput = new JTextField();
    this.competitionDateInput = new JTextField();

    this.addCompButton = new JButton("Ajouter");

    this.addCompButton.addActionListener (new ActionListener () {
        public void actionPerformed(ActionEvent e) {
            update_layout();
        }
    });

    this.add(new JLabel("Nom: "));
    this.add(this.competitionNameInput);
    this.add(new JLabel("Date (dd/mm/yyyy): "));
    this.add(this.competitionDateInput);
    this.add(new JLabel("Competiteurs (id): "));
    this.add(this.listComp.get(0));
    addBottomStuff();

  }

  private void update_layout(){
    for(int i = 0; i < 4+this.listComp.size()*2; i++){this.remove(4);}

    this.listComp.add(new JFormattedTextField(NumberFormat.getIntegerInstance()));

    this.gl.setRows(4+listComp.size());

    this.add(new JLabel("Competiteurs (id): "));
    this.add(this.listComp.get(0));
    for(int i=1; i<this.listComp.size(); i++){
      this.add(new JLabel("id : "));
      this.add(listComp.get(i));
    }
    addBottomStuff();

    this.revalidate();
    this.repaint();
    Window window = (Window) SwingUtilities.getAncestorOfClass(JFrame.class, this);
    window.pack();

  }

  private void addBottomStuff(){
    this.add(new JLabel(""));
    this.add(this.addCompButton);
    this.add(new JLabel(""));
    this.add(new SendDataButton("Envoyer", 1, 3));
  }
}
