var banqueApp = angular.module('banqueApp', []);


banqueApp.controller('banqueCtrl', ['$http', '$scope', function($http, $scope) {
	$scope.comptes = null;
	$scope.compte = null;
	$scope.montant = 0;
	
     	
    $scope.reset = function () {
  		$scope.compte = null;
  		$scope.comptes = $scope.getComptes();
  		$scope.montant = 0;
   };
       
       
	$scope.getCompte = function(numero) {
		$scope.comptes = null;
		$http.get('http://localhost:8080/rest/compte/'+ numero).then(function(value) {
			$scope.compte=value.data;
			console.log(value.data);
		}, function(reason) {
			//en cas de réponse en erreur reason contient l'erreur ....
			console.log(reason);
			
		}, function(value) {
			//optionnel ... ne sert à rien ici ... !
		});
	};
	$scope.getComptes = function() {
		$scope.compte = null;
		$http.get('http://localhost:8080/rest/compte').then(function(value) {
			$scope.comptes=value.data;
			console.log(value.data);
		}, function(reason) {
			//en cas de réponse en erreur reason contient l'erreur ....
			console.log(reason);
			
		}, function(value) {
			//optionnel ... ne sert à rien ici ... !
		});
	};
	
	
	$scope.operation = function(montant, operation) {
		$http.put('http://localhost:8080/rest/compte/'
				+ $scope.compte.numero 
				+'?montant=' + montant + '&operation=' + operation)
				.then(function(value) {
					$scope.compte=value.data;}
					, function(reason) {}
					, function(value) {}
				)
	}; 
  }]);
