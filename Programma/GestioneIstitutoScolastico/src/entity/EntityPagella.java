package entity;

import java.util.ArrayList;
import database.DBPagella;

public class EntityPagella {
	private EntityAlunno alunno;
	private ArrayList<EntityMedia> medie;
	private int approvata;
	
	public EntityPagella() {
		setApprovata(0);
	}
	
	public EntityPagella(String username) {
		DBPagella pagella = new DBPagella(username);
		this.alunno = new EntityAlunno(pagella.getAlunno());
		this.approvata = pagella.getApprovata();
		this.medie = new ArrayList<EntityMedia>();
		pagella.caricaMedieDaDB();
		caricaMedie();
	}
	
	public void caricaMedie() {
		DBPagella pagella = new DBPagella(this.alunno.getUsername());
		for(int i=0;i<pagella.getMedie().size();i++) {
			EntityMedia media = new EntityMedia(pagella.getMedie().get(i));
			this.medie.add(media);
		}
	}
	
	public int inserisciPagella(String username) {
		int ret = 0;
		DBPagella pagellaDB = new DBPagella();
		ret = pagellaDB.salvaInDB(username);
		if(ret!=-1) {
			setApprovata(0);
			this.alunno = new EntityAlunno(username);
		}
		return ret;
	}
	

	public int sonoStateGenerate() {
		int ret = 0;
		DBPagella pagellaDB = new DBPagella();
		ret=pagellaDB.sonoStateGenerateInDB();
		return ret;
	}
	
	public int approvaPagella() {
		int ret = 0;
		DBPagella pagellaDB = new DBPagella(this.alunno.getUsername());
		ret=pagellaDB.approvaPagellaInDB();
		setApprovata(1);
		return ret;
	}

	public EntityAlunno getAlunno() {
		return alunno;
	}

	public void setAlunno(EntityAlunno alunno) {
		this.alunno = alunno;
	}

	public ArrayList<EntityMedia> getMedie() {
		return medie;
	}

	public void setMedie(ArrayList<EntityMedia> medie) {
		this.medie = medie;
	}

	@Override
	public String toString() {
		return "EntityPagella [alunno=" + alunno.getNomeCognome() + ", medie=" + medie + ", approvata=" + approvata + "]";
	}

	public int isApprovata() {
		return approvata;
	}

	public void setApprovata(int i) {
		this.approvata = i;
	}
}
