/**   
 * Filename:    CartUpdateItemService.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午5:05:18   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.service.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.yves.logic.Cart;
import cn.com.yves.service.Service;

public class CartUpdateItemService implements Service {

    public void execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.updateItemNum(request.getParameter("productId"),
                Integer.parseInt(request.getParameter("productCount")));

        try {

            request.setAttribute("message", "商品数量修改成功!");
            request.setAttribute("url", "cartControl?service=cartList");
            request.getRequestDispatcher("pages/cart/message.jsp").forward(
                    request, response);

        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
