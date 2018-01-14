package yncrea.pw02.beans;

import javassist.Modifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import yncrea.pw02.beans.impl.ShopImpl;
import yncrea.pw02.pojo.Order;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.Visibility;
import static yncrea.pw02.TestUtils.shouldHaveMethod;

@RunWith(JUnit4.class)
public class ShopImplStructureTest {

    @Test
    public void shouldImplementShop() {
        // GIVEN
        ShopImpl boutique = new ShopImpl();
        // WHEN
        // THEN
        assertThat(boutique).isInstanceOf(Shop.class);
    }


    @Test
    public void shouldHaveStockField() throws NoSuchFieldException, SecurityException {
        // GIVEN
        // WHEN
        Field field = ShopImpl.class.getDeclaredField("stock");
        // THEN
        assertThat(field).isNotNull();
        assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();
        assertThat(field.getType()).isEqualTo(Map.class);
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        Type[] actualTypeArguments = genericType.getActualTypeArguments();
        assertThat(actualTypeArguments[0]).isEqualTo(String.class);
        assertThat(actualTypeArguments[1]).isEqualTo(Integer.class);
    }


    @Test
    public void shouldHaveUpdateStocksMethod() throws Exception {
        shouldHaveMethod(ShopImpl.class, "updateStocks", Void.TYPE, Visibility.PUBLIC, Order.class);
    }


    @Test
    public void shouldHaveGetStockMethod() throws NoSuchMethodException, SecurityException {
        // GIVEN
        // WHEN
        Method method = ShopImpl.class.getDeclaredMethod("getStock");
        // THEN
        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(Map.class);
        ParameterizedType genericReturnType = (ParameterizedType) method.getGenericReturnType();
        Type[] actualTypeArguments = genericReturnType.getActualTypeArguments();
        assertThat(actualTypeArguments[0]).isEqualTo(String.class);
        assertThat(actualTypeArguments[1]).isEqualTo(Integer.class);
    }


    @Test
    public void shouldHaveSetStockMethod() throws NoSuchMethodException, SecurityException {
        // GIVEN
        // WHEN
        Method method = ShopImpl.class.getDeclaredMethod("setStock", Map.class);
        // THEN
        assertThat(method).isNotNull();
        assertThat(Modifier.isPublic(method.getModifiers())).isTrue();
        assertThat(method.getReturnType()).isEqualTo(Void.TYPE);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Type[] actualTypeArguments = ((ParameterizedType) genericParameterTypes[0]).getActualTypeArguments();
        assertThat(actualTypeArguments[0]).isEqualTo(String.class);
        assertThat(actualTypeArguments[1]).isEqualTo(Integer.class);
    }
}
