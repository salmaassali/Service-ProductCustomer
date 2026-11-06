package ma.algo.billingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem  {
    @Id
    @GeneratedValue
    private Long id;
    private  Long productId;
    private int quantity;
    private double price;
    @ManyToOne
    private Bill bill;
}
