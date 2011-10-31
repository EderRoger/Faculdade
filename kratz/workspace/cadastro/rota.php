<?php
$origem = array (1 => 1, 1, 2, 2, 2, 3, 4, 4, 5 );
$destino = array (1 => 2, 3, 3, 4, 5, 5, 6, 5, 6 );
$custo = array (1 => 1, 3, 1, 2, 3, 2, 3, - 3, 2 );
$nos = 6;
$narcos = 9;

// Define o infinito como sendo a soma de todos os custos
$infinito = array_sum ( $custo );

// Imprimindo origem destino e custo
echo utf8_decode ( "Grafo:<br>" );

for($i = 1; $i <= count ( $origem ); $i ++) {
	echo utf8_decode ( "$origem[$i] $destino[$i] $custo[$i]<br>" );
}

// ------ Passo inicial


// Seta os valores de T
for($i = 1; $i <= 6; $i ++) {
	if ($i == 1) {
		$t [$i] = $i;
	} else {
		$t [$i] = "nulo";
	}
}

// Seta os valores de V
for($i = 1; $i <= 6; $i ++) {
	if ($i == 1) {
		$v [$i] = "nulo";
	} else {
		$v [$i] = $i;
	}
}

echo utf8_decode ( "Início" );
echo utf8_decode ( "<br> T: " );
print_r ( $t );
echo utf8_decode ( "<br> V: " );
print_r ( $v );
echo utf8_decode ( "<br>" );

// ------ Fim do passo inicial
$total_nos = count ( $origem );
for($x = 1; $x <= ($nos - 1); $x ++) {
	// Verifica origem -> destino
	$minimo1 = $infinito;
	for($i = 1; $i <= $narcos; $i ++) {
		for($j = 1; $j <= $nos; $j ++) {
			if ($origem [$i] == $t [$j]) {
				for($k = 1; $k <= $nos; $k ++) {
					if ($destino [$i] == $v [$k]) {
						if ($custo [$i] < $minimo1) {
							$minimo1 = $custo [$i];
							$aux1 = $i;
						}
					}
				}
			}
		}
	}
	
	// Verifica destino -> origem
	$minimo2 = $infinito;
	for($i = 1; $i <= $narcos; $i ++) {
		for($j = 1; $j <= $nos; $j ++) {
			if ($destino [$i] == $t [$j]) {
				for($k = 1; $k <= $nos; $k ++) {
					if ($origem [$i] == $v [$k]) {
						if ($custo [$i] < $minimo2) {
							$minimo2 = $custo [$i];
							$aux2 = $i;
						}
					}
				}
			}
		}
	}
	
	if ($minimo2 < $minimo1) {
		$cont = 1;
		$minimo = $minimo1;
		$aux = $aux1;
		echo utf8_decode ( "<br> Aresta ($origem[$aux],$destino[$aux]) escolhida de custo $custo[$aux]" );
	} else {
		$minimo = $minimo2;
		$aux = $aux2;
		echo utf8_decode ( "<br> Aresta ($destino[$aux],$origem[$aux]) escolhida de custo $custo[$aux]" );
		$cont = 2;
	}
	if ($cont == 1) {
		$t [$destino [$aux]] = $destino [$aux];
		$v [$destino [$aux]] = "nulo";
	} else {
		$t [$origem [$aux]] = $origem [$aux];
		$v [$origem [$aux]] = "nulo";
	}
	
	echo utf8_decode ( "<br> " . $x . "° iteração" );
	echo utf8_decode ( "<br> T: " );
	print_r ( $t );
	echo utf8_decode ( "<br> V: " );
	print_r ( $v );
}