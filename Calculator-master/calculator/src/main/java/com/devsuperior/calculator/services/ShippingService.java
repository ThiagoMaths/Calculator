package com.devsuperior.calculator.services;

import com.devsuperior.calculator.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {


    public double shipment(Order order) {
        if (order.getBasic() <= 99.99) {

            return 20.0;

        } else if (order.getBasic() > 100.0 && order.getBasic() < 200.0) {

            return 12.0;

        } else {
            return 0.0;
        }

    }


}
