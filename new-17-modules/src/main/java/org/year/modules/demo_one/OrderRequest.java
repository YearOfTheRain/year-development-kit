package org.year.modules.demo_one;

/**
 * @author YearOfTheRain
 * @create 2024-11-19  11:44
 */
public record OrderRequest(String orderId, Integer type) {

    public OrderRequest {
        orderId = orderId.trim();
        type = 2;
    }
}
