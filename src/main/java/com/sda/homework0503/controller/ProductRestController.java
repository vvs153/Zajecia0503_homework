package com.sda.homework0503.controller;

import com.sda.homework0503.model.Product;
import com.sda.homework0503.model.dto.ProductCreateRequest;
import com.sda.homework0503.model.dto.ProductResponse;
import com.sda.homework0503.model.dto.ProductUpdateRequest;
import com.sda.homework0503.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse add(@RequestBody ProductCreateRequest request){
        return productService.add(request);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> list(){
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductUpdateRequest request){
        return productService.update(id,request);
    }
}
