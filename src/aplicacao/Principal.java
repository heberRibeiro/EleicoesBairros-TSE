package aplicacao;


import java.util.ArrayList;
import java.util.List;

import entidades.Bairro;
import entidades.Candidato;
import servicos.ServicoLeitura2T2016;
import servicos.ServicoLocaisVotacaoRecife;
import servicos.ServicoResultado;

//====================================================================================================
/*
*	Este programa faz a leitura dos dados na extens�o .txt relativos �s elei��es municipais de 2016 
*	em Pernambuco fornecidos pelo TSE-Tribunal Superior Eleitoral no portal: 
*	http://www.tse.jus.br/eleicoes/estatisticas/repositorio-de-dados-eleitorais-1/repositorio-de-dados-eleitorais
*	E fornece resultados discriminados em fun��o dos bairros da cidade do Recife.
*	
*	Foi criada a interface "ServicoLeitura", dessa forma, � poss�vel fazer a an�lise de qualquer elei��o
*	sem a necessidade de alterar o "ServicoResultado", bastando apenas criar uma nova classe para realizar
*	a leitura do novo arquivo .txt relativo a elei��o desejada e instanci�-la no programa principal.
*	Isso ocorre devido ao desacoplamento criado pela interface ServicoLeitura.
*	
*	Caso queira analisar o resultado do 2� turno da elei��o presidencial de 2018, basta extrair o arquivo
*	compactado, mudar a extens�o de .csv para .txt e no programa principal instanciar um novo objeto
*	da classe "ServicoLeitura2T2016", passando esse novo objeto como par�metro do "ServicoResultado"
*/
//====================================================================================================

public class Principal {

	public static void main(String[] args) {
		/* Arquivo com os bairros da Cidade do Recife*/
		String path_dadosLocaisRecife = "..\\eleicoesEstratificacaoBairros-tse\\locaisVotacaoRecife.txt";
		/* Arquivos com dados do TSE contendo as informa��es a serem usadas */
		String path_dadosTSE_2T2016PE = "..\\eleicoesEstratificacaoBairros-tse\\bweb_2t_PE_31102016134108.txt";
		String path_dadosTSE_2T2018PE = "..\\eleicoesEstratificacaoBairros-tse\\bweb_2t_PE_301020181752.txt";
		/* Defini��o da cidade em que est�o os bairros analisados*/
		String cidade = "RECIFE";

		/* Leitura dos dados relativos ao 2� Turno das elei��es de 2016 em Pernambuco */
		ServicoLeitura2T2016 servicoLeitura2T2016 = new ServicoLeitura2T2016();

		/* Resultado da leitura dos dados relativos ao 2� Turno das elei��es de 2016 em Pernambuco */
		ServicoResultado servicoResultado = new ServicoResultado(path_dadosTSE_2T2016PE, servicoLeitura2T2016, cidade);
		
		/* Resultados da leitura dos dados com os locais de vota��o */
		ServicoLocaisVotacaoRecife servicoLocaisVotacaoRecife = new ServicoLocaisVotacaoRecife();
		List<String> listaLocaisVotacao = servicoLocaisVotacaoRecife.leitura(path_dadosLocaisRecife);
		List<String> listaBairrosRecife = servicoLocaisVotacaoRecife.relacaoBairros(path_dadosLocaisRecife);
		
		
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
