package newdev.project01.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import newdev.project01.models.entities.Order;
import newdev.project01.models.entities.User;
import newdev.project01.models.entities.enums.OrderStatus;
import newdev.project01.repositories.OrderRepository;
import newdev.project01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("Maria", "maria@gmail.com", "988888888", "123456");
		User u2 = new User("Alex", "alex@gmail.com", "9765479999", "12385246");
		User u3 = new User("Emma", "emma@gmail.com", "978235799", "12348965");
		User u4 = new User("David", "david@gmail.com", "977777777", "12378965");
		
		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u2);
		Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.ENVIADO, u1);
		Order o4 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAGO, u3);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
	}
	

}
