package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBRegistroElettronico {
	private String annoScolastico;
	private DBClasse classe;
	private ArrayList<DBVoto> voti;
	private ArrayList<DBAttivita> attivita;
	private String anno;
	private String sezione;
	
	public DBRegistroElettronico() {
	}
	
	public DBRegistroElettronico(String anno,String sezione) {
		this.anno = anno;
		this.sezione = sezione;
		this.classe = new DBClasse(anno,sezione);
		caricaDaDB();
	}
	
	public DBRegistroElettronico(DBClasse classe) {
		this.anno = classe.getAnno();
		this.sezione = classe.getSezione();
		this.classe = classe;
		caricaDaDB();
	}
	
	public DBRegistroElettronico(DBRegistroElettronico registroElettronico) {
		this.anno = registroElettronico.getAnno();
		this.sezione = registroElettronico.getSezione();
		this.classe = registroElettronico.getClasse();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM registrielettronici WHERE Classi_anno='"+this.anno+"' AND Classi_sezione='"+this.sezione+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setAnnoScolastico(rs.getString("annoScolastico"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaVotiDaDB() { 
		this.voti = new ArrayList<DBVoto>();
		String query = new String("SELECT * FROM voti WHERE RegistriElettronici_Classi_anno='"+this.anno+"' AND RegistriElettronici_Classi_sezione='"+this.sezione+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				int idVoto = rs.getInt("idVoti");
				DBVoto voto = new DBVoto(idVoto);
				this.voti.add(voto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaAttivitaDaDB() { 
		this.attivita = new ArrayList<DBAttivita>();
		String query = new String("SELECT * FROM attivita WHERE RegistriElettronici_Classi_anno='"+this.anno+"' AND RegistriElettronici_Classi_sezione='"+this.sezione+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				int idAttivita = rs.getInt("idAttivita");
				DBAttivita attiv = new DBAttivita(idAttivita);
				this.attivita.add(attiv);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public DBClasse getClasse() {
		return classe;
	}

	public void setClasse(DBClasse classe) {
		this.classe = classe;
	}

	public ArrayList<DBVoto> getVoti() {
		return voti;
	}

	public void setVoti(ArrayList<DBVoto> voti) {
		this.voti = voti;
	}

	public ArrayList<DBAttivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(ArrayList<DBAttivita> attivita) {
		this.attivita = attivita;
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

	@Override
	public String toString() {
		return "DBRegistroElettronico [annoScolastico=" + annoScolastico + ", classe=" + classe + ", voti=" + voti
				+ ", attivita=" + attivita + ", anno=" + anno + ", sezione=" + sezione + "]";
	}
}
