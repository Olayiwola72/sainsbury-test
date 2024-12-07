package uk.co.sainsburys.interview.service;

import org.springframework.stereotype.Service;
import uk.co.sainsburys.interview.client.ProductsClient;
import uk.co.sainsburys.interview.client.model.Product;
import uk.co.sainsburys.interview.client.model.ProductPrice;
import uk.co.sainsburys.interview.controller.response.UnifiedProduct;
import uk.co.sainsburys.interview.mapper.UnifiedProductMapper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * ProductService is responsible for handling product-related operations, 
 * including fetching products and their prices from the ProductsClient 
 * and applying any necessary filters.
 * 
 */
@Service
public class ProductService {

    private final ProductsClient productsClient;

    public ProductService(ProductsClient productsClient) {
        this.productsClient = productsClient;
    }

    public List<UnifiedProduct> getProducts(String typeFilter) {
        Set<Product> products = productsClient.getProducts();
        Set<ProductPrice> productPrices = productsClient.getProductsPrices();

        // Map productUid to ProductPrice
        Map<Integer, ProductPrice> priceMap = productPrices.stream()
                .collect(Collectors.toMap(ProductPrice::productUid, price -> price));

        // Merge products and prices, applying filters
        return products.stream()
                .filter(product -> typeFilter == null || typeFilter.isEmpty() || product.productType().equalsIgnoreCase(typeFilter))
                .map(product -> UnifiedProductMapper.mapToDTO(product, priceMap.get(product.productUid())))
                .filter(Objects::nonNull) // Remove entries where no matching ProductPrice exists
                .collect(Collectors.toList());
    }

}
