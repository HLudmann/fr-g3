import javax.swing.JFrame;
import java.util.ArrayList;

public class MainWindow {
  public static void main(String[] args){

    ArrayList<ArrayList<String>> list = createExemple(); //Simple example

    //Will show the correct window according to the arguements provided
    WindowList window = new WindowList("List Window", list);
  }

  // TODO: This methods is "useless" and is due to be removed
  
  private static ArrayList<ArrayList<String>> createExemple(){
    ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    ArrayList el = new ArrayList();
    el.add("Jean-Baptiste Valladeau");
    el.add("jbvallad");
    list.add(el);
    el = new ArrayList();
    el.add("Jean Machin");
    el.add("jmachin");
    list.add(el);
    return(list);
  }
}
