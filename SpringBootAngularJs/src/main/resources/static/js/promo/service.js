'use strict';

MyApp.factory('PromoService', [
	'$http',
	'$q',
	function($http, $q) {

		return {
			
			InsPromo : function(promo) {
				return $http.post('http://localhost:8080/promo/inserisci', promo)
					.then(function(response) {
					return response.data;
				}, function(errResponse) {
					console.error('Errore Creazione Promozione');
					return $q.reject(errResponse);
				});
			},
			
			SelAllPromo : function() {
				return $http.get('http://localhost:8080/api/promo')
						.then(function(response) {
							return response.data;
						}, function(errResponse) {
							console.error('Errore caricamento Promo ');
							return $q.reject(errResponse);
						});
			},
			
			SelPromo : function(idPromo) {
				return $http
						.get('http://localhost:8080/promo/cerca/' + idPromo)
						.then(function(response) {
							return response.data;
						}, function(errResponse) {
							console.error('Errore caricamento Promo ' + idPromo);
							return $q.reject(errResponse);
						});
			},
			
			DelPromo : function(idPromo) {
				return $http.delete('http://localhost:8080/api/promo/elimina/' + idPromo)
						.then(function(response) {
							return response.data;
				}, function(errResponse) {
					console.error('Errore Eliminazione Promo ' + idPromo);
					return $q.reject(errResponse);
				});
			},
			
			DelDettPromo : function(idRow) {
				return $http.delete('http://localhost:8080/dettpromo/elimina/' + idRow)
						.then(function(response) {
							return response.data;
				}, function(errResponse) {
					console.error('Errore Eliminazione Riga Promo ' + idRow);
					return $q.reject(errResponse);
				});
			}
		};

	}]);