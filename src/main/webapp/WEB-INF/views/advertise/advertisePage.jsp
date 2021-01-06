<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-17
  Time: 오후 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
                                     data-target="#AddChat">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="chatListContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${chat}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_ChatList&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatListImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${chat}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
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
                                     data-target="#AddChatRoom">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="chatContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${chatRoom}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_ChatRoom&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${chatRoom}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 메인 배너 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">메인 배너</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddMainBanner">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="bannerContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${mainBanner}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_MainBanner&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="bannerImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${mainBanner}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 메인 상단 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">메인 상단</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddMainTop">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="topContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${mainTop}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_MainTop&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="topImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${mainTop}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 메인 하단 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">메인 하단</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddMainBottom">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="footerContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${mainBottom}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_MainBottom&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="footerImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${mainBottom}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 바꿔 먹어 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">바꿔먹어</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddChange">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="changeFoodContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${changeEat}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_Change&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="changeFoodImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${changeEat}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 시켜 먹어 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">시켜머거</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddCall">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="callFoodContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${orderEat}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_Request&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="callFoodImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${orderEat}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 샵인 샵 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">샵인샵</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddShop">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="shopContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${shop}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_Shopin&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="shopImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${shop}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 상세 페이지 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">상세페이지</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddDetail">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="detailPageContents">
                                <!-- TODO 요소 하나 -->
                                <c:forEach items="${detail}" var="item" varStatus="i">
                                    <c:set var="fileName" value="${fn:split(item, '/')}" />
                                    <div class="chatListContent chatListContent0 d-flex justify-content-between mb-3">
                                        <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                        <div class="customInputForm cursor-pointer col-8">
                                            <div class="d-flex align-items-center chatListImgName0">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertise.do?Ad_Type=Ad_Details&Ad_Url=${item}'">삭제</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="detailPageImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <c:forEach items="${detail}" var="item" varStatus="i">
                                        <div class="item">
                                            <img src="${FilePath}${item}" alt="item-image">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 리뷰 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">리뷰</h5>
                                <div class="btn btn-outline-linkedin" data-toggle="modal"
                                     data-target="#AddReview">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="reviewContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-9">
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
                                    <c:set var="fileName" value="${fn:split(item.get('url'), '/')}" />
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-9">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4" value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="설명" class="form-control mr-4" value="${item.get('desc')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4" value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertiseFromNo.do?Ad_No=${item.get("no")}&Ad_Url=${item.get('url')}'">삭제</div>
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
                                     data-target="#AddCommunity">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="communityContents">
                                <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                    <div class="d-flex col-9">
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
                                    <c:set var="fileName" value="${fn:split(item.get('url'), '/')}" />
                                    <div class="reviewContent reviewContent0 d-flex justify-content-between mb-3">
                                        <div class="d-flex col-9">
                                            <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                            <input type="text" placeholder="제목" class="form-control mr-4" value="${item.get('title')}" disabled>
                                            <input type="text" placeholder="설명" class="form-control mr-4" value="${item.get('desc')}" disabled>
                                            <input type="text" placeholder="이동링크" class="form-control mr-4" value="${item.get('link')}" disabled>
                                            <div class="form-control reviewImgName0 d-flex align-items-center">${fileName[fn:length(fileName) - 1]}</div>
                                        </div>
                                        <div class="btn btn-primary" onclick="location.href='/deleteAdvertiseFromNo.do?Ad_No=${item.get("no")}&Ad_Url=${item.get('url')}'">삭제</div>
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
            </div>
        </div>
        <jsp:include page="/resources/include/footer.jsp"/>
    </div>
</div>
<!-- TODO 모델 -->
<div class="modalBox">
    <!-- TODO 커뮤니티 -->
    <div class="modal fade" id="AddCommunity" tabindex="-1" role="dialog" aria-labelledby="modalCommunity"
         aria-hidden="true">
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalCommunity">리뷰 광고 추가</h5>
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
                            <input type="text"  class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>설명</label>
                            <input type="text"  class="form-control" name="Ad_Desc">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control"  name="Ad_Link">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_Community">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                            <input type="text"  class="form-control" name="Ad_Title">
                        </div>
                        <div class="form-group mb-3">
                            <label>설명</label>
                            <input type="text"  class="form-control" name="Ad_Desc">
                        </div>
                        <div class="form-group mb-3">
                            <label>링크</label>
                            <input type="text" class="form-control"  name="Ad_Link">
                        </div>
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_Reviews">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_ChatList">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_ChatRoom">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_MainBanner">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_MainTop">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_MainBottom">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_Change">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_Request">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_Shopin">
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
        <form action="/uploadAdvertise.do" enctype="multipart/form-data" method="post">
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
                        <input type="file" class="advertiseFile" name="Ad_File">
                        <input type="text" class="d-none" name="Ad_Type" value="Ad_Details">
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
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<script src="/resources/assets/js/carousel.js"></script>
<!-- end custom js for this page -->
</body>
<script>
    $(document).ready(function(){
        $('.advertiseFile').dropify();
    });
</script>
</html>
