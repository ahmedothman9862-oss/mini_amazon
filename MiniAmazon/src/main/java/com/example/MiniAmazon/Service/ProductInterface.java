package com.example.MiniAmazon.Service;

import com.example.MiniAmazon.Dto.ProductDTO;

import java.util.List;

public interface ProductInterface {
    ProductDTO createproduct(ProductDTO productDTO);
    List<ProductDTO>findALL();
}
