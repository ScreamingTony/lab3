package cn.edu.xmu.restfuldemo.bean;

import com.alibaba.druid.sql.dialect.oracle.ast.OracleDataTypeIntervalYear;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post_Orders implements Serializable{
    private String consignee;
    private Integer regionId;
    private String address;
    private String mobile;
    private String message;
    private Integer couponId;
    private Integer presaleId;
    private Integer grouponId;
    private List<Post_OrderItems> orderItemsList;

}
