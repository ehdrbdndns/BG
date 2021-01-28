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
    <link rel="stylesheet" href="/resources/assets/vendors/sweetalert2/sweetalert2.min.css">
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
                            <h6 class="card-title">Push 리스트</h6>
                            <div class="table-responsive">
                                <table id="memberInfo" class="table">
                                    <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>푸쉬 내용</th>
                                        <th>작성 일자</th>
                                        <th>상세보기</th>
                                        <th>삭제하기</th>
                                        <th>전송하기</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pushInfo}" varStatus="i" var="item">
                                        <tr>
                                            <td>${i.index + 1}</td>
                                            <td>${item.ap_Title}</td>
                                            <td>${item.ap_RegDate}</td>
                                            <td>
                                                <div class="btn btn-outline-linkedin" onclick="location.href='/pushDetailPage.do?Ap_No=${item.ap_No}'">보기</div>
                                            </td>
                                            <td>
                                                <div class="btn btn-danger" onclick="deletePush(${item.ap_No})">삭제</div>
                                            </td>
                                            <td>
                                                <div class="btn btn-primary" onclick="alert('${item.ap_Title}')">전송</div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="d-flex justify-content-between mt-3">
                                <div></div>
                                <div class="btn btn-primary" onclick="location.href='/pushMakePage.do'">푸쉬 내용 작성하기</div>
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
<script src="/resources/assets/vendors/datatables.net/jquery.dataTables.js"></script>
<script src="/resources/assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<script src="/resources/assets/vendors/sweetalert2/sweetalert2.min.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="/resources/assets/js/dashboard.js"></script>
<script src="/resources/assets/js/data-table.js"></script>
<script src="/resources/assets/js/sweet-alert.js"></script>
<!-- end custom js for this page -->
</body>
<script>
    function deletePush(no){
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger mr-2'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: '취소하시겠습니까?',
            text: "작성한 내용은 전부 사라집니다.",
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
                    location.href='/deletePushInfo.do?Ap_No=' + no
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

    function alert(content){
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger mr-2'
            },
            buttonsStyling: false,
        });

        swalWithBootstrapButtons.fire({
            title: '푸쉬 내용을 전송하시겠습니까?',
            text: "내용을 전송하는데 다소 시간이 걸릴 수 있습니다.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonClass: 'mr-2',
            confirmButtonText: '네, 전송하겠습니다.',
            cancelButtonText: '아니요, 전송하지 않겠습니다.',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                swalWithBootstrapButtons.fire({
                        html: '<div id="swal2-content" class="swal2-html-container" style="display: block">갑작스러운 종료는 위험할 수 있습니다.</div> ' +
                            '<div class="spinner-border text-primary mt-2" role="status">\n' +
                            '  <span class="sr-only"></span>\n' +
                            '</div>',
                        title: "저장중입니다!",
                        icon: "success",
                        confirmButtonClass: 'd-none',
                    },
                    sendPush(content)
                )
            } else if (
                // Read more about handling dismissals
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    '취소되었습니다.',
                    'error'
                )
            }
        })
    }

    function sendPush(content){
        $.ajax({
            type: "POST",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            url: "/sendPushContentToUser.ajax",
            data: {
                "Ap_Title":content
            }, // serializes the form's elements.
            dataType: "json",
            error: function () {
                alert("실패했습니다.");
                location.href = "/pushPage.do";
            },
            success: function (data) {
                if (data.result) {
                    alert("성공하셨습니다.");
                    location.href = "/pushPage.do";
                } else {
                    alert("실패했습니다.");
                    location.href = "/pushPage.do";
                }
            }
        });
    }
</script>
</html>
