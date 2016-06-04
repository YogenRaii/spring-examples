package com.eShop;

import com.eShop.domain.Product;
import com.eShop.service.IProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        IProductService productService = context.getBean("productService", IProductService.class);

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


