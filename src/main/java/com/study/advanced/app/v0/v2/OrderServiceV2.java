package com.study.advanced.app.v0.v2;

import com.study.advanced.trace.TraceId;
import com.study.advanced.trace.TraceStatus;
import com.study.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceId beforeTraceId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(beforeTraceId, "OrderService.orderItem");

            orderRepository.save(itemId, status.getTraceId());

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
