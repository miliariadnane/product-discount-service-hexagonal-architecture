package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.mapper;

import dev.nano.ecom.discount.domain.model.Product;
import dev.nano.ecom.discount.infrastructure.adapters.input.request.ProductRequest;
import dev.nano.ecom.discount.infrastructure.adapters.input.response.ProductResponse;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product entityToProduct(ProductEntity entity);
    ProductEntity toEntity(Product product);
    ProductResponse toProductResponse(Product product);
    Product toProduct(ProductRequest productRequest);
    List<ProductResponse> toProductResponseList(List<Product> products);

}
