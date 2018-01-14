package yncrea.pw02.beans;

import javassist.Modifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import yncrea.pw02.beans.impl.Company;
import yncrea.pw02.pojo.Order;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.Visibility;
import static yncrea.pw02.TestUtils.shouldHaveMethod;

@RunWith(JUnit4.class)
public class CompanyStructureTest {

    @Test
    public void shouldImplementCustomer() {
        // GIVEN
        Company company = new Company();
        // WHEN
        // THEN
        assertThat(company).isInstanceOf(Customer.class);
    }


    @Test
    public void shouldHaveSendOrderMethod() throws Exception {
        shouldHaveMethod(Company.class, "sendOrder", Void.TYPE, Visibility.PUBLIC, Order.class);
    }


    @Test
    public void shouldHaveGetFavouriteShopMethod() throws Exception {
        shouldHaveMethod(Company.class, "getFavouriteShop", Shop.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveSetFavouriteShopMethod() throws Exception {
        shouldHaveMethod(Company.class, "setFavouriteShop", Void.TYPE, Visibility.PUBLIC, Shop.class);
    }


    @Test
    public void shouldHaveFavouriteShopField() throws Exception {
        // GIVEN
        // WHEN
        Field field = Company.class.getDeclaredField("favouriteShop");
        // THEN
        assertThat(field).isNotNull();
        assertThat(field.getType()).isEqualTo(Shop.class);
        assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();
    }


    @Test
    public void shouldHaveLicenseField() throws Exception {
        // GIVEN
        // WHEN
        Field field = Company.class.getDeclaredField("license");
        // THEN
        assertThat(field).isNotNull();
        assertThat(field.getType()).isEqualTo(String.class);
        assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();
    }


    @Test
    public void shouldHaveGetLicenseMethod() throws Exception {
        shouldHaveMethod(Company.class, "getLicense", String.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveSetLicenseMethod() throws Exception {
        shouldHaveMethod(Company.class, "setLicense", Void.TYPE, Visibility.PUBLIC, String.class);
    }
}
