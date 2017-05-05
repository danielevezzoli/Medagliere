package it.unibs.ing.fp.medagliere;

import it.unibs.fp.mylib.InputDati;

public class MedagliereMain {

	public static void main(String[] args) {
		ElencoNazioni medagliere = new ElencoNazioni();
		ElencoGare gare = new ElencoGare();

		Nazione nazione = new Nazione(InputDati.leggiStringaNonVuota("inserisci nazione"));
		medagliere.addNazione(nazione);
		Nazione nazione2 = new Nazione(InputDati.leggiStringaNonVuota("inserisci nazione"));
		medagliere.addNazione(nazione2);
		System.out.println(medagliere);

	}

}
