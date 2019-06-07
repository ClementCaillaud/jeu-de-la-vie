package jeu_de_la_vie;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Monde extends JPanel implements Runnable
{
	private static final long serialVersionUID = -2318077517510272794L;
	private int largeur;
	private int hauteur;
	private boolean grille[][];
	private int nbIterations;
	
	/**
	 * Constructeur du monde
	 * @param largeur Nombre de colonnes
	 * @param hauteur Nombre de lignes
	 */
	public Monde(int largeur, int hauteur)
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.grille = new boolean[hauteur][largeur];
		nbIterations = 0;
	}
	
	/**
	 * Fait naitre une cellule à l'emplacement donné
	 * @param positionX Colonne
	 * @param positionY Ligne
	 */
	public void naissance(int positionX, int positionY)
	{
		grille[positionY][positionX] = true;
	}
	
	/**
	 * Fait mourir une cellule à l'emplacement donné
	 * @param positionX Colonne
	 * @param positionY Ligne
	 */
	public void mort(int positionX, int positionY)
	{
		grille[positionY][positionX] = false;
	}
	
	/**
	 * Fais évoluer la grille
	 */
	public void evolution()
	{
		boolean futurMonde[][] = new boolean[largeur][hauteur];
		
		//Rempli le futur monde avec le prochain état de chaque cellule
		for (int y = 0; y < hauteur; y++)
		{
			for (int x = 0; x < largeur; x++)
			{
				futurMonde[y][x] = futur_etat(x, y);
			}
		}
		grille = futurMonde;
	}
	
	/**
	 * Détermine le futur état d'une cellule
	 * @param x Colonne
	 * @param y Ligne
	 * @return boolean Le futur état
	 */
	private boolean futur_etat(int x, int y)
	{
		//Trouver tous les voisins de la cellule
		boolean voisins[] = {
			(y-1 >= 0) 							? grille[y-1][x] 	: false,//haut
			(y-1 >= 0 && x+1 < largeur) 		? grille[y-1][x+1] 	: false,//haut droite
			(x+1 < largeur) 					? grille[y][x+1] 	: false,//droite
			(y+1 < hauteur && x+1 < largeur) 	? grille[y+1][x+1] 	: false,//bas droite
			(y+1 < hauteur) 					? grille[y+1][x] 	: false,//bas
			(y+1 < hauteur && x-1 >= 0) 		? grille[y+1][x-1] 	: false,//bas gauche
			(x-1 >= 0) 							? grille[y][x-1] 	: false,//gauche
			(x-1 >= 0 && y-1 >= 0) 				? grille[y-1][x-1] 	: false //haut gauche
		};
		
		int nbVoisinsVivants = 0;
		//Compter le nombre de voisins vivants
		for (boolean etatVoisin : voisins)
		{
			if(etatVoisin)
			{
				nbVoisinsVivants++;
			}
		}
		
		//Si la cellule est vivante
		if(grille[y][x])
		{
			//Si elle a 2 ou 3 voisins vivants elle vit
			if(nbVoisinsVivants == 2 || nbVoisinsVivants == 3)
			{
				return true;
			}
			//Sinon elle meurt
			else
			{
				return false;
			}
		}
		//Sinon si la cellule est vivante
		else
		{
			//Si elle a 3 voisins vivants elle nait
			if(nbVoisinsVivants == 3)
			{
				return true;
			}
			//Sinon elle reste morte
			else
			{
				return false;
			}
		}
	}
	
	@Override
	public String toString()
	{
		String affichage = "";
		for (int y = 0; y < hauteur; y++)
		{
			for (int x = 0; x < largeur; x++)
			{
				affichage = affichage.concat( (grille[y][x] == true) ? "O" : "X" );
			}
			affichage = affichage.concat("\n");
		}
		return affichage;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//Affichage de la grille
		for (int y = 0; y < hauteur; y++)
		{
			for (int x = 0; x < largeur; x++)
			{
				//Si la cellule est vivante on l'affiche en gris
				if(grille[y][x])
				{
					g.setColor(Color.GRAY);
				}
				//Sinon on l'affiche en blanc
				else
				{
					g.setColor(Color.WHITE);
				}
				g.fillOval(x*10, y*10, 10, 10);
			}
		}
		//Affichage du nombre d'itérations de la simulation
		g.setColor(Color.BLACK);
		g.drawString(""+nbIterations, 20, 20);
	}
	
	@Override
	public void run()
	{
		while(true)
		{	
			try 
			{
				nbIterations++;//On incrémente le nombre d'itérations
				evolution();//On fait évoluer la simulation
				repaint();//On redessine la fenêtre
				Thread.sleep(50);//On temporise
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public int get_largeur()
	{
		return largeur;
	}
	
	public int get_hauteur()
	{
		return hauteur;
	}
}
