package servicos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Bairro;
import entidades.Candidato;

public class ServicoResultado {

	private String path;
	private ServicoLeitura servicoLeitura;
	private String cidade;

	public ServicoResultado(String path, ServicoLeitura servicoLeitura, String cidade) {
		this.path = path;
		this.servicoLeitura = servicoLeitura;
		this.cidade = cidade;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/*
	 * Este método recebe um tipo "Bairro" e utiliza os parâmetros: "path",
	 * "ServicoLeitura" (como interface) e "cidade" recebidos na instanciação desta
	 * classe. Dessa forma, este método chama o objeto instanciado do tipo
	 * "ServicoLeitura" e seu método "leitura" passando para ele o patho do arquivo
	 * para que seja realizada a leitura. O retorno é um tipo "List" com os dados
	 * lidos. Esta lista é tratada por este método e ao final atualiza o objeto do
	 * tipo "Bairro" com os dados dos candidatos com o número de votos.
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

			if (bairro.getLocaisVotacao().contains(localVotacao) && nomeMunicipio.equals(cidade)) {

				Candidato c = new Candidato(nomeCandidato, legenda, cargo, nomeMunicipio);
				if (resultados.containsKey(c)) {
					Integer acum = resultados.get(c) + Integer.parseInt(quantidadeVotos);
					resultados.put(c, acum);
				} else {
					resultados.put(c, Integer.parseInt(quantidadeVotos));
				}

			}
		}

		bairro.setCandidatos(resultados);

	}

}
