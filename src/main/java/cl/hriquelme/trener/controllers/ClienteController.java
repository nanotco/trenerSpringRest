package cl.hriquelme.trener.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.hriquelme.trener.entities.Cliente;
import cl.hriquelme.trener.services.ClienteService;

@Controller
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("clientes", clienteService.listAllClientes());
		System.out.println("Retornando clientes:");
		return "listaClientes";
	}

	@RequestMapping("clientes/agregar")
	public String newCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "nuevocliente";
	}

	@RequestMapping("clientes/{id}")
	public String showCliente(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente", clienteService.getClienteById(id));
		return "clientemostrar";
	}

	@RequestMapping(value = "cliente/nuevo", method = RequestMethod.POST)
	public String saveCliente(Cliente cliente) {
		clienteService.saveCliente(cliente);
		return "redirect:/clientes";
	}

	@RequestMapping("clientes/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente", clienteService.getClienteById(id));
		return "nuevocliente";
	}

	@RequestMapping("clientes/delete/{id}")
	public String delete(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
		return "redirect:/clientes";
	}

}
