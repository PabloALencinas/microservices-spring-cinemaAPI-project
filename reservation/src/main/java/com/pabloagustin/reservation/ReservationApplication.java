package com.pabloagustin.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
		scanBasePackages = {
				"com.pabloagustin.reservation",
				"com.pabloagustin.amqp",
		}
)
@ComponentScan( basePackages = {"com.pabloagustin.reservation", "com.pabloagustin.clients", "com.pabloagustin.amqp"})
@EnableEurekaClient
@EnableFeignClients(
		basePackages = "com.pabloagustin.reservation.clients"
)
@PropertySources({
		@PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class ReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

}
