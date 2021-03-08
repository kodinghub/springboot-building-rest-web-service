package net.codinghub.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.codinghub.restservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	// CRUD refers Create, Read, Update, Delete
}
