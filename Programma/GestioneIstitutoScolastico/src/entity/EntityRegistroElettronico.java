package entity;

import java.util.ArrayList;
import database.DBClasse;
import database.DBRegistroElettronico;

public class EntityRegistroElettronico {
	private String annoScolastico;
	private EntityClasse classe;
	private ArrayList<EntityVoto> voti;
	private ArrayList<EntityAttivita> attivita;
	
	public EntityRegistroElettronico() {
	}
	
	public EntityRegistroElettronico(String anno,String sezione) {
		DBRegistroElettronico registroElettronico = new DBRegistroElettronico(anno,sezione);
		this.annoScolastico = registroElettronico.getAnnoScolastico();
		this.classe = new EntityClasse(anno,sezione);
	}
	
	public EntityRegistroElettronico(DBClasse classe) {
		DBRegistroElettronico registroElettronico = new DBRegistroElettronico(classe);
		this.annoScolastico = registroElettronico.getAnnoScolastico();
		this.classe = new EntityClasse(classe);
	}
	
	public void caricaVoti() {
		DBRegistroElettronico registroElettronico = new DBRegistroElettronico(classe.getAnno(),classe.getSezione());
		this.voti = new ArrayList<EntityVoto>();
		registroElettronico.caricaVotiDaDB();
		for(int i=0;i<registroElettronico.getVoti().size();i++) {
			EntityVoto voto = new EntityVoto();
			voto.setId(registroElettronico.getVoti().get(i).getId());
			voto.setValore(registroElettronico.getVoti().get(i).getValore());
			voto.setMateria(registroElettronico.getVoti().get(i).getMateria());
			EntityAlunno a = new EntityAlunno(registroElettronico.getVoti().get(i).getAlunno().getUsername());
			voto.setAlunno(a);
			this.voti.add(voto);
		}
	}
	
	public void caricaVoti(DBRegistroElettronico registroElettronico) {
		this.voti = new ArrayList<EntityVoto>();
		registroElettronico.caricaVotiDaDB();
		for(int i=0;i<registroElettronico.getVoti().size();i++) {
			EntityVoto voto = new EntityVoto();
			voto.setId(registroElettronico.getVoti().get(i).getId());
			voto.setId(registroElettronico.getVoti().get(i).getId());
			voto.setValore(registroElettronico.getVoti().get(i).getValore());
			voto.setMateria(registroElettronico.getVoti().get(i).getMateria());
			EntityAlunno a = new EntityAlunno(registroElettronico.getVoti().get(i).getAlunno().getUsername());
			voto.setAlunno(a);
			this.voti.add(voto);
		}
	}
	
	public void caricaAttivita() {
		DBRegistroElettronico registroElettronico = new DBRegistroElettronico(classe.getAnno(),classe.getSezione());
		this.attivita = new ArrayList<EntityAttivita>();
		registroElettronico.caricaAttivitaDaDB();
		for(int i=0;i<registroElettronico.getAttivita().size();i++) {
			EntityAttivita attiv = new EntityAttivita();
			attiv.setId(registroElettronico.getAttivita().get(i).getId());
			attiv.setMateria(registroElettronico.getAttivita().get(i).getMateria());
			attiv.setDescrizione(registroElettronico.getAttivita().get(i).getDescrizione());
			attiv.setData(registroElettronico.getAttivita().get(i).getData());
			String Anno = registroElettronico.getAttivita().get(i).getClasse().getAnno();
			String Sezione = registroElettronico.getAttivita().get(i).getClasse().getSezione();
			EntityClasse a = new EntityClasse(Anno,Sezione);
			attiv.setClasse(a);
			this.attivita.add(attiv);
		}
	}
	
	public void caricaAttivita(DBRegistroElettronico registroElettronico) {
		this.attivita = new ArrayList<EntityAttivita>();
		registroElettronico.caricaAttivitaDaDB();
		for(int i=0;i<registroElettronico.getAttivita().size();i++) {
			EntityAttivita attiv = new EntityAttivita();
			attiv.setId(registroElettronico.getAttivita().get(i).getId());
			attiv.setMateria(registroElettronico.getAttivita().get(i).getMateria());
			attiv.setDescrizione(registroElettronico.getAttivita().get(i).getDescrizione());
			attiv.setData(registroElettronico.getAttivita().get(i).getData());
			String Anno = registroElettronico.getAttivita().get(i).getClasse().getAnno();
			String Sezione = registroElettronico.getAttivita().get(i).getClasse().getSezione();
			EntityClasse a = new EntityClasse(Anno,Sezione);
			attiv.setClasse(a);
			this.attivita.add(attiv);
		}
	}
	
	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public EntityClasse getClasse() {
		return classe;
	}

	public void setClasse(EntityClasse classe) {
		this.classe = classe;
	}

	public ArrayList<EntityVoto> getVoti() {
		return voti;
	}

	public void setVoti(ArrayList<EntityVoto> voti) {
		this.voti = voti;
	}

	public ArrayList<EntityAttivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(ArrayList<EntityAttivita> attivita) {
		this.attivita = attivita;
	}

	@Override
	public String toString() {
		return "EntityRegistroElettronico [annoScolastico=" + annoScolastico + ", classe=" + classe.getAnnoSezione() + ", voti=" + voti
				+ ", attivita=" + attivita + "]";
	}

	
}
