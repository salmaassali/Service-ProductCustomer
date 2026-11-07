package ma.algo.billingservice.feign;

import ma.algo.billingservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customer-service", fallbackMethod="getDefeultCustomer")
    Customer findByCustomerById(@PathVariable("id") Long id);
    default Customer getDefeultCustomer(Long id, Exception exception ) {
        exception.printStackTrace();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("default customer name");
        customer.setEmail("default customer email");
        return customer;
    }
}
