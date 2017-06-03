package gui.panels;

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

import gui.buttons.BoutonInvisible;

@SuppressWarnings("serial")
public class PlayerPanel extends JFrame implements ActionListener{
	private Font font = new Font("arial",Font.CENTER_BASELINE,20);
	private JPanel mainBox = new JPanel();
	//pour bar de connexion
		private JButton boutonDeconnection = new JButton("Déconnection");
		private JButton boutonChgtPassword = new JButton("Changer mdp");
		private JPanel connectionBar = new JPanel();
		private JPanel borderLayoutConnectionBar1 = new JPanel();
		private JPanel borderLayoutConnectionBar2 = new JPanel();
    //pour les lister
    	private JButton competition = new JButton("Lister compétitions");
    	private JButton competiteur = new JButton("Lister compétiteurs");
    	private JPanel lister = new JPanel();
    	private JPanel lister2 = new JPanel();
    	private JPanel lister3 = new JPanel();
    	private JPanel lister4 = new JPanel();
    //pour search
    	private JPanel search = new JPanel();
        private JPanel searchField = new JPanel();
	    private JLabel searchLabel = new JLabel("Rechercher:");
        private JButton searchButton = new JButton("Rechercher");
	    private JTextField searchText = new JTextField();
    //pour les paris
    	private JPanel bet = new JPanel();
    	private JPanel bet2 = new JPanel();
    	private JPanel bet3 = new JPanel();
    	private JButton makeBet= new JButton("Parier");
    	private JButton changeBet= new JButton("Changer");
    	private JButton delBet = new JButton("Supprimer");
    	private JLabel betLabel = new JLabel("Paris");



	public PlayerPanel(){
	    this.setBackground(new Color(0,150,250));
		this.setTitle("logiciel de paris sportifs - interface player");
		this.setSize(500, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getSize();


	    //set du bouton d�connection chgt de password (box ligne de prenant 1/3 de la fenetre)
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
	    //connectionBar.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/4));
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
	    //lister.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/4));
	    //1lister.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/4));






	    //set du search
	    searchButton.setFont(font);
	    search.setLayout(new BorderLayout());
	    searchField.add(searchLabel);
	    searchText.setPreferredSize(new Dimension(this.getWidth()-150, 30));
	    searchField.add(searchText);
	    search.setBackground(new Color(0,150,250));
	    Border borderSearch = BorderFactory.createLineBorder(Color.BLUE, 3);
	    searchField.setBorder(borderSearch);
	    search.add(searchField, BorderLayout.NORTH);
	    search.add(searchButton, BorderLayout.CENTER);
	    //search.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/4));
	    //search.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/4));





	    //set de la partie paris
	    betLabel.setFont(font);
	    betLabel.setHorizontalAlignment(betLabel.CENTER);
	    bet3.setLayout(new GridLayout(1,3));
	    bet2.setLayout(new BorderLayout());
	    bet.setLayout(new BorderLayout());
	    Border borderBet = BorderFactory.createLineBorder(Color.BLUE, 3);
	    betLabel.setBorder(borderBet);
	    bet2.add(betLabel, BorderLayout.CENTER);
	    //betLabel.setPreferredSize(new Dimension(this.getWidth(),40));
	    bet3.add(makeBet);
	    bet3.add(changeBet);
	    bet3.add(delBet);
	    bet.add(bet2, BorderLayout.NORTH);
	    bet.add(bet3, BorderLayout.CENTER);
	    //bet.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/4));
	    //bet.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/4));






	    //assemblage final
	    mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));
	    mainBox.add(connectionBar);
	    mainBox.add(lister);
	    mainBox.add(bet);
	    mainBox.add(search);
	    mainBox.setBackground(Color.WHITE);





	    //setActions
	    boutonDeconnection.addActionListener(this);
	    competition.addActionListener(this);
	    competiteur.addActionListener(this);
	    searchButton.addActionListener(this);
	    makeBet.addActionListener(this);
	    delBet.addActionListener(this);
	    changeBet.addActionListener(this);
	    boutonChgtPassword.addActionListener(this);




	    this.getContentPane().add(mainBox);
	    this.setVisible(true);
	}
	
	public void showPlayerPanel(){
		this.setContentPane(mainBox);
	    this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		/*if(e.getSource() == boutonDeconnection){
			;
		}*/
		if(e.getSource() == boutonChgtPassword){
			PanelPasswordEdit PasswordEditPan = new PanelPasswordEdit(new String());
			this.setContentPane(PasswordEditPan);
			this.setVisible(true);
		}
		if(e.getSource() == competition){
			PanelList listCompetition = new PanelList(new ArrayList<ArrayList<String>>(), 2);
			this.setContentPane(listCompetition);
			this.setVisible(true);
		}
		if(e.getSource() == competiteur){
			PanelList listCompetiteur = new PanelList(new ArrayList<ArrayList<String>>(), 1);
			this.setContentPane(listCompetiteur);
			this.setVisible(true);
		}
		/*if(e.getSource() == searchButton){
			;
		}*/
		if(e.getSource() == makeBet){
			PanelFormBet panelFormBet = new PanelFormBet(false, new String(), new ArrayList<String>(), 1, 1);
			this.setContentPane(panelFormBet);
			this.setVisible(true);
		}
		/*if(e.getSource() == changeBet){
			;
		}
		if(e.getSource() == delBet){
			;
		}*/
	}
}
