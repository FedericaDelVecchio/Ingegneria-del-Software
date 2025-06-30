package control;
import entity.*;
import java.util.ArrayList;

public class GestioneIstitutoScolastico {
	/**Il metodo stampaClassiEAlunni permette di visualizzare l'anno e la sezione di tutte le classi dell'istituto scolastico
	 * e il nome, il cognome e l'username degli alunni che ne fanno parte.
	 * La funzione puo' essere eseguita solo dal preside.
	 * @param username del preside
	 * @return String che contiene le informazioni specificate
	 */
	public String stampaClassiEAlunni(String username) {
		String str="";
		EntityPreside preside = new EntityPreside(username);
		preside.caricaClassi();
		for(int i=0;i<preside.getClassi().size();i++) {
			String anno = preside.getClassi().get(i).getAnno();
			String sezione = preside.getClassi().get(i).getSezione();
			str+="CLASSE: anno="+anno+", sezione="+sezione+"\n";
			str+=stampaAlunni(anno,sezione)+"\n";
		}
		return str;
	}
	
	/**Il metodo stampaClassiEMaterie permette di visualizzare l'anno e la sezione delle classi in cui insegna
	 * il docente e delle rispettive materie insegnate. La funzione e' accessibile solo ai docenti.
	 * @param username del docente
	 * @return String che contiene le informazioni desiderate
	 */
	public String stampaClassiEMaterie(String username) {
			EntityDocente docente = new EntityDocente(username);
			docente.caricaInsegna();
			String str="";
			for(int i=0;i<docente.getInsegna().size();i++) {
				String anno = docente.getInsegna().get(i).getClasse().getAnno();
				String sezione = docente.getInsegna().get(i).getClasse().getSezione();
				String materia = docente.getInsegna().get(i).getMateria();
				str += "CLASSE: anno="+anno+", sezione="+sezione+", materia="+materia+"\n";
			}
			if(str.equals("")) str="Il docente non insegna in nessuna classe!\n";
			return str;
	}
	
	/**Il metodo stampaAlunni permette di visualizzare il nome, il cognome e l'username degli alunni facenti parte di una classe (anno,sezione).
	 * La funzione e' accessibile solo ai docenti o al preside durante l'esecuzione di stampaClassiEAlunni.
	 * @param anno della classe
	 * @param sezione della casse
	 * @return String che contiene le informazioni specificate
	 */
	public String stampaAlunni(String anno,String sezione) {
			EntityClasse c = new EntityClasse(anno,sezione);
			c.caricaAlunni();
			c.caricaRegistroElettronico();
			String ris="";
			ris+="annoScolastico="+c.getRegistroElettronico().getAnnoScolastico()+"\n";
			for(int i=0;i<c.getAlunni().size();i++) {
				ris += "ALUNNO: nome e cognome="+c.getAlunni().get(i).getNomeCognome()+", username="+c.getAlunni().get(i).getUsername()+"\n";
			}
			if(c.getAlunni().size()==0) ris="La classe non ha alunni!\n";
			return ris;
	}
	
	/**Il metodo stampaFigli permette di visualizzare il nome, il cognome e l'username degli alunni, figli di un genitore.
	 * La funzione puo' essere chiamata da un genitore.
	 * @param username del genitore
	 * @return String che contiene le informazioni richieste
	 */
	public String stampaFigli(String username) { // genitore
		EntityGenitore genitore = new EntityGenitore(username);
		genitore.caricaFigli();
		String r="";
		for(int i=0;i<genitore.getFigli().size();i++) {
			r += "nome e cognome="+genitore.getFigli().get(i).getNomeCognome()+", username="+genitore.getFigli().get(i).getUsername()+"\n";
		}
		if(r.equals("")) r="Non ci sono figli registrati. ERRORE!\n";
		return r;
	}
	
	/**Il metodo inserimentoVoto permette di inserire il voto (valore, media, data) di un alunno nel registro elettronico ed e' chiamato da un docente. 
	 * Se il voto interito e' insufficiente, la funzione simula l'invio di una email ai genitori dell'alunno per notificarli.
	 * @param valore del voto
	 * @param materia del voto
	 * @param data del voto
	 * @param username dell'alunno
	 * @return String che contiene un messaggio di errore o conferma
	 */
	public String inserimentoVoto(int valore,String materia,String data,String username) {
		String str="";
		boolean containsOnlyLettersMateria = materia.matches("[a-zA-Z]+");
		if(!containsOnlyLettersMateria) {
			str="La meteria contiene numeri o simboli. ERRORE!\n";
			return str;
		}
		if(materia.length()>30) {
			str="La meteria e' troppo lunga. ERRORE!\n";
			return str;
		};
		boolean isDateData = data.matches("\\d{2}/\\d{2}/\\d{4}");
		if(!isDateData) {
			str="Il formato della data non e' valido. ERRORE!\n";
			return str;
		}
		if(username.length()>30) {
			str="L'username e' troppo lungo. ERRORE!\n";
			return str;
		};
		
		EntityVoto voto = new EntityVoto();
		EntityAlunno alunno = new EntityAlunno(username);
		int ris = voto.inserisciVoto(valore,materia,data,alunno.getClasse().getAnno(),alunno.getClasse().getSezione(),username);
		if(ris==-1) str="C'e' stato un ERRORE nell'inserimento!\n";
		else {
			str="Il voto e' stato inserito correttamente!\n";
			if(valore<6) {
				alunno.caricaGenitori();
				ArrayList<String> emailGenitori = new ArrayList<String>();
				for(int i=0;i<alunno.getGenitori().size();i++) {
					emailGenitori.add(alunno.getGenitori().get(i).getEmail());
				}
				str+="Insufficienza!\n";
				for(int i=0;i<alunno.getGenitori().size();i++) {
					str+="E' stata inviata una email al genitore "+alunno.getGenitori().get(i).getNomeCognome()+" ("+emailGenitori.get(i)+") per notificarlo.\n";
				}
			}
		}
		return str;
	}
	
	/**Il metodo inserimentoAttivita permette di inserire un'attivita' (materia, descrizione, data) svolta in una classe nel registro elettronico ed e' chiamato da un docente. 
	 * @param materia dell'attivita'
	 * @param descrizione dell'attivita'
	 * @param data dell'attivita'
	 * @param anno della classe
	 * @param sezione della classe
	 * @return String che contiene un messaggio di errore o conferma
	 */
	public String inserimentoAttivita(String materia,String descrizione,String data,String anno,String sezione) { 
		EntityAttivita attivita = new EntityAttivita();
		String r="";
		boolean containsOnlyLettersMateria = materia.matches("[a-zA-Z]+");
		if(!containsOnlyLettersMateria) {
			r="La meteria contiene numeri o simboli. ERRORE!\n";
			return r;
		}
		if(materia.length()>30) {
			r="La meteria e' troppo lunga. ERRORE!\n";
			return r;
		};
		boolean isDateData = data.matches("\\d{2}/\\d{2}/\\d{4}");
		if(!isDateData) {
			r="Il formato della data non e' valido. ERRORE!\n";
			return r;
		}
		if(!anno.equals("I") && !anno.equals("II") && !anno.equals("III") && !anno.equals("IV") && !anno.equals("V")) {
			r="L'anno della classe non e' valido. ERRORE!\n";
			return r;
		}
		if(sezione.length()!=1) {
			r="La sezione della classe non e' valida. ERRORE!\n";
			return r;
        }
		else {
			char carattere=sezione.charAt(0);
			if(Character.isLowerCase(carattere)) {
				r="La sezione della classe non e' valida. ERRORE!\n";
				return r;
			}
		}
		
		int ris = attivita.inserisciAttivita(materia,descrizione,data,anno,sezione);
		if(ris!=-1) r="L'attivita' e' stata inserita correttamente!\n";
		else r="C'e' stato un ERRORE nell'inserimento!\n";
		return r;
	}
	
	/**Il metodo letturaAttivita permette di visualizzare le attivita' (descrizione,materia) svolte  in una certa data nella classe di un alunno.
	 * La funzione e' richiamata da un alunno.
	 * @param username dell'alunno
	 * @param data delle attivita'
	 * @return String che contiene le informazioni desiderate
	 */
	public String letturaAttivita(String username,String data) {
		EntityAlunno alunno = new EntityAlunno(username);
		String anno = alunno.getClasse().getAnno();
		String sezione = alunno.getClasse().getSezione();
		EntityRegistroElettronico registro = new EntityRegistroElettronico(anno,sezione);
		registro.caricaAttivita();
		int k=0;
		String ritorno="";
		for(int i=0;i<registro.getAttivita().size();i++) {
			if(data.equals(registro.getAttivita().get(i).getData())) {
				k++;
				ritorno += "descrizione="+registro.getAttivita().get(i).getDescrizione()+", materia="+registro.getAttivita().get(i).getMateria()+"\n";
				
			}
		}
		if(k==0) ritorno = "Non sono state svolte attivita' nel giorno "+data+".\n";
		return ritorno;
	}
	
	/**Il metodo letturaCarriera permette di visualizzare i voti (valore,materia,data) e le medie (valore,materia) di un alunno, figlio di un genitore.
	 * La funzione e' eseguita da un genitore.
	 * @param username dell'alunno
	 * @return String che contiene le informazioni specificate
	 */
	public String letturaCarriera(String username) { // genitore
		String ris="";
		EntityAlunno alunno = new EntityAlunno(username);
		String anno = alunno.getClasse().getAnno();
		String sezione = alunno.getClasse().getSezione();
		EntityRegistroElettronico registro = new EntityRegistroElettronico(anno,sezione);
		registro.caricaVoti();
		ArrayList<EntityVoto> voti = new ArrayList<EntityVoto>();
		for(int i=0;i<registro.getVoti().size();i++) {
			String user = registro.getVoti().get(i).getAlunno().getUsername();
			if(user.equals(username)) {
				EntityVoto v=new EntityVoto(registro.getVoti().get(i).getId());
				voti.add(v);
			}
		}
		
		for(int i=0;i<voti.size();i++) {
			ris += ("VOTO: materia="+voti.get(i).getMateria()+", valore="+voti.get(i).getValore()+", data="+voti.get(i).getData()+"\n");
		}
		
		ArrayList<String> materie = new ArrayList<String>();
		for(int i=0;i<voti.size();i++) {
			String m = voti.get(i).getMateria();
			if(!materie.contains(m)) materie.add(m);
		}
		
		for(int i=0;i<materie.size();i++) {
			String m1 = materie.get(i);
			ArrayList<Integer> valori = new ArrayList<Integer>();
			for(int j=0;j<voti.size();j++) {
				String m2 = voti.get(j).getMateria();
				if(m1.equals(m2)) {
					valori.add(voti.get(j).getValore());
				}
			}
			double v = calcolaMedia(valori);
			ris += ("MEDIA: materia="+m1+", valore="+v+"\n");
		}
		return ris;
	}
	
	/**Il metodo calcolaMedia calcola la media di un insieme di interi. La funzione e' chiamata 
	 * durante l'esecuzione dei metodi letturaCarriera e genezarionePagelle.
	 * @param valori di interi
	 * @return double che e' la media
	 */
	private double calcolaMedia(ArrayList<Integer> valori) {
		int somma=0;
		for (int valore : valori) {
            somma += valore;
        }
        return (double)somma/valori.size();
	}
	
	/**Il metodo generazionePagelle genera per ogni alunno dell'istituto scolastico una pagella contenente le medie dei voti assegnati.
	 * La funzione e' chiamata allo scadere di un quadrimestre.
	 */
	public void generazionePagelle() {
		EntityPreside preside = new EntityPreside("preside1");
		preside.caricaClassi();
		for(int i=0;i<preside.getClassi().size();i++) {
			preside.getClassi().get(i).caricaAlunni();
		}
		
		int id=1;
		for(int i=0;i<preside.getClassi().size();i++) {
			for(int j=0;j<preside.getClassi().get(i).getAlunni().size();j++) {
				String username = preside.getClassi().get(i).getAlunni().get(j).getUsername();
				EntityPagella p = new EntityPagella();
				p.inserisciPagella(username);
				
				EntityAlunno alunno = new EntityAlunno(username);
				String anno = alunno.getClasse().getAnno();
				String sezione = alunno.getClasse().getSezione();
				EntityRegistroElettronico registro = new EntityRegistroElettronico(anno,sezione);
				registro.caricaVoti();
				ArrayList<EntityVoto> voti = new ArrayList<EntityVoto>();
				for(int t=0;t<registro.getVoti().size();t++) {
					String user = registro.getVoti().get(t).getAlunno().getUsername();
					if(user.equals(username)) {
						EntityVoto v=new EntityVoto(registro.getVoti().get(t).getId());
						voti.add(v);
					}
				}
				
				ArrayList<String> materie = new ArrayList<String>();
				for(int f=0;f<voti.size();f++) {
					String m = voti.get(f).getMateria();
					if(!materie.contains(m)) materie.add(m);
				}
				
				for(int l=0;l<materie.size();l++) {
					String m1 = materie.get(l);
					ArrayList<Integer> valori = new ArrayList<Integer>();
					for(int q=0;q<voti.size();q++) {
						String m2 = voti.get(q).getMateria();
						if(m1.equals(m2)) {
								valori.add(voti.get(q).getValore());
						}
					}
					double v = calcolaMedia(valori);
					EntityMedia media = new EntityMedia();
					media.inserisciMedia(id,v,m1,username);
					id++;
				}
			}
		}
	}
	
	/**Il metodo inserimentoUntente permette di registrare un nuovo utente nel sistema ed e' svolto dalla segreteria.
	 * Bisogna specificare l'username, la password, il nome, il cognome, la residenza, la data di nascita, il codice fiscale, il cellulare, l'email e il tipo di utente.
	 * L'utente puo' essere un alunno, un docente o un genitore.
	 * @param username dell'utente
	 * @param password dell'utente
	 * @param nome dell'utente
	 * @param cognome dell'utente
	 * @param residenza dell'utente
	 * @param nascita dell'utente
	 * @param codiceFiscale dell'utente
	 * @param cellulare dell'utente
	 * @param email dell'utente
	 * @param tipoUtente
	 * @return String che contiene un messaggio di errore o conferma
	 */
	public String inserimentoUtente(String username,String password,String nome,String cognome,String residenza,String nascita,String codiceFiscale,Integer cellulare,String email,String tipoUtente) {
		String ret="";
		if(username.length()>30) {
			ret="L'username e' troppo lungo. ERRORE!\n";
			return ret;
		};
		if(password.length()>30) {
			ret="La password e' troppo lunga. ERRORE!\n";
			return ret;
		};
		boolean containsOnlyLettersNome = nome.matches("[a-zA-Z]+");
		if(!containsOnlyLettersNome) {
			ret="Il nome contiene numeri o simboli. ERRORE!\n";
			return ret;
		}
		if(nome.length()>30) {
			ret="Il nome e' troppo lungo. ERRORE!\n";
			return ret;
		};
		boolean containsOnlyLettersCognome = cognome.matches("[a-zA-Z]+");
		if(!containsOnlyLettersCognome) {
			ret="Il cognome contiene numeri o simboli. ERRORE!\n";
			return ret;
		}
		if(cognome.length()>30) {
			ret="Il cognome e' troppo lungo. ERRORE!\n";
			return ret;
		};
		boolean containsOnlyLettersResidenza = residenza.matches("[a-zA-Z]+");
		if(!containsOnlyLettersResidenza) {
			ret="La residenza contiene numeri o simboli. ERRORE!\n";
			return ret;
		}
		if(residenza.length()>30) {
			ret="La residenza e' troppo lunga. ERRORE!\n";
			return ret;
		};
		if(codiceFiscale.length()!=16) {
			ret="Il codice fiscale non e' composto da 16 caratteri. ERRORE!\n";
			return ret;
		};
		if(!email.contains("@")) {
			ret="L'email non contiene la chiocciola. ERRORE!\n";
			return ret;
		}
		boolean isDateNascita = nascita.matches("\\d{2}/\\d{2}/\\d{4}");
		if(!isDateNascita) {
			ret="Il formato della data di nascita non e' valido. ERRORE!\n";
			return ret;
		}
		if(!tipoUtente.equals("docente") && !tipoUtente.equals("alunno") &&!tipoUtente.equals("genitore")) {
			ret="Il tipo dell'utente non e' valido. ERRORE!\n";
			return ret;
		}
		if(cellulare<1000000000) {
			ret="Il cellulare e' troppo corto. ERRORE!\n";
			return ret;
		}
		
		int r=0;
 		if(tipoUtente.equals("docente")) {
			EntityDocente docente = new EntityDocente();
			r=docente.registraDocente(username,password,nome,cognome,residenza,nascita,codiceFiscale,cellulare,email);
		}
		else if(tipoUtente.equals("alunno")) {
			EntityAlunno alunno = new EntityAlunno();
			r=alunno.registraAlunno(username, password, nome, cognome, residenza, nascita, codiceFiscale, cellulare, email);
		}
		else if(tipoUtente.equals("genitore")) {
			EntityGenitore genitore = new EntityGenitore();
			r=genitore.registraGenitore(username, password, nome, cognome, residenza, nascita, codiceFiscale, cellulare, email);
		}
 		if(r!=-1) ret="L'utente e' stato inserito correttamente\n";
 		else ret="L'utente non e' stato inserito! ERRORE\n";
		return ret;
	}
	
	/**Il metodo modificaPagella permette al docente di modificare il valore di una media (materia) della una pagella di un alunno.
	 * La modifica puo' consistere in un arrotondamento per eccesso (0) o per difetto (1). La funzione e' eseguibile solo da un docente.
	 * @param username dell'alunno
	 * @param materia della media
	 * @param arrotondamento per eccesso o difetto
	 * @return String che contiene un messaggio di errore o conferma
	 */
	public String modificaPagella(String username,String materia,int arrotondamento) {
		String str="";
		EntityPagella pagella = new EntityPagella();
		int ris = pagella.sonoStateGenerate();
		if(ris==-1) {
			str="Le pagelle non sono ancora state create!\n";
		}
		else {
			EntityPagella p = new EntityPagella(username);
			EntityMedia media = new EntityMedia();
			int ret=0;
			for(int i=0;i<p.getMedie().size();i++) {
				if(materia.equals(p.getMedie().get(i).getMateria())) {
					ret=1;
					media = p.getMedie().get(i);
				}
			}
			if(ret==0) {
				str="La pagella non contiene medie!\n";
			}
			else {
				if(p.isApprovata()==1) {
					str="La pagella e' gia' stata approvata, non si puo' piu' modificare!\n";
				}
				else {				
					double valoreIniziale = media.getValore();
					double valoreFinale=0;
					if(arrotondamento==0) {
						valoreFinale = Math.ceil(valoreIniziale);
					}
					else if(arrotondamento==1) {
						valoreFinale = Math.floor(valoreIniziale);
					}
					str="valore iniziale= "+valoreIniziale+", valore finale="+valoreFinale+"\n";
					int i=media.aggiornaMedia(valoreFinale);
					if(i==-1) str="C'e' stato un ERRORE!\n";
					else str="La pagella e' stata correttamente modificata.\nvalore iniziale= "+valoreIniziale+", valore finale="+valoreFinale+"\n";
				}
			}
		}
		return str;
	}
	
	/**Il metodo approvazionePagella permettedi approvare la pagella di un alunno. 
	 * Se tutte le pagelle degli altri alunni della classe risultano approvate, il metodo simula l'invio di una email ai genitori per notificarli.
	 * La funzione puo' essere chiamata solo dal preside.
	 * @param username dell'alunno
	 * @return String che contiene un messaggio di errore o conferma
	 */
	public String approvazionePagella(String username) {
		String str="";
		EntityPagella pagella = new EntityPagella();
		int ris = pagella.sonoStateGenerate();
		if(ris==-1) {
			str="Le pagelle non sono ancora state create!\n";
		}
		else {
			EntityPagella p = new EntityPagella(username);
			if(p.isApprovata()==1) {
				str="La pagella e' gia' stata approvata!\n";
			}
			else {
				int w=p.approvaPagella();
				if(w==-1) str="C'e' stato un ERRORE nell'approvazione!\n";
				else str="La pagella e' stata approvata correttamente.\n";
				EntityAlunno alunno = new EntityAlunno(username);
				EntityClasse classe = new EntityClasse(alunno.getClasse().getAnno(),alunno.getClasse().getSezione());
				classe.caricaAlunni();
				int r=0;
				for(int i=0;i<classe.getAlunni().size();i++) {
					EntityPagella pa = new EntityPagella(classe.getAlunni().get(i).getUsername());
					if(pa.isApprovata()==0) r=1;
				}
				if(r!=1) {
					str+="Tutte le pagelle della classe di cui fa parte l'alunno risultano ora approvate!\n";
					for(int i=0;i<classe.getAlunni().size();i++) {
						EntityAlunno a = classe.getAlunni().get(i);
						a.caricaGenitori();
						ArrayList<String> emailGenitori = new ArrayList<String>();
						for(int g=0;g<a.getGenitori().size();g++) {
							emailGenitori.add(a.getGenitori().get(g).getEmail());
						}
						for(int u=0;u<a.getGenitori().size();u++) {
							str+="E' stata inviata una email al genitore "+a.getGenitori().get(u).getNomeCognome()+" ("+emailGenitori.get(u)+") per notificarlo.\n";
						}
					}
				}
				
			}
		}
		return str;
	}
	
}