<%-- 
    Document   : users
    Created on : Mar 6, 2023, 3:44:41 PM
    Author     : radia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users System</title>
    </head>
    <body>
        ${Message}
        <h1>Manage Users</h1>
        <c:if test="${users.isEmpty()}">No users found. Please try again</c:if>
        
        <c:if test="${!users.isEmpty()}">
         <table border="1">
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                
                 <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.role.roleName}</td>
                        <td><a href="User?action=edit&amp;key=${user.email}">Edit</a></td>
                        <td><a href="User?action=delete&amp;key=${user.email}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
                    
            <c:if test="${user eq null}">
            <h2>Add User</h2>
            <form action="" method="post">
                Email: <input type="text" name="email" value="${email}"><br>
                First name <input type="text" name="firstname" value="${firstname}"><br>
                Last name <input type="text" name="lastname" value="${lastname}"><br>
                Password: <input type="password" name="password"><br>
                Role:
                <select name="role">
                    <option value="1">system </option>
                    <option value="2">regular user</option>
                </select><br>
                <input type="submit" name="submit" value="Add User">
            </form>
                ${fillAll}
        </c:if>
        
        <c:otherwise>
                <h3>Edit User</h3>
                <form action="User" method="POST">
                    Email: ${user.getemail}<br>
                    <input type="hidden" name="email" value="${user.getemail}">
                    <label>First Name <input name="firstName" value="${selecteduser.firstName}"></label><br>
                    <label>Last Name <input name="lastName" value="${selecteduser.lastName}"></label><br>
                    <label>Password <input type="password" name="password"</label><br>
                    Role:  
                    <select name="role">
                        <option value="2">regular user</option>
                        <option value="1" ${selecteduser.role.roleID == '1' ? 'selected' : ''}> system
                        </option>
                    </select><br>
                    
                    <input type="hidden" name="role" value="${selecteduser.role.roleID}">
                    <input type="submit" name="submit" value="Update">
                    <input type="submit" name ="submit" value="Cancel">
                    ${formmessage}
                </form>         

            </c:otherwise> 
 
    </body>
</html>
