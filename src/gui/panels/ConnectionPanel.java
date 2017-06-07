package gui.panels;

import gui.*;
import gui.panels.*;

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

import gui.buttons.BoutonConnection;
import gui.buttons.BoutonRetour;


/*
import userInterface.VisitorInterface;
import userInterface.exceptions.ManagerAuthentificated;
import userInterface.exceptions.PlayerAuthentificated;
*/


public class ConnectionPanel extends JFrame implements ActionListener {
    private BoutonConnection boutonAdmin = new BoutonConnection("Connection admin");
    private BoutonConnection boutonPlayer = new BoutonConnection("Connection joueur");
    private JPanel initialPan = new JPanel();
    private JPanel adminPan = new JPanel();
    private JPanel playerPan = new JPanel();
    private JTextField playerName = new JTextField("");
    private JTextField adminName = new JTextField("");
    private JTextField playerPassword = new JTextField("");
    private JTextField adminPassword = new JTextField("");
    private JLabel labelUserNamePlayer = new JLabel("Username:",JLabel.CENTER);
    private JLabel labelPasswordAdmin = new JLabel("Password: ");
    private JLabel labelUserNameAdmin = new JLabel("Username:",JLabel.CENTER);
    private JLabel labelPasswordPlayer = new JLabel("Password: ");
    private BoutonRetour backButtonPlayer = new BoutonRetour("Retour");
    private BoutonRetour backButtonAdmin = new BoutonRetour("Retour");
    private BoutonRetour connectButtonPlayer = new BoutonRetour("Connect");
    private BoutonRetour connectButtonAdmin = new BoutonRetour("Connect");
    private Window window;
    //private VisitorInterface visitor= new VisitorInterface();
    private MainInterface mainInterface;



	public ConnectionPanel(MainInterface mainInterface, Window window){
		this.mainInterface = mainInterface;
    this.window = window;
		this.setTitle("logiciel de paris sportifs");
		this.setSize(500, 500);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setContentPane(initialPan);
    boutonPlayer.addActionListener(this);
    boutonAdmin.addActionListener(this);
    GridLayout grid = new GridLayout(2, 1);
    grid.setHgap(5);
    grid.setVgap(5);
    this.setLayout(grid);
    initialPan.add(boutonPlayer);
    initialPan.add(boutonAdmin);
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
		if(event.getSource() == backButtonPlayer || event.getSource() == backButtonAdmin){
			this.showMainPanel();
		}
		if(event.getSource() == connectButtonPlayer){
      window.setPanel(new PlayerPanel());
      this.dispose();
			/*try{
				//visitor.signIn(playerName.getText(), playerPassword.getText());
			} catch(PlayerAuthentificated e){
				//à faire
			} catch(Exception e){
				showMainPanel();
			}*/
		}
		if(event.getSource() == connectButtonAdmin){
      window.setPanel(new ManagerPanel());
      this.dispose();
      /*
			try{
				visitor.signIn(adminName.getText(), adminPassword.getText());
			} catch(ManagerAuthentificated e){
				//à faire
			} catch(Exception e){
				showMainPanel();
			};*/
		}
	}


	private void showMainPanel(){
	    this.setContentPane(initialPan);
	}

	//méthode permettant de set la fen�tre d'authentification des joueurs
	private void setPlayerConnectionPan(){

		//set de la case formulaire username
    JPanel userNamePan = new JPanel();
    JPanel userNamePan2 = new JPanel();
		playerName.setPreferredSize(new Dimension(300, 30));
		playerName.setForeground(Color.BLACK);
		labelUserNamePlayer.setForeground(Color.BLACK);
		userNamePan2.add(labelUserNamePlayer);
		userNamePan2.add(playerName);
		userNamePan.setLayout(new BorderLayout());
		userNamePan.add(userNamePan2, BorderLayout.SOUTH);

	    //set de la case formulaire password
		JPanel passwordPan = new JPanel();
		JPanel passwordPan2 = new JPanel();
    playerPassword.setPreferredSize(new Dimension(300, 30));
    playerPassword.setForeground(Color.BLACK);
    labelPasswordPlayer.setForeground(Color.BLACK);
    passwordPan2.add(labelPasswordPlayer);
    passwordPan2.add(playerPassword);
    passwordPan.setLayout(new BorderLayout());
    passwordPan.add(passwordPan2, BorderLayout.NORTH);

    //set du bouton retour
    backButtonPlayer.addActionListener(this);

    //set du bouton connect
    connectButtonPlayer.addActionListener(this);

    GridLayout gridPlayer = new GridLayout(4, 1);
    playerPan.setLayout(gridPlayer);
    playerPan.add(userNamePan);
    playerPan.add(passwordPan);
    playerPan.add(connectButtonPlayer);
    playerPan.add(backButtonPlayer);
	}


	//méthode permettant de set la fen�tre d'authentification des admins
	private void setAdminConnectionPan(){

		//set de la case formulaire username
	  JPanel userNamePan = new JPanel();
	  JPanel userNamePan2 = new JPanel();
		adminName.setPreferredSize(new Dimension(300, 30));
		adminName.setForeground(Color.BLACK);
		labelUserNameAdmin.setForeground(Color.BLACK);
		userNamePan2.add(labelUserNameAdmin);
		userNamePan2.add(adminName);
		userNamePan.setLayout(new BorderLayout());
		userNamePan.add(userNamePan2, BorderLayout.SOUTH);

	    //set de la case formulaire password
		JPanel passwordPan = new JPanel();
		JPanel passwordPan2 = new JPanel();
    adminPassword.setPreferredSize(new Dimension(300, 30));
    adminPassword.setForeground(Color.BLACK);
    labelPasswordAdmin.setForeground(Color.BLACK);
    passwordPan2.add(labelPasswordAdmin);
    passwordPan2.add(adminPassword);
    passwordPan.setLayout(new BorderLayout());
    passwordPan.add(passwordPan2, BorderLayout.NORTH);

    //set du bouton retour
    backButtonAdmin.addActionListener(this);

    //set du bouton connect
    connectButtonAdmin.addActionListener(this);

    GridLayout gridAdmin = new GridLayout(4, 1);
    adminPan.setLayout(gridAdmin);
    adminPan.add(userNamePan);
    adminPan.add(passwordPan);
    adminPan.add(connectButtonAdmin);
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
