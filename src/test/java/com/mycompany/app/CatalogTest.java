package com.mycompany.app;

import com.mycompany.app.model.Catalog;
import com.mycompany.app.model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {
    private Product prduct1;
    private Product sameOfPrduct1;
    private Product prduct3;
    private Catalog catalog;

    @Before
    public void setup() {
        prduct1 = new Product("P1");
        sameOfPrduct1 = new Product("P1");
        prduct3 = new Product("P3");
        catalog = new Catalog();
    }

    @Test
    public void test01_ANewCatalogShoildBeEmpty() {
        assertThat(catalog.isEmpty()).isTrue();
    }

    @Test
    public void test02_AProductCanBeAddedToAnemptyCatalog() {
        assertThat(catalog.isEmpty()).isTrue();
        catalog.add(prduct1, 40);
        assertThat(catalog.isEmpty()).isFalse();
    }

    @Test
    public void test03_Adding2DifferentProductShouldHaveaSizeOf2() {
        catalog.add(prduct1, 40);
        catalog.add(prduct3, 80);
        assertThat(catalog.size()).isEqualTo(2);
    }

    @Test
    public void test04_Adding2ProductWithTheSameNameShouldHaveThesizeOf1() {
        catalog.add(prduct1, 40);
        catalog.add(sameOfPrduct1, 40);
        assertThat(catalog.size()).isEqualTo(1);
    }

    @Test
    public void test05_AddingANullProductProduceNoChange() {
        assertThat(catalog.add(null, 40)).isEmpty();
        assertThat(catalog.size()).isEqualTo(0);
    }

    @Test
    public void test06_Adding2TimeTheSameProductOverwriteTheOldOne() {
        catalog.add(prduct1, 40);
        assertThat(catalog.getProductPrice(prduct1)).isNotEmpty().contains(40);
        catalog.add(sameOfPrduct1, 80);
        assertThat(catalog.size()).isEqualTo(1);
        assertThat(catalog.getProductPrice(prduct1)).isNotEmpty().contains(80);
    }

    @Test
    public void test07_ACatalogGettingThePriceOfNotPresentProductShouldReturnAnEmptyObject() {
        assertThat(catalog.getProductPrice(prduct1)).isEmpty();
    }

    @Test
    public void test08_ACatalogDoNotAcceptProductwithNegativePrice() {
        assertThat(catalog.add(prduct1,-20)).isEmpty();
        assertThat(catalog.size()).isEqualTo(0);
    }

}
