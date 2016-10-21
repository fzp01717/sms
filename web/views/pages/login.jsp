<%@ page import="com.farhad.SMS.Value.Html" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/views/common/header.jsp" %>
<div id="container">
    <div class="container-fluid"><br/>
        <br/>
        <div class="row">
            <div class="col-sm-offset-4 col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h1 class="panel-title"><i class="fa fa-lock"></i> Please enter your login details.</h1>
                    </div>
                    <div class="panel-body">
                        <c:if test="${Error!=null}">
                            <div class="alert alert-danger"><i class="fa fa-exclamation-circle"></i> ${Error}<a href="#"
                                                                                                                class="close"
                                                                                                                data-dismiss="alert"
                                                                                                                aria-label="close">&times;</a>
                            </div>
                        </c:if>
                        <c:if test="${LogOut!=null}">
                            <div class="alert alert-success"><i class="fa fa-exclamation-circle"></i> ${LogOut}<a href="#"
                                                                                                                class="close"
                                                                                                                data-dismiss="alert"
                                                                                                                aria-label="close">&times;</a>
                            </div>
                        </c:if>
                        <form:form modelAttribute="UserInfoViewModel" action="${userActionUr}" method="post">
                            <spring:bind path="userName">
                                <div class="form-group  ${status.error ? 'has-error' : ''}">
                                    <label for="login-username">Username</label>
                                    <div class="input-group"><span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input:input type="text" path="userName" value="${userName}" placeholder="Username"
                                                     id="login-username" class="form-control" required="required"/>
                                    </div>
                                    <input:errors path="userName" cssClass="control-label"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="password">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label for="login-password">Password</label>
                                    <div class="input-group"><span class="input-group-addon"><i
                                            class="fa fa-key"></i></span>
                                        <input:input type="password" path="password"
                                                     placeholder="Password" id="login-password" class="form-control"
                                                     required="required"/>
                                    </div>
                                    <input:errors path="password" cssClass="control-label"/>
                                    <span class="help-block"><a
                                            href="#">Forgotten Password</a></span>
                                </div>
                            </spring:bind>
                            <div class="-align-right" style="float: left">
                                Remember Me:<input type="checkbox" class="checkbox"  style="float: right;" name="remember-me" />
                            </div>
                            <div class="text-right">

                                <button type="submit" id="submit" class="btn btn-primary"><i class="fa fa-key"></i>
                                    Login
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/views/common/footer.jsp" %>