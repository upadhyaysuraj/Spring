import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.chandra.spring.bean.Product;
import com.chandra.spring.configuration.AppConfig;
import com.chandra.spring.service.ProductService;

public class AppMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService  service = (ProductService) context.getBean("productService");
		
		//create Products
		Product p1 = new Product();
		p1.setPname("Rice");
		p1.setQty(25);
		p1.setPrice(1300);
		
		Product p2 = new Product();
		p2.setPname("Oil");
		p2.setQty(1);
		p2.setPrice(95);
		
		Product p3 = new Product();
		p3.setPname("KRice");
		p3.setQty(25);
		p3.setPrice(1250);
		
		service.saveProduct(p1);
		service.saveProduct(p2);
		service.saveProduct(p3);
		
		List<Product> products = service.findAllProducts();
		for(Product product:products)
		{
			System.out.println(product);
		}

		service.deleteProduct(1);
		
		Product p = service.findByProductId(3);
		p.setPname("KurnolRice");
		service.updateProduct(p);
		
		List<Product> list = service.findAllProducts();
		for(Product product:list)
		{
			System.out.println(product);
		}
		context.close();
	}

}
