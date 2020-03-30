package com.larkinds.aikamtest.mapper.entity;

import com.larkinds.aikamtest.dto.model.ProductDto;
import com.larkinds.aikamtest.model.Product;
import com.larkinds.aikamtest.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractMapper<Product, ProductDto> {
    private ModelMapper mapper;
    private ProductRepository productRepository;

    @Autowired
    public ProductMapper(ModelMapper mapper, ProductRepository productRepository) {
        super(Product.class, ProductDto.class);
        this.mapper = mapper;
        this.productRepository = productRepository;
    }
}
