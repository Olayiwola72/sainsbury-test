package uk.co.sainsburys.interview.controller.response;

public record UnifiedProduct(int productUid,
                             String productType,
                             String name,
                             String fullUrl,
                             double unitPrice,
                             String unitPriceMeasure,
                             int unitPriceMeasureAmount) {
}
