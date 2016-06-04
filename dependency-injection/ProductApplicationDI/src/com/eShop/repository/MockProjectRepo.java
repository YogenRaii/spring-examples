package com.eShop.repository;

import com.eShop.domain.Product;

/**
 * Created by rajkumar on 6/3/2016.
 */
public class MockProjectRepo implements IProductRepository {
    @Override
    public Product findOne(int productNumber) {
        return new Product(423,"Mock Object",123.00);
    }
}
