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
<title>Insert title here</title>
<style>
body{
    		background-color: black;
    		font-family: Open sans;
    	}
    	img{
    		width: 70%;
    		min-height: 200px;
    		/* border-radius:20px; */
    	}
    	.main{
    		padding: 40px 0;
    	}
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
    		font-size: 30px;
    		margin-bottom: 34px;
    		border-bottom: 4px solid #e6e6e6;
    		padding-bottom: 15px;
    		color:white;
    		
    	}
    	p{
    		font-size: 15px;
    	}
    	h4{
    		font-size: 16px;
    		text-transform: uppercase;
    		margin-top: 15px;
    		font-weight: 700;
    		color:white;
    	}
    	header {
    width: 100%;
    height: 70px;
    background: #232323;
}

.hidden {
  display: none;
}
header h1 a {
	
    letter-spacing: 3px;
    position:relative;
    right: -80px;
    top: 15px;
    background: -webkit-linear-gradient(#fc4a1a, #ee0979);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;   
}
.headerele a{
 color: white;
  position:relative;
  right: -260px;
  top: -25px;
  text-decoration: none;
}
.headerele a:hover{
color: white;
	text-decoration: none;
}
.headerele2 a{
 color: white;
  position:relative;
  right: -350px;
  top: -57px;
  text-decoration: none;
}
.headerele2 a:hover{
color: white;
	text-decoration: none;
}
.headerele3 a{
 color: white;
  position:relative;
  right: -465px;
  top: -89px;
  text-decoration: none;
}
	.headerele3 a:hover{
    color: white;
	text-decoration: none;
}
.headerele4 a{
 color: white;
  position:relative;
  right: -570px;
  top: -121px;
  text-decoration: none;
}
.headerele4 a:hover{
color: white;
	text-decoration: none;
}
header .nav .navlink a{
	color: white;
	position:relative;
    top:-111px;
    right: -1150px;
    text-decoration: none;
    font-size: 1.2em;
}
</style>
</head>
<body>
<header>
        <h1><a>MUSIC</a></h1>
        <h5 class="headerele"><a href="AlbAndAlbTypeController?action=HOME">Home</a></h5>
        <h5 class="headerele2"><a href="AlbAndAlbTypeController?action=HOME">Discover</a></h5>
        <h5 class="headerele3"><a href="AlbAndAlbTypeController?action=HOME">Browse</a></h5>
        <h5 class="headerele4"><a href="FavoritesController">Favorites</a></h5>
</header>
    
<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h3>FAVORITE ALBUMS</h3>
			</div>
			
			<c:forEach items="${favoritealbums}" var="favalbum">
			<div class="col-md-3">
			<a href="${pageContext.request.contextPath}/TrackDisplayController?action=trackDisplay&id=${favalbum.album_id}" class="album-poster">
    			<img src="./FavoritesAlbumRetrieve?album_name=${favalbum.album_name}" height="100" width="75">
			</a>
			<h4>${favalbum.album_name}</h4>
				
			</div>
			</c:forEach>
			
		</div>
	</div>
</div>
<%-- <c:forEach items="${favoritealbums}" var="favalbum">

	<h4>${favalbum.album_name}</h4>
	<h4>${favalbum.album_description}</h4>
	<h4>${favalbum.language}</h4>
	<a href="${pageContext.request.contextPath}/TrackDisplayController?action=trackDisplay&id=${favalbum.album_id}" class="album-poster">
    	<img src="./FavoritesAlbumRetrieve?album_name=${favalbum.album_name}" height="100" width="75">
	</a>
	
</c:forEach> --%>
<!-- Jquery Link -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<!-- Bootstrap Link -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<!-- APlayer Jquery link -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>
</body>
</html>