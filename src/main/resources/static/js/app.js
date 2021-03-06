//criação do modulo principal da aplicaçã
var appCliente = angular.module("appCliente", [ 'ngRoute' ]);

appCliente.config(function($routeProvider,$locationProvider) {

	$routeProvider
	.when("/clientes", {templateUrl : 'view/cliente.html', controller : 'clienteController'})
	.when("/clientes/:clienteId", {templateUrl : 'view/cliente-detalhe.html', controller : 'clienteDetalheController'})
	.when("/cidades", {templateUrl : 'view/cidade.html', controller : 'cidadeController'})
	.when("/estados", {templateUrl : 'view/estado.html', controller : 'estadoController'})
	.otherwise({
		redirectTo : '/'
	});
	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
	console.log("teste");

});
// criação e controller
