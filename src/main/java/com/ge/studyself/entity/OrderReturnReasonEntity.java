package com.ge.studyself.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gwj
 */
@ToString
@Data
public class OrderReturnReasonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;
	/**
	 * 退货原因名
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 启用状态
	 */
	private Integer status;
	/**
	 * create_time
	 */
	private Date createTime;

}
