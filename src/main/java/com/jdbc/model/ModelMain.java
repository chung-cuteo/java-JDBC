package com.jdbc.model;

public class ModelMain {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("abc");
        String name = product.getName();
        System.out.println("name"+ name );
    }
    
}
