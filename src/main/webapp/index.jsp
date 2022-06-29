<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Calculator</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/css/font-face.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="${pageContext.request.contextPath}/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet" media="all">
  
  <style>
    body{
      background-color: aliceblue;
    }

    .op{
      text-align: center;
    }

    .op input:nth-child(n+2){
      margin-left: 18%;
    }

    .container{
      width: 50%;
      background: rgb(193,189,255);
      background: linear-gradient(90deg, rgba(193,189,255,1) 0%, rgba(197,208,210,1) 100%);
      border-radius: 20px;
      padding: 20px;
      margin-top: 5% !important;
    }
  </style>
</head> 
<body>
  <form action="calculate" method="get" >

    <div class="container mt-3" >
      <h4>SIMPLE CALCULATOR</h4>
        
        <div class="mb-3">
          <label for="firstNumber">First number:</label>
          <input class="form-control" id="firstNumber" value="${firstNumber }" name="firstNumber" required>
        </div>
        <div class="mb-3">
          <label for="secondNumber">Second number:</label>
          <input type="text" class="form-control" id="secondNumber" value="${secondNumber }" name="secondNumber" required>
        </div>
        
        <c:if test="${fn:contains(result, '.0')}">
        	 <fmt:parseNumber var="result" integerOnly="true" type="number" value="${result}" />  
        </c:if>

        <div class="mb-3 mt-3">
          <label for="result">Result:</label>
          <input type="text" class="form-control" id="result" value="${result }" name="result" disabled="disabled">
        </div>
        <div class="mb-3 mt-3 op">
          <input style="width: 10%; font-size: 20px;" type="submit" id="cong" name="action" class="btn btn-primary" value="+">
          <input style="width: 10%; font-size: 20px;" type="submit" id="tru" name="action" class="btn btn-primary" value="-">
          <input style="width: 10%; font-size: 20px;" type="submit" id="nhan" name="action" class="btn btn-primary" value="*">
          <input style="width: 10%; font-size: 20px;" type="submit" id="chia" name="action" class="btn btn-primary" value="/">
        </div>
        
    </div>
  </form>

</html>