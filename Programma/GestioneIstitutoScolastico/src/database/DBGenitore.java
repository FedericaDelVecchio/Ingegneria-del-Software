package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBGenitore {
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String nascita;
	private String codiceFiscale;
	private String residenza;
	private String email;
	private Integer cellulare;
	private ArrayList<DBAlunno> figli;
	
	public DBGenitore() {
	}
	
	public DBGenitore(String username) {
		this.username = username;
		caricaDaDB();
	}
	
	public DBGenitore(DBGenitore genitore) {
		this.username = genitore.getUsername();
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM genitori WHERE username='"+this.username+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setPassword(rs.getString("password"));
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setNascita(rs.getString("nascita"));
				this.setCodiceFiscale(rs.getString("codiceFiscale"));
				this.setResidenza(rs.getString("residenza"));
				this.setEmail(rs.getString("email"));
				this.setCellulare(rs.getInt("cellulare"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaFigliDaDB() { 
		this.figli = new ArrayList<DBAlunno>();
		String query = new String("SELECT * FROM genitori_has_alunni WHERE Genitori_username='"+this.username+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				String usernameFiglio = new String(rs.getString("Alunni_username"));
				DBAlunno figlio = new DBAlunno(usernameFiglio);
				this.figli.add(figlio);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int salvaInDB(String username,String password,String nome,String cognome,String residenza,String nascita,String codiceFiscale,Integer cellulare,String email) {
		int ret = 0;
		String query1 = new String("SELECT * FROM genitori WHERE codiceFiscale='"+codiceFiscale+"';");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query1);
			if(rs.next()) {
				ret=-1;
				return ret;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String query = "INSERT INTO genitori(username,password,nome,cognome,nascita,residenza,cellulare,codiceFiscale,email) VALUES ('"+username+"','"+password+"','"+nome+"','"+cognome+"','"+nascita+"','"+residenza+"','"+cellulare+"','"+codiceFiscale+"','"+email+"');"; 
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		return ret;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNascita() {
		return nascita;
	}

	public void setNascita(String nascita) {
		this.nascita = nascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCellulare() {
		return cellulare;
	}

	public void setCellulare(Integer cellulare) {
		this.cellulare = cellulare;
	}

	public ArrayList<DBAlunno> getFigli() {
		return figli;
	}

	public void setFigli(ArrayList<DBAlunno> figli) {
		this.figli = figli;
	}

	@Override
	public String toString() {
		return "DBGenitore [username=" + username + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ ", nascita=" + nascita + ", codiceFiscale=" + codiceFiscale + ", residenza=" + residenza + ", email="
				+ email + ", cellulare=" + cellulare + "]";
	}

	
}
