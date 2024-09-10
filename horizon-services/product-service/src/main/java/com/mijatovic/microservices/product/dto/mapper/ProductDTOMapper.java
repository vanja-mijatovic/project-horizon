package com.mijatovic.microservices.product.dto.mapper;

import com.mijatovic.microservices.product.dto.ProductDTO;
import com.mijatovic.microservices.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDTOMapper implements Function<Product, ProductDTO> {

    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
