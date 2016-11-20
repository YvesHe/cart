/**   
 * Filename:    SessionListen.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午6:45:15   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.listen;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.com.yves.logic.Cart;

public class SessionListen implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent e) {// session
                                                    // 创建的时候，就将购物车放在session中,防止直接时候session没有cart

        Cart cart = new Cart();

        HttpSession session = e.getSession();
        session.setAttribute("cart", cart);

    }

    public void sessionDestroyed(HttpSessionEvent e) {

    }

}
