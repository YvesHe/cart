/**   
 * Filename:    BookItemBean.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午5:07:01   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.pojo;

/**
 * 购物车 每一行的封装商品Bean
 * 
 * @author Yves He
 * 
 */
public class ItemBean {// 属性的初始化放在构造方法中

    private final ProductBean productBean;
    private int count; // 购买的数量

    public ItemBean(ProductBean productBean) {
        this.count = 1;
        this.productBean = productBean;
    }

    /**
     * 返回该种商品的总价
     * 
     * @return
     */
    public double getSumPrice() {
        return productBean.getPrice().doubleValue() * count;
    }

    /**
     * 返回该种商品的id
     * 
     * @return
     */
    public String getProductId() {
        return productBean.getId();
    }

    public int getCount() {
        return count;
    }

    /**
     * 设置该种商品的购买数量
     * 
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

}
