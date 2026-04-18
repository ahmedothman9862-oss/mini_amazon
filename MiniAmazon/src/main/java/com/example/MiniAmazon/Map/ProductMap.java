package com.example.MiniAmazon.Map;

import com.example.MiniAmazon.Dto.ProductDTO;
import com.example.MiniAmazon.Entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMap {
    Product toentityProduct(ProductDTO productDTO);
    ProductDTO toDtoProduct(Product product);
    List<ProductDTO> toDTOLIST(List<Product> product);
}
