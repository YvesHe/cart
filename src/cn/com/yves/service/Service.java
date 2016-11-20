/**   
 * Filename:    Service.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午4:34:26   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
