<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${proPath}/jquery-easyui-1.3.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${proPath}/jquery-easyui-1.3.5/themes/icon.css">
<script type="text/javascript" src="${proPath}/jquery-easyui-1.3.5/jquery.min.js"></script>
<script type="text/javascript" src="${proPath}/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>

<script type="text/javascript">
	$(function(){alert("可以使用了!");});
</script>

</head>
<body>
   <div id="p" class="easyui-panel" style="width:500px;height:200px;padding:10px;"  
        title="My Panel" iconCls="icon-save" collapsible="true">  
    test my panel   
   </div>

</body>
</html>