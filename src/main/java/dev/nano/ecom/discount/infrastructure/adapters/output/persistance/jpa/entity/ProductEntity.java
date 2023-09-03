package dev.nano.ecom.discount.infrastructure.adapters.output.persistance.jpa.entity;

import dev.nano.ecom.discount.domain.enumeration.Category;
import dev.nano.ecom.discount.domain.enumeration.Manufacture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "products", schema = "public")
@Getter @Setter
@NoArgsConstructor(force = true) @AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            updatable = false,
            unique = true,
            nullable = false,
            columnDefinition = "VARCHAR(255)"
    )
    private String id;

    @Column(name = "name", nullable = false, length = 125)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturer", nullable = false)
    private Manufacture manufacture;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
