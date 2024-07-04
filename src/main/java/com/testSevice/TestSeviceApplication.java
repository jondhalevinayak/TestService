package com.testSevice;

import com.testSevice.model.Book;
import com.testSevice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
public class TestSeviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestSeviceApplication.class, args);
        Object dataSource = context.getBean("dataSource");
        System.out.println("Datasource is::" + dataSource);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(Book.builder().title("Spring in action").pages(100).author("Vinayak").build());
            bookRepository.save(Book.builder().title("Kafka details").pages(200).author("Pooja").build());
        };
    }
}
