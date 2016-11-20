package cn.com.yves.dao.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.yves.dao.BookDaoInf;
import cn.com.yves.pojo.BookBean;
import cn.com.yves.utill.DBUtill;

public class BookDaoImpl implements BookDaoInf {

    public List<BookBean> listAllBookBean() throws SQLException {

        List<BookBean> list = new ArrayList<BookBean>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        final String sql = "select * from book";
        try {
            conn = DBUtill.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            BookBean bBean = null;
            while (rs.next()) {
                bBean = new BookBean();
                bBean.setId(rs.getString("id"));
                bBean.setIsbn(rs.getString("isbn"));
                bBean.setName(rs.getString("name"));
                bBean.setPrice(rs.getBigDecimal("price"));
                bBean.setPubdate(rs.getTimestamp("Pubdate"));
                bBean.setPublisher(rs.getString("publisher"));
                list.add(bBean);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            DBUtill.close(conn, pstm, rs);
        }
        return list;
    }

    public List<BookBean> getBookBeanName(String bookName) throws SQLException {
        return null;
    }

    public BookBean getBookBeanById(String bookId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        BookBean bBean = null;
        final String sql = "select * from book where id = ?";
        try {
            conn = DBUtill.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, bookId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                bBean = new BookBean();
                bBean.setId(rs.getString("id"));
                bBean.setIsbn(rs.getString("isbn"));
                bBean.setName(rs.getString("name"));
                bBean.setPrice(rs.getBigDecimal("price"));
                bBean.setPubdate(rs.getTimestamp("Pubdate"));
                bBean.setPublisher(rs.getString("publisher"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            DBUtill.close(conn, pstm, rs);
        }
        return bBean;
    }

    public BookBean getBookBeanByIsbn(String isbn) throws SQLException {
        return null;
    }

    public boolean addBookBean(BookBean uBean) throws SQLException {
        return false;
    }

    public boolean deleteBookBean(String userId) throws SQLException {
        return false;
    }

    public boolean updateBookBean(BookBean BookBean) throws SQLException {
        return false;
    }
}
