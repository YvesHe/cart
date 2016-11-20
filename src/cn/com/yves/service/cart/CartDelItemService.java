/**   
 * Filename:    CartDelItemService.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午5:03:18   
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

public class CartDelItemService implements Service {

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.delItem(request.getParameter("productId").trim());

        try {

            request.setAttribute("message", "删除成功!");
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
