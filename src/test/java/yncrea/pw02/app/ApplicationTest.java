package yncrea.pw02.app;

import org.assertj.core.data.MapEntry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yncrea.pw02.beans.Customer;
import yncrea.pw02.beans.Shop;
import yncrea.pw02.pojo.Order;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnit4.class)
public class ApplicationTest {

    private ConfigurableApplicationContext applicationContext;

    private Shop appleStore;

    private Shop knowledgeStore;

    private Customer mrsMichu;

    private Customer awesomePros;


    @Before
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext("yncrea.pw02.config");
        appleStore = (Shop) applicationContext.getBean("appleStore");
        knowledgeStore = (Shop) applicationContext.getBean("knowledgeStore");
        mrsMichu = (Customer) applicationContext.getBean("mrsMichu");
        awesomePros = (Customer) applicationContext.getBean("awesomePros");
    }


    @After
    public void tearDown() {
        applicationContext.close();
    }


    @Test
    public void shouldHaveCorrectStockAfterInit() {
        // GIVEN
        // WHEN
        // THEN
        assertThat(appleStore.getStock()).containsOnly(MapEntry.entry("iPhone X", 3), MapEntry.entry("macbook pro", 10), MapEntry.entry("iPad", 50));
        assertThat(knowledgeStore.getStock()).containsOnly(MapEntry.entry("cd", 2), MapEntry.entry("tv", 8), MapEntry.entry("book", 7));
    }


    @Test
    public void shouldHaveCorrectStockAfterUpdates() {
        // GIVEN
        // WHEN
        Order order1 = new Order();
        order1.addProduct("macbook pro");
        order1.addProduct("macbook pro");
        order1.addProduct("iPhone X");
        mrsMichu.sendOrder(order1);
        Order order2 = new Order();
        order2.addProduct("tv");
        order2.addProduct("tv");
        order2.addProduct("tv");
        order2.addProduct("cd");
        order2.addProduct("book");
        awesomePros.sendOrder(order2);
        // THEN
        assertThat(appleStore.getStock()).containsOnly(MapEntry.entry("iPhone X", 2), MapEntry.entry("macbook pro", 8), MapEntry.entry("iPad", 50));
        assertThat(knowledgeStore.getStock()).containsOnly(MapEntry.entry("cd", 1), MapEntry.entry("tv", 5), MapEntry.entry("book", 6));
    }
}
