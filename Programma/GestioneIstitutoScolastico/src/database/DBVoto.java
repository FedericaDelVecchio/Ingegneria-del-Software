package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBVoto {
	private int id;
	private int valore;
	private String materia;
	private String data;
	private DBAlunno alunno;
	
	public DBVoto() {
	}
	
	public DBVoto(int id) {
		this.id = id;
		caricaDaDB();
	}
	
	public DBVoto(DBVoto voto) {
		this.id = voto.getId();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM voti WHERE idVoti="+this.id+";");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setValore(rs.getInt("valore"));
				this.setMateria(rs.getString("materia"));
				this.setData(rs.getString("data"));
				this.alunno = new DBAlunno(rs.getString("Alunni_username"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int salvaInDB(int valore,String data,String materia,String anno,String sezione,String username) {
		String query1 = new String("SELECT * FROM voti ORDER BY idVoti DESC LIMIT 1;");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query1);
			if(rs.next()) {
				this.id = (rs.getInt("idVoti"))+1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int ret = 0;
		String query2 = "INSERT INTO voti(idVoti,valore,data,materia,RegistriElettronici_Classi_anno,RegistriElettronici_Classi_sezione,Alunni_username) VALUES ('"+this.id+"','"+valore+"','"+data+"','"+materia+"','"+anno+"','"+sezione+"','"+username+"');"; 
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

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DBAlunno getAlunno() {
		return alunno;
	}

	public void setAlunno(DBAlunno alunno) {
		this.alunno = alunno;
	}

	@Override
	public String toString() {
		return "DBVoto [id=" + id + ", valore=" + valore + ", materia=" + materia + ", data=" + data + ", alunno="
				+ alunno + "]";
	}
	
	
}
