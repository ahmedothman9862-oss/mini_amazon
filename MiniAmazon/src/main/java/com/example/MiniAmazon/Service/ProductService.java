package com.example.MiniAmazon.Service;

import com.example.MiniAmazon.Dto.ProductDTO;
import com.example.MiniAmazon.Entity.Product;
import com.example.MiniAmazon.Map.ProductMap;
import com.example.MiniAmazon.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductInterface {
    private final ProductRepo productRepo;
    private final ProductMap productMap;
    @Autowired
    public ProductService(ProductRepo productRepo , ProductMap productMap) {
        this.productRepo = productRepo;
        this.productMap = productMap;
    }


    @Override
    public ProductDTO createproduct(ProductDTO productDTO) {
        Product save = productMap.toentityProduct(productDTO);
        Product product = productRepo.save(save);
        return productMap.toDtoProduct(product);
    }

    @Override
    public List<ProductDTO> findALL() {
        List<Product> products = productRepo.findAll();
        return productMap.toDTOLIST(products);
    }
}
