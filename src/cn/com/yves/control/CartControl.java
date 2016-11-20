/**   
 * Filename:    BookControl.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午5:44:18   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.yves.service.cart.CartServiceFactory;

public class CartControl extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String service = request.getParameter("service").trim();

        if (service.equals("cartList")) {
            CartServiceFactory.createListService().execute(request, response);
        } else if (service.equals("cartAdd")) {
            CartServiceFactory.createAddService().execute(request, response);

        } else if (service.equals("cartUpdate")) {
            CartServiceFactory.createUpdateItemService().execute(request,
                    response);

        } else if (service.equals("cartDelete")) {
            CartServiceFactory.createDelItemService()
                    .execute(request, response);
        } else if (service.equals("cartClear")) {
            CartServiceFactory.createClearService().execute(request, response);
        } else if (service.equals("shopping")) {// 继续购物
            response.sendRedirect("pages/cart/listAllBook.jsp");
        }

    }
}
