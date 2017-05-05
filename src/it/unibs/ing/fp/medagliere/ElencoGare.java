package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class ElencoGare 
{
	private Vector<Gara> elenco= new Vector<>();
	
	
	
	public boolean addGara (Gara _gara)
	{
		boolean flag;
		if (elenco.contains(_gara))
		{
			flag=false;
		}
		else
		{
			flag=true;
			elenco.add(_gara);
		}
		
		return flag;
		
	}
	
	@Override
	public String toString()
	{
		StringBuffer str = new StringBuffer ("Elenco gare:\n");
		for (Gara g: elenco)
		{
			str.append(g.getNome() + "\n");
		}
		
		return str.toString();
		
	}
}
