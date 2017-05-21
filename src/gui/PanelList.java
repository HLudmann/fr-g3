import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class PanelList extends JPanel {
  public PanelList(ArrayList<ArrayList<String>> list, int type){

    //Aesthetic borders
    this.setBorder(new EmptyBorder(10, 10, 10, 10));

    //Creates a good layout for our list
    GridLayout gl = new GridLayout();
    gl.setColumns(2);
    gl.setRows(list.size());
    gl.setHgap(5);
    gl.setVgap(5);
    this.setLayout(gl);

    //Adds buttons related to the data provided
    for (int i=0; i < list.size(); i++){
      this.add(new JLabel(list.get(i).get(0)));
      JButton btn = new EditButton("edit", i, type, list.get(i).get(1));
      this.add(btn);
    }

  }
}
