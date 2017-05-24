package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainInterface extends JFrame implements ActionListener{

	public MainInterface(){
		this.setTitle("logiciel de paris sportifs");
		this.setSize(300, 120);
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel connectionBar = new JPanel();
	    connectionBar.setLayout(new BoxLayout(connectionBar, BoxLayout.LINE_AXIS));
	    connectionBar.add(new JButton("vide"));
	    connectionBar.add(new JButton("vide"));
	    connectionBar.add(new JButton("connection"));
	    JPanel lister = new JPanel();
	    lister.setLayout(new BoxLayout(lister, BoxLayout.LINE_AXIS));
	    lister.add(new JButton("lister compétition"));
	    lister.add(new JButton("lister compétiteur"));
	    JPanel search = new JPanel();
	    search.setLayout(new BoxLayout(search, BoxLayout.LINE_AXIS));
	    search.add(new JButton("search"));
	    JPanel mainBox = new JPanel();
	    mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));
	    mainBox.add(connectionBar);
	    mainBox.add(lister);
	    mainBox.add(search);
	    this.getContentPane().add(mainBox);
	    this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	
}
