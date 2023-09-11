package com.example.ordercommand.service;

import com.example.ordercommand.client.api.OrderQueryClient;
import com.example.ordercommand.domain.entity.Order;
import com.example.ordercommand.domain.request.OrderRequest;
import com.example.ordercommand.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderQueryClient orderQueryClient;
//    다른 곳에서 데이터를 받아온다
//    저장 -> h2 (in memory)
//    이 서버 장점 : h2 (서버가 죽음 = db 죽었다)
//    다중 서버를 계속 늘리면 저장 하는 디비가 늘어난다
//    UUID PK
//    CQRS (c, rud)
    public void save(OrderRequest orderRequest){
        try {
            Order save = orderRepository.save(orderRequest.toEntity());
            // of 요청 보냄
            orderQueryClient.save(save);
            orderRepository.delete(save);
        }catch (Exception e){

        }

        // of query save 성공을 하면 delete
        // 아니면 대기하면
        // 1분에 한번 내 select All
    }
}
