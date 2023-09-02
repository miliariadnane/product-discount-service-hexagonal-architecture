package dev.nano.ecom.discount.infrastructure.adapters.input.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@JsonInclude(NON_DEFAULT)
public record ProductResponse (String name, String description, String category, String manufacture, double price, int quantity) {
}
