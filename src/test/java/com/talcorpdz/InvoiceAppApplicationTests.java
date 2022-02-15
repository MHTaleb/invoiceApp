package com.talcorpdz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest;

import com.talcorpdz.domain.Tva;
import com.talcorpdz.repository.TvaRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class InvoiceAppApplicationTests {

	@Autowired
	TvaRepository repo;
	
	@BeforeAll
	 public void setUp() throws Exception {
        repo.save(new Tva(10L, "BMAL0", "BMAL0", 1D));
        repo.save(new Tva(20L, "AMAL1", "AMAL1", 3D));
        repo.save(new Tva(30L, "AMAL2", "AMAL2", 7D));
    }
	
	@Test
	void contextLoads() {
		 assertThat(repo.findAll()).isNotEmpty();
		 System.out.println(repo.findByRateBetweenOrderByNameAsc(0D, 5D));
		 assertThat(repo.findAll().get(0).getName()).isEqualTo("BMAL0");
	}

}
