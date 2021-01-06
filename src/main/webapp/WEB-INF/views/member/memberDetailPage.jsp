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
                <div class="col-xl-12">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 회원가입 정보 -->
                            <div class="mb-5">
                                <h5 class="card-title">회원 가입 정보</h5>
                                <div class="d-flex">
                                    <div class="form-group mr-4">
                                        <label for="userEmail">사용자 ID(E-mail)</label>
                                        <input type="text" id="userEmail" class="form-control" disabled
                                               value="${userInfo.user_Email}">
                                    </div>
                                    <div class="form-group mr-4">
                                        <label for="userName">이름</label>
                                        <input type="text" id="userName" class="form-control" disabled
                                               value="${userInfo.user_Name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="phoneNumber">연락처</label>
                                        <input type="text" id="phoneNumber" class="form-control" disabled
                                               value="${userInfo.user_Phone}">
                                    </div>
                                </div>
                                <div class="d-flex position-relative">
                                    <div class="form-group mr-4">
                                        <label for="businessName">상호명</label>
                                        <input type="text" id="businessName" class="form-control" disabled
                                               value="${userInfo.user_ComNm}">
                                    </div>
                                    <div class="form-group mr-4">
                                        <label for="businessNumber">사업자 등록번호</label>
                                        <input type="text" id="businessNumber" class="form-control" disabled
                                               value="${userInfo.user_ComNo}">
                                    </div>
                                    <div class="form-group col-2">
                                        <label for="businessAddress">사업장 주소</label>
                                        <input type="text" id="businessAddress" class="form-control" disabled
                                               value="${userInfo.user_Addr}">
                                    </div>
                                    <div class="form-group col-2 mr-4">
                                        <label for="businessLicence">사업자 등록증</label>
                                        <div id="businessLicence"
                                             class="form-control cursor-pointer d-flex justify-content-between align-items-center"
                                             onclick="moveUrl('${userInfo.user_ComImg}')">
                                            <a>파일 다운로드</a>
                                            <i data-feather="upload"></i>
                                        </div>
                                    </div>
                                    <div class="btn btn-danger position-absolute" style="right: 0; bottom: 1rem">회원정지
                                    </div>
                                </div>
                            </div>
                            <!-- TODO 기업 정보 -->
                            <h5 class="card-title">기업 정보</h5>
                            <div class="d-flex">
                                <div class="form-group mr-4">
                                    <label for="formCategory">카테고리</label>
                                    <input type="text" class="form-control" id="formCategory" disabled
                                           value="${storeInfo.store_Category}">
                                </div>
                                <div class="form-group">
                                    <label for="formMenu">대표메뉴</label>
                                    <input type="text" class="form-control" id="formMenu" disabled
                                           value="${storeInfo.store_MainMenu}">
                                </div>
                            </div>
                            <!-- TODO 기업 정보의 상품리스트 -->
                            <div class="form-group">
                                <label>상품리스트</label>
                                <c:forEach items="${storeInfo.product_List}" varStatus="i" var="item">
                                    <div class="d-flex align-items-center mb-3">
                                        <img src="${filePath}${item.product_Img}"
                                             alt="" class="mr-4"
                                             style="width: 150px; height: 150px; border-radius: 10px;">
                                        <div class="form-group mr-4">
                                            <label>상품 이름</label>
                                            <input type="text" class="form-control" disabled
                                                   value="${item.product_Name}">
                                        </div>
                                        <div class="form-group mr-4">
                                            <label>상품 구성</label>
                                            <input type="text" class="form-control" disabled
                                                   value="${item.product_Compo}">
                                        </div>
                                        <div class="form-group mr-4">
                                            <label>상품 가격</label>
                                            <input type="text" class="form-control" disabled
                                                   value="${item.product_Price}">
                                        </div>
                                        <div class="form-group">
                                            <label>상품 할인율</label>
                                            <input type="text" class="form-control" disabled
                                                   value="${item.product_Sales}">
                                        </div>
                                    </div>
                                </c:forEach>
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
    function moveUrl(url) {
        window.open(url);
    }
</script>
</html>
