package cl.hriquelme.trener.services;

import java.util.List;

import cl.hriquelme.trener.entities.Cliente;

public interface ClienteService {

	public List<Cliente> listAllClientes();

	public Cliente getClienteById(Integer id);

	public Cliente saveCliente(Cliente cliente);

	public void deleteCliente(Integer id);

}
