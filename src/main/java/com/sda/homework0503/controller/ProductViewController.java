package com.sda.homework0503.controller;

import com.sda.homework0503.model.dto.ProductCreateRequest;
import com.sda.homework0503.model.dto.ProductResponse;
import com.sda.homework0503.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//http://localhost:8080/view/product
@Controller
@RequestMapping("/view/product")
public class ProductViewController {
    private final ProductService productService;

  public ProductViewController(ProductService productService) {
     this.productService = productService;
    }
    @GetMapping("/home")
    public String demo(){
        return "home-page";
    }

    @GetMapping()
    public String list(Model model){
      List<ProductResponse> productList = productService.getAll();
      model.addAttribute("attributeName", productList);
      return "product-list-page";
    }

    @GetMapping("/form")
    public String getFormPage(Model model){
        model.addAttribute("attributeObjectForm", new ProductCreateRequest());
        return "product-form-page";
    }
    @PostMapping("/form")
    public String submitForm(Model model, ProductCreateRequest request){
      productService.add(request);
      return "redirect:/view/product";
    }
}
