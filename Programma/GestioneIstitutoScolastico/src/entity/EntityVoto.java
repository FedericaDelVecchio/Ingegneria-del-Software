package entity;

import database.DBVoto;


public class EntityVoto extends EntityValutazione{
	private String data;
	private int valore;
	private EntityAlunno alunno;
	
	public EntityVoto() {
	}
	
	public EntityVoto(int id) {
		DBVoto voto = new DBVoto(id);
		this.id = id;
		this.materia = voto.getMateria();
		this.valore = voto.getValore();
		this.data = voto.getData();
		this.alunno = new EntityAlunno(voto.getAlunno());
	}
	
	public int inserisciVoto(int valore,String materia,String data,String anno,String sezione,String username) {
		int ret = 0;
		DBVoto votoDB = new DBVoto();
		ret = votoDB.salvaInDB(valore,data,materia,anno,sezione,username);
		if(ret!=-1) {
			setId(votoDB.getId());
			setValore(valore);
			setMateria(materia);
			setData(data);
			alunno = new EntityAlunno(username);
		}
		return ret;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public EntityAlunno getAlunno() {
		return alunno;
	}

	public void setAlunno(EntityAlunno alunno) {
		this.alunno = alunno;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return "EntityVoto [data=" + data + ", alunno=" + alunno.getNomeCognome() + ", id=" + id + ", valore=" + valore + ", materia="
				+ materia + "]";
	}

	
}
