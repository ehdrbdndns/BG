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
            <!-- TODO 회원 및 방문자 수 그래프 -->
            <div class="row">
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between">
                                <h6 class="card-title m-0">회원가입 및 방문자 수</h6>
                                <div class="d-flex">
                                    <div class="btn btn-secondary" onclick="location.href='/homePage.do'" id="oneDay">1일
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/homePage.do?dayType=oneWeek'" id="oneWeek">1주
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/homePage.do?dayType=oneMonth'" id="oneMonth">1달
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/homePage.do?dayType=threeMonth'" id="threeMonth">3달
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/homePage.do?dayType=sixMonth'" id="sixMonth">6달
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/homePage.do?dayType=oneYear'" id="oneYear">1년
                                    </div>
                                </div>
                            </div>
                            <canvas id="chartViewerCount"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">문의 응답 및 미응답 개수</h6>
                            <canvas id="chartInquiry"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <!-- TODO 신규 회원가입 테이블 -->
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between  mb-2">
                                <h6 class="card-title m-0">신규 회원가입</h6>
                                <div class="btn btn-outline-linkedin" onclick="location.href='/memberPage.do'">더보기</div>
                            </div>
                            <div class="table-responsive">
                                <table id="newMemberInfo" class="table">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>이메일</th>
                                        <th>이름</th>
                                        <th>상호명</th>
                                        <th>사업자등록번호</th>
                                        <th>주소</th>
                                        <th>가입 일자</th>
                                        <th>상세보기</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:forEach items="${userInfoList}" varStatus="i" var="item">
                                            <td>${i.index + 1}</td>
                                            <td>${item.user_Email}</td>
                                            <td>${item.user_Name}</td>
                                            <td>${item.user_ComNm}</td>
                                            <td>${item.user_ComNo}</td>
                                            <td>${item.user_Addr}</td>
                                            <td>${item.user_RegDate}</td>
                                            <td>
                                                <div class="btn btn-primary" onclick="location.href='/memberDetailPage.do?User_No=${item.user_No}'">이동</div>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- TODO 커뮤니티 테이블 -->
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-2">
                                <h6 class="card-title m-0">커뮤니티</h6>
                                <div class="btn btn-outline-linkedin" onclick="location.href='/communityPage.do'">더보기</div>
                            </div>
                            <div class="table-responsive">
                                <table id="communityInfo" class="table">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성 일자</th>
                                        <th>상세보기</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${communityInfoList}" varStatus="i" var="item">
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td>${item.community_Title}</td>
                                            <td>${item.user_ComNm}</td>
                                            <td>${item.community_RegDate}</td>
                                            <td>
                                                <div class="btn btn-primary" onclick="location.href='/communityDetailPage.do?Community_No=${item.community_No}'">이동</div>
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
<script src="/resources/assets/vendors/chartjs/Chart.min.js"></script>
<script src="/resources/assets/vendors/datatables.net/jquery.dataTables.js"></script>
<script src="/resources/assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<script src="/resources/assets/js/chartjs.js"></script>
<script src="/resources/assets/js/data-table.js"></script>
<!-- end custom js for this page -->
</body>
<script>
    $(document).ready(function () {
        var curr_url = document.URL;
        var new_curr_url = new URL(curr_url);

        var param = new_curr_url.searchParams.get("dayType");
        if (param === null) {
            $('#oneDay').attr("class", "btn btn-primary");
        } else if (param === "oneWeek") {
            $('#oneWeek').attr("class", "btn btn-primary ml-2");
        } else if (param === "oneMonth") {
            $('#oneMonth').attr("class", "btn btn-primary ml-2");
        } else if (param === "threeMonth") {
            $('#threeMonth').attr("class", "btn btn-primary ml-2");
        } else if (param === "sixMonth") {
            $('#sixMonth').attr("class", "btn btn-primary ml-2");
        } else if (param === "oneYear") {
            $('#oneYear').attr("class", "btn btn-primary ml-2");
        }

        if ($('#chartViewerCount').length) {
            new Chart($('#chartViewerCount'), {
                type: 'line',
                data: {
                    labels: ["${visitorCountOfDayType.get(18)}", "${visitorCountOfDayType.get(16)}", "${visitorCountOfDayType.get(14)}", "${visitorCountOfDayType.get(12)}", "${visitorCountOfDayType.get(10)}", "${visitorCountOfDayType.get(8)}", "${visitorCountOfDayType.get(6)}", "${visitorCountOfDayType.get(4)}", "${visitorCountOfDayType.get(2)}", "${visitorCountOfDayType.get(0)}"],
                    datasets: [{
                        data: ["${visitorCountOfDayType.get(19)}", "${visitorCountOfDayType.get(17)}", "${visitorCountOfDayType.get(15)}", "${visitorCountOfDayType.get(13)}", "${visitorCountOfDayType.get(11)}", "${visitorCountOfDayType.get(9)}", "${visitorCountOfDayType.get(7)}", "${visitorCountOfDayType.get(5)}", "${visitorCountOfDayType.get(3)}", "${visitorCountOfDayType.get(1)}"],
                        label: "방문자 수",
                        borderColor: "#7ee5e5",
                        backgroundColor: "rgba(0,0,0,0)",
                        fill: false
                    }, {
                        data: ["${registerCountOfDayType.get(19)}", "${registerCountOfDayType.get(17)}", "${registerCountOfDayType.get(15)}", "${registerCountOfDayType.get(13)}", "${registerCountOfDayType.get(11)}", "${registerCountOfDayType.get(9)}", "${registerCountOfDayType.get(7)}", "${registerCountOfDayType.get(5)}", "${registerCountOfDayType.get(3)}", "${registerCountOfDayType.get(1)}"],
                        label: "회원가입 수",
                        borderColor: "#f77eb9",
                        backgroundColor: "rgba(0,0,0,0)",
                        fill: false
                    }
                    ]
                }
            });
        }

        if ($('#chartInquiry').length) {
            new Chart($("#chartInquiry"), {
                type: 'bar',
                data: {
                    labels: ["응답", "미응답"],
                    datasets: [
                        {
                            backgroundColor: ["#b1cfec", "#f77eb9"],
                            data: [${inquiryCountOfState.get("replyCount")}, ${inquiryCountOfState.get("notReplyCount")}, 0]
                        }
                    ]
                },
                options: {
                    legend: {display: false},
                }
            });
        }
    });
</script>
</html>
