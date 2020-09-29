package org.neustupov.videonotes.repo;

import org.neustupov.videonotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
