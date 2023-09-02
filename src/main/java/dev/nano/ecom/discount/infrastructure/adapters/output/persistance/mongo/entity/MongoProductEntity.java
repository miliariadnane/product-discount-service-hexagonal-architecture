package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.mongo.entity;

import dev.nano.ecom.discount.domain.enumeration.Category;
import dev.nano.ecom.discount.domain.enumeration.Manufacture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(force = true) @AllArgsConstructor
@Document(collection = "products")
public class MongoProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private Category category;
    private Manufacture manufacture;
    private double price;
    private int quantity;
}
