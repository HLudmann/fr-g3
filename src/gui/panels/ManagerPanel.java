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
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import gui.buttons.BoutonInvisible;

public class ManagerPanel extends JFrame implements ActionListener{
	private Font font = new Font("arial",Font.CENTER_BASELINE,20);
	private JPanel mainBox = new JPanel();
	Border borderBlack = BorderFactory.createLineBorder(Color.BLACK, 3);
	//pour bar de connexion
		private JButton boutonDeconnection = new JButton("Déconnection");
		private JButton boutonChgtPassword = new JButton("Changer mdp");
		private JPanel connectionBar = new JPanel();
		private JPanel borderLayoutConnectionBar1 = new JPanel();
		private JPanel borderLayoutConnectionBar2 = new JPanel();
	//pour les lister
	    private JButton listCompetition = new JButton("Lister compétitions");
	    private JButton listCompetitor = new JButton("Lister compétiteurs");
	    private JPanel lister = new JPanel();
	    private JPanel lister2 = new JPanel();
	    private JPanel lister3 = new JPanel();
	    private JPanel lister4 = new JPanel();
	//pour delBet
	    private JPanel delBetPanel = new JPanel();
	    private JButton delBet = new JButton("Supprimer paris");
	//pour changeWallet
	    private JPanel walletPanel = new JPanel();
	    private JButton walletButton = new JButton("Changer le solde d'un compte");
	//pour end compétition
	    private JPanel endCompPanel = new JPanel();
	    private JButton endCompButton = new JButton("Rendre les résultats d'une compétition");
	//pour set des colonnes
	    private JLabel add = new JLabel("Ajouter");
	    private JLabel delete = new JLabel("Supprimer");
	    private JPanel addDel = new JPanel();
	    private JPanel addDel2 = new JPanel();
	    private JPanel addDel3 = new JPanel();
	    private JPanel addDel4 = new JPanel();
	//pour player
	    private JButton addPlayer = new JButton("Joueur");
	    private JButton delPlayer = new JButton("Joueur");
	    private JPanel player = new JPanel();
	    private JPanel player2 = new JPanel();
	    private JPanel player3 = new JPanel();
	    private JPanel player4 = new JPanel();
	//pour compétition
	    private JButton addCompetition = new JButton("Compétition");
	    private JButton delCompetition = new JButton("Compétition");
	    private JPanel competition = new JPanel();
	    private JPanel competition2 = new JPanel();
	    private JPanel competition3 = new JPanel();
	    private JPanel competition4 = new JPanel();
	//pour compétitor
	    private JButton addCompetitor = new JButton("Compétiteur");
	    private JButton delCompetitor = new JButton("Compétiteur");
	    private JPanel competitor = new JPanel();
	    private JPanel competitor2 = new JPanel();
	    private JPanel competitor3 = new JPanel();
	    private JPanel competitor4 = new JPanel();
	//pour search
    	private JPanel search = new JPanel();
        private JPanel searchField = new JPanel();
	    private JLabel searchLabel = new JLabel("Rechercher:");
        private JButton searchButton = new JButton("Rechercher");
	    private JTextField searchText = new JTextField();
	    
	    
	    
	    
	    
	public ManagerPanel(){
		this.setBackground(new Color(0,150,250));
		this.setTitle("logiciel de paris sportifs - interface manager");
		this.setSize(700, 1040);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getSize();
	    makeAndShowManagerPanel();
	}
	
	    
	private void makeAndShowManagerPanel(){
		//set bouton déco et chgt password
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
	    //connectionBar.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    borderLayoutConnectionBar2.add(boutonDeconnection, BorderLayout.NORTH);
	    borderLayoutConnectionBar1.add(boutonChgtPassword, BorderLayout.NORTH);
	    
	    
	    
	    
	    
	    //set de la bande central (bouton de listage)
	    lister.setBackground(new Color(0,150,250));
	    lister.setLayout(new BorderLayout());
	    lister2.setLayout(new BorderLayout());
	    lister3.setLayout(new BorderLayout());
	    listCompetition.setFont(font);
	    listCompetitor.setFont(font);
	    lister2.add(listCompetition, BorderLayout.CENTER);
	    lister3.add(listCompetitor, BorderLayout.CENTER);
	    lister4.setLayout(new GridLayout(1,2));
	    lister4.add(lister2);
	    lister4.add(lister3);
	    lister.add(lister4, BorderLayout.CENTER);
	    //lister.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //lister.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
	
	    
	
	
		//set bouton delBet
	    delBet.setFont(font);
	    delBetPanel.setLayout(new BorderLayout());
		delBetPanel.add(delBet, BorderLayout.CENTER);
		//delBetPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
		//delBetPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		
		//set bouton changeWallet
		walletButton.setFont(font);
	    walletPanel.setLayout(new BorderLayout());
	    walletPanel.add(walletButton, BorderLayout.CENTER);
	    //walletPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //walletPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		
		//set du endCompetition
	    endCompButton.setFont(font);
	    endCompPanel.setLayout(new BorderLayout());
	    endCompPanel.add(endCompButton, BorderLayout.CENTER);
	    //endCompPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //endCompPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		
		//set des colonnes add/del
	    addDel.setBackground(new Color(0,150,250));
	    addDel.setLayout(new BorderLayout());
	    addDel2.setLayout(new BorderLayout());
	    addDel3.setLayout(new BorderLayout());
	    add.setFont(font);
	    delete.setFont(font);
	    addDel2.setBackground(Color.WHITE);
	    addDel3.setBackground(Color.WHITE);
	    add.setHorizontalAlignment(SwingConstants.CENTER);
	    delete.setHorizontalAlignment(SwingConstants.CENTER);
	    addDel2.add(add, BorderLayout.CENTER);
	    addDel3.add(delete, BorderLayout.CENTER);
	    addDel4.setLayout(new GridLayout(1,2));
	    addDel4.add(addDel2);
	    addDel4.add(addDel3);
	    addDel.setBorder(borderBlack);
	    addDel2.setBorder(borderBlack);
	    addDel3.setBorder(borderBlack);
	    addDel.add(addDel4, BorderLayout.CENTER);
	    //addDel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //addDel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		//set add/del Player
	    player.setBackground(new Color(0,150,250));
	    player.setLayout(new BorderLayout());
	    player2.setLayout(new BorderLayout());
	    player3.setLayout(new BorderLayout());
	    addPlayer.setFont(font);
	    delPlayer.setFont(font);
	    player2.add(addPlayer, BorderLayout.CENTER);
	    player3.add(delPlayer, BorderLayout.CENTER);
	    player4.setLayout(new GridLayout(1,2));
	    player4.add(player2);
	    player4.add(player3);
	    //player.setBorder(borderBlack);
	    player2.setBorder(borderBlack);
	    player3.setBorder(borderBlack);
	    player.add(player4, BorderLayout.CENTER);
	    //player.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //player.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		//set add/del Compétition
	    competition.setBackground(new Color(0,150,250));
	    competition.setLayout(new BorderLayout());
	    competition2.setLayout(new BorderLayout());
	    competition3.setLayout(new BorderLayout());
	    addCompetition.setFont(font);
	    delCompetition.setFont(font);
	    competition2.add(addCompetition, BorderLayout.CENTER);
	    competition3.add(delCompetition, BorderLayout.CENTER);
	    competition4.setLayout(new GridLayout(1,2));
	    competition4.add(competition2);
	    competition4.add(competition3);
	    competition.setBorder(borderBlack);
	    competition2.setBorder(borderBlack);
	    competition3.setBorder(borderBlack);
	    competition.add(competition4, BorderLayout.CENTER);
	    //competition.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //competition.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		//set add/del compétitor
	    competitor.setBackground(new Color(0,150,250));
	    competitor.setLayout(new BorderLayout());
	    competitor2.setLayout(new BorderLayout());
	    competitor3.setLayout(new BorderLayout());
	    addCompetitor.setFont(font);
	    delCompetitor.setFont(font);
	    competitor2.add(addCompetitor, BorderLayout.CENTER);
	    competitor3.add(delCompetitor, BorderLayout.CENTER);
	    competitor4.setLayout(new GridLayout(1,2));
	    competitor4.add(competitor2);
	    competitor4.add(competitor3);
	    //competitor.setBorder(borderBlack);
	    competitor2.setBorder(borderBlack);
	    competitor3.setBorder(borderBlack);
	    competitor.add(competitor4, BorderLayout.CENTER);
	    //competitor.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //competitor.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
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
	    //search.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    //search.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    
	    
	    
	    
	    //assemblage final
	    mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));
	    mainBox.add(connectionBar);
	    mainBox.add(lister);
	    mainBox.add(delBetPanel);
	    mainBox.add(walletPanel);
	    mainBox.add(endCompPanel);
	    mainBox.add(addDel);
	    mainBox.add(player);
	    mainBox.add(competition);
	    mainBox.add(competitor);
	    mainBox.add(search);
	    mainBox.setBackground(Color.WHITE);
	    
	    
	    
	    
	    //set bouton actionnable
	    boutonDeconnection.addActionListener(this);
	    boutonChgtPassword.addActionListener(this);
	    listCompetition.addActionListener(this);
	    listCompetitor.addActionListener(this);
	    delBet.addActionListener(this);
	    walletButton.addActionListener(this);
	    endCompButton.addActionListener(this);
	    addPlayer.addActionListener(this);
	    delPlayer.addActionListener(this);
	    addCompetition.addActionListener(this);
	    delCompetition.addActionListener(this);
	    addCompetitor.addActionListener(this);
	    delCompetitor.addActionListener(this);
	    searchButton.addActionListener(this);
	    
	
	
	
	    this.getContentPane().add(mainBox);
	    this.setVisible(true);
	}
	
	//méthode liée à l'activation des boutons
	public void actionPerformed(ActionEvent e) {
		/*if(e.getSource() == boutonDeconnection){
			
		}
		if(e.getSource() == boutonChgtPassword){
			
		}
		if(e.getSource() == listCompetition){
			
		}
		if(e.getSource() == listCompetitor){
			
		}
		if(e.getSource() == delBet){
			
		}
		if(e.getSource() == walletButton){
			
		}
		if(e.getSource() == endCompButton){
			
		}*/
		if(e.getSource() == addPlayer){
			PanelAddPlayer addPlayerPan = new PanelAddPlayer();
			this.setContentPane(addPlayerPan);
			this.setVisible(true);
		}/*
		if(e.getSource() == delPlayer){
			
		}*/
		if(e.getSource() == addCompetition){
			PanelAddCompetition addCompetitionPan = new PanelAddCompetition();
			this.setContentPane(addCompetitionPan);
			this.setVisible(true);
		}/*
		if(e.getSource() == delCompetition){
			
		}*/
		if(e.getSource() == addCompetitor){
			PanelAddCompetitor addCompetitorPan = new PanelAddCompetitor();
			this.setContentPane(addCompetitorPan);
			this.setVisible(true);
		}/*
		if(e.getSource() == delCompetitor){
			
		}
		if(e.getSource() == searchButton){
			
		}*/
	}
}
