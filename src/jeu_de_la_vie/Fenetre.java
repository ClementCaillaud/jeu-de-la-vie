package jeu_de_la_vie;
import javax.swing.JFrame;

public class Fenetre extends JFrame
{
	private static final long serialVersionUID = 7804048215544764410L;

	public Fenetre(Monde monde)
	{
		super();
		setTitle("Jeu de la vie"); //On donne un titre à l'application
		setSize(1200,700); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On autorise le redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(monde);//On définit le content pane
	}
}
