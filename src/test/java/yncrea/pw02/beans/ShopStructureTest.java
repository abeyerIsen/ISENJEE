package yncrea.pw02.beans;

import javassist.Modifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import yncrea.pw02.pojo.Order;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.Visibility;
import static yncrea.pw02.TestUtils.shouldHaveMethod;

@RunWith(JUnit4.class)
public class ShopStructureTest {

    @Test
    public void shouldBeAnInterface() throws Exception {
        Class<?> clazz = Shop.class;
        assertThat(clazz.isInterface()).isTrue();
    }


    @Test
    public void shouldHaveUpdateStocksMethod() throws Exception {
        shouldHaveMethod(Shop.class, "updateStocks", Void.TYPE, Visibility.PUBLIC, Order.class);
    }


    @Test
    public void shouldHaveGetStockMethod() throws NoSuchMethodException, SecurityException {
        // GIVEN
        // WHEN
        Method method = Shop.class.getDeclaredMethod("getStock");
        // THEN
        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(Map.class);
        ParameterizedType genericReturnType = (ParameterizedType) method.getGenericReturnType();
        Type[] actualTypeArguments = genericReturnType.getActualTypeArguments();
        assertThat(actualTypeArguments[0]).isEqualTo(String.class);
        assertThat(actualTypeArguments[1]).isEqualTo(Integer.class);
    }
}
