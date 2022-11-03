package pl.payment.main;

		import io.swagger.v3.oas.annotations.OpenAPIDefinition;
		import io.swagger.v3.oas.annotations.info.Info;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(title = "Payment API",
				version = "1.0",
				description = "Payment information"))
@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
}
