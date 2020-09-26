<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>DISCOVER</title>
<style>
body{
    		background-color: black;
    		font-family: Open sans;
    	}
    	img{
    		width: 100%;
    		min-height: 250px;
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
    		box-shadow: 0 15px 35px #3d2173a1;
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
    		
    		color: white;
    		
    	}
    	
</style>
</head>
<body>
<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Discover Songs</h3>
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=romance" class="album-poster" data-switch="0">
					<img src="source/ROMANCE.jpg" alt="">
				</a>				
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=canticle" class="album-poster" data-switch="1">
					<img src="source/CANTICLE.jpg" alt="">
				</a>				
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=Devotional Songs" class="album-poster" data-switch="2">
					<img src="source/DEVOTIONAL.jpg" alt="">
				</a>
				
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=FOLK" class="album-poster" data-switch="3">
					<img src="source/FOLK.jpg" alt="">
				</a>
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=Gazals" class="album-poster" data-switch="4">
					<img src="source/GHAZALS.jpg" alt="">
				</a>
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=Instrumental" class="album-poster" data-switch="4">
					<img src="source/INSTRUMENTAL.png" alt="">
				</a>
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=Live albums" class="album-poster" data-switch="4">
					<img src="source/LIVE ALBUMS.jpg" alt="">
				</a>
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=Retro Covers" class="album-poster" data-switch="4">
					<img src="source/RETRO.jpg" alt="">
				</a>
			</div>
			<div class="col-md-3">
				<a href="./DiscoverSongController?action=DISCOVER&type=Vocal" class="album-poster" data-switch="4">
					<img src="source/VOCAL.jpg" alt="">
				</a>
			</div>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>
	
</body>
</html>