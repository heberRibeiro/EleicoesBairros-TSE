package servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServicoLeitura2T2018 implements ServicoLeitura {

	/*
	 * Faz a leitura do arquivo .txt e retorna um String com os seguintes dados em
	 * ordem separados por vírgula: Nome do Candidato, Legenda, Cargo, Nome do
	 * Município, Número do Local de Votação, Quantidade de Votos.
	 * 
	 */

	@Override
	public List<String> leitura(String path) {

		List<String> retorno = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String conteudo = br.readLine();
			while (conteudo != null) {
				String[] vetor = conteudo.split(";");
				String nomeCandidato = vetor[28];
				String legenda = vetor[18]; // pode indicar voto "Nulo" de acordo com os dados do arquivo
				String cargo = vetor[16];
				String nomeMunicipio = vetor[11];
				String localVotacao = vetor[14];
				String quantidadeVotos = vetor[29];
				
				retorno.add(nomeCandidato+";"+legenda+";"+cargo+";"+nomeMunicipio+";"+localVotacao+";"+quantidadeVotos);
				
				conteudo = br.readLine();

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return retorno;
		
	}

}
