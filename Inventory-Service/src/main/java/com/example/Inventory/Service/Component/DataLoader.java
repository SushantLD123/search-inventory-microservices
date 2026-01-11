	package com.example.Inventory.Service.Component;
	
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Component;
	
	import com.example.Inventory.Service.Entity.Product;
	import com.example.Inventory.Service.Repository.ProductRepository;
	
	@Component
	public class DataLoader implements CommandLineRunner {
	
	    private final ProductRepository repo;
	
	    public DataLoader(ProductRepository repo) {
	        this.repo = repo;
	    }
	
	    @Override
	    public void run(String... args) {
	        repo.save(new Product(null, "Mouse", 25));
	        repo.save(new Product(null, "Keyboard", 45));
	        repo.save(new Product(null, "Monitor", 120));
	        repo.save(new Product(null, "USB Cable", 10));
	    }
	}
