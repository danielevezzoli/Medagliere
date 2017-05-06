package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class ElencoGare 
{
	private Vector<Gara> elenco= new Vector<>();
	
	/**
	 * aggiunge una gara ad elenco se non è già presente
	 * @param gara
	 * @return true se è stata inserita, false altrimenti
	 */
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
	
	/**
	 * crea una stringa contenente tutte le gare prive di risultato 
	 * @return stringa di gare
	 */
	public String printGareWOResult()
	{
		StringBuffer str = new StringBuffer ("Elenco gare senza risultato:\n");
		for (Gara g: elenco)
		{
			if (g.getNazPremiate().size()==0)
				str.append(g.getNome() + "\n");
		}
		return str.toString();
	}
	
	/**
	 * crea un vector contenente tutte le gare prive di risultato
	 * @return vector di gare
	 */
	public Vector<Gara> getGareWOResult()
	{
		Vector<Gara> str= new Vector <>();
		for (Gara g: elenco)
		{
			if (g.getNazPremiate().size()==0)
				str.add(g);
		}
		return str;
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
