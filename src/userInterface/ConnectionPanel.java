import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class ConnectionPanel extends JFrame implements ActionListener{
	private BoutonConnection boutonVisitor = new BoutonConnection("see as just a visitor");
    private BoutonConnection boutonAdmin = new BoutonConnection("connect as admin");
    private BoutonConnection boutonPlayer = new BoutonConnection("connect as player");
    private JPanel initialPan = new JPanel();
    private JPanel adminPan = new JPanel();
    private JPanel playerPan = new JPanel();
    
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
	}

	
	
	
	//méthode permettant de faire les actions lorsqu'on appuie sur un bouton
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == boutonPlayer){
			this.setPlayerPan();
		}
		if(event.getSource() == boutonAdmin){
			System.out.println(" ok ");
		}
		if(event.getSource() == boutonVisitor){
			System.out.println(" ok ");
		}
	}
	
	
	
	
	//méthode permettant d'afficher la fenêtre d'authentification des joueurs
	private void setPlayerPan(){
		playerPan.setBackground(Color.red);
		this.setContentPane(playerPan);
		this.setVisible(true);
	}
}
