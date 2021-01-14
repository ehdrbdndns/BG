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
    <link rel="stylesheet" href="/resources/assets/vendors/sweetalert2/sweetalert2.min.css">
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
                <div class="card col-12">
                    <form id="Form">
                        <div class="card-body">
                            <h5 class="card-title">문의 작성</h5>
                            <div class="d-flex justify-content-between">
                                <div class="form-group">
                                    <label>이름</label>
                                    <input type="text" class="form-control" disabled value="${inquiryInfo.user_Name}">
                                    <input type="text" name="Inquiry_No" class="d-none" value="${inquiryInfo.inquiry_No}">
                                </div>
                                <div class="form-group">
                                    <label>상호명</label>
                                    <input type="text" class="form-control" disabled value="${inquiryInfo.user_ComNm}">
                                </div>
                                <div class="form-group">
                                    <label>사업자 등록 번호</label>
                                    <input type="text" class="form-control" disabled value="${inquiryInfo.user_ComNo}">
                                </div>
                                <div class="form-group">
                                    <label>연락처</label>
                                    <input type="text" class="form-control" disabled value="${inquiryInfo.user_Phone}">
                                </div>
                                <div class="form-group">
                                    <label>문의 일자</label>
                                    <input type="text" class="form-control" disabled value="${inquiryInfo.inquiry_RegDate}">
                                </div>
                                <div class="form-group">
                                    <label>카테고리</label>
                                    <c:choose>
                                        <c:when test="${inquiryInfo.inquiry_Category eq 'report'}">
                                            <input type="text" class="form-control" disabled value="신고">
                                        </c:when>
                                        <c:when test="${inquiryInfo.inquiry_Category eq 'use'}">
                                            <input type="text" class="form-control" disabled value="이용 문의">
                                        </c:when>
                                        <c:when test="${inquiryInfo.inquiry_Category eq 'advertise'}">
                                            <input type="text" class="form-control" disabled value="광고 문의">
                                        </c:when>
                                        <c:when test="${inquiryInfo.inquiry_Category eq 'inconvenient'}">
                                            <input type="text" class="form-control" disabled value="불편 문의">
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>문의 내용</label>
                                <textarea rows="10" class="form-control" placeholder="문의 내용" disabled>${inquiryInfo.inquiry_Title}</textarea>
                            </div>
                            <div class="form-group">
                                <label>답변</label>
                                <textarea name="Inquiry_Answer" rows="10" class="form-control required" placeholder="문의 답변">${inquiryInfo.inquiry_Answer}</textarea>
                            </div>
                            <div class="d-flex justify-content-between">
                                <div></div>
                                <div class="d-flex">
                                    <div class="btn btn-danger mr-3" onclick="cancel()">취소</div>
                                    <div class="btn btn-success" id="answerInquiry">저장</div>
                                </div>
                            </div>
                        </div>
                    </form>
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
<script src="/resources/assets/vendors/sweetalert2/sweetalert2.min.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<!-- end custom js for this page -->
<!-- check empty -->
<script src="/resources/assets/js/formCheckEmpty.js"></script>
</body>
<script>

    $('#answerInquiry').click(function(e){
        e.preventDefault();
        if(basicEmptyCheck()){
            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger mr-2'
                },
                buttonsStyling: false,
            });

            swalWithBootstrapButtons.fire({
                title: '저장하시겠습니까?',
                text: "",
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
                        save()
                    )
                } else if (
                    // Read more about handling dismissals
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire(
                        '취소되었습니다.',
                        '회원의 정보는 안전합니다 :)',
                        'error'
                    )
                }
            });
        }
    });

    function save(){
        var form = $('form[id=Form]')[0];
        // Create an FormData object
        var data = new FormData(form);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            url: "/saveInquiryInfo.ajax",
            data: data, // serializes the form's elements.
            dataType: "json",
            error: function () {
                console.log('마이페이지 전송 ajax 버그');
                alert("변경에 실패했습니다. 기술팀에 문의바랍니다.");
            },
            success: function (data) {
                if (data.result) {
                    alert("성공적으로 변경되었습니다.");
                    location.href = "/inquiryPage.do"
                } else {
                    alert("변경에 실패했습니다. 기술팀에 문의바랍니다.");
                    location.href = "/inquiryPage.do"
                }
            }
        })
    }

    function cancel(){
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger mr-2'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: '취소하시겠습니까?',
            text: "작성된 내용은 삭제됩니다.",
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
                    location.href='/inquiryPage.do'
                )
            } else if (
                // Read more about handling dismissals
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    '취소되었습니다.',
                    '회원의 정보는 안전합니다 :)',
                    'error'
                )
            }
        });
    }
</script>
</html>
