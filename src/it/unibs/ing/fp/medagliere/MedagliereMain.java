package it.unibs.ing.fp.medagliere;

import java.util.Vector;

import mylib.InputDati;
import mylib.MyMenu;
public class MedagliereMain 
{

	public static void main (String[] args)
	{
		String [] scelte= {"Inserire nuova nazione", "Inserire nuova gara", "Inserire risultato gara", "Visualizzare medagliere"};

		ElencoNazioni medagliere = new ElencoNazioni();
		ElencoGare gare = new ElencoGare();
		
		
		MyMenu menu= new MyMenu("Medagliere", scelte);
		
		boolean ciclo=true;
		
		while (ciclo==true)
		{
			switch (menu.scegli())
			{
			case 1:
				Nazione nazione= new Nazione (InputDati.leggiStringaNonVuota("inserisci il nome della nazione:"));	
				if(medagliere.addNazione(nazione))
					System.out.println("Aggiunta ");
				else
					System.out.println("Nazione già presente");
					
				break;
			case 2:
				Gara gara= new Gara (InputDati.leggiStringaNonVuota("inserisci il nome della gara:"));	
//				if(gare.contains(gara))
//				{
//					 char squadra= InputDati.leggiUpperChar("E' una gara a squadre? [S/N]","SN");
//					 String str=squadra;
//					 if(squadra=="S")
//					 {
//						 gara.setSquadra(true);
//						 gare.addGara(gara);
//						 System.out.println("Aggiunta");
//					 }
//					 else
//					 {
//						 gare.addGara(gara);
//						 System.out.println("Aggiunta");
//					 }
//				}
//					
//				else
//					System.out.println("Gara già presente");
				gara.setSquadra(true);
				gare.addGara(gara);
				
				break;
			case 3:
				System.out.println(gare.printGareWOResult());
				Vector <Nazione> risultato= new Vector <>();
				Gara g= new Gara (InputDati.leggiStringaNonVuota("Scegli una gara alla quale inserire un risultato:"));	
				if (gare.getElenco().contains(g))
				{
					System.out.println("Selezionato la gara: "+ g.getNome());
					Nazione oro= new Nazione();
					Nazione argento= new Nazione();
					Nazione bronzo= new Nazione();
					boolean repeat=true;
					do
					{
						oro= new Nazione (InputDati.leggiStringaNonVuota("inserisci il nome della nazione che ha vinto l'oro:"));
						if (!medagliere.getNazioni().contains(oro))
						{
						
							System.out.println("nazione non esistente, inseriscine un'altra.");

						}
						
						else
						{
							
								repeat=false;
								bronzo.addBronzo();
			
							
						}
					}
					while (repeat);
					do
					{
						argento= new Nazione (InputDati.leggiStringaNonVuota("inserisci il nome della nazione che ha vinto l'argento:"));
						if (!medagliere.getNazioni().contains(oro))
						{
							System.out.println("nazione non esistente, inseriscine un'altra.");

						}
						else
						{
							if ((gare.getElenco().get(gare.getElenco().indexOf(g)).getSquadra()) && (argento.equals(oro)))
								System.out.println("Nazione inserita 2 volte");
							else
							{
								repeat=false;
								bronzo.addBronzo();
							}
								
							
						}
					}
					while (repeat);
					do
					{
						bronzo= new Nazione (InputDati.leggiStringaNonVuota("inserisci il nome della nazione che ha vinto il bronzo:"));
						if (!medagliere.getNazioni().contains(oro))
						{
							System.out.println("nazione non esistente, inseriscine un'altra.");

						}
						else
						{
							if ((gare.getElenco().get(gare.getElenco().indexOf(g)).getSquadra()) && (bronzo.equals(oro) || bronzo.equals(argento) ))
								System.out.println("Nazione inserita 2 volte");
							else
							{
								repeat=false;
								bronzo.addBronzo();
							}
								
							
						}
							
					}
					while (repeat);
					
					risultato.add(oro);
					risultato.add(argento);
					risultato.add(bronzo);
					gare.getElenco().get(gare.getElenco().indexOf(g)).addRisultato(risultato);
					
				}
				else
					System.out.println("gara non presente nell'elenco");

					

				
				
				break;
			case 4:
				System.out.println(medagliere);
				System.out.println(gare);
				System.out.println(medagliere.getNazioni().get(0));
				break;
			case 0:
				System.out.println("USCITO ");
				ciclo=false;
				break;
			}	
		}
		
		
	}
		
}
	

