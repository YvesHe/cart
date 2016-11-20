<%@page import="cn.com.yves.pojo.BookBean"%>
<%@page import="cn.com.yves.dao.book.BookDaoImpl"%>
<%@page import="cn.com.yves.dao.BookDaoInf"%>

<!--  设置页面显示的编码  和  启用EL表达式  -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"
	contentType="text/html; charset=UTF-8"%>

<!-- 引用标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>



<!-- 获取所有的商品信息: 这里是所有的书籍 -->
<%
    BookDaoInf bookDao = new BookDaoImpl();
    List<BookBean> list = bookDao.listAllBookBean();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'listCart.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>


<body>
	<h1>
		<center>所有的书籍信息</center>
	</h1>

	<a href="cartControl?service=cartList">查看购物车</a>
	<br>
	<table border="1">

		<tr>
			<th>书籍编号</th>
			<th>书籍ISBN</th>
			<th>书籍名称</th>
			<th>书籍出版社</th>
			<th>书籍出版日期</th>
			<th>书籍价格</th>
			<th>购买</th>
		</tr>
		<c:forEach var="bookBean" items="<%=list %>">
			<tr>
				<td>${bookBean.id }</td>
				<td>${bookBean.isbn }</td>
				<td>${bookBean.name }</td>
				<td>${bookBean.publisher }</td>
				<td>${bookBean.pubdate }</td>
				<td>${bookBean.price }</td>
				<td><a href="cartControl?service=cartAdd&productId=${bookBean.id  }">购买</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
