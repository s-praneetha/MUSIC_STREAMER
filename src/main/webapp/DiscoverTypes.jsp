<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- APlayer CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.css"/>
<meta charset="UTF-8">
<title>Discover Types</title>
<style>
		.row{
		margin-top: 50px;
		}
		body{
    		background-color: black;
    		font-family: Open sans;
    	}
    	.topimage{
    		width: 1475px;
    		height: 250px;
    		margin-left:-200px;
    	}
    	/* .main{
    		padding: 40px 0;
    	} */
    	.col-md-3{
    		margin-bottom: 40px;
    	}
    	.album-poster{
    		position: relative;
    		display: block;
    		border-radius: 7px;
    		overflow: hidden;
    		transition: all ease 0.4s;
    	}
    	.album-poster:hover{
    		box-shadow: none;
    		transform: scale(0.98) translateY(5px);
    	}
    	h3{
    		font-size: 34px;
    		margin-bottom: 34px;
    		border-bottom: 4px solid #e6e6e6;
    		padding-bottom: 15px;
    		text-transform: capitalize;
    		
    	}
    	p{
    		font-size: 15px;
    	}
    	h4{
    		font-size: 16px;
    		text-transform: uppercase;
    		margin-top: 15px;
    		font-weight: 700;
    		color: white;
    	}
</style>
</head>
<body>
<div class="main">

	<div class="container">
		 <c:set var="count" value="0" scope="page" />
		<c:forEach  items="${discoveralbums}" var="discoveralbums">
			<c:if test="${count eq 0}">
        		<img class="topimage" src="./TypeImageRetrieve?type_name=${discoveralbums.type_name}">
    		</c:if>
		    <c:set var="count" value="${count + 1}" scope="page"/>
		</c:forEach>
		<div class="row">
		<c:forEach  items="${discoveralbums}" var="discoveralbums">		
		<div class="col-md-3">
		<a href="${pageContext.request.contextPath}/TrackDisplayController?action=trackDisplay&id=${discoveralbums.album_id}" class="album-poster">
    		<img src="./DiscoverImagesRetrieve?album_name=${discoveralbums.album_name}" height="200" width="150">
		</a>
		<h4>${discoveralbums.album_name}</h4>
		</div>
		</c:forEach>
		</div>
	</div>
</div>


			
		
			
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<!-- Bootstrap Link -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>