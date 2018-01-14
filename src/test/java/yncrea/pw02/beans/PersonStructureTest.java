package yncrea.pw02.beans;

import javassist.Modifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import yncrea.pw02.beans.impl.Person;
import yncrea.pw02.pojo.Order;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.Visibility;
import static yncrea.pw02.TestUtils.shouldHaveMethod;

@RunWith(JUnit4.class)
public class PersonStructureTest {

    @Test
    public void shouldImplementCustomer() {
        // GIVEN
        Person person = new Person();
        // WHEN
        // THEN
        assertThat(person).isInstanceOf(Customer.class);
    }


    @Test
    public void shouldHaveSendOrderMethod() throws Exception {
        shouldHaveMethod(Person.class, "sendOrder", Void.TYPE, Visibility.PUBLIC, Order.class);
    }


    @Test
    public void shouldHaveGetPreferredShopMethod() throws Exception {
        shouldHaveMethod(Person.class, "getFavouriteShop", Shop.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveSetPreferredShopMethod() throws Exception {
        shouldHaveMethod(Person.class, "setFavouriteShop", Void.TYPE, Visibility.PUBLIC, Shop.class);
    }


    @Test
    public void shouldHaveFavouriteShopField() throws Exception {
        // GIVEN
        // WHEN
        Field field = Person.class.getDeclaredField("favouriteShop");
        // THEN
        assertThat(field).isNotNull();
        assertThat(field.getType()).isEqualTo(Shop.class);
        assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();
    }
}
