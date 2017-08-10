<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="/employee/Register.controller"/>" method="post">
帳號: <input type="text" name="account" value="">${errorMsg.account}<br><br>
密碼: <input type="password" name="password" value="">${errorMsg.password}<br><br>
員工編號: <input type="text" name="empNo" value="">${errorMsg.empNo}<br><br>
員工姓名: <input type="text" name="name" value="">${errorMsg.name}<br><br>
英文姓名: <input type="text" name="engName" value="">${errorMsg.engName}<br><br>
分機: <input type="text" name="ext" value="">${errorMsg.ext}<br><br>
部門: <select name="dep">
         <option value="0">選擇部門</option>
         <c:forEach var="depList" items="${depList}">
         <option value="${depList.no}">${depList.name}</option>
         </c:forEach>
     </select>${errorMsg.depNo}<br><br>
職務: <select name="job">
         <option value="0">選擇職務</option>
         <c:forEach var="jobList" items="${jobList}">
         <option value="${jobList.no}">${jobList.name}</option>
         </c:forEach>
     </select>${errorMsg.jobNo}<br><br> 
權限: <select name="character">
         <option value="0">選擇職務</option>
         <option value="admin">admin</option>
         <option value="common">common</option>
     </select>${errorMsg.character}<br><br> 
<button type="submit" name="send" value="register">確認</button>
<button type="reset" name="send" value="cancel">清除</button>
 
</form>

</body>
</html>