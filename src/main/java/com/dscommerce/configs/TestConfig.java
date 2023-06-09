package com.dscommerce.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dscommerce.entities.Category;
import com.dscommerce.entities.Order;
import com.dscommerce.entities.OrderItem;
import com.dscommerce.entities.Payment;
import com.dscommerce.entities.Product;
import com.dscommerce.entities.User;
import com.dscommerce.enums.OrderStatus;
import com.dscommerce.repositories.CategoryRepository;
import com.dscommerce.repositories.OrderItemRepository;
import com.dscommerce.repositories.OrderRepository;
import com.dscommerce.repositories.ProductRepository;
import com.dscommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category("Eletrônicos");
		Category cat2 = new Category("Livros");
		Category cat3 = new Category("Computadores");
		
		
		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 70.0, "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2500.0, "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 9250.0, "");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 3000.0, "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null,"Maria", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex", "alex@gmail.com", "9765479999", "12385246");
		User u3 = new User(null, "Emma", "emma@gmail.com", "978235799", "12348965");
		User u4 = new User(null, "David", "david@gmail.com", "977777777", "12378965");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Order o1 = new Order(Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAGO, u1);
		Order o2 = new Order(Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u2);
		Order o3 = new Order(Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u1);
		Order o4 = new Order(Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.PAGO, u3);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o3, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o2, p5, 2, p5.getPrice());
		OrderItem oi5 = new OrderItem(o4, p2, 2, p2.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));
		
		Payment pay1 = new Payment(Instant.parse("2022-06-20T21:53:07Z"), o1);
		Payment pay2 = new Payment(Instant.parse("2022-07-22T17:21:07Z"), o4);
		
		o1.setPayment(pay1);
		o4.setPayment(pay2);
		
		orderRepository.saveAll(Arrays.asList(o1, o4));
		
	}
}
