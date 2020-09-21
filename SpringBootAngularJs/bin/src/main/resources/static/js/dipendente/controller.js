'use strict';

/* Controller */

angular.module('app').controller('DipendenteController',
			[
				'$scope',
				'$log',
				'$interval',
				'DipendenteService',
				function($scope, $log, $interval, DipendenteService) {
					
				$scope.dipendenti = [];
				
				$scope.index=0;
				
				

				// ******** DELETE **********
				$scope.deleteDipendente = function(idDipendente) {
					DipendenteService
							.deleteDipendente(idDipendente)
							.then(
									//OkInsEan(),
									function(errResponse) {
										console.error(errResponse);
									});
				};
				
				
				
				//******** INSERT *********
				$scope.insert = function(dipendente){
					
					DipendenteService
									.insDipendente(dipendente)
									.then(
										function(errResponse){
											console.error(errResponse);
										});
				};
				
				
				// ******** SELECT ALL **********
				$scope.selectAllDipendente = function(authorization) {
					DipendenteService
							.getAllDipendenti(authorization)
							.then(
									function(d) {
										$log.log('Caricamento Tutti i dipendenti', d);
										$scope.dipendenti = d;
										//$scope.edit(d.codart);
									},
									function(errResponse) {

										if (errResponse.status == "404") {
											
											showmsg("dipendente non Trovato");
											
										} else if (errResponse.status == "-1") {

											showmsg("Errore: Servizio non attivo o non raggiungibile!");
										}

									});
				};
				
				
				//***********Dett Dipendente*********//
				$scope.getDettDipendente=function(dipendente){
					
					DipendenteService
					.GetDettDipendente(dipendente)
					.then(
							function(di){
								$log.log('dettaglio',di);
								$scope.dettDipendenti=di;
							},
							function(errResponse){
								console.error(errResponse);
							});
					
				};

				$interval(function()
					{ 
						$scope.selectAllDipendente() 
					}, 10000);
				
				$scope.elimina = function(IdDipendente) {
					 
					$log.log('Eliminazione dipendente Id' + IdDipendente);
					
					$scope.deleteDipendente(IdDipendente);
					
					$scope.selectAllDipendente();
				};
				
				$scope.dettaglio = function(dipendente){
				
					$scope.getDettDipendente(dipendente);
					
				};
				
				$scope.inserimento = function(dipendente){
					
					$log.log('inserimento dipendente ' + dipendente);
					
					$scope.insert(dipendente);
					
					$scope.index=0;
					
					$scope.selectAllDipendente();
				
				};
				
				
				
				//STARTUP FUNCTION
				var startAction = function() {
					
					$log.log('Avvio Dipendente Controller');
					
					$scope.titolo = "Dipendenti Disponibili";
					
					$scope.nomeApp="Dipendenti Web-App";
					
					$scope.selectAllDipendente();
				};
				
				
				var init = function() {
					startAction();
					$scope.numrow = 0;
				};

				init();
				
				}]);