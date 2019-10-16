package entidades;

public class Candidato {
	
	private String nomeCandidato;
	private String legenda;
	private String cargo;
	private String nomeMunicipio;
	
	public Candidato() {
		
	}
	
	public Candidato(String nomeCandidato, String legenda, String cargo, String nomeMunicipio) {
		this.nomeCandidato = nomeCandidato;
		this.legenda = legenda;
		this.cargo = cargo;
		this.nomeMunicipio = nomeMunicipio;
	}

	public String getNome() {
		return nomeCandidato;
	}

	public void setNome(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((legenda == null) ? 0 : legenda.hashCode());
		result = prime * result + ((nomeCandidato == null) ? 0 : nomeCandidato.hashCode());
		result = prime * result + ((nomeMunicipio == null) ? 0 : nomeMunicipio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (legenda == null) {
			if (other.legenda != null)
				return false;
		} else if (!legenda.equals(other.legenda))
			return false;
		if (nomeCandidato == null) {
			if (other.nomeCandidato != null)
				return false;
		} else if (!nomeCandidato.equals(other.nomeCandidato))
			return false;
		if (nomeMunicipio == null) {
			if (other.nomeMunicipio != null)
				return false;
		} else if (!nomeMunicipio.equals(other.nomeMunicipio))
			return false;
		return true;
	}
	
	
}
