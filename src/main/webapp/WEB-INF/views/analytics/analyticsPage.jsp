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
                <!-- TODO 회원가입 및 방문자 수 그래프 -->
                <div class="col-xl-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between">
                                <h6 class="card-title m-0">회원가입 및 방문자 수</h6>
                                <div class="d-flex">
                                    <div class="btn btn-secondary" onclick="location.href='/analyticsPage.do'" id="oneDay">1일
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/analyticsPage.do?dayType=oneWeek'" id="oneWeek">1주
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/analyticsPage.do?dayType=oneMonth'" id="oneMonth">1달
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/analyticsPage.do?dayType=threeMonth'" id="threeMonth">3달
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/analyticsPage.do?dayType=sixMonth'" id="sixMonth">6달
                                    </div>
                                    <div class="btn btn-secondary ml-2"
                                         onclick="location.href='/analyticsPage.do?dayType=oneYear'" id="oneYear">1년
                                    </div>
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
                            <canvas id="chartjsPie"></canvas>
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

        var areaColor = new Array();
        for(var i = 0; i<9; i++){
            areaColor.push("#" + Math.round(Math.random() * 0xffffff).toString(16));
        }

        if($('#chartjsPie').length) {
            new Chart($('#chartjsPie'), {
                type: 'pie',
                data: {
                    labels: ["경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주도"],
                    datasets: [{
                        label: "Population (millions)",
                        backgroundColor: areaColor,
                        data: [${areaCount.get("경기도")}, ${areaCount.get("강원도")}, ${areaCount.get("충청북도")},
                            ${areaCount.get("충청남도")}, ${areaCount.get("전라북도")}, ${areaCount.get("전라남도")}, ${areaCount.get("경상북도")},
                            ${areaCount.get("경상남도")},${areaCount.get("제주도")}]
                    }]
                }
            });
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

        if ($('#chartProposal').length) {
            new Chart($("#chartProposal"), {
                type: 'bar',
                data: {
                    labels: ["바꿔머거", "시켜먹어"],
                    datasets: [
                        {
                            label: "Population",
                            backgroundColor: ["#b1cfec", "#f77eb9", "#f77eb9"],
                            data: [${proposalInfo.changeCount}, ${proposalInfo.callCount}, 0]
                        }
                    ]
                },
                options: {
                    legend: {display: false},
                }
            });
        }

        var categoryColor = new Array();
        for(var i = 0; i<16; i++){
            categoryColor.push("#" + Math.round(Math.random() * 0xffffff).toString(16));
        }

        if ($('#chartCategory').length) {
            new Chart($('#chartCategory'), {
                type: 'doughnut',
                data: {
                    labels: ["치킨", "한식", "돈까스/회/일식", "분식", "아시안/양식", "피자", "카페/디저트", "중국집",
                        "족발/보쌈", "야식", "찜/탕", "도시락", "패스트푸드", "프랜차이즈"],
                    datasets: [
                        {
                            label: "Population (millions)",
                            backgroundColor: categoryColor,
                            data: [${storeCategoryInfo.get("chicken")}, ${storeCategoryInfo.get("korea")}, ${storeCategoryInfo.get("japan")},
                                ${storeCategoryInfo.get("school")}, ${storeCategoryInfo.get("western")}, ${storeCategoryInfo.get("pizza")},
                                ${storeCategoryInfo.get("dessert")}, ${storeCategoryInfo.get("chinese")}, ${storeCategoryInfo.get("pig")},
                                ${storeCategoryInfo.get("midnight")}, ${storeCategoryInfo.get("steam")}, ${storeCategoryInfo.get("lunchbox")},
                                ${storeCategoryInfo.get("fast")}, ${storeCategoryInfo.get("franchise")}]
                        }
                    ]
                }
            });
        }

        var analyticsLabel = new Array();
        var analyticsData = new Array();
        var analyticsColor = new Array();

        <c:forEach items="${advertiseInfo}" varStatus="i" var="item">
        <c:choose>
        <c:when test="${i.index %2 eq 0}">
        analyticsLabel.push("${item}");
        </c:when>
        <c:otherwise>
        analyticsData.push("${item}");
        analyticsColor.push("#" + Math.round(Math.random() * 0xffffff).toString(16));
        </c:otherwise>
        </c:choose>
        </c:forEach>

        if ($('#chartAdvertise').length) {
            new Chart($('#chartAdvertise'), {
                type: 'doughnut',
                data: {
                    labels: analyticsLabel,
                    datasets: [
                        {
                            label: "Population (millions)",
                            backgroundColor: analyticsColor,
                            data: analyticsData
                        }
                    ]
                }
            });
        }

    });
</script>
</html>
