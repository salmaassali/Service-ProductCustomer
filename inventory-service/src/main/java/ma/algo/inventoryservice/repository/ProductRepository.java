package ma.algo.inventoryservice.repository;

import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ma.algo.inventoryservice.entities.Product;
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

}
