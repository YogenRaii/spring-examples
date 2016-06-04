package com.eShop.repository;

import com.eShop.domain.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajkumar on 6/3/2016.
 */
public class ProductRepository implements IProductRepository {

    private Collection<Product> productList;

    public ProductRepository(){
        productList = new ArrayList(){
            {
                add(new Product(234,"LCD TV", 895.50));
                add(new Product(239,"DVD player", 315.00));
                add(new Product(423,"Plasma TV", 992.55));
            }
        };
    }


    @Override
    public Product findOne(int productNumber) {
        for (Product product : productList) {
            if (product.getProductNumber() == productNumber)
                return product;
        }
        return null;
    }
}
