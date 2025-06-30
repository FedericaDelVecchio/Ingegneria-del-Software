package entity;

import database.DBMedia;

public class EntityMedia extends EntityValutazione{
	private double valore;
	private EntityAlunno alunno;
	
	public EntityMedia() {
	}
	
	public EntityMedia(int id) {
		DBMedia media = new DBMedia(id);
		this.id = id;
		this.materia = media.getMateria();
		this.valore = media.getValore();
		this.alunno = new EntityAlunno(media.getAlunno());
	}
	
	public EntityMedia(DBMedia media) {
		this.id = media.getId();
		this.materia = media.getMateria();
		this.valore = media.getValore();
		this.alunno = new EntityAlunno(media.getAlunno());
	}
	
	public int inserisciMedia(int id,double v,String materia,String username) {
		int ret = 0;
		DBMedia mediaDB = new DBMedia();
		ret = mediaDB.salvaInDB(id,v,materia,username);
		if(ret!=-1) {
			setId(id);
			setValore(v);
			setMateria(materia);
			alunno = new EntityAlunno(username);
		}
		return ret;
	}	
	
	public int aggiornaMedia(double valoreFinale) {
		int ret = 0;
		DBMedia mediaDB = new DBMedia(this.id);
		ret = mediaDB.aggiornaMediaInDB(valoreFinale);
		if(ret!=-1) {
			setValore(valoreFinale);
		}
		return ret;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(double valore) {
		this.valore = valore;
	}

	public EntityAlunno getAlunno() {
		return alunno;
	}

	public void setAlunno(EntityAlunno alunno) {
		this.alunno = alunno;
	}

	@Override
	public String toString() {
		return "EntityMedia [alunno=" + alunno.getNomeCognome() + ", id=" + id + ", valore=" + valore + ", materia=" + materia + "]";
	}

}
