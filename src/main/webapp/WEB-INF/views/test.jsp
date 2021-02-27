<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-11
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/resources/include/header.jsp"/>
    <title>Title</title>
</head>
<body>
<h3>changeComNo</h3>
<form action="/changeComNo">
    <button>제출</button>
</form>
<h2>appChangePwd.app</h2>
<form action="/appChangePwd.app">
    <input type="text" name="User_Email" placeholder="User_Email">
    <input type="text" name="User_PW" placeholder="User_PW">
    <button>제출</button>
</form>
<h2>잘 나오는 것이여</h2>
<h3>testDocument</h3>
<form action="/testDocument">
    <input type="number" name="userNo" placeholder="userNo">
    <button>제출</button>
</form>
<h3>지역 지점수 카운트</h3>
<form action="/countAllStore">
<%--    <button>제출</button>--%>
</form>
<h3>유저 회원가입</h3>
<form action="/appRegister.app">
    <input type="text" name="User_Email" placeholder="User_Email">
    <input type="text" name="User_PW" placeholder="User_PW">
    <input type="text" name="User_Name" placeholder="User_Name">
    <input type="text" name="User_Phone" placeholder="User_Phone">
    <input type="text" name="User_ComNo" placeholder="User_ComNo">
    <input type="text" name="User_ComNm" placeholder="User_ComNm">
    <input type="text" name="User_Addr" placeholder="User_Addr">
    <button>제출</button>
</form>
<h3>유저 번호 비밀번호 암호화</h3>
<form action="/changePwd">
    <input type="text" name="userNo" placeholder="userNo">
    <button>제출</button>
</form>
<h3>모든 사용자 비밀번호 암호화</h3>
<form action="/changeAllPwd">
<%--    <button>제출</button>--%>
</form>
<h3>암호화 비밀번호</h3>
<form action="/pwdToByte">
    <input type="text" name="pwd" placeholder="pwd">
    <button>제출</button>
</form>
<h3>역 지오코딩</h3>
<form action="/reversGeocode">
    <input type="text" name="lat" placeholder="lat">
    <input type="text" name="lng" placeholder="lng">
    <button>제출</button>
</form>
<form action="/appCheckVersion.app">
    <input type="text" name="version">
    <button>제출</button>
</form>
<form action="/appRetrieveProposalDetailOfChangeEat.app">
    <input type="text" name="User_No">
    <input type="text" name="Proposal_No">
    <button>제출</button>
</form>
<form action="/appMakeUserStoreProduct.app">
    <input type="text" name="User_No">
    <input type="text" name="Product_Name">
    <input type="text" name="Product_Compo">
    <input type="text" name="Product_Price">
    <input type="text" name="Product_Sales">
    <input type="file" name="Product_Type">
    <input type="file" name="Product_Img_File">
</form>
<form action="/appLogin.app">
    <input type="text" name="User_Email">
    <input type="text" name="User_PW">
    <input type="text" name="User_Fcm">
    <button>제출</button>
</form>
<form action="/appRetrieveUserInfo.app" method="post">
    <input type="text" name="User_No">
    <button>제출</button>
</form>
<label>요기 회원가입</label>
<form action="/appSendCodeOfRegister.app" method="post">
    <input type="text" name="Register_Email">
    <button>제출</button>
</form>
<form action="/appRetrieveProposalList.app" method="post">
    <input type="text" name="User_No">
    <button>제출</button>
</form>
<form action="/appRetrieveShopList.app" enctype="multipart/form-data" method="post">
    <input type="text" name="Location">
    <input type="text" name="Location_Range">
    <input type="text" name="Category">
    <input type="text" name="Ways">
    <input type="text" name="Search">
    <input type="text" name="FirstIndex">
    <button>제출</button>
</form>
<form action="/appGetAdvertise.app">
    <button>제출</button>
</form>
<form action="/appClickLikeBtn.app">
    <input type="text" name="User_No">
    <input type="text" name="Like_Type">
    <input type="text" name="Board_No">
    <button>제출</button>
</form>
<form action="/appIsClickLike.app">
    <input type="text" name="User_No">
    <input type="text" name="Like_Type">
    <input type="text" name="Board_No">
    <button>제출</button>
</form>
<form action="/appClickAdvertise.app">
    <input type="text" name="Ad_Type">
    <input type="text" name="Ad_Url">
    <button>제출</button>
</form>
<h3>appGetProposalItem</h3>
<form action="/appGetProposalItem.app">
    <input type="text" name="My_No">
    <input type="text" name="Your_No">
    <button>제출</button>
</form>
<form action="/appChangeStateOfProposal.app">
    <input type="text" name="Proposal_No">
    <input type="text" name="Proposal_State">
    <input type="text" name="Proposal_Room">
    <button>제출</button>
</form>
<form action="/appRegisterProposal.app">
    <input type="text" name="My_No">
    <input type="text" name="Your_No">
    <input type="text" name="Proposal_Room">
    <input type="text" name="Proposal_Category">
    <input type="text" name="Proposal_Ways">
    <input type="text" name="My_ProductNo">
    <input type="text" name="Your_ProductNo">
    <input type="text" name="Proposal_Addr">
    <input type="text" name="Proposal_State">
    <input type="text" name="Proposal_Credit">
    <button>제출</button>
</form>
<form action="/appCheckChatRoom.app">
    <input type="text" name="My_No">
    <input type="text" name="Your_No">
    <button>제출</button>
</form>
<form action="/testSendNotification.do">
    <div>원석형 여기 notification 입니다!(true or false, 에러뜨면 false)</div>
    <div class="form-group">
        <input type="text" name="fcm" placeholder="fcm토큰을 입력해주세요.">
    </div>
    <button>제출</button>
</form>
</body>
    <jsp:include page="/resources/include/javascript.jsp"/>
</html>
