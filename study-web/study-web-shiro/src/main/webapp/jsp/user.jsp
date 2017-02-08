<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>
        用户列表
    </title>
</head>
<body>
<h1>${message}</h1>
<h1>用户列表--<a href="/user/add">添加用户</a>--<a href="/logout">退出登录</a></h1>
<h2>权限列表</h2>
<shiro:authenticated>用户已登录显示此内容</shiro:authenticated>
<shiro:hasRole name="admin">admin角色登录显示此类容</shiro:hasRole>
<shiro:hasRole name="manager">manager角色登录显示此类容</shiro:hasRole>
<shiro:hasRole name="normal">normal角色登录显示此类容</shiro:hasRole>

<shiro:hasAnyRoles name="manager,admin">manager or admin 角色登录显示此内容</shiro:hasAnyRoles>

<shiro:principal/>
<shiro:hasPermission name="add">add权限</shiro:hasPermission>
<shiro:hasPermission name="user:query">query权限</shiro:hasPermission>
<shiro:lacksPermission name="user:del">del权限</shiro:lacksPermission>

<ul>
    <c:forEach items="${userList}" var="user">
        <li>用户名：${user.userName}-----密码:${user.pwd}-----<a href="/user/edit/${user.id}">修改用户</a>-----<a href="javascript:;" class="del" ref="${user.id}">删除用户</a></li>
    </c:forEach>
</ul>

<script type="text/javascript" src="http://cdn.staticfile.org/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".del").click(function(){
            var id=$(this).attr("ref");
            $.ajax({
                type:"delete",
                url:"/user/del/"+id,
                success:function (e) {
                    
                }
            });
        });
    });
</script>

</body>
</html>