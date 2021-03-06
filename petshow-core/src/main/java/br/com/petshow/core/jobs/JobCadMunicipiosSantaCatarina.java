package br.com.petshow.core.jobs;

import java.util.Arrays;
import java.util.List;


public class JobCadMunicipiosSantaCatarina {
	
	
	public static List<String> getMunicipios() {
		List<String> municipios = Arrays.asList(	
				"1|   Joinville",
				"2|   Florianópolis",
				"3|   Blumenau",
				"4|   São José",
				"5|    Chapecó",
				"6|   Criciúma",
				"7|   Itajaí",
				"8|   Jaraguá do Sul",
				"9|   Palhoça",
				"10|  Lages",
				"11|   Balneário Camboriú",
				"12|  Brusque",
				"13|   Tubarão",
				"14|   São Bento do Sul",
				"15|   Camboriú",
				"16|  Caçador",
				"17|   Navegantes",
				"18|   Concórdia",
				"19|   Rio do Sul",
				"20|   Araranguá",
				"21|   Gaspar",
				"22|   Biguaçu",
				"23|   Indaial",
				"24|   Itapema",
				"25|   Mafra",
				"26|   Canoinhas",
				"27|   Içara",
				"28|   Videira",
				"29|   São Francisco do Sul",
				"30|   Xanxerê",
				"31|   Laguna",
				"32|   Imbituba",
				"33|   Timbó",
				"34|   Guaramirim",
				"35|   Rio Negrinho",
				"36|   Curitibanos",
				"37|   São Miguel do Oeste",
				"38|   Tijucas",
				"39|   Fraiburgo",
				"40|   Campos Novos",
				"41|   Porto União",
				"42|   São João Batista",
				"43|   Araquari",
				"44|   Braço do Norte",
				"45|   Pomerode",
				"46|   Penha",
				"47|   Sombrio",
				"48|   Joaçaba",
				"49|   Xaxim",
				"51|   Barra Velha",
				"52|   São Joaquim",
				"53|   Forquilhinha",
				"54|   Maravilha",
				"55|   Ituporanga",
				"56|   Capivari de Baixo",
				"57|   São Lourenço do Oeste",
				"58|   Orleans",
				"59|   Capinzal",
				"60|   Herval d'Oeste",
				"61|   Santo Amaro da Imperatriz",
				"62|   Guabiruba",
				"63|   Garopaba",
				"64|   Itaiópolis",
				"65|   Balneário Piçarras",
				"66|   Urussanga",
				"67|   Porto Belo",
				"68|   Schroeder",
				"69|   Jaguaruna",
				"70|   Pinhalzinho",
				"71|   Três Barras",
				"72|   Papanduva",
				"73|   Itapoá",
				"74|   Ibirama",
				"75|   Taió",
				"76|   Otacílio Costa",
				"77| Bombinhas",
				"78|   Abelardo Luz",
				"79|   Seara",
				"80|   Morro da Fumaça",
				"81|   Garuva",
				"82|   Presidente Getúlio",
				"83|   Pouso Redondo",
				"84|   Santa Cecília",
				"85|   Itapiranga",
				"86|   Cocal do Sul",
				"87|   Palmitos",
				"88|   Massaranduba",
				"89|   Dionísio Cerqueira",
				"91|   Corupá",
				"92|   Lauro Müller",
				"93|   Nova Veneza",
				"94|   Governador Celso Ramos",
				"95|   São José do Cedro",
				"96|   Nova Trento",
				"97|   Siderópolis",
				"98|   Ilhota",
				"99|   Correia Pinto",
				"100|  São Ludgero",
				"101|  Turvo",
				"102|Balneário Rincão",
				"103|  Luiz Alves",
				"104|  Lebon Régis",
				"105|  Campo Alegre",
				"106|Sangão",
				"107|Balneário Arroio do Silva",
				"108|  Canelinha",
				"109|  Lontras",
				"110|  Ponte Serrada",
				"111|  Rodeio",
				"112|  Mondaí",
				"113|  Gravatal",
				"114|  Benedito Novo",
				"115|  Rio dos Cedros",
				"116|  Urubici",
				"117|  Irineópolis",
				"118|  São Carlos",
				"119|  Cunha Porã",
				"120|  Faxinal dos Guedes",
				"121|  Imaruí",
				"122|  Jacinto Machado",
				"123|  Catanduvas",
				"124|  Apiúna",
				"125|  Agrolândia",
				"126|  Guaraciaba",
				"127|  Irani",
				"128|  Coronel Freitas",
				"129|Balneário Gaivota",
				"130|  Quilombo",
				"131|Balneário Barra do Sul",
				"132|Pescaria Brava",
				"133|  Alfredo Wagner",
				"134|  Monte Carlo",
				"135|  Bom Retiro",
				"136|  Saudades",
				"137|  São Domingos",
				"138|  Campo Erê",
				"139|Iporã do Oeste",
				"140|Santa Terezinha",
				"141|  Tangará",
				"142|  São José do Cerrito",
				"143|  Monte Castelo",
				"144|  Descanso",
				"145|  Armazém",
				"146|Santa Rosa do Sul",
				"147|  Antônio Carlos",
				"148|Passo de Torres",
				"149|  Major Vieira",
				"150|  Ascurra",
				"151|  Anita Garibaldi",
				"152|Timbó Grande",
				"153|  Salete",
				"154|  Palma Sola",
				"155|  Ipumirim",
				"156|  Rio do Oeste",
				"157|  Treze Tílias",
				"158|  Ouro",
				"159|  Praia Grande",
				"160|Ipuaçu",
				"161|  Paulo Lopes",
				"162|  São João do Sul",
				"163|  Campo Belo do Sul",
				"164|  Água Doce",
				"165|  Trombudo Central",
				"166|  Treze de Maio",
				"167|  Meleiro",
				"168|  Maracajá",
				"169|  Laurentino",
				"170|  Grão Pará",
				"171|  Águas de Chapecó",
				"172|  Vidal Ramos",
				"173|  Itá",
				"174|  São João do Oeste",
				"175|Bela Vista do Toldo",
				"176|Rio das Antas",
				"177|  Caibi",
				"178|  Águas Mornas",
				"179|  Imbuia",
				"180|  Rio do Campo",
				"181|  Petrolândia",
				"182|  Anchieta",
				"183|Luzerna",
				"184|Aurora",
				"185|  São Pedro de Alcântara",
				"186|São Cristóvão do Sul",
				"187|  Timbé do Sul",
				"188|  Agronômica",
				"189|  Romelândia",
				"190|  Guarujá do Sul",
				"191|Vitor Meireles",
				"192|  Botuverá",
				"193|  Angelina",
				"194|José Boiteux",
				"195|  Nova Erechim",
				"196|  Ponte Alta",
				"197|  Guatambu",
				"198|Riqueza",
				"199|  Bom Jardim da Serra",
				"200|Vargem Bonita",
				"201|Lindóia do Sul",
				"202|  Salto Veloso",
				"203|Tunápolis",
				"204|  Ipira",
				"205|  Rio Fortuna",
				"206|  Erval Velho",
				"207|Nova Itaberaba",
				"208|Passos Maia",
				"209|Arabutã",
				"210|Cordilheira Alta",
				"211|  Piratuba",
				"212|  Modelo",
				"213|Iraceminha",
				"214|  Pedras Grandes",
				"215|  Dona Emma",
				"216|  Xavantina",
				"217|  Jaborá",
				"218|Doutor Pedrinho",
				"219|  Caxambu do Sul",
				"220|  Witmarsum",
				"221|Saltinho",
				"222|Treviso",
				"223|Paraíso",
				"224|Braço do Trombudo",
				"225|São João do Itaperiú",
				"226|  Vargeão",
				"227|  Arroio Trinta",
				"228|Bocaina do Sul",
				"229|  Pinheiro Preto",
				"230|  Major Gercino",
				"231|Ponte Alta do Norte",
				"232|Calmon",
				"233|Cerro Negro",
				"234|Serra Alta",
				"235|  Ibicaré",
				"236|  Atalanta",
				"237|Zortéa",
				"238|  Anitápolis",
				"239|  São Martinho",
				"240|  Leoberto Leal",
				"241|Entre Rios",
				"242|Galvão",
				"243|  Chapadão do Lageado",
				"244|  São Bonifácio",
				"245|  Morro Grande",
				"246|Iomerê",
				"247|Princesa",
				"248|  Peritiba",
				"249|  Bom Jesus",
				"250|  Rancho Queimado",
				"251|Planalto Alegre",
				"252|Bandeirante",
				"253|Celso Ramos",
				"254|Belmonte",
				"255|  Matos Costa",
				"256|União do Oeste",
				"257|Capão Alto",
				"258|Abdon Batista",
				"259|Santa Terezinha do Progresso",
				"260|Brunópolis",
				"270|Sul Brasil",
				"271|Vargem",
				"272|Novo Horizonte",
				"273|Formosa do Sul",
				"274|Palmeira",
				"275|Coronel Martins",
				"276|São Bernardino",
				"277|Urupema",
				"278|Rio Rufino",
				"279|Mirim Doce",
				"280|Águas Frias",
				"281|Painel",
				"282|  Presidente Nereu",
				"283|Santa Helena",
				"284|Arvoredo",
				"285|Ouro Verde",
				"286|  Lacerdópolis",
				"287|Frei Rogério",
				"288|Bom Jesus do Oeste",
				"289|Jupiá",
				"290|  Santa Rosa de Lima",
				"291|Ermo",
				"292|Irati",
				"293|  Alto Bela Vista",
				"294|Ibiam",
				"295|Marema",
				"296|Cunhataí",
				"297|São Miguel da Boa Vista",
				"298|Macieira",
				"299|Barra Bonita",
				"300|Tigrinhos",
				"301|Jardinópolis",
				"302|Presidente Castello Branco",
				"303|Paial",
				"304|Flor do Sertão",
				"305|Lajeado Grande",
				"306|Santiago do Sul                        "
				
		);
		return municipios;
	}
	

}


