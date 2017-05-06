package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class ElencoGare 
{
	private Vector<Gara> elenco= new Vector<>();
	
//	public boolean contains (Gara g)
//	{
//	boolean flag= false;
//	for (Gara u: elenco)
//	{
//		if (u.getNome().equalsIgnoreCase(g.getNome()))
//			flag=true;
//	}
//	return flag;
//	}
	
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
	
	
	public String printGareWOResult()
	{
		StringBuffer str = new StringBuffer ("Elenco gare senza risultato:\n");
		for (Gara g: elenco)
		{
			if (g.getRisultato().size()==0)
				str.append(g.getNome() + "\n");
		}
		return str.toString();
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


	public Vector<Gara> getElenco() {
		return elenco;
	}
}
