package ma.algo.inventoryservice;

import ma.algo.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.algo.inventoryservice.entities.Product;
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
 @Bean
  CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(3500)
                    .quantity(15)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart phone")
                    .price(5000)
                    .quantity(15)
                    .build());
            productRepository.save(Product.builder()
                    .name(" Printer")
                    .price(1200)
                    .quantity(15)
                    .build());
        };
  }
}
