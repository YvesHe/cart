/**   
 * Filename:    ProductBean.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午5:40:59   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.pojo;

/**
 * 所有商品的父Bean
 * 
 * @author Yves He
 * 
 */
public abstract class ProductBean {

    private String id; // 商品id
    private String name; // 商品名
    private java.math.BigDecimal price; // 商品价格

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

}
