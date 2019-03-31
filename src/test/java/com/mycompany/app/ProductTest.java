package com.mycompany.app;

import com.mycompany.app.model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class ProductTest {
    private Product prduct1;
    private Product prduct2;

    @Before
    public void setup() {
        prduct1 = new Product("P1");
        prduct2 = new Product("P1");
    }

    @Test
    public void Test01_ANewCreatedProduct1shouldHaveTheNameP1() {
        assertThat(prduct1.getName()).isEqualTo("P1");
    }

    @Test(expected = NullPointerException.class)
    public void Test02_AnewProductWithNullNameShouldThrowNullPointerExeption(){
        new Product(null);
    }

    @Test
    public void Test03_2ProductsWithTheSameNameShouldBeEqual(){
        assertThat(prduct1).isEqualTo(prduct2);
    }

    @Test
    public void Test04_2ProductsWithTheSameNameShouldHaveEqualHAscode(){
        assertThat(prduct1.hashCode()).isEqualTo(prduct2.hashCode());
    }
}
