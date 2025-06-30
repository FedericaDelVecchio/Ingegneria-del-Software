package entity;

import java.util.ArrayList;
import database.DBDocente;

public class EntityDocente extends EntityUtente {
	ArrayList<EntityInsegna> insegna;

	public EntityDocente() {
	}
	
	public EntityDocente(String username) {
		DBDocente docente = new DBDocente(username);
		this.username = username;
		this.password = docente.getPassword();
		this.nome = docente.getNome();
		this.cognome = docente.getCognome();
		this.nascita = docente.getNascita();
		this.email = docente.getEmail();
		this.cellulare = docente.getCellulare();
		this.codiceFiscale = docente.getCodiceFiscale();
	}
	
	public EntityDocente(DBDocente docente) {
		this.username = docente.getUsername();
		this.password = docente.getPassword();
		this.nome = docente.getNome();
		this.cognome = docente.getCognome();
		this.nascita = docente.getNascita();
		this.email = docente.getEmail();
		this.cellulare = docente.getCellulare();
		this.codiceFiscale = docente.getCodiceFiscale();
	}

	public void caricaInsegna() {
		DBDocente docente = new DBDocente(username);
		this.insegna = new ArrayList<EntityInsegna>();
		docente.caricaInsegnaDaDB();
		for(int i=0;i<docente.getInsegna().size();i++) {
			EntityInsegna ins = new EntityInsegna(docente.getInsegna().get(i));
			this.insegna.add(ins);
		}
	}
	
	public int registraDocente(String username,String password,String nome,String cognome,String residenza,String nascita,String codiceFiscale,Integer cellulare,String email) {
		int ret = 0;
		DBDocente docenteDB = new DBDocente();
		ret = docenteDB.salvaInDB(username,password,nome,cognome,residenza,nascita,codiceFiscale,cellulare,email);
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

	public ArrayList<EntityInsegna> getInsegna() {
		return insegna;
	}

	public void setInsegna(ArrayList<EntityInsegna> insegna) {
		this.insegna = insegna;
	}

	@Override
	public String toString() {
		return "EntityDocente [insegna=" + insegna + ", nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita
				+ ", codiceFiscale=" + codiceFiscale + ", residenza=" + residenza + ", email=" + email + ", cellulare="
				+ cellulare + ", username=" + username + ", password=" + password + "]";
	}

	
	
}
