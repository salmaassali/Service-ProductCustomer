package ma.algo.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.algo.billingservice.models.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue
    private  Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ProductItem> productItems;
    @Transient //dit au jpa ignore cette attribut
    private Customer customer;
}
