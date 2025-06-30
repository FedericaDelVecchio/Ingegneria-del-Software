package entity;

import java.util.ArrayList;
import database.DBGenitore;

public class EntityGenitore extends EntityUtente {
	private ArrayList<EntityAlunno> figli;

	public EntityGenitore() {
	}
	
	public EntityGenitore(String username) {
		DBGenitore genitore = new DBGenitore(username);
		this.username = username;
		this.password = genitore.getPassword();
		this.nome = genitore.getNome();
		this.cognome = genitore.getCognome();
		this.nascita = genitore.getNascita();
		this.email = genitore.getEmail();
		this.cellulare = genitore.getCellulare();
		this.codiceFiscale = genitore.getCodiceFiscale();
	}
	
	public EntityGenitore(DBGenitore genitore) {
		this.username = genitore.getUsername();
		this.password = genitore.getPassword();
		this.nome = genitore.getNome();
		this.cognome = genitore.getCognome();
		this.nascita = genitore.getNascita();
		this.email = genitore.getEmail();
		this.cellulare = genitore.getCellulare();
		this.codiceFiscale = genitore.getCodiceFiscale();
	}

	public void caricaFigli() {
		DBGenitore genitore = new DBGenitore(username);
		this.figli = new ArrayList<EntityAlunno>();
		genitore.caricaFigliDaDB();
		for(int i=0;i<genitore.getFigli().size();i++) {
			EntityAlunno alunno = new EntityAlunno(genitore.getFigli().get(i));
			this.figli.add(alunno);
		}
	}
	
	public int registraGenitore(String username,String password,String nome,String cognome,String residenza,String nascita,String codiceFiscale,Integer cellulare,String email) {
		int ret = 0;
		DBGenitore genitoreDB = new DBGenitore();
		ret = genitoreDB.salvaInDB(username,password,nome,cognome,residenza,nascita,codiceFiscale,cellulare,email);
		if(ret!=-1) {
			setUsername(username);
			setPassword(password);
			setNome(nome);
			setCognome(cognome);
			setNascita(nascita);
			setResidenza(residenza);
			setEmail(email);
			setCellulare(cellulare);
			setCodiceFiscale(codiceFiscale);
		}
		return ret;
	}
	
	public ArrayList<EntityAlunno> getFigli() {
		return figli;
	}

	public void setFigli(ArrayList<EntityAlunno> figli) {
		this.figli = figli;
	}

	@Override
	public String toString() {
		return "EntityGenitore [figli=" + figli + ", nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita
				+ ", codiceFiscale=" + codiceFiscale + ", residenza=" + residenza + ", email=" + email + ", cellulare="
				+ cellulare + ", username=" + username + ", password=" + password + "]";
	}

	
	
}
