package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class Gara 
{
	public Vector<Nazione> getRisultato() {
		return risultato;
	}

	private String nome;
	private boolean squadra;
	private Vector<Nazione>risultato=new Vector <>();
	
	public Gara (String _nome, boolean _squadra)
	{
		nome=_nome;
		squadra=_squadra;
	}
	
	public Gara (String _nome)
	{
		nome=_nome;
		squadra=false;
	}
	
	public void addRisultato (Vector<Nazione>_risultato)
	{
		risultato.addAll(_risultato);
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
}
