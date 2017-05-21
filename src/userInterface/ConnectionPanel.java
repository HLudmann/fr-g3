import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ConnectionPanel extends JFrame implements ActionListener{
	private BoutonConnection boutonVisitor = new BoutonConnection("see as just a visitor");
    private BoutonConnection boutonAdmin = new BoutonConnection("connect as admin");
    private BoutonConnection boutonPlayer = new BoutonConnection("connect as player");
    private JPanel initialPan = new JPanel();
    private JPanel adminPan = new JPanel();
    private JPanel playerPan = new JPanel();
    private JTextField playerName = new JTextField("");
    private JTextField adminName = new JTextField("");
    private JTextField playerPassword = new JTextField("");
    private JTextField adminPassword = new JTextField("");
    private Font font =new Font("TimesRoman",Font.CENTER_BASELINE,25);
    private JLabel labelUserNamePlayer = new JLabel("Username:",JLabel.CENTER);
    private JLabel labelPasswordAdmin = new JLabel("Password: ");
    private JLabel labelUserNameAdmin = new JLabel("Username:",JLabel.CENTER);
    private JLabel labelPasswordPlayer = new JLabel("Password: ");
    private BoutonRetour backButtonPlayer = new BoutonRetour("back");
    private BoutonRetour backButtonAdmin = new BoutonRetour("back");


	
	
	public ConnectionPanel(){
		this.setTitle("logiciel de paris sportifs");          
	    this.setVisible(true);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    initialPan.setBackground(Color.BLUE.darker().darker().darker());        
	    this.setContentPane(initialPan);
	    boutonPlayer.addActionListener(this);
	    boutonAdmin.addActionListener(this);
	    boutonVisitor.addActionListener(this);
	    GridLayout grid = new GridLayout(3, 1);
	    grid.setHgap(10);
	    grid.setVgap(30);
	    this.setLayout(grid);
	    initialPan.add(boutonPlayer);
	    initialPan.add(boutonAdmin);
	    initialPan.add(boutonVisitor);
	    setPlayerConnectionPan();
	    setAdminConnectionPan();
	}

	
	
	
	//méthode permettant de faire les actions lorsqu'on appuie sur un bouton
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == boutonPlayer){
			this.showPlayerConnectionPan();
		}
		if(event.getSource() == boutonAdmin){
			this.showAdminConnectionPan();
		}
		if(event.getSource() == boutonVisitor){
			System.out.println(" à faire ");
		}
		if(event.getSource() == backButtonPlayer || event.getSource() == backButtonAdmin){
			this.showMainPanel();
		}
	}
	
	
	private void showMainPanel(){      
	    this.setContentPane(initialPan);
	}
	
	//méthode permettant de set la fenêtre d'authentification des joueurs
	private void setPlayerConnectionPan(){
		playerPan.setBackground(Color.BLUE.darker().darker().darker());
		
		//set de la case formulaire username
	    JPanel userNamePan = new JPanel();
	    JPanel userNamePan2 = new JPanel();
		userNamePan.setBackground(Color.BLUE.darker().darker().darker());
		playerName.setFont(font);
		playerName.setPreferredSize(new Dimension(300, 30));
		playerName.setForeground(Color.BLACK);
		labelUserNamePlayer.setFont(font);
		labelUserNamePlayer.setForeground(Color.BLACK);
		userNamePan2.add(labelUserNamePlayer);
		userNamePan2.add(playerName);
		userNamePan.setLayout(new BorderLayout());
		userNamePan.add(userNamePan2, BorderLayout.SOUTH);
	    
	    //set de la case formulaire password
		JPanel passwordPan = new JPanel();
		JPanel passwordPan2 = new JPanel();
		passwordPan.setBackground(Color.BLUE.darker().darker().darker());
	    playerPassword.setFont(font);
	    playerPassword.setPreferredSize(new Dimension(300, 30));
	    playerPassword.setForeground(Color.BLACK);
	    labelPasswordPlayer.setFont(font);
	    labelPasswordPlayer.setForeground(Color.BLACK);
	    passwordPan2.add(labelPasswordPlayer);
	    passwordPan2.add(playerPassword);
	    passwordPan.setLayout(new BorderLayout());
	    passwordPan.add(passwordPan2, BorderLayout.NORTH);
	    
	    //set du bouton retour
	    backButtonPlayer.addActionListener(this);
	    
	    GridLayout gridPlayer = new GridLayout(3, 1);
	    playerPan.setLayout(gridPlayer);
	    playerPan.add(userNamePan);
	    playerPan.add(passwordPan);
	    playerPan.add(backButtonPlayer);
	}
	
	
	//méthode permettant de set la fenêtre d'authentification des admins
	private void setAdminConnectionPan(){
		adminPan.setBackground(Color.BLUE.darker().darker().darker());
		
		//set de la case formulaire username
	    JPanel userNamePan = new JPanel();
	    JPanel userNamePan2 = new JPanel();
		userNamePan.setBackground(Color.BLUE.darker().darker().darker());
		adminName.setFont(font);
		adminName.setPreferredSize(new Dimension(300, 30));
		adminName.setForeground(Color.BLACK);
		labelUserNameAdmin.setFont(font);
		labelUserNameAdmin.setForeground(Color.BLACK);
		userNamePan2.add(labelUserNameAdmin);
		userNamePan2.add(adminName);
		userNamePan.setLayout(new BorderLayout());
		userNamePan.add(userNamePan2, BorderLayout.SOUTH);
	    
	    //set de la case formulaire password
		JPanel passwordPan = new JPanel();
		JPanel passwordPan2 = new JPanel();
		passwordPan.setBackground(Color.BLUE.darker().darker().darker());
	    adminPassword.setFont(font);
	    adminPassword.setPreferredSize(new Dimension(300, 30));
	    adminPassword.setForeground(Color.BLACK);
	    labelPasswordAdmin.setFont(font);
	    labelPasswordAdmin.setForeground(Color.BLACK);
	    passwordPan2.add(labelPasswordAdmin);
	    passwordPan2.add(adminPassword);
	    passwordPan.setLayout(new BorderLayout());
	    passwordPan.add(passwordPan2, BorderLayout.NORTH);
	    
	    //set du bouton retour
	    backButtonAdmin.addActionListener(this);
	    
	    GridLayout gridAdmin = new GridLayout(3, 1);
	    adminPan.setLayout(gridAdmin);
	    adminPan.add(userNamePan);
	    adminPan.add(passwordPan);
	    adminPan.add(backButtonAdmin);
	}
	
	private void showPlayerConnectionPan(){
		this.setContentPane(playerPan);
	    this.setVisible(true);
	}
	
	private void showAdminConnectionPan(){
		this.setContentPane(adminPan);
	    this.setVisible(true);
	}
}
