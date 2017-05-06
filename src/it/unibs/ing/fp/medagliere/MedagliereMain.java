package it.unibs.ing.fp.medagliere;

import java.util.Vector;

import mylib.InputDati;
import mylib.MyMenu;
public class MedagliereMain 
{
	//opzioni del menù iniziale del programma
	public static final String[] VOCI_MENU_INIZIALE = {"Inserire nuova nazione", "Inserire nuova gara", "Inserire risultato gara", "Visualizzare medagliere"};
	public static final String TITOLO_MENU_MEDAGLIERE = "Medagliere";
	public static final String END = "Fine";
	public static final String INSERISCI_NAZIONE = "Inserisci il nome della nazione:";
	public static final String INSERISCI_GARA = "Inserisci il nome della gara:";
	public static final String SCEGLI_GARA = "Scegli una gara alla quale inserire un risultato";
	public static final String MSG_AGGIUNTA_SUCCESSO = "Aggiunta con successo!";
	public static final String ERR_NAZIONE_PRESENTE = "Nazione già presente!";
	public static final String ERR_NAZIONE_NON_ESISTE = "Nazione non esistente, inserirne un'altra:";
	public static final String ERR_NAZIONE_PRESENTE2_VOLTE = "Nazione inserita 2 volte";
	public static final String ERR_GARA_NON_PRESENTE = "Gara non presente!";
	public static final String ERR_MENO3_NAZIONI = "non ci sono abbastanza nazioni inserite per stabilire i 3 vincitori, prima inseriscini altre";
	public static final String ERR_ELENCO_VUOTO = "L'elenco delle nazioni è vuoto! Non si possono inserire vincitori";
	public static final String INSERISCI_ORO = "Inserisci il nome della nazione che ha vinto l'oro:";
	public static final String INSERISCI_ARGENTO = "Inserisci il nome della nazione che ha vinto l'argento:";
	public static final String INSERISCI_BRONZO = "Inserisci il nome della nazione che ha vinto il bronzo:";
	
	public static void main (String[] args)
	{

		ElencoNazioni medagliere = new ElencoNazioni();
		ElencoGare gare = new ElencoGare();
		
		
		MyMenu menu= new MyMenu(TITOLO_MENU_MEDAGLIERE, VOCI_MENU_INIZIALE);
		
		boolean ciclo=true;
		
		//ciclo per il menù iniziale
		while (ciclo==true)
		{
			
			switch (menu.scegli())
			{
			case 1: //aggiungi nazione
				Nazione nazione= new Nazione (InputDati.leggiStringaNonVuota(INSERISCI_NAZIONE));	
				if(medagliere.addNazione(nazione))
					System.out.println(MSG_AGGIUNTA_SUCCESSO);
				else
					System.out.println(ERR_NAZIONE_PRESENTE);
					
				break;
				
				
			case 2: //aggiungi gara
				Gara gara= new Gara (InputDati.leggiStringaNonVuota(INSERISCI_GARA));	
				if(!gare.getElenco().contains(gara))
				{
					 char squadra= InputDati.leggiUpperChar("E' una gara a squadre? [S/N]","SN");
					 if(squadra=='S' || squadra=='s')
					 {
						 gara.setSquadra(true);
						 gare.addGara(gara);
						 System.out.println(MSG_AGGIUNTA_SUCCESSO);
					 }
					 else
					 {
						 gare.addGara(gara);
						 System.out.println(MSG_AGGIUNTA_SUCCESSO);
					 }
				}
					
				else
					System.out.println("Gara già presente");
				
				gare.addGara(gara);
				break;
				
				
			case 3: //aggiungi risultato gara
				
				//stampa gare alle quali è possibile inserire un risultato
				System.out.println(gare.printGareWOResult());
				Vector <Nazione> risultato= new Vector <>();
				Gara g= new Gara (InputDati.leggiStringaNonVuota(SCEGLI_GARA));	
				
				//se l'elenco delle nazioni è vuoto
				if (medagliere.getNazioni().size()<=0)
					System.out.println(ERR_ELENCO_VUOTO);
				
				//se la gara selta è a squadre e ci sono meno di 3 nazioni in elenco nazioni
				else if ((gare.getElenco().get(gare.getElenco().indexOf(g)).getSquadra())  && (medagliere.getNazioni().size()<3))
					System.out.println(ERR_MENO3_NAZIONI);
				
				//se la gara inserita è contenuta nell'elenco delle gare ancora senza vincitori
				else if (gare.getGareWOResult().contains(g))
				{
					System.out.println("Selezionato la gara: "+ g.getNome());
					Nazione oro= new Nazione();
					Nazione argento= new Nazione();
					Nazione bronzo= new Nazione();
					boolean repeat=true;
					do
					{
						oro= new Nazione (InputDati.leggiStringaNonVuota(INSERISCI_ORO));
						//se non è contenuta in medagliere
						if (!medagliere.getNazioni().contains(oro))
						{
						
							System.out.println(ERR_NAZIONE_NON_ESISTE);

						}
						
						else
						{
								repeat=false;
								medagliere.getNazioni().get(medagliere.getNazioni().indexOf(oro)).addOro();
						}
					}
					while (repeat);
					repeat=true;
					
					do
					{
						argento= new Nazione (InputDati.leggiStringaNonVuota(INSERISCI_ARGENTO));
						//se non è contenuta nel medagliere
						if (!medagliere.getNazioni().contains(argento))
						{
							System.out.println(ERR_NAZIONE_NON_ESISTE);

						}
						else
						{
							//se la gara è a squadre ed è stata inserita 2 volte la stessa nazione
							if ((gare.getElenco().get(gare.getElenco().indexOf(g)).getSquadra()) && (argento.equals(oro)))
								System.out.println(ERR_NAZIONE_PRESENTE2_VOLTE);
							else
							{
								repeat=false;
								medagliere.getNazioni().get(medagliere.getNazioni().indexOf(argento)).addArgento();
							}
								
							
						}
					}
					while (repeat);
					repeat=true;
					
					do
					{
						bronzo= new Nazione (InputDati.leggiStringaNonVuota(INSERISCI_BRONZO));
						//se non è presente in medagliere
						if (!medagliere.getNazioni().contains(bronzo))
						{
							System.out.println(ERR_NAZIONE_NON_ESISTE);

						}
						else
						{
							//se la gara è a squadre e sono state inserite due nazioni uguali
							if ((gare.getElenco().get(gare.getElenco().indexOf(g)).getSquadra()) && (bronzo.equals(oro) || bronzo.equals(argento) ))
								System.out.println(ERR_NAZIONE_PRESENTE2_VOLTE);
							else
							{
								repeat=false;
								medagliere.getNazioni().get(medagliere.getNazioni().indexOf(bronzo)).addBronzo();
								
							}						
						}						
					}
					while (repeat);
					
					//aggiungo i vincitori
					risultato.add(medagliere.getNazioni().get(medagliere.getNazioni().indexOf(oro)));
					risultato.add(medagliere.getNazioni().get(medagliere.getNazioni().indexOf(argento)));
					risultato.add(medagliere.getNazioni().get(medagliere.getNazioni().indexOf(bronzo)));
					gare.getElenco().get(gare.getElenco().indexOf(g)).addRisultato(risultato);
					
				}
				else
					System.out.println(ERR_GARA_NON_PRESENTE);

					

				
				
				break;
			case 4: //stamapa medagliere
				
				//lo ordina
				medagliere.ordinaMedagliere();
				//lo stampa con il metodo printMedagliere
				System.out.println(medagliere.printMedagliere());
				break;
				
			case 0:
				System.out.println(END);
				ciclo=false;
				break;
			}	
		}
		
		
	}
	
	private void aggiungi_nazione()
	{
		
	}
		
}
	

