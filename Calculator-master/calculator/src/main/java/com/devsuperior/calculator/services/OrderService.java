package com.devsuperior.calculator.services;

import com.devsuperior.calculator.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private final ShippingService shippingService;

    @Autowired
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double discountOrder(Order order) {
        return order.getBasic() * order.getDiscount();

    }

    public double total(Order order) {
        return order.getBasic() - discountOrder(order);
    }

    public double calculoTotal(Order order) {
        return total(order) + shippingService.shipment(order);
    }

}

