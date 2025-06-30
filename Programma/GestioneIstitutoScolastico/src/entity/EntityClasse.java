package entity;

import java.util.ArrayList;
import database.DBClasse;

public class EntityClasse {
	String anno;
	String sezione;
	ArrayList<EntityAlunno> alunni;
	EntityRegistroElettronico registroElettronico;
	
	public EntityClasse() {
	}
	
	public EntityClasse(String anno,String sezione) {
		this.anno = anno;
		this.sezione = sezione;
	}
	
	public EntityClasse(DBClasse classe) {
		this.anno = classe.getAnno();
		this.sezione = classe.getSezione();
	}
	
	public EntityClasse(EntityClasse classe) {
		this.anno = classe.getAnno();
		this.sezione = classe.getSezione();
	}

	
	public void caricaAlunni() {
		DBClasse classe = new DBClasse(anno,sezione);
		this.alunni = new ArrayList<EntityAlunno>();
		classe.caricaAlunniDaDB();
		for(int i=0;i<classe.getAlunni().size();i++) {
			String username = classe.getAlunni().get(i).getUsername();
			EntityAlunno alunno = new EntityAlunno(username);
			this.alunni.add(alunno);
		}
	}
	
	public void caricaRegistroElettronico() {
		DBClasse classe = new DBClasse(anno,sezione);
		classe.caricaRegistroElettronicoDaDB();
		EntityRegistroElettronico re = new EntityRegistroElettronico();
		String annoScolastico = classe.getRegistroElettronico().getAnnoScolastico();
		EntityClasse clas = new EntityClasse(classe);
		re.setClasse(clas);
		re.setAnnoScolastico(annoScolastico);
		this.registroElettronico = re;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	public String getAnnoSezione() {
		return anno+" "+sezione;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public ArrayList<EntityAlunno> getAlunni() {
		return alunni;
	}

	public void setAlunni(ArrayList<EntityAlunno> alunni) {
		this.alunni = alunni;
	}

	public EntityRegistroElettronico getRegistroElettronico() {
		return registroElettronico;
	}

	public void setRegistroElettronico(EntityRegistroElettronico registroElettronico) {
		this.registroElettronico = registroElettronico;
	}

	@Override
	public String toString() {
		return "EntityClasse [anno=" + anno + ", sezione=" + sezione + ", alunni=" + alunni + ", registroElettronico]";
	}

	
}
