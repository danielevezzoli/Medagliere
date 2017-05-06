package it.unibs.ing.fp.medagliere;

public class Nazione 
{
	private String nome;
	private int nTotOri=0;
	private int nTotArgenti=0;
	private int nTotBronzi=0;
	
	//costruttore vuoto
	public Nazione ()
	{	
	}
	
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
//		return String.format("%s : Numero ori: %d%n Numero argenti: %d%n Numero bronzi: %d%n", nome,nTotOri,nTotArgenti,nTotBronzi);
		return String.format("%s :  %d  %d  %d", nome,nTotOri,nTotArgenti,nTotBronzi);

	}
	
	public int getnTotOri() {
		return nTotOri;
	}
	public int getnTotArgenti() {
		return nTotArgenti;
	}
	public int getnTotBronzi() {
		return nTotBronzi;
	}
	public String getNome()
	{
		return nome;
	}
	
	//override del metodo equals
	@Override
	public boolean equals(Object obj) 
	{
		if ((obj instanceof Nazione))
		{
			Nazione n=(Nazione)obj;
			if (nome.equalsIgnoreCase(n.getNome()))
				return true;
			else
				return false;
		}
		else
			return false;	
	}
	
	
	
}
