package dev.nano.ecom.discount.infrastructure.adapters.input.rest;

import dev.nano.ecom.discount.application.ports.ProductPort;
import dev.nano.ecom.discount.domain.model.Product;
import dev.nano.ecom.discount.infrastructure.adapters.input.request.ProductRequest;
import dev.nano.ecom.discount.infrastructure.adapters.input.response.ProductResponse;
import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static dev.nano.ecom.discount.commons.constant.ProductControllerConstant.PRODUCT_API_BASE_URL;
import static dev.nano.ecom.discount.commons.constant.ProductControllerConstant.PRODUCT_DELETED_MSG;

@RestController
@RequestMapping(PRODUCT_API_BASE_URL)
@RequiredArgsConstructor
public class ProductRestControllerAdapter {

    private final ProductPort productPort;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Void> createProduct(
            @RequestBody @Valid ProductRequest createNewProductRequest
    ) {

        Product product = productMapper.toProduct(createNewProductRequest);
        productPort.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        Optional<Product> product = productPort.getProductById(id);

        if(product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ProductResponse productResponse = productMapper.toProductResponse(product.get());
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/all-products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productPort.getProducts();
        List<ProductResponse> productResponses = productMapper.toProductResponseList(products);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
        productPort.removeProduct(product);
        return new ResponseEntity<>(
                PRODUCT_DELETED_MSG,
                HttpStatus.OK
        );
    }
}
