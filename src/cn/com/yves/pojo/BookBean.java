/**   
 * Filename:    BookBean.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午5:24:14   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.pojo;

public class BookBean extends ProductBean {

    private String isbn;
    private String publisher;
    private java.sql.Timestamp pubdate; // 对应mysql中的datetime 类型

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public java.sql.Timestamp getPubdate() {
        return pubdate;
    }

    public void setPubdate(java.sql.Timestamp pubdate) {
        this.pubdate = pubdate;
    }

}
