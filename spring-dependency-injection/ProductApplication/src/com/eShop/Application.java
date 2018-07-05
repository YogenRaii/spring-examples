package com.eShop;


import com.eShop.domain.Product;
import com.eShop.service.IProductService;
import com.eShop.service.ProductService;
public class Application {
    public static void main(String[] args) {
        IProductService productService = new ProductService();

        Product product1 = productService.getProduct(423);
        if (product1 != null) {
            System.out.println(product1);
        }
        Product product2 = productService.getProduct(239);
        if (product2 != null) {
            System.out.println(product2);
        }
    }

}


