package aplicacao;

//====================================================================================================
/*
 *	Este programa faz a leitura dos dados na extensão .txt relativos às eleições presidenciais de 2018 
 *	em Pernambuco fornecidos pelo TSE-Tribunal Superior Eleitoral no portal: 
 *	http://www.tse.jus.br/eleicoes/estatisticas/repositorio-de-dados-eleitorais-1/repositorio-de-dados-eleitorais
 *	E fornece resultados discriminados em função dos bairros da cidade do Recife.
 */
//====================================================================================================

import java.util.ArrayList;
import java.util.List;

import entidades.Bairro;
import entidades.Candidato;
import servicos.ServicoLeitura2T2018;
import servicos.ServicoLocaisVotacaoRecife;
import servicos.ServicoResultado;

public class Principal {

	public static void main(String[] args) {

		String path_dadosTSE = "..\\eleicoesEstratificacaoBairros-tse\\bweb_2t_PE_301020181752.txt";
		String path_dadosLocaisRecife = "..\\eleicoesEstratificacaoBairros-tse\\locaisVotacaoRecife.txt";
		String cidade = "RECIFE";

		ServicoLeitura2T2018 servicoLeitura2T2018 = new ServicoLeitura2T2018();

		ServicoResultado servicoResultado = new ServicoResultado(path_dadosTSE, servicoLeitura2T2018, cidade);

		ServicoLocaisVotacaoRecife servicoLocaisVotacaoRecife = new ServicoLocaisVotacaoRecife();
		List<String> listaLocaisVotacao = servicoLocaisVotacaoRecife.leitura(path_dadosLocaisRecife);
		List<String> listaBairrosRecife = servicoLocaisVotacaoRecife.relacaoBairros(path_dadosLocaisRecife);
		
		/**************/
		/* * BAIRRO * */
		/**************/
		// String bairroDefinodoPeloUsuario = "BOMBA DO HEMETÉRIO";

		for (String bairroDefinodoPeloUsuario : listaBairrosRecife) {

			List<String> locaisVotacaoPorBairro = new ArrayList<>();
			for (String local : listaLocaisVotacao) {
				String[] vetor = local.split(",");
				String nomeBairro = vetor[0];
				String localVotacao = vetor[1];
				if (nomeBairro.equals(bairroDefinodoPeloUsuario)) {
					locaisVotacaoPorBairro.add(localVotacao);
				}
			}
			Bairro bairro = new Bairro(bairroDefinodoPeloUsuario, cidade, locaisVotacaoPorBairro);

			servicoResultado.resultado(bairro);

			int sum = 0;
			for (Candidato candidato : bairro.getCandidatos().keySet()) {
				int numeroVotosCandidato = bairro.getCandidatos().get(candidato);
				sum += numeroVotosCandidato;
			}
			System.out.println("-------------------------------------");
			System.out.println(bairroDefinodoPeloUsuario + ":");
			for (Candidato candidato : bairro.getCandidatos().keySet()) {
				int numeroVotosCandidato = bairro.getCandidatos().get(candidato);
				double percVotosCandidato = 100 * (double) numeroVotosCandidato / sum;
				System.out.println(candidato.getNome() + ", " + candidato.getLegenda() + ", " + numeroVotosCandidato
						+ ", " + String.format("%.2f", percVotosCandidato) + "%");
			}
			System.out.println("-------------------------------------");
		}

	}
}
