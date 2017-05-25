package gui.panels;

import gui.buttons.SendDataButton;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

public class PanelFormBet extends JPanel {

  private int type;
  private ArrayList<String> competitors;

  private GridLayout gl;
  private JLabel betSelectLabel;
  private JLabel betValueLabel;
  private JLabel firstCompLabel;
  private JLabel secondCompLabel;
  private JLabel thirdCompLabel;
  private JComboBox betSelect;
  private JComboBox firstCompetitorSelector;
  private JComboBox secondCompetitorSelector;
  private JComboBox thirdCompetitorSelector;
  private JFormattedTextField valueInput;
  private SendDataButton submit;

  //TODO: add competitors when editing so the user doesn't have to search again
  public PanelFormBet(boolean is_edition, String id, ArrayList<String> competitors, int value, int type){

    this.type = type;
    this.competitors = competitors;

    //Aesthetic borders
    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    this.gl = new GridLayout();
    this.gl.setColumns(2);
    this.gl.setRows(6);
    this.gl.setHgap(5);
    this.gl.setVgap(5);
    this.setLayout(this.gl);

    this.valueInput = new JFormattedTextField(NumberFormat.getIntegerInstance());

    this.betSelectLabel = new JLabel("Type: ");
    this.betValueLabel = new JLabel("Montant: ");

    this.submit = new SendDataButton("Submit", 1, 1);

    this.add(betSelectLabel);
    if(is_edition){
      this.add(new JLabel("Non modifiable"));
    }else{
      this.betSelect = new JComboBox();
      this.betSelect.addItem("Pari podium");
      this.betSelect.addItem("Pari simple");

      this.betSelect.addActionListener (new ActionListener () {
          public void actionPerformed(ActionEvent e) {
              update_layout(betSelect.getSelectedIndex());
          }
      });
      this.add(this.betSelect);
    }

    this.firstCompetitorSelector = createAndPopulateCompSelectors();
    this.secondCompetitorSelector = createAndPopulateCompSelectors();
    this.thirdCompetitorSelector =  createAndPopulateCompSelectors();
    this.firstCompLabel = new JLabel("Compétiteur: ");
    this.secondCompLabel = new JLabel("Deuxième compétiteur: ");
    this.thirdCompLabel = new JLabel("Troisième compétiteur: ");

    addBottomStuff();

  }

  public JComboBox createAndPopulateCompSelectors(){
    JComboBox comboBox = new JComboBox();
    for(String el:this.competitors){
      comboBox.addItem(el);
    }
    return comboBox;
  }

  public void update_layout(int index) {
    if(index == 1){
      for(int i = 0; i < 4; i++){this.remove(4);}
    }else {
      for(int i = 0; i < 3; i++){this.remove(4);}
      addBottomStuff();
    }
    this.revalidate();
    this.repaint();
  }

  public void addBottomStuff(){
    this.add(this.firstCompLabel);
    this.add(this.firstCompetitorSelector);
    this.add(this.secondCompLabel);
    this.add(this.secondCompetitorSelector);
    this.add(this.thirdCompLabel);
    this.add(this.thirdCompetitorSelector);
    this.add(this.betValueLabel);
    this.add(this.valueInput);
    this.add(this.submit);
  }

  public int getType(){
    return this.type;
  }
}
