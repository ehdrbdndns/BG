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
    <link rel="stylesheet" href="/resources/assets/vendors/owl.carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/assets/vendors/owl.carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="/resources/assets/vendors/animate.css/animate.min.css">
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="chatListContents">
                                <!-- TODO 요소 하나 -->
                                <div class="chatListContent chatListContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none chatListImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center chatListImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatListImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="chatContents">
                                <!-- TODO 요소 하나 -->
                                <div class="chatContent chatContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none chatImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center chatImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="chatImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="bannerContents">
                                <!-- TODO 요소 하나 -->
                                <div class="bannerContent bannerContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none bannerImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center bannerImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="bannerImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="topContents">
                                <!-- TODO 요소 하나 -->
                                <div class="topContent topContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none topImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center topImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="topImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="footerContents">
                                <!-- TODO 요소 하나 -->
                                <div class="footerContent footerContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none footerImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center footerImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="footerImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="changeFoodContents">
                                <!-- TODO 요소 하나 -->
                                <div class="changeFoodContentchangeFoodrContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none changeFoodImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center changeFoodImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="changeFoodImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="callFoodContents">
                                <!-- TODO 요소 하나 -->
                                <div class="callFoodContent callFoodContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none callFoodImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center callFoodImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="callFoodImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="shopContents">
                                <!-- TODO 요소 하나 -->
                                <div class="shopContent shopContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none shopImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center shopImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="shopImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="detailPageContents">
                                <!-- TODO 요소 하나 -->
                                <div class="detailPageContent detailPageContent0 d-flex justify-content-between">
                                    <input type="file" class="d-none detailPageImgFile0" name="dbName[0]" onchange="">
                                    <div class="customInputForm cursor-pointer col-8" onclick="inputChatImg(0)">
                                        <div class="d-flex align-items-center detailPageImgName0">파일을 업로드해주세요.</div>
                                    </div>
                                    <div class="btn btn-primary">삭제</div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="detailPageImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 리뷰 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">리뷰</h5>
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="reviewContents">
                                <!-- TODO 요소 하나 -->
                                <div class="reviewContent reviewContent0 d-flex justify-content-between">
                                    <div class="d-flex col-9">
                                        <input type="file" class="d-none reviewImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4">
                                        <input type="text" placeholder="설명" class="form-control mr-4">
                                        <input type="text" placeholder="이동링크" class="form-control mr-4">
                                        <div class="form-control reviewImgName0 d-flex align-items-center cursor-pointer"
                                             onclick="inputChatImg(0)">파일을 업로드해주세요.
                                        </div>
                                    </div>
                                    <div class="d-flex">
                                        <div class="btn btn-success mr-3">저장</div>
                                        <div class="btn btn-primary">삭제</div>
                                    </div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="reviewImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <!-- TODO 리뷰 -->
                            <div class="d-flex justify-content-between mb-3 align-items-center">
                                <h5 class="card-title m-0">커뮤니티</h5>
                                <div class="btn btn-outline-linkedin">광고 추가</div>
                            </div>
                            <!-- TODO 요소 담는 통 -->
                            <div id="communityContents">
                                <!-- TODO 요소 하나 -->
                                <div class="communityContent communityContent0 d-flex justify-content-between">
                                    <div class="d-flex col-9">
                                        <input type="file" class="d-none communityImgFile0" name="dbName[0]" onchange="">
                                        <input type="text" placeholder="제목" class="form-control mr-4">
                                        <input type="text" placeholder="설명" class="form-control mr-4">
                                        <input type="text" placeholder="이동링크" class="form-control mr-4">
                                        <div class="form-control communityImgName0 d-flex align-items-center cursor-pointer"
                                             onclick="inputChatImg(0)">파일을 업로드해주세요.
                                        </div>
                                    </div>
                                    <div class="d-flex">
                                        <div class="btn btn-success mr-3">저장</div>
                                        <div class="btn btn-primary">삭제</div>
                                    </div>
                                </div>
                            </div>
                            <!-- TODO 이미지 미리 보기 -->
                            <div class="mt-2">
                                <div class="communityImgCarousel owl-carousel owl-theme owl-animate-css">
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
                                    <div class="item">
                                        <img src="http://via.placeholder.com/350x65" alt="item-image">
                                    </div>
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
<script src="/resources/assets/vendors/owl.carousel/owl.carousel.min.js"></script>
<script src="/resources/assets/vendors/jquery-mousewheel/jquery.mousewheel.js"></script>
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
    function inputChatImg(no) {
        $('.chatImg' + no).click();
    }
</script>
</html>
