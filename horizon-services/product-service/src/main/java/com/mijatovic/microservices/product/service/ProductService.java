package com.mijatovic.microservices.product.service;

import com.mijatovic.microservices.product.dto.ProductDTO;
import com.mijatovic.microservices.product.dto.mapper.ProductDTOMapper;
import com.mijatovic.microservices.product.model.Product;
import com.mijatovic.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDTOMapper productDTOMapper;
    private final ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productRequest) {
        Product product = Product.builder().name(productRequest.name()).description(productRequest.description()).price(productRequest.price()).build();
        product = productRepository.save(product);
        log.info("Product " + product.getId() + " created successfully.");
        return productDTOMapper.apply(product);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(productDTOMapper::apply).collect(Collectors.toList());
    }
}
