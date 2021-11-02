package cn.edu.xmu.restfuldemo.bean;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Post_OrderItems {
    private Integer skuId;
    private Integer quantity;
    private Integer couponActId;
}
