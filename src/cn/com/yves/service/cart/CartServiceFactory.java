/**   
 * Filename:    CartServiceFactory.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午5:21:43   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.service.cart;

import cn.com.yves.service.Service;

public abstract class CartServiceFactory {

    public static Service createListService() {
        return new CartListService();
    }

    public static Service createAddService() {
        return new CartAddService();
    }

    public static Service createDelItemService() {
        return new CartDelItemService();
    }

    public static Service createUpdateItemService() {
        return new CartUpdateItemService();
    }

    public static Service createClearService() {
        return new CartClearService();
    }

}
