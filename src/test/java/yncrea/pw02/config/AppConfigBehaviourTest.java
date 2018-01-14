package yncrea.pw02.config;

import org.assertj.core.data.MapEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import yncrea.pw02.beans.Customer;
import yncrea.pw02.beans.Shop;
import yncrea.pw02.beans.impl.Person;
import yncrea.pw02.beans.impl.Company;
import yncrea.pw02.beans.impl.ShopImpl;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnit4.class)
public class AppConfigBehaviourTest {

    @Test
    public void shouldBuildKnowledgeStore() {
        // GIVEN
        AppConfig config = new AppConfig();
        // WHEN
        Shop knowledgeStore = config.knowledgeStore();
        // THEN
        assertThat(knowledgeStore).isInstanceOf(ShopImpl.class);
        assertThat(knowledgeStore.getStock()).containsOnly(MapEntry.entry("tv", 8), MapEntry.entry("book", 7), MapEntry.entry("cd", 2));
    }


    @Test
    public void shouldBuildAppleStore() {
        // GIVEN
        AppConfig config = new AppConfig();
        // WHEN
        Shop appleStore = config.appleStore();
        // THEN
        assertThat(appleStore).isInstanceOf(ShopImpl.class);
        assertThat(appleStore.getStock()).containsOnly(MapEntry.entry("macbook pro", 10), MapEntry.entry("iPhone X", 3), MapEntry.entry("iPad", 50));
    }


    @Test
    public void shouldBuildMrsMichu() {
        // GIVEN
        AppConfig config = new AppConfig();
        Shop appleStore = config.appleStore();
        // WHEN
        Customer customer = config.mrsMichu(appleStore);
        // THEN
        assertThat(customer).isInstanceOf(Person.class);
        Person person = (Person) customer;
        assertThat(person.getFavouriteShop()).isEqualTo(appleStore);
    }


    @Test
    public void shouldBuildAwesomePros() {
        // GIVEN
        AppConfig config = new AppConfig();
        Shop knowledgeStore = config.knowledgeStore();
        // WHEN
        Customer customer = config.awesomePros(knowledgeStore);
        // THEN
        assertThat(customer).isInstanceOf(Company.class);
        Company company = (Company) customer;
        assertThat(company.getLicense()).isEqualTo("123456");
        assertThat(company.getFavouriteShop()).isEqualTo(knowledgeStore);
    }
}
