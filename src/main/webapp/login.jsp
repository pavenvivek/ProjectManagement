<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- <jsp:include page="basic.jsp"></jsp:include> --%>

<script type="text/javascript">
	<%@ include file="resources/js/bootstrap-login.min.js"%>
</script>

<style type="text/css">
	<%@ include file="resources/css/bootstrap-login-theme.min.css"%>
	<%@ include file="resources/css/bootstrap-login.min.css"%>
	<%@ include file="resources/login.css"%>
</style>
</head>

<body>

<div class="container">

      <form class="form-signin" action="dologin.html" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="username" class="sr-only">Email address</label>
        <input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->



</body>
</html>