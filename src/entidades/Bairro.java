package entidades;

import java.util.List;
import java.util.Map;

public class Bairro {

	private String nomeBairro;
	private String nomeMunicipio;
	private List<String> locaisVotacao;
	private Map<Candidato, Integer> candidatos;
	
	public Bairro() {

	}

	public Bairro(String nomeBairro, String nomeMunicipio, List<String> locaisVotacao) {
		this.nomeBairro = nomeBairro;
		this.locaisVotacao = locaisVotacao;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nome) {
		this.nomeBairro = nome;
	}
	
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public List<String> getLocaisVotacao() {
		return locaisVotacao;
	}

	public void setLocaisVotacao(List<String> locaisVotacao) {
		this.locaisVotacao = locaisVotacao;
	}

	public Map<Candidato, Integer> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(Map<Candidato, Integer> candidatos) {
		this.candidatos = candidatos;
	}

}
