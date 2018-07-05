package com.eShop.repository;

import com.eShop.domain.Product;

/**
 * Created by rajkumar on 6/3/2016.
 */
public interface IProductRepository {
    Product findOne(int productNumber);
}
