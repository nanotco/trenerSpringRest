package cl.hriquelme.trener.controllers;

import java.util.List;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.hriquelme.trener.entities.Cliente;
import cl.hriquelme.trener.services.ClienteService;

@RestController
@RequestMapping("v1/api/")
public class ClienteRestController {
	private ClienteService clienteService;

	@Autowired
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("clientes")
	public List<Cliente> listAllClientes() {
		return clienteService.listAllClientes();
	}

	@GetMapping("clientes/{id}")
	public Cliente find(@PathVariable Integer id, Model model) {
		return clienteService.getClienteById(id);
	}

	@PostMapping("clientes/nuevo")
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente) throws GenericJDBCException, ParseException {
		clienteService.saveCliente(cliente);
		return ResponseEntity.ok().body("Cliente creado");
	}

	@DeleteMapping("clientes/delete/{id}")
	public ResponseEntity<?> deleteMethod(@PathVariable("id") Integer id) throws GenericJDBCException, ParseException {
		clienteService.deleteCliente(id);
		return ResponseEntity.ok().body("Cliente eliminado");
	}

	@PatchMapping("clientes/edit/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Cliente cliente)
			throws GenericJDBCException, ParseException {
		clienteService.saveCliente(cliente);
		return ResponseEntity.ok().body("Cambio exitoso");
	}
}
