<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< HEAD
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>상품</title>
</head>
<body>
	<section class="container">
		<a href="/webstore">홈으로</a>
		<hr>
	</section>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>상품 목록</h1>
			<p>All the available products in our store</p>
		</div>
	</div>
	</section>
	<section class="container">
	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<div class="caption">
					<h3>${product.name}</h3>
					<p>${product.description}</p>
					<p>₩${product.unitPriceStr}</p>
					<p>재고 수량 : ${product.unitsInStockStr}</p>
				</div>
			</div>
		</div>
		</c:forEach>		
	</div>
	</section>
</body>
</html>
=======
=======
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js">
	
</script>
</head>
<section class="container">
	<a href="/webstore-jb">홈으로</a>
	<hr>
	<p>${greeting }</p>
	<p>${tagline }</p>
</section>
<section>
	<div class="pull-right" style="padding-right: 50px">
		<a href="<c:url value="add"/>">상품 추가</a>
	</div>
</section>
<section class="container">
	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3" style="height: 450px">
				<div class="thumbnail" style="height: 100%">
					<img src="<c:url value='/img/${product.productId}.png'></c:url>"
						alt="상품 사진" style="width: 100%" />
					<div class="caption">
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>₩${product.unitPriceStr}</p>
						<p>제고 수량 : ${product.unitsInStockStr}</p>
						<p>
							<a
								href="<spring:url value='/market/product?id=${product.productId}'/>"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> 상세정보
							</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f
