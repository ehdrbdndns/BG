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

    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="/resources/assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="/resources/assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="/resources/assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="/resources/assets/images/favicon.png" />
    <!-- custom -->
    <link rel="stylesheet" href="/resources/assets/css/custom.css" />
</head>
<body class="sidebar-dark">
<div class="main-wrapper">
    <jsp:include page="/resources/include/sidebar.jsp"/>
    <div class="page-wrapper">
        <!--TODO Top NavBar-->
        <jsp:include page="/resources/include/navbar.jsp" />
        <!--TODO Top NavBar End-->
        <div class="page-content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">
                                커뮤니티 상세내용
                            </div>
                            <div class="d-flex">
                                <div class="form-group col-6 pl-0">
                                    <label>제목</label>
                                    <input type="text" value="${communityInfo.community_Title}" class="form-control" disabled>
                                </div>
                                <div class="form-group mr-3">
                                    <label>좋아요 수</label>
                                    <input type="text" value="${communityInfo.community_Likes}" class="form-control" disabled>
                                </div>
                                <div class="form-group mr-3">
                                    <label>댓글 수</label>
                                    <input type="text" value="${communityInfo.reply_Count}" class="form-control" disabled>
                                </div>
                                <div class="form-group mr-3">
                                    <label>작성자</label>
                                    <input type="text" value="${communityInfo.user_Name}" class="form-control" disabled>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="form-group col-6 pl-0">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="5" disabled>${communityInfo.community_Contents}</textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>이미지</label>
                                <div class="d-flex">
                                    <c:forEach var="item" varStatus="i" items="${communityInfo.community_Img_Array}">
                                        <img src="${filePath}${item}" alt="" class="mr-4">
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between">
                                <div></div>
                                <div class="d-flex">
                                    <div class="btn btn-primary mr-3" onclick="location.href='/communityPage.do'">뒤로</div>
                                    <div class="btn btn-danger" onclick="deleteCommunity(${communityInfo.community_No})">삭제</div>
                                </div>
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
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<!-- end custom js for this page -->
</body>
<script>
    function deleteCommunity(communityNo){
        location.href="/deleteCommunity.do?Community_No=" + communityNo;
    }
</script>
</html>
