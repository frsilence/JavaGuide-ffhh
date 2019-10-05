<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gk</title>
</head>
<body>
	<form action='<c:url value="/GKServlet"></c:url>'  method="post">
		<table>
			<thead>
				<tr>
					<td>年份</td>
					<td>批次</td>
					<td>最高</td>
					<td>最低</td>	
					<td>平均</td>				
				</tr>
			</thead>
			<tbody>
				<tr>
				<td><select name="year">
			<option value="2018">2018</option>
			<option value="2017">2017</option>
			<option value="2016">2016</option>
		</select></td>
					<td><select name="pici">
			<option value="0">一</option>
			<option value="1" selected="selected">二</option>
			<option value="2">三</option>
			<option value="3">四</option>
		</select></td>
				<td><input name="high"/></td>
				<td><input name="low" /></td>
				<td><input name="avg"></td>
				</tr>
				<tr>
					<td colspan="2">差值</td>
					<td><input value='<c:out value="${requestScope.score.high }"></c:out>'/></td>
					<td><input value='<c:out value="${requestScope.score.low }"></c:out>'/></td>
					<td><input value='<c:out value="${requestScope.score.avg }"></c:out>'/></td>
					</tr>
					<tr><td colspan="4"><input type="submit" value="计算"></td></tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>