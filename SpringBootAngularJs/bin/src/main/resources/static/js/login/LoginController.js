angular.module('app')
.controller('LoginController',[
	'$scope',
	'$log',
	'DipendenteService',
	function($scope,$log,DipendenteService){
		
		$scope.data=[];
		
		$scope.config="";
		
		$scope.getJWT= function(data,config,home){
			DipendenteService
					  .generateJWTToken(data,config,home)
					  .then(
								function(errResponse) {
									console.error(errResponse);
								}); 
		};
	
	
		$scope.JWToken = function(data,config,home){
			$scope.getJWT(data,config,home);
		};
	
	
	
	}])