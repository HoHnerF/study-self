package com.ge.studyself.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * member_id
     */
    private String name;
    /**
     * 订单总额
     */
    private BigDecimal totalAmount;
}
