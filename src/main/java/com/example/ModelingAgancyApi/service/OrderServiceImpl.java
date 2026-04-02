package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.dto.OrderCreateRequest;
import com.example.ModelingAgancyApi.model.Client;
import com.example.ModelingAgancyApi.model.Model;
import com.example.ModelingAgancyApi.model.Order;
import com.example.ModelingAgancyApi.model.Product;
import com.example.ModelingAgancyApi.repository.ClientRepository;
import com.example.ModelingAgancyApi.repository.ModelRepository;
import com.example.ModelingAgancyApi.repository.OrderRepository;
import com.example.ModelingAgancyApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    // ✅ NEW
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Order saveOrder(OrderCreateRequest request) {

        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = new Order();
        order.setBookingDate(request.getBookingDate());
        order.setTotalAmount(request.getTotalAmount());
        order.setClient(client);
        order.setProduct(product);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id).map(order -> {

            order.setBookingDate(orderDetails.getBookingDate());
            order.setTotalAmount(orderDetails.getTotalAmount());
            order.setClient(orderDetails.getClient());
            order.setProduct(orderDetails.getProduct());
            order.setModel(orderDetails.getModel());

            return orderRepository.save(order);

        }).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // ✅ NEW METHOD
    @Override
    public Order assignModelToOrder(Long orderId, Long modelId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        order.setModel(model);

        return orderRepository.save(order);
    }
}