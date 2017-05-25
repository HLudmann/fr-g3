package gui.buttons;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BoutonLister extends JButton implements MouseListener{
	private String name;
	private Font font =new Font("TimesRoman",Font.CENTER_BASELINE,25);
	  
	  
	public BoutonLister(String str){
		super(str);
	    this.name = str;
	    this.setFont(font);
	this.addMouseListener(this);
	}
	  
	public void mouseClicked(MouseEvent event) {                     
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
		
	}
		 
	public void mouseReleased(MouseEvent event) {
	}
}
