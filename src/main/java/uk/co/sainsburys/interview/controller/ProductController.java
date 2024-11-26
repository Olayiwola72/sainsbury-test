package uk.co.sainsburys.interview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.sainsburys.interview.controller.response.UnifiedProduct;
import uk.co.sainsburys.interview.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 * 
 * ProductController handles incoming HTTP requests related to products. 
 * It provides endpoints for retrieving product information, 
 * utilizing the ProductService to fetch data.
 * 
 */
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<UnifiedProduct> getProducts(@RequestParam Optional<String> type) {
        return productService.getProducts(type); // Retrieves products based on the optional type parameter
    }

}
