package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class ElencoNazioni 
{
	private Vector<Nazione> elenco= new Vector <>(); 
	
	public boolean addNazione (Nazione _nazione)
	{
		boolean flag;
		if (!elenco.contains(_nazione))
		{
			flag=true;
			elenco.add(_nazione);
			
		}
		else
		{
			flag=false;
		}
		
		return flag;
	}
	
	public Vector<Nazione> getNazioni()
	{
		return elenco;
	}
	
	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer ("Elenco nazioni:\n");
		for (Nazione g: elenco)
		{
			str.append(g.getNome() + "\n");
		}
		
		return str.toString();
	}
}
