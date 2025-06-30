package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMedia {
	private int id;
	private double valore;
	private String materia;
	private DBAlunno alunno;
	
	public DBMedia() {
	}
	
	public DBMedia(int id) {
		this.id = id;
		caricaDaDB();
	}
	
	public DBMedia(DBMedia media) {
		this.id = media.getId();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM medie WHERE idMedie="+this.id+";");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setValore(rs.getDouble("valore"));
				this.setMateria(rs.getString("materia"));
				this.alunno = new DBAlunno(rs.getString("Pagelle_Alunni_username"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int salvaInDB(int id,double valore,String materia,String username) {
		int ret = 0;
		String query = "INSERT INTO medie(idMedie,valore,materia,Pagelle_Alunni_username) VALUES ('"+id+"','"+valore+"','"+materia+"','"+username+"');"; 
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int aggiornaMediaInDB(double valore) {
		int ret = 0;
		String query = "UPDATE medie SET valore='"+valore+"' WHERE idMedie='"+this.id+"';"; 
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		setValore(valore);
		return ret;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(double valore) {
		this.valore = valore;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public DBAlunno getAlunno() {
		return alunno;
	}

	public void setAlunno(DBAlunno alunno) {
		this.alunno = alunno;
	}

	@Override
	public String toString() {
		return "DBMedia [id=" + id + ", valore=" + valore + ", materia=" + materia + ", alunno=" + alunno + "]";
	}
}
