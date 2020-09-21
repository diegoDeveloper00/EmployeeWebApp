'use strict';
var app = angular.module('app', [ "ngRoute" ]);
app.config(function($routeProvider,$httpProvider) {
	$routeProvider.when("/dipendenti", {
		templateUrl : "dipendenti.html",
		controller : 'DipendenteController'
	});
});