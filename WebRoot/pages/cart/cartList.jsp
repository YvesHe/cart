<!-- 设置页面属性 -->
<%@page import="cn.com.yves.pojo.BookBean"%>
<%@page import="cn.com.yves.pojo.ItemBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8" isELIgnored="false"%>


<!-- 设置引用标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'cartList.jsp' starting page</title>

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
	<h1>我的购物车</h1>
	<table border="1">

		<tr>
			<th>书籍编号</th>
			<th>书籍ISBN</th>
			<th>书籍名称</th>
			<th>书籍出版社</th>
			<th>书籍出版日期</th>
			<th>书籍价格</th>
			<th>数量</th>
			<th>操作</th>
		</tr>

		<%
		    Collection collection = (Collection) request.getAttribute("items");
		    for (Object oo : collection) {
		        ItemBean ib = (ItemBean) oo;
		        BookBean bBean = (BookBean) ib.getProductBean();
		%>
		<form action="cartControl?service=cartUpdate" method="post">
			<input name="productId" type="hidden" value="<%=bBean.getId()%>">
			<tr>
				<td><%=bBean.getId()%></td>
				<td><%=bBean.getIsbn()%></td>
				<td><%=bBean.getName()%></td>
				<td><%=bBean.getPublisher()%></td>
				<td><%=bBean.getPubdate()%></td>
				<td><%=bBean.getPrice()%></td>
				<td><input name="productCount" type="text" value="<%=ib.getCount()%>">
				</td>
				<td><input type="submit" value="修改"> <a
						href="cartControl?service=cartDelete&productId=<%=bBean.getId()%>">删除</a></td>
			</tr>
		</form>

		<%
		    }
		%>
	</table>

	<a href="cartControl?service=cartClear">清空购物车</a>
	<a href="cartControl?service=shopping">继续购物</a>

	<br> 商品种类:${sessionScope.cart.count }
	<br>商品总价:${sessionScope.cart.sumPrice }
	<!-- 这里的原理是EL是通过属性反射来获取值的,所以sumPrice属性不存在,但是只要有getSumPrice()方法依然可以用. -->
</body>


</html>
