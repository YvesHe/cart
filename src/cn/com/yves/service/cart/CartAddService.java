/**   
 * Filename:    CartAddService.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-20 下午5:02:14   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.service.cart;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.yves.dao.BookDaoInf;
import cn.com.yves.dao.book.BookDaoImpl;
import cn.com.yves.logic.Cart;
import cn.com.yves.pojo.BookBean;
import cn.com.yves.pojo.ItemBean;
import cn.com.yves.service.Service;

public class CartAddService implements Service {
    // dao层在Service层写, 在实体的javabean中 比如logicbean中不做访问数据库的操作.
    private final BookDaoInf bookDao;

    public CartAddService() {
        bookDao = new BookDaoImpl();
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) {

        // 如果购物中已经有了,就不做任何操作
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");// 英文cart配置在了监听器中,所有一定会有

        if (cart.exist(request.getParameter("productId"))) {
            request.setAttribute("message", "该商品已经在购物车中,要修改数量请在购物车中修改!");// 设置跳转后显示的消息
            request.setAttribute("url", "cartControl?service=cartList");// 设置显示消息后要跳转的页面
            try {
                request.getRequestDispatcher("pages/cart/message.jsp").forward(
                        request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }

        // 不存在，就查数据库,查出数据
        BookBean bookBean = null;
        try {
            bookBean = bookDao.getBookBeanById(request
                    .getParameter("productId").trim());

            if (bookBean != null) {
                cart.addItem(new ItemBean(bookBean));
            }

            request.setAttribute("message", "添加商品成功!");// 设置跳转后显示的消息
            request.setAttribute("url", "pages/cart/listAllBook.jsp");// 设置显示消息后要跳转的页面
            try {
                request.getRequestDispatcher("pages/cart/message.jsp").forward(
                        request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
