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
                <!-- TODO 회원가입 및 방문자 수 그래프 -->
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between">
                                <h6 class="card-title m-0">회원가입 및 방문자 수</h6>
                                <div class="d-flex">
                                    <div class="btn btn-primary">1일</div>
                                    <div class="btn btn-primary ml-2">1주</div>
                                    <div class="btn btn-primary ml-2">1달</div>
                                    <div class="btn btn-primary ml-2">3달</div>
                                    <div class="btn btn-primary ml-2">6달</div>
                                    <div class="btn btn-primary ml-2">1년</div>
                                </div>
                            </div>
                            <canvas id="chartViewerCount"></canvas>
                        </div>
                    </div>
                </div>
                <!-- TODO 제안 요청 수 그래프 -->
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">제안 요청 수</h6>
                            <canvas id="chartProposal"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <!-- TODO 카테고리 별 입점 수 그래프 -->
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">카테고리 별 입점 수</div>
                            <canvas id="chartCategory"></canvas>
                        </div>
                    </div>
                </div>
                <!-- TODO 광고 클릭 수 그래프 -->
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">광고 클릭 수</div>
                            <canvas id="chartAdvertise"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <!-- TODO 지역 별 입점 수 그래프 -->
                <div class="col-xl-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">지역 별 입점 수</h6>
                            <canvas id="chartArea"></canvas>
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
<script src="/resources/assets/vendors/chartjs/Chart.min.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<script src="/resources/assets/js/chartjs.js"></script>
<!-- end custom js for this page -->
</body>
<script>

</script>
</html>
