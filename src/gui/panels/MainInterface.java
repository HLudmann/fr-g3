package gui.panels;

import gui.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.SwingUtilities;

import gui.buttons.BoutonInvisible;

public class MainInterface extends JPanel implements ActionListener{
	private JButton boutonConnection = new JButton("Connection");
	private JButton competition = new JButton("Lister compétition");
	private JButton competiteur = new JButton("Lister compétiteur");
	private JButton searchButton = new JButton("Rechercher");
	private JLabel searchLabel = new JLabel("Rechercher:");

	public MainInterface(){
		this.setBackground(new Color(0,150,250));

		//set du bouton connection (box ligne de prenant 1/3 de la fenetre)
		JPanel connectionBar = new JPanel();
		JPanel borderLayoutConnectionBar = new JPanel();
		borderLayoutConnectionBar.setLayout(new BorderLayout());
		connectionBar.setBackground(new Color(0,150,250));
		connectionBar.setLayout(new BoxLayout(connectionBar, BoxLayout.LINE_AXIS));
		BoutonInvisible boutonInvisible = new BoutonInvisible();
		boutonInvisible.setPreferredSize(new Dimension(this.getWidth()*4/5,30));
		connectionBar.add(boutonInvisible);
		connectionBar.add(borderLayoutConnectionBar);
		//connectionBar.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/3));
		borderLayoutConnectionBar.add(boutonConnection, BorderLayout.NORTH);


    //set de la bande central (bouton de listage)
		JPanel lister = new JPanel();
		JPanel lister2 = new JPanel();
		JPanel lister3 = new JPanel();
		JPanel lister4 = new JPanel();
		lister.setLayout(new BorderLayout());
		lister2.setLayout(new BorderLayout());
		lister3.setLayout(new BorderLayout());
		lister2.add(competition, BorderLayout.CENTER);
		lister3.add(competiteur, BorderLayout.CENTER);
		lister4.setLayout(new GridLayout(1,2));
		lister4.add(lister2);
		lister4.add(lister3);
		lister.add(lister4, BorderLayout.CENTER);
		//lister.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/3));
		//lister.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/3));

		//set du search
		JPanel search = new JPanel();
		JPanel searchField = new JPanel();
		search.setLayout(new BorderLayout());
		searchField.add(searchLabel);
		JTextField searchText = new JTextField();
		searchText.setPreferredSize(new Dimension(this.getWidth()-150, 30));
		searchField.add(searchText);
		search.add(searchField, BorderLayout.NORTH);
		search.add(searchButton, BorderLayout.CENTER);
		//search.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/3));
		//search.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/3));

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(connectionBar);
		this.add(lister);
		this.setBackground(Color.WHITE);

		//setActions
		boutonConnection.addActionListener(this);
		competition.addActionListener(this);
		competiteur.addActionListener(this);
		searchButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Window window = (Window) SwingUtilities.getAncestorOfClass(JFrame.class, this);
		if(e.getSource() == boutonConnection){
			new ConnectionPanel(this, window);
		}
		if (e.getSource() == competition) {
			window.setPanel(new PanelListWithoutButtons(1));
		}
		if (e.getSource() == competiteur) {
			window.setPanel(new PanelListWithoutButtons(1));
		}
		/*if(e.getSource() == searchButton){
		;
	}*/
}



}
