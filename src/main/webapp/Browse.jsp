<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
		body{
    		
    		font-family: Open sans;
    	}

 		.row{
 		
 		margin-top: 200px;
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
    		border-radius: 15px;
    		overflow: hidden;
    		/* box-shadow: 0 15px 35px #3d2173a1; */
    		transition: all ease 0.4s;
    	}
    	.album-poster:hover{
    		box-shadow: none;
    		
    	}
    	
    	h5{
    		font-size: 5px;
    		text-transform: uppercase;
    		margin-top: 15px;
    		font-weight: 700;
    		color: white;
    		}


</style>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- APlayer CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.css"/>
	
<title>BROWSE</title>
</head>
<body style="background-color: black;">

<div class="main">
	<div class="container">
		<div class="row">
			<!-- <div class="col-md-12">
				<h3>TOP ALBUMS</h3>
			</div> -->
			<c:forEach  items="${allAlbumsList}" var="albums">
			<div class="col-md-3">
				<a href="#" class="album-poster" >
					<img src="./AllAlbumsRetrieve?album_name=${albums.album_name}" width="175px" height="175px" >
				</a>
				<h5>${albums.album_name}</h5>			
			</div>
			</c:forEach>
		</div>
	</div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<!-- Jquery Link -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<!-- Bootstrap Link -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<!-- APlayer Jquery link -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>	
</body>
</html>