'use strict'


angular.module('detailsApp').controller('dettDipendenteController',
		[
			'$scope',
			'$log',
			'dettDipendenteService'
			function($scope, $log,dettDipendenteService){
				
				$scope.dettDipendenti=[];
				
				$scope.getDettDipendenti(function(dipendente)){
					
					dettDipendenteService
					.GetDettDipendente(dipendente)
					.then(
					function(errResponse){
						console.error(errResponse);
					});
					
					$scope.prendiDettaglio=function(dipendente){
						
						$scope.getDettDipendenti(dipendente);
						
						$log.log('dettaglio dipendente: '+dipendente);
						
					}
					
					
				}
				
}]);