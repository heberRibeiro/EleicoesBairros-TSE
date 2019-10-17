# Eleições-TSE
** Estratificação de dados de boletins das urnas fornecidos pelo Tribunal Superior Eleitoral **

### Descrição
Diante da falta de estratificação dos resultados das eleições por bairros, foi desenvovido este programa para realizar esta tarefa, a princípio, em relação aos bairros da Cidade do Recife.

### Detalhe sobre os dados
O tribunal Superior Eleitoral possui um repositório de dados com informações de eleições desde 1945. Dentre os dados disponibilizados, há os boletins das urnas, que possuem dados eleitorais por urna. Esses dados são disponibilizados em arquivos .txt ou .csv divididos por estado e possuem muitos atributos como por exemplo: *Número da zona eleitoral na qual foi realizada a eleição, a seção eleitoral, quantidade de abstenções e comparecimento, além dos candidatos e o respectivo número de votos*. Como não há o atributo *Bairro*, mas há o 'Número do local de votação referente ao boletim de urna', e sabendo de antemão os bairros e seus respectivos números de votação, foi possível realizar a estratificação.

### Guia
Os dados devem ser colocados no pacote do projeto, ou deve ser informado no programa principal qual diretório ele está. São necessário dois arquivos: O arquivo referente ao boletim da urna, encontrado no repositório do TSE (Link abaixo) e um arquivo com os bairros e seus respectivos locais de votação, também encontrados facilmente no portal do Tribunal Regional Eleitoral do estado.
Os arquivos contidos neste pacote são os relativos à cidade do Recife e os dados relativos ao 2° turno das eleições municipais de 2016 e eleição presidencial de 2018. Para a análise da eleição presidencial de 2018 é necessário descompactar o arquivo, mudar a extensão para .txt e alterar as linhas 43 e 46 no programa principal, conforme a seguir:

		ServicoLeitura2T2018 servicoLeitura2T2016 = new ServicoLeitura2T2016();

		ServicoResultado servicoResultado = new ServicoResultado(path_dadosTSE_2T2018PE, servicoLeitura2T2018, cidade);

A ideia é que seja possível estratificar os dados de qualquer eleição dispinibilizados pelo TSE; dessa forma, neste projeto, foi criado a interface *ServicoLeitura* cujo papel é permitir o desacoplamento entre uma classe específica que realiza a leitura de dados de uma determindada eleição e o *ServicoResultado* que retorna o resultado da leitura. Então, é possível criar uma classe que realize a leitura dos dados de uma determinada eleição implementando a interface.

### Resultados Parciais
-------------------------------------
AFLITOS:
JOÃO PAULO, PT, 4631, 36,39%
GERALDO JULIO, PSB, 6677, 52,46%
NULO, , 961, 7,55%
BRANCO, , 458, 3,60%

-------------------------------------
AFOGADOS:
GERALDO JULIO, PSB, 84513, 55,14%
JOÃO PAULO, PT, 51789, 33,79%
NULO, , 11672, 7,62%
BRANCO, , 5284, 3,45%

-------------------------------------
AGUA FRIA:
GERALDO JULIO, PSB, 64623, 55,62%
JOÃO PAULO, PT, 38929, 33,50%
NULO, , 8668, 7,46%
BRANCO, , 3970, 3,42%

-------------------------------------
ALTO JOSE BONIFACIO:
JOÃO PAULO, PT, 239, 45,52%
GERALDO JULIO, PSB, 239, 45,52%
NULO, , 30, 5,71%
BRANCO, , 17, 3,24%

-------------------------------------

`<link>`: [Repositório do Tribunal Superior Eleitoral](http://www.tse.jus.br/eleicoes/estatisticas/repositorio-de-dados-eleitorais-1/repositorio-de-dados-eleitorais "Repositório do Tribunal Superior Eleitoral")


[TOCM]

