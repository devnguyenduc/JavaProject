package com.coindesk.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("user")
public interface UsersRepository extends CrudRepository<User, String> {

}
