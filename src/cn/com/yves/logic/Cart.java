/**   
 * Filename:    Cart.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午5:23:55   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.yves.pojo.ItemBean;

/**
 * 购物车Bean
 * 
 * @author Yves He
 * 
 */
public class Cart {

    private final Map<String, ItemBean> map;

    private int count; // 商品的种类

    public Cart() {
        map = new HashMap<String, ItemBean>();
        this.count = 0;
    }

    // 增加某种商品到购物车中
    public void addItem(ItemBean bib) {// 增加一种商品
        // 思考:map中有没有该商品 要不要在这判断

        map.put(bib.getProductId(), bib);// 用商品的id做map的key
        this.count++;

    }

    // 从购物车中删除某种商品
    public void delItem(String productId) {
        map.remove(productId);
        this.count--;
    }

    // 修改在购物车中某种商品的数量
    public void updateItemNum(String productId, int count) {// count不能为0
        if (map.containsKey(productId)) {
            map.get(productId).setCount(count);
        }
    }

    // 清空购物车
    public void clearCart() {
        map.clear();
        this.count = 0;
    }

    // 判断购物中是否已经有了该商品(是否有ItemBean)
    public boolean exist(String productId) {
        return map.containsKey(productId);
    }

    // 获取购物中所有的ItemBean : Collection是所有集合的父
    public Collection<ItemBean> getItems() {

        // return map.values();

        List<ItemBean> list = new ArrayList<ItemBean>();
        Set<String> key = map.keySet();
        for (String ss : key) {
            list.add(map.get(ss));
        }
        return list;

    }

    // 购物车中所有商品的总价
    public double getSumPrice() {
        double sumPrice = 0;
        Collection<ItemBean> items = this.map.values();
        for (ItemBean ib : items) {
            sumPrice += ib.getSumPrice();
        }
        return sumPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
