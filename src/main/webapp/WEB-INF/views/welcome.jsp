<<<<<<< HEAD
<<<<<<< HEAD
<%@ page language="java" contentType="text/html;
charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
=======
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<<<<<<< HEAD
<<<<<<< HEAD
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstra p.min.css">
</head>
<body>
	<div class="jumbotron">
		<h1>${greeting}</h1>
		<p>${tagline}</p>
		<ul>
			<li><a href="customers/">고객 목록</a></li>
=======
=======
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div style="margin-left: 10%;">
				<h1>${greeting}</h1>
				<p>${tagline}</p>
			</div>
		</div>
	</section>
	<section class="container">
		<ul>
			<li><a href="login">로그인</a></li>
			<li><a href="market/products/specialOffer?promo=OFF3R">판촉코드-성공(목록표시)-6장</a></li>
			<li><a href="market/products/specialOffer?promo=OFFER">판촉코드-오류</a></li>
			<li><a href="market/products/add">상품 추가 - (우상귀)언어버튼</a></li>
			<li><a href="market/product?id=P1266">없는 상품 P1266 검색</a></li>
			<li><a href="market/products/chargers">충전기류 검색</a></li>
			<li><a href="market/product.xml?id=P1235">상품 XML 요청</a></li>
			<li><a href="market/product.json?id=P1235">상품 JSON 요청</a></li>
			<li><a href="market/products/add">상품 추가 - 영상 업로드</a></li>
			<li><a
				href="market/products/filter/params;categories=Laptop,Tablet;brands=Google,Dell">
					행렬변수(범주, 상표)</a></li>
			<li><a href="market/customers/">고객 목록</a></li>
			<li><a href="market/customers/add">고객 추가</a></li>
			<li><a href="market/products/add">상품 추가</a></li>
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f
			<li><span><a href="market/products/">상품 목록</a></span>(<span><a
					href="market/products/laptop">랩탑</a></span>,&nbsp;<span><a
					href="market/products/TABLET">태블릿</a></span>)</li>
			<li><a href="market/update/stock/">제고 증가</a></li>
		</ul>
<<<<<<< HEAD
<<<<<<< HEAD
	</div>
=======
	</section>
>>>>>>> origin/main
=======
	</section>
>>>>>>> 7f34603b0c5bb5ceb57a641c16b6908d8563744f
</body>
</html>