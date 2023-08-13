package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner{

    private CategoryRepository categoryRespository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRespository, CustomerRepository customerRepository) {
        this.categoryRespository = categoryRespository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();

    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRespository.save(fruits);
        categoryRespository.save(dried);
        categoryRespository.save(fresh);
        categoryRespository.save(exotic);
        categoryRespository.save(nuts);


        System.out.println("Category data loaded = " + categoryRespository.count() );
    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstname("Joe");
        customer1.setLastname("Newman");
        customer1.setId(1L);
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstname("Michael");
        customer2.setLastname("Lachappele");
        customer2.setId(2L);
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstname("John");
        customer3.setLastname("Doe");
        customer3.setId(3L);
        customerRepository.save(customer3);

        System.out.println("Customer data loaded = " + customerRepository.count());
    }
}
