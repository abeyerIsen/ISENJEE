package yncrea.pw02.pojo;

import javassist.Modifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.Visibility;
import static yncrea.pw02.TestUtils.shouldHaveMethod;

@RunWith(JUnit4.class)
public class OrderStructureTest {

    @Test
    public void shouldHaveLicenseField() throws NoSuchFieldException, SecurityException {
        // GIVEN
        // WHEN
        Field field = Order.class.getDeclaredField("license");
        // THEN
        assertThat(field).isNotNull();
        assertThat(field.getType()).isEqualTo(String.class);
        assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();
    }


    @Test
    public void shouldHaveProductsField() throws NoSuchFieldException, SecurityException {
        // GIVEN
        // WHEN
        Field field = Order.class.getDeclaredField("products");
        // THEN
        assertThat(field).isNotNull();
        assertThat(field.getType()).isEqualTo(List.class);
        assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();
        ParameterizedType fieldType = (ParameterizedType) field.getGenericType();
        assertThat(fieldType.getActualTypeArguments()[0]).isEqualTo(String.class);
    }


    @Test
    public void shouldHaveGetLicenseMethod() throws Exception {
        shouldHaveMethod(Order.class, "getLicense", String.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveSetLicenseMethod() throws Exception {
        shouldHaveMethod(Order.class, "setLicense", Void.TYPE, Visibility.PUBLIC, String.class);
    }


    @Test
    public void shouldHaveGetProductsMethod() throws Exception {
        shouldHaveMethod(Order.class, "getProducts", List.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveSetProductsMethod() throws Exception {
        shouldHaveMethod(Order.class, "setProducts", Void.TYPE, Visibility.PUBLIC, List.class);
    }


    @Test
    public void shouldHaveAddProductMethod() throws Exception {
        shouldHaveMethod(Order.class, "addProduct", Void.TYPE, Visibility.PUBLIC, String.class);
    }
}
