package com.cs370.springdemo;

import com.cs370.springdemo.model.Store;
import com.cs370.springdemo.repository.FakeStoreRepository;
import com.cs370.springdemo.service.CustomerService;
import com.cs370.springdemo.service.StoreService;
import com.cs370.springdemo.model.Customer;
import com.cs370.springdemo.model.CustomerType;
import com.cs370.springdemo.repository.FakeStoreRepository;
import com.cs370.springdemo.service.StoreService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "basicAuth",
        scheme = "basic")
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(StoreService storeService, CustomerService customerService) {
        return args -> {
            storeService.insert(new Store("1", "addr1", "desc1"));
            storeService.insert(new Store("2", "addr2", "desc2"));
            storeService.insert(new Store("3", "addr3", "desc3"));
            customerService.insert(new Customer("1", "fname1", "lname1", CustomerType.registered, "email1", "addr1"));
            customerService.insert(new Customer("2", "fname2", "lname2", CustomerType.registered, "email2", "addr2"));
            customerService.insert(new Customer("3", "fname3", "lname3", CustomerType.guest, "email3", "addr3"));
        };
    }

}
