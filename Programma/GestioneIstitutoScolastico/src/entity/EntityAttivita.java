package entity;

import database.DBAttivita;

public class EntityAttivita {
	private int id;
	private String materia;
	private String descrizione;
	private String data;
	private EntityClasse classe;
	
	public EntityAttivita() {
	}
	
	public EntityAttivita(int id) {
		DBAttivita attivita = new DBAttivita(id);
		this.id = id;
		this.materia = attivita.getMateria();
		this.descrizione = attivita.getDescrizione();
		this.data = attivita.getData();
		this.classe = new EntityClasse(attivita.getClasse());
	}
	
	public EntityAttivita(DBAttivita attivita) {
		this.id = attivita.getId();
		this.materia = attivita.getMateria();
		this.descrizione = attivita.getDescrizione();
		this.data = attivita.getData();
		this.classe = new EntityClasse(attivita.getClasse());
	}
	
	public int inserisciAttivita(String materia,String descrizione,String data,String anno,String sezione) {
		int ret = 0;
		DBAttivita attivitaDB = new DBAttivita();
		ret = attivitaDB.salvaInDB(materia,descrizione,data,anno,sezione);
		if(ret!=-1) {
			setId(attivitaDB.getId());
			setDescrizione(descrizione);
			setMateria(materia);
			setData(data);
			setClasse(new EntityClasse(anno,sezione));
		}
		return ret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public EntityClasse getClasse() {
		return classe;
	}

	public void setClasse(EntityClasse classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "EntityAttivita [id=" + id + ", materia=" + materia + ", descrizione=" + descrizione + ", data=" + data
				+ ", classe=" + classe.getAnnoSezione() + "]";
	}
	
	
}
