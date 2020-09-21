'use strict'


MyApp.factory('dettDipendenteService',[
	'$http',
	'$q',
	function($http,$q){
			return {
			
			GetDettDipendenti : function() {
				return $http.get('http://localhost:8080/api/dettDipendente')
					.then(function(response) {
					return response.data;
				}, function(errResponse) {
					console.error('Errore caricamento dettaglio dipendente');
					return $q.reject(errResponse);
				});
			};
		
		
}]);