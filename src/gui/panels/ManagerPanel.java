package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import gui.buttons.BoutonInvisible;

@SuppressWarnings("serial")
public class ManagerPanel extends JFrame implements ActionListener{
	private Font font = new Font("arial",Font.CENTER_BASELINE,20);
	private JPanel mainBox = new JPanel();
	//pour bar de connexion
		private JButton boutonDeconnection = new JButton("déconnection");
		private JButton boutonChgtPassword = new JButton("changer password");
		private JPanel connectionBar = new JPanel();
		private JPanel borderLayoutConnectionBar1 = new JPanel();
		private JPanel borderLayoutConnectionBar2 = new JPanel();
	//pour les lister
	    private JButton competition = new JButton("lister compétition");
	    private JButton competiteur = new JButton("lister compétiteur");
	    private JPanel lister = new JPanel();
	    private JPanel lister2 = new JPanel();
	    private JPanel lister3 = new JPanel();
	    private JPanel lister4 = new JPanel();
	//pour delBet
	    private JPanel delBetPanel = new JPanel();
	    private JButton delBet = new JButton("supprimer paris");
	//pour changeWallet
	    private JPanel walletPanel = new JPanel();
	    private JButton walletButton = new JButton("changer le solde d'un compte");
	//pour end comp�tition
	    private JPanel endCompPanel = new JPanel();
	    private JButton endCompButton = new JButton("rendre les r�sultats d'une comp�tition");
	//pour set des colonnes
	//pour player
	//pour comp�tition
	//pour comp�titeur
	//pour search
    	private JPanel search = new JPanel();
        private JPanel searchField = new JPanel();
	    private JLabel searchLabel = new JLabel("search:");
        private JButton searchButton = new JButton("search");
	    private JTextField searchText = new JTextField();





	public ManagerPanel(){
		this.setBackground(new Color(0,150,250));
		this.setTitle("logiciel de paris sportifs - interface manager");
		this.setSize(700, 1040);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getSize();

		//set bouton d�co et chgt password
	    borderLayoutConnectionBar1.setLayout(new BorderLayout());
	    borderLayoutConnectionBar2.setLayout(new BorderLayout());
	    borderLayoutConnectionBar1.setBackground(new Color(0,150,250));
	    borderLayoutConnectionBar2.setBackground(new Color(0,150,250));
	    connectionBar.setBackground(new Color(0,150,250));
	    connectionBar.setLayout(new BoxLayout(connectionBar, BoxLayout.LINE_AXIS));
	    BoutonInvisible boutonInvisible = new BoutonInvisible();
	    boutonInvisible.setPreferredSize(new Dimension(this.getWidth()*3/5,30));
	    connectionBar.add(borderLayoutConnectionBar1);
	    connectionBar.add(boutonInvisible);
	    connectionBar.add(borderLayoutConnectionBar2);
	    connectionBar.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    borderLayoutConnectionBar2.add(boutonDeconnection, BorderLayout.NORTH);
	    borderLayoutConnectionBar1.add(boutonChgtPassword, BorderLayout.NORTH);





	    //set de la bande central (bouton de listage)
	    lister.setBackground(new Color(0,150,250));
	    lister.setLayout(new BorderLayout());
	    lister2.setLayout(new BorderLayout());
	    lister3.setLayout(new BorderLayout());
	    competition.setFont(font);
	    competiteur.setFont(font);
	    lister2.add(competition, BorderLayout.CENTER);
	    lister3.add(competiteur, BorderLayout.CENTER);
	    lister4.setLayout(new GridLayout(1,2));
	    lister4.add(lister2);
	    lister4.add(lister3);
	    lister.add(lister4, BorderLayout.CENTER);
	    lister.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    lister.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));




		//set bouton delBet
	    delBet.setFont(font);
	    delBetPanel.setLayout(new BorderLayout());
		delBetPanel.add(delBet, BorderLayout.CENTER);
		delBetPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
		delBetPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));




		//set bouton changeWallet
		walletButton.setFont(font);
	    walletPanel.setLayout(new BorderLayout());
	    walletPanel.add(walletButton, BorderLayout.CENTER);
	    walletPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    walletPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));




		//set du endComp�tition
	    endCompButton.setFont(font);
	    endCompPanel.setLayout(new BorderLayout());
	    endCompPanel.add(endCompButton, BorderLayout.CENTER);
	    endCompPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    endCompPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));




		//set des colonnes add/del




		//set add/del Player




		//set add/del Comp�tition




		//set add/del comp�titor




		//set du search
	    searchButton.setFont(font);
	    search.setLayout(new BorderLayout());
	    searchField.add(searchLabel);
	    searchText.setPreferredSize(new Dimension(this.getWidth()-100, 30));
	    searchField.add(searchText);
	    search.setBackground(new Color(0,150,250));
	    Border borderSearch = BorderFactory.createLineBorder(Color.BLUE, 3);
	    searchField.setBorder(borderSearch);
	    search.add(searchField, BorderLayout.NORTH);
	    search.add(searchButton, BorderLayout.CENTER);
	    search.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    search.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));




	    //assemblage final
	    mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));
	    mainBox.add(connectionBar);
	    mainBox.add(lister);
	    mainBox.add(delBetPanel);
	    mainBox.add(walletPanel);
	    mainBox.add(endCompPanel);
	    mainBox.add(search);
	    mainBox.setBackground(Color.WHITE);



	    this.getContentPane().add(mainBox);
	    this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {

	}
}
