package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBClasse {
	String anno;
	String sezione;
	ArrayList<DBAlunno> alunni;
	DBRegistroElettronico registroElettronico;
	
	public DBClasse() {
	}
	
	public DBClasse(String anno,String sezione) {
		this.anno = anno;
		this.sezione = sezione;
	}
	
	public DBClasse(DBClasse classe) {
		this.anno = classe.getAnno();
		this.sezione = classe.getSezione();
	}
	
	public void caricaAlunniDaDB() { 
		this.alunni = new ArrayList<DBAlunno>();
		String query = new String("SELECT * FROM alunni WHERE Classi_anno='"+this.anno+"' AND Classi_sezione='"+this.sezione+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				String username = new String(rs.getString("username"));
				DBAlunno alunno = new DBAlunno(username);
				this.alunni.add(alunno);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaRegistroElettronicoDaDB() { 
		this.registroElettronico = new DBRegistroElettronico();
		String query = new String("SELECT * FROM registrielettronici WHERE Classi_anno='"+this.anno+"' AND Classi_sezione='"+this.sezione+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBRegistroElettronico re= new DBRegistroElettronico(this);
				this.registroElettronico = re;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public ArrayList<DBAlunno> getAlunni() {
		return alunni;
	}

	public void setAlunni(ArrayList<DBAlunno> alunni) {
		this.alunni = alunni;
	}

	public DBRegistroElettronico getRegistroElettronico() {
		return registroElettronico;
	}

	public void setRegistroElettronico(DBRegistroElettronico registroElettronico) {
		this.registroElettronico = registroElettronico;
	}

	@Override
	public String toString() {
		return "DBClasse [anno=" + anno + ", sezione=" + sezione + ", alunni=" + alunni + ", registroElettronico="
				+ registroElettronico + "]";
	}

	
}
