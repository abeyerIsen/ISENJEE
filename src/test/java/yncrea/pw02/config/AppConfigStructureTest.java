package yncrea.pw02.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import yncrea.pw02.beans.Customer;
import yncrea.pw02.beans.Shop;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;
import static yncrea.pw02.TestUtils.*;

@RunWith(JUnit4.class)
public class AppConfigStructureTest {

    @Test
    public void shouldHaveConfigurationAnnotation() {
        shouldHaveAnnotationOnClass(AppConfig.class, Configuration.class);
    }


    @Test
    public void shouldHaveAppleStoreMethod() throws NoSuchMethodException {
        shouldHaveMethod(AppConfig.class, "appleStore", Shop.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveBeanAnnotationOnAppleStoreMethod() throws NoSuchMethodException {
        shouldHaveAnnotationOnMethod(AppConfig.class.getDeclaredMethod("appleStore"), Bean.class);
    }


    @Test
    public void shouldHaveKnowledgeStoreMethod() throws NoSuchMethodException {
        shouldHaveMethod(AppConfig.class, "knowledgeStore", Shop.class, Visibility.PUBLIC);
    }


    @Test
    public void shouldHaveBeanAnnotationOnKnowledgeStoreMethod() throws NoSuchMethodException {
        shouldHaveAnnotationOnMethod(AppConfig.class.getDeclaredMethod("knowledgeStore"), Bean.class);
    }


    @Test
    public void shouldHaveMrsMichuMethod() throws NoSuchMethodException {
        shouldHaveMethod(AppConfig.class, "mrsMichu", Customer.class, Visibility.PUBLIC, Shop.class);
    }


    @Test
    public void shouldHaveBeanAnnotationOnMrsMichuMethod() throws NoSuchMethodException {
        shouldHaveAnnotationOnMethod(AppConfig.class.getDeclaredMethod("mrsMichu", Shop.class), Bean.class);
    }


    @Test
    public void shouldHaveAppleStoreParameterInMrsMichuMethod() throws NoSuchMethodException {
        // GIVEN
        Method personMethod = AppConfig.class.getDeclaredMethod("mrsMichu", Shop.class);
        LocalVariableTableParameterNameDiscoverer paramNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        // WHEN
        String[] parameterNames = paramNameDiscoverer.getParameterNames(personMethod);
        // THEN
        assertThat(parameterNames[0]).isEqualTo("appleStore");
    }


    @Test
    public void shouldHaveAwesomeProsMethod() throws NoSuchMethodException {
        shouldHaveMethod(AppConfig.class, "awesomePros", Customer.class, Visibility.PUBLIC, Shop.class);
    }


    @Test
    public void shouldHaveBeanAnnotationOnAwesomeProsMethod() throws NoSuchMethodException {
        shouldHaveAnnotationOnMethod(AppConfig.class.getDeclaredMethod("awesomePros", Shop.class), Bean.class);
    }


    @Test
    public void shouldHaveKnowledgeStoreParameterInAwesomeProsMethod() throws NoSuchMethodException {
        // GIVEN
        Method awesomeProsMethod = AppConfig.class.getDeclaredMethod("awesomePros", Shop.class);
        LocalVariableTableParameterNameDiscoverer paramNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        // WHEN
        String[] parameterNames = paramNameDiscoverer.getParameterNames(awesomeProsMethod);
        // THEN
        assertThat(parameterNames[0]).isEqualTo("knowledgeStore");
    }
}
