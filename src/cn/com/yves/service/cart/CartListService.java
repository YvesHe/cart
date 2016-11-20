/**   
 * Filename:    CartQueryService.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午4:37:32   
 * Description: 展示购物中所有的清单  : list all
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

public class CartListService implements Service {

    public void execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        request.setAttribute("items", cart.getItems());
        try {
            request.getRequestDispatcher("pages/cart/cartList.jsp").forward(
                    request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
