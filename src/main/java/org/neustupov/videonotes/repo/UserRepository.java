package org.neustupov.videonotes.repo;

import org.neustupov.videonotes.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
