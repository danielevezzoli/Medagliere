package it.unibs.ing.fp.medagliere;

import java.util.Vector;

public class Gara 
{
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
	
	@Override
	public String toString() {
		return String.format("%s%n Medaglia oro: %s%n Medaglia argento: %s%n Medaglia bronzo:%s",nome,risultato.get(0).getNome(),risultato.get(1).getNome(),risultato.get(2).getNome());
	}
}
