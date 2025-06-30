package entity;

import java.util.ArrayList;
import database.DBPreside;

public class EntityPreside extends EntityUtenteRegistrato{
	private ArrayList<EntityClasse> classi;
	
	public EntityPreside(String username) {
		DBPreside preside = new DBPreside(username);
		this.username = username;
		this.password = preside.getPassword();
	}
	
	public void caricaClassi() {
		DBPreside preside = new DBPreside(username);
		this.classi = new ArrayList<EntityClasse>();
		preside.caricaClassiDaDB();
		for(int i=0;i<preside.getClassi().size();i++) {
			EntityClasse classe = new EntityClasse();
			String anno = preside.getClassi().get(i).getAnno();
			classe.setAnno(anno);
			String sezione = preside.getClassi().get(i).getSezione();
			classe.setSezione(sezione);
			this.classi.add(classe);
		}
	}

	public ArrayList<EntityClasse> getClassi() {
		return classi;
	}

	public void setClassi(ArrayList<EntityClasse> classi) {
		this.classi = classi;
	}

	@Override
	public String toString() {
		return "EntityPreside [classi=" + classi + ", username=" + username + ", password=" + password + "]";
	}
}
