package com.jdbc.model.DAO;

import com.jdbc.model.Product;

public class MainDAO {

    public static void main(String[] args) {

//       create();
//        update();
        findById();

    }

    public static void create() {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(0, "ao nam", 1000, "Ao danh cho name");

        try {
            Product createdProduct = productDAO.create(product);
            System.out.printf("id: %d, name: %s, price: %f, desc: %s", createdProduct.getId(), createdProduct.getName(), createdProduct.getPrice(), createdProduct.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(2, "ao rach", 1000, "ao rach thoi trang");

        try {
            Product updateddProduct = productDAO.update(product);
            System.out.printf("id: %d, name: %s, price: %f, desc: %s", updateddProduct.getId(), updateddProduct.getName(), updateddProduct.getPrice(), updateddProduct.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findById() {
        ProductDAO productDAO = new ProductDAO();

        try {
            Product found = productDAO.findById(2);
            if (found != null) {
                System.out.printf("id: %d, name: %s, price: %f, desc: %s", found.getId(), found.getName(), found.getPrice(), found.getDescription());

            } else {
                System.out.println("not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
