package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository repo;

	@Before
    public void beforeMethod() {
        Mockito.reset(repo);
       
    }
	@Test
	public void testCreateFirstrole() {
		Role roleAdmin = new Role("Admin", "Manage evrything");
		Role savedRole = repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);

	}
	

	@Test
	public void testCreateRestRoles() {
		Role roleSales = new Role("SalesPerson", "Manage product price," + "cutomer,shipping");

		Role roleEditor = new Role("RoleEditor", "Manage catogories, brands,products,articles and menu");

		Role roleShipper = new Role("Shipper", "view products, and update order status");

		Role roleAssitant = new Role("RoleAssitanat", "manage questions and reviews");

		
		
		repo.saveAll(List.of(roleAssitant,roleEditor,roleSales,roleShipper));
		
		 

		

	}
}
