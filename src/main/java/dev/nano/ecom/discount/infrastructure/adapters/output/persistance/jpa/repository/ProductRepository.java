package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.repository;

import dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
