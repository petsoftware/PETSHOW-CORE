package br.com.petshow.core.jobs;

import java.util.Arrays;
import java.util.List;


public class JobCadMunicipiosParaiba {
	
	
	public static List<String> getMunicipios() {
		List<String> municipios = Arrays.asList(	
				"1|   João Pessoa ",
				"2|   Campina Grande ",
				"4|  Santa Rita ",
				"5|  Patos ",
				"7|  Bayeux ",
				"8|  Sousa ",
				"9|  Cabedelo ",
				"10 |Cajazeiras ",
				"11 |Guarabira ",
				"12 |Sapé ",
				"14 |Mamanguape ",
				"15 |Queimadas ",
				"16 |São Bento ",
				"17 |Monteiro ",
				"18 |Esperança ",
				"19 |Pombal ",
				"20 |Catolé do Rocha ",
				"21 |Alagoa Grande ",
				"22 |Pedras de Fogo ",
				"23 |Lagoa Seca ",
				"24 |Solânea ",
				"25 |Itaporanga ",
				"26 |Itabaiana ",
				"27 |Conde ",
				"28 |Rio Tinto ",
				"29 |Princesa Isabel ",
				"30 |Areia ",
				"31 |Mari ",
				"32 |Caaporã ",
				"33 |Bananeiras ",
				"34 |Alagoa Nova ",
				"35 |Cuité ",
				"36 |Araruna ",
				"37 |São José de Piranhas ",
				"39 |Alhandra ",
				"40 |Remígio ",
				"41 |Aroeiras ",
				"42 |Pitimbu ",
				"43 |Conceição ",
				"44 |Picuí ",
				"45 |Itapororoca ",
				"46 |Pocinhos ",
				"47 |Ingá ",
				"48 |Juazeirinho ",
				"49 |São João do Rio do Peixe ",
				"51 |Boqueirão ",
				"52 |Belém ",
				"53 |Cruz do Espírito Santo ",
				"54 |Cacimba de Dentro ",
				"55 |Araçagi ",
				"56 |Sumé ",
				"57 |Piancó ",
				"58 |Coremas ",
				"59 |Santa Luzia ",
				"60 |Uiraúna ",
				"61 |Barra de Santa Rosa ",
				"62 |Taperoá ",
				"63 |Teixeira ",
				"64 |Soledade ",
				"65 |Tavares ",
				"66 |Alagoinha ",
				"67 |Jacaraú ",
				"68 |Gurinhém ",
				"69 |Brejo do Cruz ",
				"70 |Massaranduba ",
				"71 |Puxinanã ",
				"72 |Serra Branca ",
				"73 |Arara ",
				"74 |Mogeiro ",
				"75 |Lucena ",
				"76 |Paulista ",
				"77 |Salgado de São Félix ",
				"78 |Pilar ",
				"79 |Bonito de Santa Fé ",
				"80 |Imaculada ",
				"81 |São Sebastião de Lagoa de Roça ",
				"82 |Fagundes ",
				"83 |Manaíra ",
				"84 |São Vicente do Seridó ",
				"85 |Tacima ",
				"86 |Itatuba ",
				"87 |Juripiranga ",
				"88 |Nova Floresta ",
				"89 |Pirpirituba ",
				"91 |Natuba ",
				"92 |Dona Inês ",
				"93 |Cachoeira dos Índios ",
				"94 |Água Branca ",
				"96 |Umbuzeiro ",
				"97 |Mulungu ",
				"98 |Juru ",
				"99 |Triunfo ",
				"100|Baía da Traição ",
				"101|Riacho dos Cavalos ",
				"102|Marcação ",
				"103|Gado Bravo ",
				"104|Aparecida ",
				"105|Mataraca ",
				"106|Desterro ",
				"107|Barra de Santana ",
				"108|Pedra Lavrada ",
				"109|Juarez Távora ",
				"110|Sobrado ",
				"111|São Mamede ",
				"112|Jericó ",
				"113|São José da Lagoa Tapada ",
				"114|Lagoa de Dentro ",
				"115|Casserengue ",
				"116|Livramento ",
				"117|Belém do Brejo do Cruz ",
				"118|Nazarezinho ",
				"119|Caiçara ",
				"120|Cubati ",
				"121|Cacimbas ",
				"122|São Miguel de Taipu ",
				"123|Junco do Seridó ",
				"124|Santana dos Garrotes ",
				"125|Serra Redonda ",
				"126|Boa Vista ",
				"127|Areial ",
				"128|Cuitegi ",
				"129|Condado ",
				"130|Pilões ",
				"131|Santa Cruz ",
				"132|Olho d'Água ",
				"133|Diamante ",
				"134|Santa Cecília ",
				"135|Marizópolis ",
				"136|Matureia ",
				"137|Capim ",
				"138|Brejo dos Santos ",
				"139|Cuité de Mamanguape ",
				"140|São José de Caiana ",
				"141|Igaracy ",
				"142|Serraria ",
				"143|Pedro Régis ",
				"144|Camalaú ",
				"145|Caldas Brandão ",
				"146|Nova Olinda ",
				"147|Ibiara ",
				"148|Barra de São Miguel ",
				"149|São José dos Ramos ",
				"150|Santa Helena ",
				"151|Malta ",
				"152|Montadas ",
				"153|Aguiar ",
				"154|Cabaceiras ",
				"155|Alcantil ",
				"156|Boa Ventura ",
				"157|Borborema ",
				"158|Vieirópolis ",
				"159|Damião ",
				"160|Curral de Cima ",
				"161|Santana de Mangueira ",
				"162|Pilõezinhos ",
				"163|Bom Sucesso ",
				"164|Sertãozinho ",
				"165|Catingueira ",
				"166|Nova Palmeira ",
				"167|Baraúna ",
				"168|Caturité ",
				"169|Monte Horebe ",
				"170|Congo ",
				"171|Lagoa ",
				"172|São José de Espinharas ",
				"173|Santa Teresinha ",
				"174|Matinhas ",
				"175|Riachão do Bacamarte ",
				"176|São Bentinho ",
				"177|Riachão do Poço ",
				"178|São João do Tigre ",
				"179|São João do Cariri ",
				"180|Logradouro ",
				"181|Poço de José de Moura ",
				"182|Prata ",
				"183|Caraúbas ",
				"184|São José do Sabugi ",
				"185|Mãe d'Água ",
				"186|Salgadinho ",
				"187|Olivedos ",
				"188|São José de Princesa ",
				"189|Assunção ",
				"190|Pedra Branca ",
				"191|Vista Serrana ",
				"192|Poço Dantas ",
				"193|Cacimba de Areia ",
				"194|São José dos Cordeiros ",
				"195|Duas Estradas ",
				"196|Santa Inês ",
				"197|Riachão ",
				"198|São José do Bonfim ",
				"199|Sossêgo ",
				"200|Emas ",
				"201|São Sebastião do Umbuzeiro ",
				"202|Gurjão ",
				"203|Bernardino Batista ",
				"204|São Francisco ",
				"205|Cajazeirinhas ",
				"206|Serra da Raiz ",
				"207|São Domingos ",
				"208|Serra Grande ",
				"209|Tenório ",
				"210|Ouro Velho ",
				"211|Frei Martinho ",
				"212|Mato Grosso ",
				"213|Várzea ",
				"214|Lastro ",
				"215|Joca Claudino ",
				"216|Carrapateira ",
				"217|São Domingos do Cariri ",
				"218|Bom Jesus ",
				"219|Santo André ",
				"220|Curral Velho ",
				"221|Algodão de Jandaíra ",
				"222|Passagem ",
				"223|Amparo ",
				"224|Zabelê ",
				"225|Areia de Baraúnas ",
				"226|Riacho de Santo Antônio ",
				"227|Quixaba ",
				"228|Coxixola ",
				"229|São José do Brejo do Cruz ",
				"230|Parari "
				
				
		);
		return municipios;
	}
	

}


