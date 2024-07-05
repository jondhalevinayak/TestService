package com.testSevice;

import com.testSevice.model.Address;
import com.testSevice.model.Book;
import com.testSevice.model.Users;
import com.testSevice.repository.BookRepository;
import com.testSevice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.HashSet;

@SpringBootApplication
public class TestSeviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestSeviceApplication.class, args);
        Object dataSource = context.getBean("dataSource");
        System.out.println("Datasource is::" + dataSource);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository, UserRepository userRepository) {
        return args -> {
            bookRepository.save(Book.builder().title("Spring in action").pages(100).author("Vinayak").build());
            bookRepository.save(Book.builder().title("Kafka details").pages(200).author("Pooja").build());

            Address address1 = Address.builder().addtressId(1).sreet1("Street one").street2("Steert two").build();
            HashSet<Address> set = new HashSet<>();
            set.add(address1);
            userRepository.save(Users.builder().user_id(1).name("Vinayak J").age(35).addresses(set).build());
        };
    }
}
