package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class Gara 
{
	private String nome;
	private boolean squadra;
	private boolean premiata;
	private Vector<Nazione>risultato=new Vector <>();
	Nazione [] out= new Nazione [3];
	
	//costruttore con il paremetro _squadra (boolean)
	public Gara (String _nome, boolean _squadra)
	{
		nome=_nome;
		squadra=_squadra;
		premiata=false;
	}
	
	//costruttore senza il parametro _squadra, che quindi viene settato a false
	public Gara (String _nome)
	{
		nome=_nome;
		squadra=false;
		premiata=false;
	}
	
	/**
	 * Aggiunge le 3 nazioni vincitrici alla variabile risultato
	 * @param vector di nazioni che corrispondono alle 3 nazioni che hanno vinto la gara
	 */
	public void addRisultato (Vector<Nazione>_risultato)
	{
		risultato.addAll(_risultato);
		setEseguita();
	}
	
	public boolean giaPremiata() {
		return premiata;
	}

	public void setEseguita() {
		premiata=true;;
	}

	public Vector<Nazione> getNazPremiate() {
		return risultato;
	}
	
	public boolean getSquadra()
	{
		return squadra;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setSquadra(boolean squadra) {
		this.squadra = squadra;
	}

	@Override
	public String toString() {
		return String.format("%s%n Medaglia oro: %s%n Medaglia argento: %s%n Medaglia bronzo:%s",nome,risultato.get(0).getNome(),risultato.get(1).getNome(),risultato.get(2).getNome());
	}
	
	//override del metodo equals
	@Override
	public boolean equals(Object obj) 
	{
		if ((obj instanceof Gara))
		{
			Gara n=(Gara)obj;
			if (nome.equalsIgnoreCase(n.getNome()))
				return true;
			else
				return false;
		}
		else
			return false;	
	}
	
	//metodo per TEST
	public void aggiungiPremiata (Nazione naz, int i)
	{
		out[i]=naz;
	}
	
	public Nazione [] getPremiate ()
	{
		return out;
		
	}
	
	
}
