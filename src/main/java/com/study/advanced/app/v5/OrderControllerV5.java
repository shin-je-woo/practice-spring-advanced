package com.study.advanced.app.v5;

import com.study.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate traceTemplate;

    @GetMapping("/v5/request")
    public String request(String itemId) {

        return traceTemplate.execute("OrderController.request", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
