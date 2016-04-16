import com.scriptnow.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CreateOrderIntegrationTest.ScriptNowConfig.class)
public class CreateOrderIntegrationTest {

    @Autowired
    private OrderController orderController;

    @Autowired
    private UserController userController;

    @Before
    public void setup() {
    }

    @Ignore
    @Test
    public void createOrder() {
        Medicine cheese = new Medicine("Cheese");
        Medicine wine = new Medicine("Wine");
        Order newOrder = new Order(3L, new Prescription(asList(cheese, wine)), new User("Sindu"));
        orderController.createOrder("Sindu", newOrder);

        assertThat(orderController.getActiveOrders().contains(newOrder), is(true));
    }

    @Test
    public void getOrders() {
        List<Order> activeOrders = orderController.getActiveOrders();
        assertThat(activeOrders.size(), is(3));
    }

    @Configuration
    class ScriptNowConfig {

        @Bean
        public OrderController orderController() {
            return new OrderController();
        }

        @Bean
        public UserController userController() {
            return new UserController();
        }
    }
}
