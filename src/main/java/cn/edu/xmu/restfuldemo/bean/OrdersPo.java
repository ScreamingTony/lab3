package cn.edu.xmu.restfuldemo.bean;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("OrdersPo")
public class OrdersPo {
    private Integer id;
    private Integer customer_id;
    private Integer shop_id;
    private String order_sn;
    private Integer pid;
    private String consignee;
    private Integer region_id;
    private String address;
    private String mobile;
    private String message;
    private Integer order_type;
    private Integer freight_price;
    private Integer coupon_id;
    private Integer coupon_activity_id;
    private Integer discount_price;
    private Integer origin_price;
    private Integer presale_id;
    private Integer groupon_discount;
    private Integer rebate_num;
    private Date confirm_time;
    private String shipment_sn;
    private Integer state;
    private Integer substate;
    private Integer be_deleted;
    private Date gmt_create;
    private Date gmt_modified;
    private Integer groupon_id;
    private List<OrderItemPo> order_itemPoList;

    public OrdersPo(Post_Orders postOrders)
    {
        this.consignee=postOrders.getConsignee();
        this.region_id=postOrders.getRegionId();
        this.address=postOrders.getAddress();
        this.mobile=postOrders.getMobile();
        this.message=postOrders.getMessage();
        this.coupon_id=postOrders.getCouponId();
        this.presale_id=postOrders.getPresaleId();
        this.groupon_id=postOrders.getGrouponId();
        for(Post_OrderItems postOrderItems:postOrders.getOrderItemsList())
        {
            OrderItemPo orderItemPo=new OrderItemPo(postOrderItems);
            order_itemPoList.add(orderItemPo);
        }
    }
}
