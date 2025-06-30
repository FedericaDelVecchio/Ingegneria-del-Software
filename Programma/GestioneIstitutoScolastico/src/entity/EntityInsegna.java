package entity;

import database.DBClasse;
import database.DBDocente;
import database.DBInsegna;

public class EntityInsegna {
	private String materia;
	private EntityClasse classe;
	private EntityDocente docente;
	
	public EntityInsegna() {
	}
	
	public EntityInsegna(DBClasse classe,DBDocente docente,String materia) {
		this.materia = materia;
		this.classe = new EntityClasse(classe);
		this.docente = new EntityDocente(docente);
	}
	
	public EntityInsegna(DBInsegna insegna) {
		this.materia = insegna.getMateria();
		this.classe = new EntityClasse(insegna.getClasse());
		this.docente = new EntityDocente(insegna.getDocente());
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public EntityClasse getClasse() {
		return classe;
	}

	public void setClasse(EntityClasse classe) {
		this.classe = classe;
	}

	public EntityDocente getDocente() {
		return docente;
	}

	public void setDocente(EntityDocente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return " [materia=" + materia + ", classe=" + classe.getAnnoSezione() + "]";
	}

	
	
}
