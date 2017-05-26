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
		private JButton boutonDeconnection = new JButton("déconnection");
		private JButton boutonChgtPassword = new JButton("changer password");
		private JPanel connectionBar = new JPanel();
		private JPanel borderLayoutConnectionBar1 = new JPanel();
		private JPanel borderLayoutConnectionBar2 = new JPanel();
	//pour les lister
	    private JButton listCompetition = new JButton("lister compétition");
	    private JButton listCompetiteur = new JButton("lister compétiteur");
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
	//pour end compétition
	    private JPanel endCompPanel = new JPanel();
	    private JButton endCompButton = new JButton("rendre les résultats d'une compétition");
	//pour set des colonnes
	    private JLabel add = new JLabel("ajouter");
	    private JLabel delete = new JLabel("supprimer");
	    private JPanel addDel = new JPanel();
	    private JPanel addDel2 = new JPanel();
	    private JPanel addDel3 = new JPanel();
	    private JPanel addDel4 = new JPanel();
	//pour player
	    private JButton addPlayer = new JButton("joueur");
	    private JButton delPlayer = new JButton("joueur");
	    private JPanel player = new JPanel();
	    private JPanel player2 = new JPanel();
	    private JPanel player3 = new JPanel();
	    private JPanel player4 = new JPanel();
	//pour compétition
	    private JButton addCompetition = new JButton("compétition");
	    private JButton delCompetition = new JButton("compétition");
	    private JPanel competition = new JPanel();
	    private JPanel competition2 = new JPanel();
	    private JPanel competition3 = new JPanel();
	    private JPanel competition4 = new JPanel();
	//pour compétiteur
	    private JButton addCompetiteur = new JButton("compétiteur");
	    private JButton delCompetiteur = new JButton("compétiteur");
	    private JPanel competiteur = new JPanel();
	    private JPanel competiteur2 = new JPanel();
	    private JPanel competiteur3 = new JPanel();
	    private JPanel competiteur4 = new JPanel();
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
	    connectionBar.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    borderLayoutConnectionBar2.add(boutonDeconnection, BorderLayout.NORTH);
	    borderLayoutConnectionBar1.add(boutonChgtPassword, BorderLayout.NORTH);
	    
	    
	    
	    
	    
	    //set de la bande central (bouton de listage)
	    lister.setBackground(new Color(0,150,250));
	    lister.setLayout(new BorderLayout());
	    lister2.setLayout(new BorderLayout());
	    lister3.setLayout(new BorderLayout());
	    listCompetition.setFont(font);
	    listCompetiteur.setFont(font);
	    lister2.add(listCompetition, BorderLayout.CENTER);
	    lister3.add(listCompetiteur, BorderLayout.CENTER);
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
		
		
		
		
		//set du endCompetition
	    endCompButton.setFont(font);
	    endCompPanel.setLayout(new BorderLayout());
	    endCompPanel.add(endCompButton, BorderLayout.CENTER);
	    endCompPanel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    endCompPanel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		
		//set des colonnes add/del
	    addDel.setBackground(new Color(0,150,250));
	    addDel.setLayout(new BorderLayout());
	    addDel2.setLayout(new BorderLayout());
	    addDel3.setLayout(new BorderLayout());
	    add.setFont(font);
	    delete.setFont(font);
	    add.setBackground(Color.WHITE);
	    delete.setBackground(Color.WHITE);
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
	    addDel.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    addDel.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
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
	    player.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    player.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
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
	    competition.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    competition.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
		//set add/del compétitor
	    competiteur.setBackground(new Color(0,150,250));
	    competiteur.setLayout(new BorderLayout());
	    competiteur2.setLayout(new BorderLayout());
	    competiteur3.setLayout(new BorderLayout());
	    addCompetiteur.setFont(font);
	    delCompetiteur.setFont(font);
	    competiteur2.add(addCompetiteur, BorderLayout.CENTER);
	    competiteur3.add(delCompetiteur, BorderLayout.CENTER);
	    competiteur4.setLayout(new GridLayout(1,2));
	    competiteur4.add(competiteur2);
	    competiteur4.add(competiteur3);
	    //competiteur.setBorder(borderBlack);
	    competiteur2.setBorder(borderBlack);
	    competiteur3.setBorder(borderBlack);
	    competiteur.add(competiteur4, BorderLayout.CENTER);
	    competiteur.setMaximumSize(new Dimension(this.getWidth(),this.getHeight()/10));
	    competiteur.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()/10));
		
		
		
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
	    mainBox.add(addDel);
	    mainBox.add(player);
	    mainBox.add(competition);
	    mainBox.add(competiteur);
	    mainBox.add(search);
	    mainBox.setBackground(Color.WHITE);
	
	
	
	    this.getContentPane().add(mainBox);
	    this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
