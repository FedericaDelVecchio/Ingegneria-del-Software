package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAttivita {
	private int id;
	private String materia;
	private String descrizione;
	private String data;
	private DBClasse classe;
	
	public DBAttivita() {
	}
	
	public DBAttivita(int id) {
		this.id = id;
		caricaDaDB();
	}
	
	public DBAttivita(DBAttivita attivita) {
		this.id = attivita.getId();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM attivita WHERE idAttivita='"+this.id+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setDescrizione(rs.getString("descrizione"));
				this.setMateria(rs.getString("materia"));
				this.setData(rs.getString("data"));
				this.classe = new DBClasse(rs.getString("RegistriElettronici_Classi_anno"),rs.getString("RegistriElettronici_Classi_sezione"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int salvaInDB(String materia,String descrizione,String data,String anno,String sezione) {
		String query1 = new String("SELECT * FROM attivita ORDER BY idAttivita DESC LIMIT 1;");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query1);
			if(rs.next()) {
				this.id = (rs.getInt("idAttivita"))+1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int ret = 0;
		String query2 = "INSERT INTO attivita(idAttivita,materia,descrizione,data,RegistriElettronici_Classi_anno,RegistriElettronici_Classi_sezione) VALUES ('"+this.id+"','"+materia+"','"+descrizione+"','"+data+"','"+anno+"','"+sezione+"');"; 
		try {
			ret = DBConnectionManager.updateQuery(query2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
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

	public DBClasse getClasse() {
		return classe;
	}

	public void setClasse(DBClasse classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "DBAttivita [id=" + id + ", materia=" + materia + ", descrizione=" + descrizione + ", data=" + data
				+ ", classe=" + classe + "]";
	}

}