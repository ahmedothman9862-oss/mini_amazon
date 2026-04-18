package com.example.MiniAmazon.Map;

import com.example.MiniAmazon.Dto.ProductDTO;
import com.example.MiniAmazon.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-16T00:19:42+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapImpl implements ProductMap {

    @Override
    public Product toentityProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setPrice( productDTO.getPrice() );

        return product;
    }

    @Override
    public ProductDTO toDtoProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setId( product.getId() );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toDTOLIST(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( product.size() );
        for ( Product product1 : product ) {
            list.add( toDtoProduct( product1 ) );
        }

        return list;
    }
}
