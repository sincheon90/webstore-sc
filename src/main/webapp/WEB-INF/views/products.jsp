<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>상품</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>상품 목록</h1>
				<p>All the available products in our store</p>
			</div>
		</div>
	</section>

	<section class="container">
		<a href="/webstore">홈으로</a>
		<hr>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="height:450px">
					<div class="thumbnail" style="height:100%">
						<img src="<c:url value='/img/${product.productId}.png'></c:url>"
							alt="상품 사진" style="width: 100%" />
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>₩${product.unitPriceStr}</p>
							<p>제고 수량 : ${product.unitsInStockStr}</p>
							<p>
								<a
									href="<spring:url value='/market/product?id=${product.productId}' /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span>상세정보
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>