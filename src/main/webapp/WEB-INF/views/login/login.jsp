<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-17
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <jsp:include page="/resources/include/header.jsp"/>
</head>
<body class="sidebar-dark">
<div class="main-wrapper">
    <div class="page-wrapper full-page">
        <div class="page-content d-flex align-items-center justify-content-center">
            <div class="row w-100 mx-0 auth-page">
                <div class="col-md-8 col-xl-4 mx-auto">
                    <div class="card">
                        <div class="row">
                            <div class="col-md-12 pl-md-0">
                                <div class="auth-form-wrapper px-4 py-5">
                                    <a href="#" class="noble-ui-logo d-block mb-2">B<span>G</span></a>
                                    <h5 class="text-muted font-weight-normal mb-4">바꿔먹어 관리자 페이지입니다.</h5>
                                    <form action="/adminLogin.do" class="forms-sample" method="post">
                                        <div class="form-group">
                                            <label for="id">아이디</label>
                                            <input name="id" type="text" class="form-control" id="id" placeholder="Id">
                                        </div>
                                        <div class="form-group">
                                            <label for="pwd">비밀번호</label>
                                            <input name="pwd" type="password" class="form-control" id="pwd" autocomplete="current-password" placeholder="Password">
                                        </div>
                                        <div class="mt-3" style="display: flex; justify-content: space-between">
                                            <button type="submit" class="btn btn-primary mr-2 mb-2 mb-md-0 text-white" style="margin-left: auto;">Login</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="/resources/include/javascript.jsp"/>
</body>
</html>
