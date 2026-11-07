package ma.algo.billingservice.web;

import ma.algo.billingservice.entities.Bill;
import ma.algo.billingservice.feign.CustomerServiceRestClient;
import ma.algo.billingservice.feign.InventoryServiceRestClient;
import ma.algo.billingservice.models.Customer;
import ma.algo.billingservice.repository.BillRepository;
import ma.algo.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestControlller {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;
    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id){
     Bill bill =billRepository.findById(id).get();
    Customer customer =customerServiceRestClient.findByCustomerById(bill.getCustomerId());
     bill.setCustomer(customer);
     bill.getProductItems().forEach(pi ->

     {pi.setProduct(
             inventoryServiceRestClient.getProduct(pi.getProductId())
     );
     });
    return bill;
    }
}
