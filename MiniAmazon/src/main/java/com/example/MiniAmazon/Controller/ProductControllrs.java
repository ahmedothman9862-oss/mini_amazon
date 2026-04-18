package com.example.MiniAmazon.Controller;

import com.example.MiniAmazon.Dto.ProductDTO;
import com.example.MiniAmazon.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductControllrs {
    private final ProductService productService;

    @Autowired
    public ProductControllrs(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ProductDTO create(@RequestBody ProductDTO dto)
    {
        System.out.println(dto);
        return productService.createproduct(dto);
    }
    @GetMapping("/all")
    public List<ProductDTO>findall(){
        return productService.findALL();
    }
}
