package servicos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Bairro;
import entidades.Candidato;

public class ServicoResultado {

	private String path;
	private ServicoLeitura servicoLeitura;

	public ServicoResultado() {

	}

	public ServicoResultado(String path, ServicoLeitura servicoLeitura) {
		this.path = path;
		this.servicoLeitura = servicoLeitura;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ServicoLeitura getServicoLeitura() {
		return servicoLeitura;
	}

	public void setServicoLeitura(ServicoLeitura servicoLeitura) {
		this.servicoLeitura = servicoLeitura;
	}

	/*
	 * Este método utiliza o "ServicoLeitura" para receber um tipo "List" com os
	 * dados relativos a cada urna separados por ponto e vírgula
	 * (NomeDoCandidato;Legenda;
	 * Cargo;NomeDoMunicípio;NumeroDoLocalDeVotação;QuantidadeDeVotos).
	 */
	public void resultado(Bairro bairro) {

		Map<Candidato, Integer> resultados = new HashMap<>();

		List<String> boletimUrna = servicoLeitura.leitura(getPath());
		for (String urna : boletimUrna) {
			String[] conteudo = urna.split(";");
			String nomeCandidato = conteudo[0].replaceAll("\"", "");
			String legenda = conteudo[1].replaceAll("\"", "");
			String cargo = conteudo[2].replaceAll("\"", "");
			String nomeMunicipio = conteudo[3].replaceAll("\"", "");
			String localVotacao = conteudo[4].replaceAll("\"", "");
			String quantidadeVotos = conteudo[5].replaceAll("\"", "");

			for (String locVot : bairro.getLocaisVotacao()) {

				if (Integer.parseInt(locVot) == Integer.parseInt(localVotacao) && nomeMunicipio.equals("RECIFE")){
					Candidato c = new Candidato(nomeCandidato, legenda, cargo, nomeMunicipio);
					if (resultados.containsKey(c)) {
						Integer acum = resultados.get(c) + Integer.parseInt(quantidadeVotos);
						resultados.put(c, acum);
					} else {
						resultados.put(c, Integer.parseInt(quantidadeVotos));
					}

				}

			}
		}

		bairro.setCandidatos(resultados);

	}

}
