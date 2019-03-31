package com.mycompany.app.model;

import java.util.HashMap;
import java.util.Optional;

public class Chart {
    private HashMap<Product, Integer> items = new HashMap<>();

    public int size() {
        return items.size();
    }

    public Optional<Product> add(Product product, int quantity) {
        if (product == null) return Optional.empty();
        int newQuantity = getQuantity(product).orElse(0)+quantity;
        if (newQuantity > 0) {
            items.put(product, newQuantity);
            return Optional.of(product);
        } else if (newQuantity == 0) {
            return remove(product);
        }

        return Optional.empty();
    }

    public Optional<Product> remove(Product product, int quantity) {
        return add(product,-quantity);
    }

    public Optional<Integer> getQuantity(Product product) {
        return Optional.ofNullable(items.get(product));
    }

    public Optional<Product> remove(Product product){
        if (!getQuantity(product).isPresent())  return Optional.empty();
        items.remove(product);
        return Optional.of(product);
    }

    public Optional<Product> add(Product product) {
        if (product == null) return Optional.empty();
        int newQuantiy = getQuantity(product).orElse(0)+1;
        items.put(product,newQuantiy);
        return Optional.of(product);
    }
}
