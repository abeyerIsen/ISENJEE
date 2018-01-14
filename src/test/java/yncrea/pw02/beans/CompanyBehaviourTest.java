package yncrea.pw02.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import yncrea.pw02.beans.impl.Company;
import yncrea.pw02.pojo.Order;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class CompanyBehaviourTest {

    @Mock
    private Shop shop;

    @Mock
    private Order order;

    @Test
    public void shouldAddLicenseToOrderThenCallUpdateStockOfFavouriteShop() {
        // GIVEN
        Company company = new Company();
        company.setFavouriteShop(shop);
        company.setLicense("1234");
        // WHEN
        company.sendOrder(order);
        // THEN
        verify(order,times(1)).setLicense(eq("1234"));
        verify(shop,times(1)).updateStocks(any(Order.class));
    }

}
