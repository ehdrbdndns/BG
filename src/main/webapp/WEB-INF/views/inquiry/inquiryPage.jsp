<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-17
  Time: 오후 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>바꿔먹어 관지자 페이지</title>
    <!-- core:css -->
    <link rel="stylesheet" href="/resources/assets/vendors/core/core.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <link rel="stylesheet" href="/resources/assets/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="/resources/assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="/resources/assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="/resources/assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="/resources/assets/images/favicon.png"/>
    <!-- custom -->
    <link rel="stylesheet" href="/resources/assets/css/custom.css"/>
</head>
<body class="sidebar-dark">
<div class="main-wrapper">
    <jsp:include page="/resources/include/sidebar.jsp"/>
    <div class="page-wrapper">
        <!--TODO Top NavBar-->
        <jsp:include page="/resources/include/navbar.jsp"/>
        <!--TODO Top NavBar End-->
        <div class="page-content">
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">문의관리</h6>
                            <div class="table-responsive">
                                <table id="inquiryInfo" class="table">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>이름</th>
                                        <th>상호명</th>
                                        <th>문의 제목</th>
                                        <th>카테고리</th>
                                        <th>답변 상태</th>
                                        <th>문의 일자</th>
                                        <th>상세 보기</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" varStatus="i" items="${inquiryInfo}">
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td>${item.user_Name}</td>
                                            <td>${item.user_ComNm}</td>
                                            <td>${item.inquiry_Title}</td>
                                            <c:choose>
                                                <c:when test="${item.inquiry_Category eq 'report'}">
                                                    <td>신고</td>
                                                </c:when>
                                                <c:when test="${item.inquiry_Category eq 'use'}">
                                                    <td>이용 문의</td>
                                                </c:when>
                                                <c:when test="${item.inquiry_Category eq 'advertise'}">
                                                    <td>광고 문의</td>
                                                </c:when>
                                                <c:when test="${item.inquiry_Category eq 'inconvenient'}">
                                                    <td>불편 문의</td>
                                                </c:when>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${item.inquiry_Answer eq null}">
                                                    <td>
                                                        <div class="btn btn-danger">미답변</div>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <div class="btn btn-success">답변</div>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${item.inquiry_RegDate}</td>
                                            <td>
                                                <div class="btn btn-outline-linkedin"
                                                     onclick="location.href='/inquiryDetailPage.do?Inquiry_No=${item.inquiry_No}'">이동
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/resources/include/footer.jsp"/>
    </div>
</div>
<!-- core:js -->
<script src="/resources/assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="/resources/assets/vendors/jquery.flot/jquery.flot.js"></script>
<script src="/resources/assets/vendors/jquery.flot/jquery.flot.resize.js"></script>
<script src="/resources/assets/vendors/datatables.net/jquery.dataTables.js"></script>
<script src="/resources/assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<script src="/resources/assets/js/data-table.js"></script>
<!-- end custom js for this page -->
</body>
<script>

</script>
</html>
