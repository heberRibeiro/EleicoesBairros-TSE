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
import servicos.ServicoLeituraEleicoes2018;
import servicos.ServicoResultado;

public class Principal {

	public static void main(String[] args) {

		String path = "..\\eleicoesEstratificacaoBairros-tse\\bweb_2t_PE_301020181752.txt";

		ServicoLeituraEleicoes2018 servicoLeitura = new ServicoLeituraEleicoes2018();

		ServicoResultado servicoResultado = new ServicoResultado(path, servicoLeitura);

		String nomeBairro = "AFOGADOS";
		String nomeMunicipio = "RECIFE";
		List<String> locaisVotacao = new ArrayList<>();
		locaisVotacao.add("1066");
		locaisVotacao.add("1481");
		locaisVotacao.add("1228");
		locaisVotacao.add("1490");
		locaisVotacao.add("1180");
		locaisVotacao.add("1236");
		locaisVotacao.add("1449");
		locaisVotacao.add("1473");
		locaisVotacao.add("1481");
		locaisVotacao.add("1279");
		locaisVotacao.add("1457");
		Bairro bairro = new Bairro(nomeBairro, nomeMunicipio, locaisVotacao);

		 servicoResultado.resultado(bairro);
		 
		 System.out.println("AFOGADOS");
		for (Candidato candidato : bairro.getCandidatos().keySet()) {
			System.out.println(candidato.getNome() + ", " + candidato.getLegenda() 
				+ ", " + bairro.getCandidatos().get(candidato));
		}

	}
}
