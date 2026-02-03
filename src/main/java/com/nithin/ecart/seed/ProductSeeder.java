package com.nithin.ecart.seed;

import com.nithin.ecart.entity.Product;
import com.nithin.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count()==0){
            List<Product> demoProducts = List.of(
                    new Product(null, "Apple iPhone 17", 799.0, "Latest Apple Smartphone",
                            "Smartphones", 4.8, "Amazon", 5, List.of("/products/1.jfif")),

                    new Product(null, "Samsung Galaxy S25", 749.0, "Flagship Android Phone",
                            "Smartphones", 4.7, "Flipkart", 8, List.of("/products/2.jfif")),

                    new Product(null, "Google Pixel 9", 699.0, "Pure Android Experience",
                            "Smartphones", 4.6, "Amazon", 6, List.of("/products/3.jfif")),

                    new Product(null, "OnePlus 13", 649.0, "High Performance Phone",
                            "Smartphones", 4.5, "OnePlus Store", 10, List.of("/products/4.jfif")),

                    new Product(null, "Xiaomi Mi 15", 599.0, "Value for Money Smartphone",
                            "Smartphones", 4.4, "Mi Store", 12, List.of("/products/5.jfif")),

                    new Product(null, "MacBook Pro M4", 1999.0, "Apple Silicon Laptop",
                            "Laptops", 4.9, "Apple Store", 4, List.of("/products/6.jfif")),

                    new Product(null, "Dell XPS 15", 1799.0, "Premium Windows Laptop",
                            "Laptops", 4.7, "Dell", 7, List.of("/products/7.jfif")),

                    new Product(null, "HP Spectre x360", 1699.0, "2-in-1 Convertible Laptop",
                            "Laptops", 4.6, "HP Store", 6, List.of("/products/8.jfif")),

                    new Product(null, "Lenovo ThinkPad X1", 1899.0, "Business Class Laptop",
                            "Laptops", 4.8, "Lenovo", 5, List.of("/products/9.jfif")),

                    new Product(null, "Asus ROG Strix", 1599.0, "High-End Gaming Laptop",
                            "Gaming", 4.5, "Amazon", 9, List.of("/products/10.jfif")),

                    new Product(null, "Apple Watch Series 10", 499.0, "Smart Fitness Watch",
                            "Wearables", 4.8, "Apple Store", 15, List.of("/products/11.jfif")),

                    new Product(null, "Samsung Galaxy Watch 7", 449.0, "Android Smart Watch",
                            "Wearables", 4.6, "Samsung", 20, List.of("/products/12.jfif")),

                    new Product(null, "Sony WH-1000XM6", 399.0, "Noise Cancelling Headphones",
                            "Audio", 4.9, "Amazon", 18, List.of("/products/13.jfif")),

                    new Product(null, "Bose QuietComfort Ultra", 429.0, "Premium ANC Headphones",
                            "Audio", 4.7, "Flipkart", 14, List.of("/products/14.jfif")),

                    new Product(null, "JBL Charge 6", 199.0, "Portable Bluetooth Speaker",
                            "Audio", 4.4, "Amazon", 25, List.of("/products/15.jfif")),

                    new Product(null, "Apple iPad Pro M3", 1099.0, "Professional Tablet",
                            "Tablets", 4.8, "Apple Store", 11, List.of("/products/16.jfif")),

                    new Product(null, "Samsung Galaxy Tab S9", 899.0, "Android Tablet",
                            "Tablets", 4.6, "Samsung", 13, List.of("/products/17.jfif")),

                    new Product(null, "Logitech MX Master 4", 129.0, "Advanced Wireless Mouse",
                            "Accessories", 4.7, "Amazon", 30, List.of("/products/18.jfif")),

                    new Product(null, "Keychron K Pro", 149.0, "Mechanical Keyboard",
                            "Accessories", 4.5, "Keychron", 22, List.of("/products/19.jfif")),

                    new Product(null, "Canon EOS R10", 999.0, "Mirrorless Camera",
                            "Cameras", 4.6, "Canon Store", 6, List.of("/products/20.jfif"))
            );
            productRepository.saveAll(demoProducts);
            System.out.println("Seeded Demo Products");
        }
        else{
            System.out.println("Product Already Exists");
        }
    }
}
