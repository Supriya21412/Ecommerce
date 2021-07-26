package com.shopme.admin.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
