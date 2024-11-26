package uk.co.sainsburys.interview.mapper;

import uk.co.sainsburys.interview.client.model.Product;
import uk.co.sainsburys.interview.client.model.ProductPrice;
import uk.co.sainsburys.interview.controller.response.UnifiedProduct;

/**
 * 
 * UnifiedProductMapper is responsible for mapping Product and ProductPrice 
 * objects to a UnifiedProduct Data Transfer Object (DTO).
 * 
 */
public class UnifiedProductMapper {

    public static UnifiedProduct mapToDTO(Product product, ProductPrice productPrice) {
        if (productPrice == null) {
            return null;
        }

        return new UnifiedProduct(
                product.productUid(),
                product.productType(),
                product.name(),
                product.fullUrl(),
                productPrice.unitPrice(),
                productPrice.unitPriceMeasure(),
                productPrice.unitPriceMeasureAmount()
        );
    }

}

