package com.mycompany.app.model;

import java.util.HashMap;
import java.util.Optional;

public class Catalog {
    private HashMap<Product,Integer> items = new HashMap<Product, Integer>();

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public Optional<Product> add(Product prduct, int price) {
        if (prduct==null){
            return Optional.empty();
        }
        items.put(prduct,price);
        return Optional.of(prduct);
    }

    public int size(){
        return items.size();
    }

    public Optional<Integer> getProductPrice(Product prduct) {
        return Optional.ofNullable(items.get(prduct));
    }
}
