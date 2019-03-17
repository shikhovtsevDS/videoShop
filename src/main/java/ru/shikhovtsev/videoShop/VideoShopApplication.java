package ru.shikhovtsev.videoShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.shikhovtsev.videoShop.model.Product;
import ru.shikhovtsev.videoShop.repository.ProductsRepository;

@SpringBootApplication
public class VideoShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductsRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Product("F1", "First1", 10D));
            repository.save(new Product("F2", "First2", 10D));
            repository.save(new Product("F3", "First3", 12D));
            repository.save(new Product("F4", "First4", 13D));
            repository.save(new Product("F5", "First5", 14D));

            // fetch an individual customer by ID
            repository.findById(10)
                    .ifPresent(customer -> {
                        System.out.println("Yep!");
                    });

            repository.findByCost(10D).forEach(bauer -> System.out.println("Cost 10!"));
        };
    }
}
