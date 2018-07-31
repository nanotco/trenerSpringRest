package cl.hriquelme.trener.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.hriquelme.trener.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
}
