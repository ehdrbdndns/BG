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
                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <form id="Form">
                            <div class="card-body">
                                <h6 class="card-title">FAQ</h6>
                                <div class="d-flex">
                                    <div class="form-group col-10 pl-0">
                                        <label>FAQ 제목</label>
                                        <input type="text" class="form-control required" value="${faqInfo.af_Title}"
                                               name="Af_Title">
                                        <input type="text" name="Af_No" class="d-none" value="${faqInfo.af_No}">
                                    </div>
                                    <div class="form-group col-2">
                                        <input type="text" class="d-none" name="Af_Category" id="Af_Category"
                                               value="${faqInfo.af_Category}">
                                        <label>카테고리</label>
                                        <div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                    id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                                    aria-expanded="false">
                                                <c:choose>
                                                    <c:when test="${faqInfo.af_Category eq 'best'}">
                                                        BEST
                                                    </c:when>
                                                    <c:when test="${faqInfo.af_Category eq 'register'}">
                                                        회원가입
                                                    </c:when>
                                                    <c:when test="${faqInfo.af_Category eq 'pay'}">
                                                        바로 결제
                                                    </c:when>
                                                    <c:when test="${faqInfo.af_Category eq 'user'}">
                                                        이용 문의
                                                    </c:when>
                                                    <c:when test="${faqInfo.af_Category eq 'inconvenient'}">
                                                        불편 문의
                                                    </c:when>
                                                </c:choose>
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" id="dropdown-item1" href="#"
                                                   onclick="changeSelectBox(1)">BEST</a>
                                                <a class="dropdown-item" id="dropdown-item2" href="#"
                                                   onclick="changeSelectBox(2)">회원가입</a>
                                                <a class="dropdown-item" id="dropdown-item3" href="#"
                                                   onclick="changeSelectBox(3)">바로 결제</a>
                                                <a class="dropdown-item" id="dropdown-item4" href="#"
                                                   onclick="changeSelectBox(4)">이용 문의</a>
                                                <a class="dropdown-item" id="dropdown-item5" href="#"
                                                   onclick="changeSelectBox(5)">불편 문의</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>FAQ 내용</label>
                                    <textarea class="form-control required" rows="10"
                                              name="Af_Contents">${faqInfo.af_Contents}</textarea>
                                </div>
                                <div class="d-flex justify-content-between">
                                    <div></div>
                                    <div class="d-flex">
                                        <div class="btn btn-danger" onclick="cancel()">취소</div>
                                        <div class="btn btn-primary ml-3" id="modifyFaq">저장</div>
                                    </div>
                                </div>
                            </div>
                        </form>
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
<script src="/resources/assets/vendors/sweetalert2/sweetalert2.min.js"></script>
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
            text: "수정한 내용은 전부 사라집니다.",
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
                        confirmButtonClass: 'd-none'
                    },
                    location.href="/faqPage.do"
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
        });
    }

    function changeSelectBox(no) {
        var text = $('#dropdown-item' + no).text();
        $('#dropdownMenuButton').text(text);

        if (text === "BEST")
            text = "best";
        else if (text === "회원가입")
            text = "register";
        else if (text === "바로 결제")
            text = "pay";
        else if (text === "이용 문의")
            text = "user";
        else if (text === "불편 문의")
            text = "inconvenient";

        $("input[name='Af_Category']").val(text);
    }

    $('#modifyFaq').click(function(e){
        e.preventDefault();
        if (basicEmptyCheck()){
            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger mr-2'
                },
                buttonsStyling: false,
            });

            swalWithBootstrapButtons.fire({
                title: '수정하시겠습니까?',
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
                            confirmButtonClass: 'd-none'
                        },
                        save()
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
            url: "/modifyFaq.ajax",
            data: data, // serializes the form's elements.
            dataType: "json",
            error: function () {
                console.log('마이페이지 전송 ajax 버그');
                alert("변경에 실패했습니다. 기술팀에 문의바랍니다.");
            },
            success: function (data) {
                if (data.result) {
                    alert("성공적으로 변경되었습니다.");
                    location.href = "/faqPage.do"
                } else {
                    alert("변경에 실패했습니다. 기술팀에 문의바랍니다.");
                    location.href = "/faqPage.do"
                }
            }
        })
    }
</script>
</html>
