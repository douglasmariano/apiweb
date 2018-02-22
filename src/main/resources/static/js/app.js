//criação do modulo principal da aplicaçã
var appCliente = angular.module("appCliente", []);

// criação e controller
appCliente.controller("indexController", function($scope, $http) {

	$scope.clientes = [];
	$scope.cliente = {};

	$scope.carregarClientes = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:3000/clientes'
		}).then(function(response) {
			$scope.clientes = response.data;
			console.log(response.data);
			console.log(response.status);

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.salvarCliente = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:3000/clientes',
			data : $scope.cliente
		}).then(function(response) {
			$scope.clientes.push(response.data);

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.excluirCliente = function(cliente) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:3000/clientes/' + cliente.id
		}).then(function(response) {

			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.alterarCliente = function(cliente) {
		$scope.cliente = angular.copy(cliente);
	};
	$scope.cancelarAlteraCliente = function(cliente) {
		$scope.cliente = {};
	};
	$scope.carregarClientes();

});
