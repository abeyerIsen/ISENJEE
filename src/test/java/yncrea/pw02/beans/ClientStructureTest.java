package yncrea.pw02.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import yncrea.pw02.pojo.Order;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.Visibility;
import static yncrea.pw02.TestUtils.shouldHaveMethod;

@RunWith(JUnit4.class)
public class ClientStructureTest {

    @Test
    public void shouldBeAnInterface() throws Exception {
        Class<?> clazz = Customer.class;
        assertThat(clazz.isInterface()).isTrue();
    }


    @Test
    public void shouldHaveSendOrderMethod() throws Exception {
        shouldHaveMethod(Customer.class, "sendOrder", Void.TYPE, Visibility.PUBLIC, Order.class);
    }
}
