package com.devsuperior.calculator;

import com.devsuperior.calculator.entities.Order;
import com.devsuperior.calculator.services.OrderService;
import com.devsuperior.calculator.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class CalculatorApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("digite o número do pedido: ");
        Integer code = sc.nextInt();
        System.out.println("Digite o valor do pedido: ");
        Double basic = sc.nextDouble();
        System.out.println("Digite o desconto do pedido: ");
        Double discount = sc.nextDouble();


        Order order = new Order(code, basic, discount);

        System.out.println("Pedido código: " + order.getCode());
        System.out.println("Valor total: " + orderService.calculoTotal(order));

        sc.close();
    }
}
