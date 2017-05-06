package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class ElencoNazioni 
{
	private Vector<Nazione> elenco= new Vector <>(); 
	
	/**
	 * aggiunge una nazione se non è già presente in elenco
	 * @param nazione
	 * @return true se è stata aggiunta, false altrimenti
	 */
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
	
	/**
	 * metodo che ordina il medagliere con il seguente principio
	 * prima gli ori
	 * se due nazioni hanno stesso numero di ori, viene messa prima chi ha più argenti
	 * se due nazioni hanno stesso numero di ori e di argenti, viene messa prima chi ha più bronzi
	 */
	public void ordinaMedagliere()
	{
		for (int i=0; i<elenco.size()-1;i++)
		{
			for (int j=elenco.size()-1; j>i; j--)
			{
				if (!(elenco.get(j-1).getnTotOri() > elenco.get(j).getnTotOri())  ||  ((elenco.get(j-1).getnTotOri() == elenco.get(j).getnTotOri()) && (elenco.get(j-1).getnTotArgenti() > elenco.get(j).getnTotArgenti()))  ||  ((elenco.get(j-1).getnTotOri() == elenco.get(j).getnTotOri()) && (elenco.get(j-1).getnTotArgenti() == elenco.get(j).getnTotArgenti()) && (elenco.get(j-1).getnTotBronzi() > elenco.get(j).getnTotBronzi())))
				{
					Nazione n= new Nazione ();
					n=elenco.get(j-1);
					elenco.set(j-1, elenco.get(j));
					elenco.set(j, n);	
					
				}
				
			}
		}
	}
	
	/**
	 * stampa tutto il medagliere appoggiandosi al vector elenco
	 * @return stringa contenente tutte le nazioni e le rispettive medaglie vinte
	 */
	public String printMedagliere()
	{
		
		StringBuffer str = new StringBuffer ("Elenco nazioni:\n");
		for (Nazione g: elenco)
		{
			str.append(g+ "\n");
		}
		
		return str.toString();
		
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
