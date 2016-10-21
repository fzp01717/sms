<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<%@ include file="/views/common/header.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        $('#getUserList').click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/public/user/api/getUserList",
                dataType:'json',
                success:function (result) {
                    result=JSON.stringify(result);
                    $('#result').html(result);
                    console.log(result);
                },
                error:function (error) {
                    $('#result').val(error);
                    console.log(error);
                }
            });
        });

        $('#getUserInfo').click(function () {
            var userName=$("#userName").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/public/user/api/getUserInfo",
                data:"userName="+userName,
                dataType:'json',
                method:"post",
                success:function (result) {

                    result=JSON.stringify(result);

                    $('#userInfo').html(result);
                    console.log(result);
                },
                error:function (error) {
                    $('#userInfo').val(error);
                    console.log(error);
                }
            });
        });

    });
</script>
<div class="container container-fluid">
   <%-- <security:authorize access="isAuthenticated()">
        Authenticated as <security:authentication property="principal.username" />
    </security:authorize>--%>
    <h1>${userName}</h1>
</div>
<div class="container container-fluid">

</div>

<%--<c:if test="${userList !=null}">
    <div class="container container-fluid">
        <table border="1" class="table-responsive">
            <tr>
                <th>User Id</th>
                    &lt;%&ndash;<th>Password</th>&ndash;%&gt;
                <th>Type</th>
            </tr>
            <c:forEach items="${userList}" var="users">
                <tr>
                    <td>${users.userId}</td>
                        &lt;%&ndash;<td>${users.password}</td>&ndash;%&gt;
                    <td>${users.type}</td>
                </tr>
            </c:forEach>
        </table>

        <button class="btn btn-info" id="infoBtn" value="${userList}">Info</button>

    </div>

</c:if>--%>

<button type="submit" class="button btn-info" id="getUserList">Click Me</button>
<form:form action="${pageContext.request.contextPath}/public/user/logout" method="post">
    <button type="submit" class="btn btn-danger">LogOut</button>
</form:form>
<br>
<div class="container">
        <input type="text" placeholder="User Name"
                     id="userName" class="form-control"/>


    <button  id="getUserInfo" class="btn btn-primary">Login</button>

    <div id="userInfo" >

    </div>
</div>
<form:form action="${pageContext.request.contextPath}/public/user/logoutAll" method="post">
    <button type="submit" class="btn btn-danger">Logout All</button>
</form:form>
<br>
<div id="result"></div>
<%@ include file="/views/common/footer.jsp" %>