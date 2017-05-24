package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;



public class BoutonConnection extends JButton implements MouseListener{
	private String name;
	private Image img;
	private Font font =new Font("TimesRoman",Font.CENTER_BASELINE,25);
	  
	  
	public BoutonConnection(String str){
		super(str);
	    this.name = str;
	    try {
	        img = ImageIO.read(new File("Bleu-degrade-vertical.jpg"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	this.addMouseListener(this);
	}
	  
	  public void paintComponent(Graphics g){
		    Graphics2D g2d = (Graphics2D)g;
		    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    g2d.setColor(Color.red.darker());
		    g2d.setFont(font);
		    g2d.drawString(name, this.getWidth() / 2 - (this.getWidth() / 2 /3), (this.getHeight() / 2) + 5);
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
		if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
			
		}
	}
	  
}
