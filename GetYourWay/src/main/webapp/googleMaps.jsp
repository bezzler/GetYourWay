<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>

<h1><%=request.getParameter("origin") %></h1>

<h2>HEllO1</h2>

<iframe
  width="600"
  height="450"
  frameborder="0" style="border:0"
  src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyB4kK5wx-R7XlUE1PjWi41biiUafnvmIcg
     &origin=Cheltenham
     &destination=London
     &mode=transit">
</iframe>
</body>
</html>