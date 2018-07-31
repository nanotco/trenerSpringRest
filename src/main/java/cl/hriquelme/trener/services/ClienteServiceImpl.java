package cl.hriquelme.trener.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.hriquelme.trener.entities.Cliente;
import cl.hriquelme.trener.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	@Autowired
	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<Cliente> listAllClientes() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findOne(id);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(Integer id) {
		clienteRepository.delete(id);
	}

}
