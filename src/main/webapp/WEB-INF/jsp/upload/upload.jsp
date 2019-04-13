<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="../fragments/headTag.jsp"/>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/upload">
    File to upload: <input type="file" name="file">
    <br/>
    Name: <input type="text" name="name">
    <br/>
    <br/>
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>
