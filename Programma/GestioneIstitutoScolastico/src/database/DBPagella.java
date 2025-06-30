package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBPagella {
	private DBAlunno alunno;
	private ArrayList<DBMedia> medie;
	private int approvata;
	
	public DBPagella() {
	}
	
	public DBPagella(String username) {
		this.alunno = new DBAlunno(username);
		caricaDaDB();
		caricaMedieDaDB();
	}
	
	public DBPagella(DBAlunno a) {
		this.alunno = a;
		caricaDaDB();
		caricaMedieDaDB();
	}
	
	public DBPagella(DBPagella pagella) {
		this.alunno = pagella.getAlunno();
		caricaDaDB();
		caricaMedieDaDB();
	}
	
	public void caricaDaDB() {
		this.medie = new ArrayList<DBMedia>();
		String query = new String("SELECT * FROM pagelle WHERE Alunni_username='"+this.alunno.getUsername()+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.approvata = rs.getInt("approvata");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void caricaMedieDaDB() { 
		String query = new String("SELECT * FROM medie WHERE Pagelle_Alunni_username='"+this.alunno.getUsername()+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				int idMedia = rs.getInt("idMedie");
				DBMedia media = new DBMedia(idMedia);
				this.medie.add(media);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int salvaInDB(String username) {
		int ret = 0;
		String query = "INSERT INTO pagelle(Alunni_username,approvata) VALUES ('"+username+"','"+0+"');"; 
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public int sonoStateGenerateInDB() {
		int ret=0;
		String query = new String("SELECT * FROM pagelle;");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(!rs.next()) {
				ret=-1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int approvaPagellaInDB() {
		int ret = 0;
		String query = "UPDATE pagelle SET approvata='"+1+"' WHERE Alunni_username='"+this.alunno.getUsername()+"';"; 
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		setApprovata(1);
		return ret;
	}

	public DBAlunno getAlunno() {
		return alunno;
	}

	public void setAlunno(DBAlunno alunno) {
		this.alunno = alunno;
	}

	public ArrayList<DBMedia> getMedie() {
		return medie;
	}

	public void setMedie(ArrayList<DBMedia> medie) {
		this.medie = medie;
	}

	public int getApprovata() {
		return approvata;
	}

	public void setApprovata(int approvata) {
		this.approvata = approvata;
	}

	@Override
	public String toString() {
		return "DBPagella [alunno=" + alunno + ", medie=" + medie + ", approvata=" + approvata + "]";
	}

	
}
