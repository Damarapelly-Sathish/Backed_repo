package com.e_commerce.e_commerceWebsite.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private RazorpayClient razorpayClient;

    public PaymentService(@Value("${razorpay.keyId}") String keyId, 
            @Value("${razorpay.keySecret}") String keySecret) throws RazorpayException {
    		if (keyId == null || keySecret == null) {
    			throw new IllegalArgumentException("Razorpay Key ID and Secret cannot be null");
    		}
    		this.razorpayClient = new RazorpayClient(keyId, keySecret);
    }

    public String createOrder(double amount) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", (int)(amount * 100)); // Amount in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "txn_123456");

        Order order = razorpayClient.orders.create(orderRequest);
        return order.toString();
    }
}
