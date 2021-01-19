<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-17
  Time: 오후 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" href="/resources/assets/vendors/owl.carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/assets/vendors/owl.carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="/resources/assets/vendors/animate.css/animate.min.css">
    <link rel="stylesheet" href="/resources/assets/vendors/dropify/dist/dropify.min.css">
    <link rel="stylesheet" href="/resources/assets/vendors/sweetalert2/sweetalert2.min.css">
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
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 채팅 목록 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">채팅목록</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddChat">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="chatListContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${chat}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatListImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${chat}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 채팅 방 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">채팅방</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddChatRoom">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="chatContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${chatRoom}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${chatRoom}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 메인 배너 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">메인 배너</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddMainBanner">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="bannerContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${mainBanner}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${mainBanner}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 메인 상단 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">메인 상단</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddMainTop">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="topContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${mainTop}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${mainTop}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 메인 하단 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">메인 하단</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddMainBottom">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="footerContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${mainBottom}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${mainBottom}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 바꿔 먹어 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">바꿔먹어</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddChange">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="changeFoodContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${changeEat}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${changeEat}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 시켜 먹어 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">시켜머거</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddCall">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="callFoodContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${orderEat}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${orderEat}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 샵인 샵 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">샵인샵</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddShop">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="shopContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${shop}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${shop}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 상세 페이지 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">상세페이지</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddDetail">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="detailPageContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${detail}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${detail}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item.get('url')}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 리뷰 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">리뷰</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddReview">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="reviewContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="설명" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${review}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="설명" class="form-control mr-4"
                                                   value="${item.get('desc')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="reviewImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${review}" varStatus="i" var="item">
                                        <div class="item">
                                            <img src="${FilePath}${item.get("url")}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 리뷰 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">커뮤니티</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddCommunity">광고 추가
                                </div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="communityContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-11">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="설명" class="form-control mr-4" disabled>
                                        <input type="text" placeholder="이동링크" class="form-control mr-4" disabled>
                                        <div class="form-control reviewImgName0 d-flex align-items-center">파일 이름</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${community}" var="item" varStatus="i">
                                    <c:set var="filePath" value="${fn:split(item.get('url'), '/')}"/>
                                    <c:set var="fileName"
                                           value="${fn:substring(filePath[fn:length(filePath) - 1], 14, filePath[fn:length(filePath) - 1].length())}"/>
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-11">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]"
                                                   onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4"
                                                   value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="설명" class="form-control mr-4"
                                                   value="${item.get('desc')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4"
                                                   value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName}</div>
                                        </div>
                                        <div class="btn btn-primary"
                                             onclick="deleteAdvertiseFromNo('${item.get('title')}', ${item.get("no")}, '${item.get('url')}')">
                                            삭제
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="communityImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${community}" varStatus="i" var="item">
                                        <div class="item">
                                            <img src="${FilePath}${item.get("url")}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">어드민 광고</h6>
                            <div class="d-flex justify-content-between">
                                <div></div>
                                <div class="btn btn-primary" data-toggle="modal"
                                     data-target="#AddAdmin">광고 추가하기
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table id="memberBlackInfo" class="table">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>광고 이름</th>
                                        <th>이동 링크</th>
                                        <th>이미지 보기</th>
                                        <th>삭제</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${advertiseV3Info}" var="item" varStatus="i">
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td>${item.ad_Title}</td>
                                            <td>${item.ad_MoveLink}</td>
                                            <td>
                                                <div class="btn btn-primary" data-toggle="modal"
                                                     data-target="#ShowAdmin${i.index + 1}">보기
                                                </div>
                                            </td>
                                            <td>
                                                <div class="btn btn-danger"
                                                     onclick="deleteAdvertiseV3('${item.ad_Title}', ${item.ad_No})">삭제
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
<!-- TODO 모델 -->
<div class="modalBox">
    <!-- TODO 어드민 이미지 미리보기 -->
    <c:forEach items="${advertiseV3Info}" varStatus="i" var="item">
        <div class="modal fade" id="ShowAdmin${i.index + 1}" tabindex="-1" role="dialog"
             aria-labelledby="modalShowAdmin"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalShowAdmin">어드민 광고 이미지</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>메인 이미지</h5>
                        <img src="${FilePath}${item.ad_MainURL}" alt="" class="mb-4 w-100">
                        <h5>서브 이미지</h5>
                        <img src="${FilePath}${item.ad_SubURL}" alt="" class="w-100">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- TODO 어드민 페이지 광고 -->
    <div class="modal fade" id="AddAdmin" tabindex="-1" role="dialog" aria-labelledby="modalAdmin"
         aria-hidden="true">
        <form action="/uploadAdvertiseV3.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalAdmin">어드민 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>메인 광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_MainFile">
                        </div>
                        <h5>*주의* 권장 이미지 사이즈는 ?*? 입니다.</h5>
                        <div class="form-group mb-3">
                            <label>서브 광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_SubFile">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="community">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <!-- TODO 커뮤니티 -->
    <div class="modal fade" id="AddCommunity" tabindex="-1" role="dialog" aria-labelledby="modalCommunity"
         aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalCommunity">커뮤니티 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>설명</label>
                            <input type="text" class="form-control" name="Ad_Desc">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="community">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <!-- TODO 리뷰 -->
    <div class="modal fade" id="AddReview" tabindex="-1" role="dialog" aria-labelledby="modalReview"
         aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalReview">리뷰 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>설명</label>
                            <input type="text" class="form-control" name="Ad_Desc">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="review">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <!-- TODO 채팅 목록 -->
    <div class="modal fade" id="AddChat" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">채팅 목록 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="chat">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddChatRoom" tabindex="-1" role="dialog" aria-labelledby="1" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="1">채팅 방 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="chatRoom">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddMainBanner" tabindex="-1" role="dialog" aria-labelledby="2" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="2">메인 배너 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*650 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="mainBanner">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddMainTop" tabindex="-1" role="dialog" aria-labelledby="3" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="3">메인 상단 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="mainTop">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddMainBottom" tabindex="-1" role="dialog" aria-labelledby="4" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="4">메인 하단 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="mainBottom">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddChange" tabindex="-1" role="dialog" aria-labelledby="5" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="5">바꿔먹어 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="changeEat">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddCall" tabindex="-1" role="dialog" aria-labelledby="6" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="6">시켜먹어 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="orderEat">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddShop" tabindex="-1" role="dialog" aria-labelledby="7" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="7">샵인 샵 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="shop">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="modal fade" id="AddDetail" tabindex="-1" role="dialog" aria-labelledby="8" aria-hidden="true">
        <form action="/uploadAdvertiseV2.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="8">상세페이지 광고 추가</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h5>*주의* 권장 이미지 사이즈는 1024*256 입니다.</h5>
                        <div class="form-group">
                            <label>광고 이미지</label>
                            <input type="file" class="advertiseFile" name="Ad_File">
                        </div>
                        <div class="form-group mb-3">
                            <label>제목</label>
                            <input type="text" class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control" name="Ad_MoveLink">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="detail">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                        <button type="submit" class="btn btn-primary">광고 추가하기</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- core:js -->
<script src="/resources/assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="/resources/assets/vendors/jquery.flot/jquery.flot.js"></script>
<script src="/resources/assets/vendors/jquery.flot/jquery.flot.resize.js"></script>
<script src="/resources/assets/vendors/owl.carousel/owl.carousel.min.js"></script>
<script src="/resources/assets/vendors/jquery-mousewheel/jquery.mousewheel.js"></script>
<script src="/resources/assets/vendors/dropify/dist/dropify.min.js"></script>
<script src="/resources/assets/vendors/sweetalert2/sweetalert2.min.js"></script>
<script src="/resources/assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<script src="/resources/assets/js/carousel.js"></script>
<script src="/resources/assets/js/data-table.js"></script>
<!-- end custom js for this page -->
</body>
<script>
    $(document).ready(function () {
        $('.advertiseFile').dropify();
    });

    function deleteAdvertiseV3(name, no) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger mr-2'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: name + '의 광고를 삭제하시겠습니까?',
            text: "삭제한 광고는 되돌릴 수 없습니다.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonClass: 'mr-2',
            confirmButtonText: '네, 실행하겠습니다.',
            cancelButtonText: '아니요, 실행하지 않겠습니다.',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                swalWithBootstrapButtons.fire({
                        html: '<div id="swal2-content" class="swal2-html-container" style="display: block">갑작스러운 종료는 위험할 수 있습니다.</div> ' +
                            '<div class="spinner-border text-primary mt-2" role="status">\n' +
                            '  <span class="sr-only"></span>\n' +
                            '</div>',
                        title: "실행중입니다!",
                        icon: "success",
                        confirmButtonClass: 'd-none',
                    },
                    location.href = '/deleteAdvertiseV3.do?Ad_No=' + no
                )
            } else if (
                // Read more about handling dismissals
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    '취소되었습니다.',
                    '해당 정보는 안전합니다 :)',
                    'error'
                )
            }
        })
    }

    function deleteAdvertiseFromNo(name, no, path) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger mr-2'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: name + '의 광고를 삭제하시겠습니까?',
            text: "삭제한 광고는 되돌릴 수 없습니다.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonClass: 'mr-2',
            confirmButtonText: '네, 실행하겠습니다.',
            cancelButtonText: '아니요, 실행하지 않겠습니다.',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                swalWithBootstrapButtons.fire({
                        html: '<div id="swal2-content" class="swal2-html-container" style="display: block">갑작스러운 종료는 위험할 수 있습니다.</div> ' +
                            '<div class="spinner-border text-primary mt-2" role="status">\n' +
                            '  <span class="sr-only"></span>\n' +
                            '</div>',
                        title: "실행중입니다!",
                        icon: "success",
                        confirmButtonClass: 'd-none',
                    },
                    location.href = '/deleteAdvertiseV2.do?Ad_No=' + no + '&Ad_URL=' + path
                )
            } else if (
                // Read more about handling dismissals
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    '취소되었습니다.',
                    '해당 정보는 안전합니다 :)',
                    'error'
                )
            }
        })
    }

    function removeAdvertise(name, type, path) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger mr-2'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: name + '의 광고를 삭제하시겠습니까?',
            text: "삭제한 광고는 되돌릴 수 없습니다.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonClass: 'mr-2',
            confirmButtonText: '네, 실행하겠습니다.',
            cancelButtonText: '아니요, 실행하지 않겠습니다.',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                swalWithBootstrapButtons.fire({
                        html: '<div id="swal2-content" class="swal2-html-container" style="display: block">갑작스러운 종료는 위험할 수 있습니다.</div> ' +
                            '<div class="spinner-border text-primary mt-2" role="status">\n' +
                            '  <span class="sr-only"></span>\n' +
                            '</div>',
                        title: "실행중입니다!",
                        icon: "success",
                        confirmButtonClass: 'd-none',
                    },
                    location.href = '/deleteAdvertiseV2.do?Ad_Type=' + type + '&Ad_URL=' + path
                )
            } else if (
                // Read more about handling dismissals
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    '취소되었습니다.',
                    '해당 정보는 안전합니다 :)',
                    'error'
                )
            }
        })
    }
</script>
</html>
