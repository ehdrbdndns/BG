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
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <form id="Form">
                                <h6 class="card-title">공지사항 작성</h6>
                                <div class="form-group col-10 pl-0">
                                    <label>공지 제목</label>
                                    <input type="text" class="form-control required" placeholder="공지 제목을 작성해주세요." name="An_Title" value="${noticeInfo.an_Title}">
                                    <input type="text" class="d-none" name="An_No" value="${noticeInfo.an_No}">
                                </div>
                                <div class="form-group">
                                    <label>공지 내용</label>
                                    <textarea class="form-control required" name="An_Contents" id="" rows="5" placeholder="공지 내용을 작성해주세요.">${noticeInfo.an_Contents}</textarea>
                                </div>
                                <div class="d-flex justify-content-between">
                                    <div></div>
                                    <div class="d-flex">
                                        <div class="btn btn-danger mr-2" onclick="location.href='/noticePage.do'">취소</div>
                                        <div class="btn btn-primary" id="modifyAnnounce">저장</div>
                                    </div>
                                </div>
                            </form>
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
<script src="/resources/assets/js/formCheckEmpty.js"></script>
</body>
<script>
    $('#modifyAnnounce').click(function (e) {
        e.preventDefault();
        if (basicEmptyCheck()){
            var form = $('form[id=Form]')[0];
            // Create an FormData object
            var data = new FormData(form);

            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                processData: false,
                contentType: false,
                cache: false,
                url: "/modifyAnnounce.ajax",
                data: data, // serializes the form's elements.
                dataType: "json",
                error: function () {
                    console.log('마이페이지 전송 ajax 버그');
                    alert("변경에 실패했습니다. 기술팀에 문의바랍니다.");
                },
                success: function (data) {
                    if (data.result) {
                        alert("성공적으로 변경되었습니다.");
                        location.href = "/noticePage.do"
                    } else {
                        alert("변경에 실패했습니다. 기술팀에 문의바랍니다.");
                        location.href = "/noticePage.do"
                    }
                }
            })
        }
    })
</script>
</html>
