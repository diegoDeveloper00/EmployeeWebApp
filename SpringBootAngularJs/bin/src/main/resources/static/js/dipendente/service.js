'use strict';

app.factory('DipendenteService', [
	'$http',
	'$q',
	'$location',
	'$window',
	function($http,$q,$location,$window) {

		return {
			
			insDipendente : function(dipendente) {
				return $http({
					  method: 'POST',
					  url:"http://localhost:8080/inserisci/"+dipendente,
					  headers: {
						   'Content-Type': "application/json"
						 }
					})
					.then(function(response) {
					return response.data;
				}, function(errResponse) {
					console.error('Errore Creazione dipendene');
					return $q.reject(errResponse);
				});
			},
			
			generateJWTToken : function(data,config,home){
				return $http({
					  method: 'POST',
					  url:"http://localhost:8080/authenticate",
					  headers: {
						   'Content-Type': config
						 },
					  data: JSON.stringify(data)
					})
					.then(function(response){
					$window.location.href = '/home';
						return response.data;
					}, function(errResponse){
						console.error('Errore connessione api authenticate');
						return $q.reject(errResponse);
					});
				
			},
			
			getAllDipendenti : function(authorization) {
				return $http({
						method:'GET',
						url:"http://localhost:8080/",
						headers:{
							'Authorization':"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE2MDAzNjQwMjgsImlhdCI6MTYwMDMyODAyOH0.SsL4YNcfl2VONajM3ZT3f1PAxB8aiEAOA4s5Efbl130"
						}
						})
						.then(function(response) {
							return response.data;
						}, function(errResponse) {
							console.error('Errore caricamento dipendenti ');
							return $q.reject(errResponse);
						});
			},
			
			getDipendenteById : function(idDipendente) {
				return $http({
						method:'GET',
						url:"http://localhost:8080/cerca" + idDipendente,
						headers:{
						'Authorization':"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE2MDAzNjQwMjgsImlhdCI6MTYwMDMyODAyOH0.SsL4YNcfl2VONajM3ZT3f1PAxB8aiEAOA4s5Efbl130"
						}
						})
						.then(function(response) {
							return response.data;
						}, function(errResponse) {
							console.error('Errore caricamento dipendente ' + idDipendente);
							return $q.reject(errResponse);
						});
			},
			
			deleteDipendente : function(idDipendente) {
				return $http({
					method:'DELETE',
					url:"http://localhost:8080/elimina/" + idDipendente,
					headers:{
						'Authorization':"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE2MDAzNjQwMjgsImlhdCI6MTYwMDMyODAyOH0.SsL4YNcfl2VONajM3ZT3f1PAxB8aiEAOA4s5Efbl130"
						}
						}) 
						.then(function(response) {
							return response.data;
				}, function(errResponse) {
					console.error('Errore Eliminazione dipendente ' + idDipendente);
					return $q.reject(errResponse);
				});
			},
			
			GetDettDipendente : function(dipendente) {
				return $http.get('http://localhost:8080/api/dettDipendente/dettaglio/'+ dipendente)
					.then(function(response) {
					return response.data;
				}, function(errResponse) {
					console.error('Errore caricamento dettaglio dipendente');
					return $q.reject(errResponse);
				});
			}

		};

	}]);