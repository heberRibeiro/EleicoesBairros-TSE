package servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServicoLocaisVotacaoRecife {

	public List<String> leitura(String path) {

		List<String> retorno = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String conteudo = br.readLine().replaceAll("\"", "");
			;
			while (conteudo != null) {
				retorno.add(conteudo);

				conteudo = br.readLine();
				if (conteudo != null)
					conteudo = conteudo.replaceAll("\"", "");

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return retorno;
	}

}
