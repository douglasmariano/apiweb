package br.com.dmariano.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dmariano.ws.model.Cliente;
import br.com.dmariano.ws.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// EndPoints
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrar = clienteService.cadastrar(cliente);

		System.out.println("Chamou /clientes!");
		return new ResponseEntity<Cliente>(clienteCadastrar, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();
		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> excluirClientes(@PathVariable Integer id) {

		Cliente clientesEncontrador = clienteService.buscarPorId(id);
		if (clientesEncontrador == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.excluir(clientesEncontrador);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.alterar(cliente);
		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}
}
