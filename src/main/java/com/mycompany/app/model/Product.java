package com.mycompany.app.model;

import java.util.Objects;

public class Product {
    private String name;

    public Product(String name) {
        if (name == null) throw new NullPointerException("A Product Can not have Null String Name");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
