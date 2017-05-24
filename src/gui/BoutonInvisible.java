package gui;


import java.awt.Dimension;

import javax.swing.JButton;



public class BoutonInvisible extends JButton{
	  
	  
	public BoutonInvisible(){
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		}
}
