package com.study.advanced.app.v5;

import com.study.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate traceTemplate;

    public void orderItem(String itemId) {

        traceTemplate.execute("OrderService.orderItem", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
