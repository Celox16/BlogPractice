<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JBlog 로그인</title>
    <link rel="stylesheet" href="css/theme.css">
</head>
<body>
<form action="login.do" method="post">
    <table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td height=40 colspan="10"></td>
        </tr>
        <tr>
            <td width="100%" height="120" colspan="10" align="center">
                <img src="images/logo.jpg" border="0">
            </td>
        </tr>
        <tr>
            <td height="20" colspan="10" align="center" class="tdcontent">
                아이디 : <input type="text" name="id" value="user" size="15">
                패스워드 : <input type="text" name="password" value="user123" size="15">
            </td>
        </tr>
        <tr>
            <td height="40" colspan="10" align="center">
                <input type="submit" value="로그인">
            </td>
        </tr>
        <tr>
            <td colspan="10"></td>
        </tr>
    </table>
</form>
</body>
</html>