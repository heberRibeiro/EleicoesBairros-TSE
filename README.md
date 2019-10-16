# EleicoesBairros-TSE
Estratificação de dados de boletins das urnas fornecidos pelo Tribunal Superior Eleitoral

O tribunal Superior Eleitoral possui um repositório de dados com informações de eleições desde 1945. Dentre os dados disponibilizados, há os boletins das urnas, que possuem dados eleitorais das próprias urna. Esses dados são disponibilizados em arquivos .txt divididos por estado e possuem muitos atributos como por exemplo: Número da zona eleitoral na qual foi realizada a eleição, a seção eleitoral, quantidade de abstenções e comparecimento, além dos candidatos e o respectivo número de votos.
Diante da falta de estratificação dos resultados das eleições por bairros, foi usado esses dados para relaizar esta tarefa, a princípio, em relação aos bairros da Cidade do Recife. Como não há o atributo 'Bairro', mas há o 'Número do local de votação referente ao boletim de urna', e sabendo de antemão os bairros e seus respectivos números de votação, foi possível realizar a estratificação.
Neste projeto, foi criado a interface 'ServicoLeituraEleicoes2018' cujo papel é realizar a leitura do arquivo .txt relativo a esta eleição. Este serviço implementa uma interface chamada 'ServicoLeitura', pois os dados das diferente eleições possuem atributos que não respeitam uma determinada ordem no arquivo fornecido, dessa forma, é possível criar uma classe que realize a leitura dos dados de uma determinada eleição sem realizar alterações desnecessárias, mantendo, assim, o devido desacoplamento  entre as classes.


http://www.tse.jus.br/eleicoes/estatisticas/repositorio-de-dados-eleitorais-1/repositorio-de-dados-eleitorais
