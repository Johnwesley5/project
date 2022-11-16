<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
 <div align="center">
  <h1>User Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>User Name</td>
     <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
     <td>User Email</td>
     <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
     <td>Mobile</td>
     <td><input type="text" name="Mobile" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>