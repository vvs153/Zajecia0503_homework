package com.sda.homework0503.service;

import com.sda.homework0503.model.Product;
import com.sda.homework0503.model.dto.ProductCreateRequest;
import com.sda.homework0503.model.dto.ProductResponse;
import com.sda.homework0503.model.dto.ProductUpdateRequest;
import com.sda.homework0503.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse add(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .expDate(request.getExpDate())
                .quantity(request.getQuantity())
                .unit(request.getUnit())
                .build();
        product=productRepository.save(product);
        return ProductToProductResponseMapper(product);
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream().map(product -> ProductToProductResponseMapper(product)).toList();
    }

    private ProductResponse ProductToProductResponseMapper(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getExpDate(),
                product.getQuantity(),
                product.getUnit()
        );
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found"));
    }

    public ProductResponse update(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found"));
        if(request.getName()!=null){
            product.setName(request.getName());
        }
        if(request.getUnit()!=null){
            product.setUnit(request.getUnit());
        }
        if(request.getQuantity()!=null){
            product.setQuantity(request.getQuantity());
        }
        product = productRepository.save(product);
        return ProductToProductResponseMapper(product);
    }
}
