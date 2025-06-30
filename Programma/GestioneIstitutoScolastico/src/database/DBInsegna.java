package database;


public class DBInsegna {
	private String materia;
	private DBClasse classe;
	private DBDocente docente;
	private String anno;
	private String sezione;
	private String username;
	
	public DBInsegna() {
		
	}
	
	public DBInsegna(DBClasse classe,DBDocente docente,String materia) {
		this.docente = docente;
		this.classe = classe;
		this.materia = materia;
		this.anno = classe.getAnno();
		this.sezione = classe.getSezione();
		this.username = docente.getUsername();
	}

	
	public DBInsegna(DBInsegna insegna) {
		this.docente = insegna.getDocente();
		this.classe = insegna.getClasse();
		this.materia = insegna.getMateria();
		this.anno = insegna.getAnno();
		this.sezione = insegna.getSezione();
		this.username = insegna.getUsername();
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public DBClasse getClasse() {
		return classe;
	}

	public void setClasse(DBClasse classe) {
		this.classe = classe;
	}

	public DBDocente getDocente() {
		return docente;
	}

	public void setDocente(DBDocente docente) {
		this.docente = docente;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "DBInsegna [materia=" + materia + ", docente=" + docente + "]";
	}
}
