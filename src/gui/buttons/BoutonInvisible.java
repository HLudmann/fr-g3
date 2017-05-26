package gui.buttons;


import javax.swing.JButton;


@SuppressWarnings("serial")
public class BoutonInvisible extends JButton{


	public BoutonInvisible(){
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		}
}
