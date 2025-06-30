package entity;

import java.util.Random;
import java.util.ArrayList;
import database.DBAlunno;

public class EntityAlunno extends EntityUtente {
	private String matricola;
	private ArrayList<EntityGenitore> genitori;
	private EntityClasse classe;
	
	public EntityAlunno() {
	}
	
	public EntityAlunno(String username) {
		DBAlunno alunno = new DBAlunno(username);
		this.username = username;
		this.password = alunno.getPassword();
		this.nome = alunno.getNome();
		this.cognome = alunno.getCognome();
		this.nascita = alunno.getNascita();
		this.email = alunno.getEmail();
		this.cellulare = alunno.getCellulare();
		this.codiceFiscale = alunno.getCodiceFiscale();
		this.matricola = alunno.getMatricola();
		this.classe = new EntityClasse(alunno.getClasse());
	}
	
	public EntityAlunno(DBAlunno alunno) {
		this.username = alunno.getUsername();
		this.password = alunno.getPassword();
		this.nome = alunno.getNome();
		this.cognome = alunno.getCognome();
		this.nascita = alunno.getNascita();
		this.email = alunno.getEmail();
		this.cellulare = alunno.getCellulare();
		this.codiceFiscale = alunno.getCodiceFiscale();
		this.matricola = alunno.getMatricola();
		this.classe = new EntityClasse(alunno.getClasse());
	}

	public void caricaGenitori() {
		DBAlunno alunno = new DBAlunno(this.username);
		this.genitori = new ArrayList<EntityGenitore>();
		alunno.caricaGenitoriDaDB();
		for(int i=0;i<alunno.getGenitori().size();i++) {
			EntityGenitore genitore = new EntityGenitore(alunno.getGenitori().get(i));
			this.genitori.add(genitore);
		}
	}
	
	public int registraAlunno(String username,String password,String nome,String cognome,String residenza,String nascita,String codiceFiscale,Integer cellulare,String email) {
		int ret = 0;
		DBAlunno alunnoDB = new DBAlunno();
		String matricola = new String(generaMatricola(8));
		ret = alunnoDB.salvaInDB(username,password,nome,cognome,residenza,nascita,codiceFiscale,cellulare,email,matricola);
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
			setMatricola(matricola);
		}
		return ret;
	}
	
	private String generaMatricola(int x) {
		Random rand=new Random();
		String res="";
		for (int i=0;i<x;i++){
		res+=String.valueOf(rand.nextInt(9));
		}
		return res;
	}


	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public ArrayList<EntityGenitore> getGenitori() {
		return genitori;
	}

	public void setGenitori(ArrayList<EntityGenitore> genitori) {
		this.genitori = genitori;
	}

	public EntityClasse getClasse() {
		return classe;
	}

	public void setClasse(EntityClasse classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "EntityAlunno [matricola=" + matricola + ", genitori=" + genitori + ", classe=" + classe.getAnnoSezione() + ", nome="
				+ nome + ", cognome=" + cognome + ", nascita=" + nascita + ", codiceFiscale=" + codiceFiscale
				+ ", residenza=" + residenza + ", email=" + email + ", cellulare=" + cellulare + ", username="
				+ username + ", password=" + password + "]";
	}

	
}
