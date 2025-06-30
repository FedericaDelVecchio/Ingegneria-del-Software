package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBPreside {
	private String username;
	private String password;
	private ArrayList<DBClasse> classi;
	
	public DBPreside() {
	}
	
	public DBPreside(String username) {
		this.username = username;
		caricaDaDB();
	}
	
	public DBPreside(DBPreside preside) {
		this.username = preside.getUsername();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM presidi WHERE username='"+this.username+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setPassword(rs.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaClassiDaDB() {
		this.classi = new ArrayList<DBClasse>();
		String query = new String("SELECT * FROM classi WHERE Presidi_username='"+this.username+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				String anno = rs.getString("anno");
				String sezione = rs.getString("sezione");
				DBClasse classe = new DBClasse(anno,sezione);
				this.classi.add(classe);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<DBClasse> getClassi() {
		return classi;
	}

	public void setClassi(ArrayList<DBClasse> classi) {
		this.classi = classi;
	}

	@Override
	public String toString() {
		return "DBPreside [username=" + username + ", password=" + password + ", classi=" + classi + "]";
	}
}
