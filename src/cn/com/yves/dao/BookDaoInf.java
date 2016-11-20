/**   
 * Filename:    BookAdd.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午5:29:05   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.dao;

import java.sql.SQLException;
import java.util.List;

import cn.com.yves.pojo.BookBean;

public interface BookDaoInf {

    List<BookBean> listAllBookBean() throws SQLException;

    List<BookBean> getBookBeanName(String bookName) throws SQLException; // 模糊书名

    BookBean getBookBeanById(String userId) throws SQLException;

    BookBean getBookBeanByIsbn(String isbn) throws SQLException;

    boolean addBookBean(BookBean uBean) throws SQLException;

    boolean deleteBookBean(String userId) throws SQLException;

    boolean updateBookBean(BookBean BookBean) throws SQLException;;

}
