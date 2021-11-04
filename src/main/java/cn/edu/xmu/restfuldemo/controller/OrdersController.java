package cn.edu.xmu.restfuldemo.controller;


import cn.edu.xmu.restfuldemo.bean.*;

import cn.edu.xmu.restfuldemo.bean.OrdersVo;
import cn.edu.xmu.restfuldemo.service.RocketMQService;
import cn.edu.xmu.restfuldemo.util.ResponseCode;
import cn.edu.xmu.restfuldemo.util.ResponseUtil;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import cn.edu.xmu.restfuldemo.service.OrdersService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.edu.xmu.restfuldemo.util.Common.*;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单控制器
 * @author Yixuan Chen
 */

//OrdersController是一个RESTful控制类，接收json格式，返回json格式
//返回的json会有中文，需要设置编码格式为UTF-8
@Api(value = "订单API",tags = "订单API")
@RestController
@RequestMapping(value = "/orders", produces = "application/json;charset=UTF-8")
public class OrdersController {
    //使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
    private final Logger logger = LoggerFactory.getLogger(OrdersController.class);


    //待定义的OrdersService类
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private RocketMQService rocketMQService;

    @PostMapping("/post/rocket/1")
    public void createGood1(@Validated @RequestBody Post_Orders post_orders, BindingResult bindingResult){
        Object returnObject = processFieldErrors(bindingResult, httpServletResponse);
        if (null != returnObject){
            System.out.println("未通过合法性检查");
        }

        post_orders.setAddress("string");
        post_orders.setConsignee("string");
        post_orders.setCouponId(0);
        post_orders.setMessage("string");
        post_orders.setMobile("string");
        post_orders.setGrouponId(0);
        post_orders.setRegionId(0);
        post_orders.setPresaleId(0);
        Post_OrderItems post_orderItems=new Post_OrderItems();
        post_orderItems.setQuantity(0);
        post_orderItems.setCouponActId(0);
        post_orderItems.setSkuId(0);
        post_orders.getOrderItemsList().add(post_orderItems);

        rocketMQService.sendOrdersMessage1(post_orders);
        httpServletResponse.setStatus(HttpStatus.CREATED.value());
    }
    @PostMapping("/post/rocket/2")
    public void createGood2(@Validated @RequestBody Post_Orders post_orders, BindingResult bindingResult){

        Object returnObject = processFieldErrors(bindingResult, httpServletResponse);
        if (null != returnObject){
            System.out.println("未通过合法性检查");
        }

        post_orders.setAddress("string");
        post_orders.setConsignee("string");
        post_orders.setCouponId(0);
        post_orders.setMessage("string");
        post_orders.setMobile("string");
        post_orders.setGrouponId(0);
        post_orders.setRegionId(0);
        post_orders.setPresaleId(0);
        Post_OrderItems post_orderItems=new Post_OrderItems();
        post_orderItems.setQuantity(0);
        post_orderItems.setCouponActId(0);
        post_orderItems.setSkuId(0);
        post_orders.getOrderItemsList().add(post_orderItems);

        rocketMQService.sendOrdersMessage1(post_orders);
        httpServletResponse.setStatus(HttpStatus.CREATED.value());
    }
    @PostMapping("/post/rocket/3")
    public void createGood3(@Validated @RequestBody Post_Orders post_orders, BindingResult bindingResult){

        Object returnObject = processFieldErrors(bindingResult, httpServletResponse);
        if (null != returnObject){
            System.out.println("未通过合法性检查");
        }

        post_orders.setAddress("string");
        post_orders.setConsignee("string");
        post_orders.setCouponId(0);
        post_orders.setMessage("string");
        post_orders.setMobile("string");
        post_orders.setGrouponId(0);
        post_orders.setRegionId(0);
        post_orders.setPresaleId(0);
        Post_OrderItems post_orderItems=new Post_OrderItems();
        post_orderItems.setQuantity(0);
        post_orderItems.setCouponActId(0);
        post_orderItems.setSkuId(0);
        post_orders.getOrderItemsList().add(post_orderItems);

        rocketMQService.sendOrdersMessage1(post_orders);
        httpServletResponse.setStatus(HttpStatus.CREATED.value());
    }

    @PostMapping("/post/test1")
    public void createGood4(@RequestBody Post_Orders post_orders){
        post_orders.setAddress("string");
        post_orders.setConsignee("string");
        post_orders.setCouponId(0);
        post_orders.setMessage("string");
        post_orders.setMobile("string");
        post_orders.setGrouponId(0);
        post_orders.setRegionId(0);
        post_orders.setPresaleId(0);
        Post_OrderItems post_orderItems=new Post_OrderItems();
        post_orderItems.setQuantity(0);
        post_orderItems.setCouponActId(0);
        post_orderItems.setSkuId(0);
        post_orders.getOrderItemsList().add(post_orderItems);
        ordersService.InsertOrders(post_orders);
    }
}
