package entity;

public abstract class EntityValutazione {
	protected int id;
	protected String materia;
	
	public EntityValutazione() {
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

	@Override
	public String toString() {
		return "EntityValutazione [id=" + id + ", materia=" + materia + "]";
	}
}
