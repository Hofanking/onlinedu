package com.scorpios.orderservice.service;

import com.scorpios.orderservice.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author scorpios
 * @since 2020-04-19
 */
public interface OrderService extends IService<Order> {
    //1 生成订单的方法
    String createOrders(String courseId, String memberIdByJwtToken);
}
