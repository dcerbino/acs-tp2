package com.mycompany.app;

import com.mycompany.app.model.Catalog;
import com.mycompany.app.model.Chart;
import com.mycompany.app.model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class CharTest {
    private Product product1;
    private Product product2;
    private Catalog catalog;
    private Chart cart;

    @Before
    public void setup() {
        product1 = new Product("P1");
        product2 = new Product("P2");
        catalog = new Catalog();
        catalog.add(product1, 40);
        catalog.add(product2, 80);
        cart = new Chart();

    }

    @Test
    public void test01_ANewCarShouldHaveSize0() {
        assertThat(cart.size()).isEqualTo(0);
    }

    @Test
    public void Tes02_ACarAfterAddingProduct1OfQuantityOf40Have40QuantityOfProduct1(){
        cart.add(product1,40);
        assertThat(cart.getQuantity(product1)).contains(40);
    }

    @Test
    public void test03_AVoidCarAfterAddingAProductHaveASizeOf1(){
        cart.add(product1,40);
        assertThat(cart.size()).isEqualTo(1);
    }

    @Test
    public void test04_AvoidCatOnAddingTheSameProduct2TimesHaveSize1AndHaveTheSumOfQuantityAdded(){
        cart.add(product1,40);
        cart.add(product1,80);
        assertThat(cart.size()).isEqualTo(1);
        assertThat(cart.getQuantity(product1)).isNotEmpty().contains(120);
    }

    @Test
    public void test05_AVoidCarONAddingANegativeQuantityReturnAnOptionalEmptyAndDoNotChangeChart(){
        assertThat(cart.add(product1,-40)).isEmpty();
        assertThat(cart.getQuantity(product1)).isEmpty();
    }

    @Test
    public void test06_AVoidCarOnAddingANullProductReturnAnOptionalEmptyAndDoNotChangeChart(){
        assertThat(cart.add(null,40)).isEmpty();
        assertThat(cart.getQuantity(null)).isEmpty();
        assertThat(cart.size()).isEqualTo(0);
    }

    @Test
    public void test08_ACartWithAProductAfterRemoveTheProductIsEmpty(){
        cart.add(product1,40);
        assertThat(cart.size()).isEqualTo(1);
        assertThat(cart.getQuantity(product1)).isNotEmpty().contains(40);
        assertThat(cart.remove(product1)).isNotEmpty();
        assertThat(cart.size()).isEqualTo(0);
        assertThat(cart.getQuantity(product1)).isEmpty();
    }


    @Test
    public void test09_ACartAfterRemoveAProductNotPresentReturnOptionalEmptyAndDoNotChangeTheCart(){
        assertThat(cart.add(product1,40)).isNotEmpty();
        assertThat(cart.size()).isEqualTo(1);
        assertThat(cart.remove(product2)).isEmpty();
        assertThat(cart.size()).isEqualTo(1);
    }

    @Test
    public void test10_AVoidCartAfterAddASingleProductHave1Item(){
        assertThat(cart.add(product1)).isNotEmpty();
        assertThat(cart.size()).isEqualTo(1);
        assertThat(cart.getQuantity(product1)).isNotEmpty().contains(1);
    }

    @Test 
    public void test11_ACarWhereAddingANegativeValueSmallerThenPresentProductRestTheProductAndReturnAnOptionThatContainsThatProduct(){
        assertThat(cart.add(product1,40)).isNotEmpty();
        assertThat(cart.add(product1,-20)).isNotEmpty();
        assertThat(cart.getQuantity(product1)).isNotEmpty().contains(20);
    }

    @Test
    public void test12_AVoidCartOnAddingAProductAndRemovingTheSameOfASmallerQuantityLeaveSize1AndHaveTheRestOfQuantity(){
        cart.add(product1,80);
        cart.remove(product1,40);
        assertThat(cart.size()).isEqualTo(1);
        assertThat(cart.getQuantity(product1)).isNotEmpty().contains(40);
    }

    @Test
    public void test13_AVoidCartOnAddingAProductAndRemovingTheSameOfABiggerQuantityLeaveSize1AndDoNotChangeQuantity(){
        cart.add(product1,40);
        cart.remove(product1,80);
        assertThat(cart.size()).isEqualTo(1);
        assertThat(cart.getQuantity(product1)).isNotEmpty().contains(40);
    }

}
