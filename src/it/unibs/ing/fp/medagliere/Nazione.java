package it.unibs.ing.fp.medagliere;

public class Nazione 
{
	private String nome;
	private int nTotOri=0;
	private int nTotArgenti=0;
	private int nTotBronzi=0;
	
	public Nazione (String _nome)
	{
		nome=_nome;
	}
	
	public void addOro()
	{
		nTotOri++;
	}
	
	public void addArgento()
	{
		nTotArgenti++;
	}
	
	public void addBronzo()
	{
		nTotBronzi++;
	}
	
	public String toString() 
	{
		return String.format("%s %n Numero ori: %d%n Numero argenti: %d%n Numero bronzi: %d%n", nome,nTotOri,nTotArgenti,nTotBronzi);
	}
	
	public String getNome()
	{
		return nome;
	}
}
