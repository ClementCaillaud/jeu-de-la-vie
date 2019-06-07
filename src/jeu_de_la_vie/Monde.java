package jeu_de_la_vie;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Monde extends JPanel implements Runnable
{
	private int largeur;
	private int hauteur;
	private boolean grille[][];
	private int nbIterations;
	
	public Monde(int largeur, int hauteur)
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.grille = new boolean[hauteur][largeur];
		nbIterations = 0;
	}
	
	public void naissance(int positionX, int positionY)
	{
		grille[positionY][positionX] = true;
	}
	
	public void mort(int positionX, int positionY)
	{
		grille[positionY][positionX] = false;
	}
	
	public void evolution()
	{
		boolean futurMonde[][] = new boolean[largeur][hauteur];
		
		for (int y = 0; y < hauteur; y++)
		{
			for (int x = 0; x < largeur; x++)
			{
				futurMonde[y][x] = futur_etat(x, y);
			}
		}
		grille = futurMonde;
	}
	
	private boolean futur_etat(int x, int y)
	{
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
		
		for (boolean etatVoisin : voisins)
		{
			if(etatVoisin)
			{
				nbVoisinsVivants++;
			}
		}
		
		if(grille[y][x])
		{
			if(nbVoisinsVivants == 2 || nbVoisinsVivants == 3)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(nbVoisinsVivants == 3)
			{
				return true;
			}
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
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		for (int y = 0; y < hauteur; y++)
		{
			for (int x = 0; x < largeur; x++)
			{
				if(grille[y][x])
				{
					g.setColor(Color.GRAY);
				}
				else
				{
					g.setColor(Color.WHITE);
				}
				g.fillOval(x*10, y*10, 10, 10);
			}
		}
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
				nbIterations++;
				evolution();
				repaint();
				Thread.sleep(50);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
