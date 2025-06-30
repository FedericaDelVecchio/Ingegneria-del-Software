package entity;

public abstract class EntityUtente extends EntityUtenteRegistrato{
	protected String nome;
	protected String cognome;
	protected String nascita;
	protected String codiceFiscale;
	protected String residenza;
	protected String email;
	protected Integer cellulare;
	
	public EntityUtente() {
		super();
	}
	
	public String getNomeCognome() {
		return nome+" "+cognome;
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

	@Override
	public String toString() {
		return "EntityUtente [nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita + ", codiceFiscale="
				+ codiceFiscale + ", residenza=" + residenza + ", email=" + email + ", cellulare=" + cellulare + "]";
	}
	
	
}
