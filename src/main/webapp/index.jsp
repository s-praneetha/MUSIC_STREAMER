<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
  
  html,body {
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
	}
.blue-square {
  background: linear-gradient(to right,  #fc4a1a, #ee0979);
/*   #003d66;
 */  
  width: 80px;
  height: 30px;
  padding-top: 5px;
  display: inline-block;
  text-align: center;
  display: inline-block
}
.blue-square a{
    color: white;
}
.blue-square a:hover{
	color:white
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
    top: 10px;
    background: -webkit-linear-gradient(#fc4a1a, #ee0979);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;   
}
.headerele a{
 color: white;
  position:relative;
  right: -260px;
  top: -30px;
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
  top: -62px;
  text-decoration: none;
}
.headerele2 a:hover{
color: white;
	text-decoration: none;
}
.headerele3 a{
 color: white;
  position:relative;
  right: -452px;
  top: -94px;
  text-decoration: none;
}
.headerele3 a:hover{
color: white;
	text-decoration: none;
}

header .nav .navlink a{
	color: white;
	position:relative;
    top:-33px;
    right: -1200px;
    text-decoration: none;
    font-size: 1.2em;
}
.register a{
	color: #fc4a1a;

}
.register a:hover{
	color: #fc4a1a;
}
img{
    		width: 80%;
    		min-height: 200px;
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
    	
    	p{
    		font-size: 15px;
    		color: grey;
    	}
    	h4{
    	
    		color:grey;
    		font-size: 7px;
    		text-transform: capitalize;
    		margin-top: -25px;
    		
    	}
.main{

margin-top: 40px;
}
</style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  
    <title>MUSIC</title>
</head>
<body style="background-color: black;">
    <header>
        <h1><a>MUSIC</a></h1>
        <ul class="nav">
            <li class="navlink">
              <a id="example-popover" data-html="true" data-placement="bottom" tabindex="0" data-toggle="popover" role="button" data-trigger="focus">Hello,Sign In</a>
            </li>
        </ul>   
    </header>
    
 <div id="example-popover-title" class="hidden"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <div class="blue-square" onclick="location.href='#';" style="cursor: pointer;" ><a href="login.jsp">Sign In</a></div><br><br>
 <div style="font-weight: 4px;" class="register">New User? <a href="UserRegister.jsp">Start Here</a></div>
 </div>
 <div id="example-popover-content" class="hidden">
 </div>




<div class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster" >
					<img src="https://a10.gaanacdn.com/gn_img/albums/BZgWoOW2d9/ZgWoVV4r32/size_m.jpg" alt="">
				</a>
				<h4>Lorem ipsum</h4>
				
			</div>
			<div class="col-md-3">
				<a  onclick="alert('Please Login/Register to continue!');" class="album-poster" >
					<img src="https://a10.gaanacdn.com/gn_img/song/jBr3gLyWR1/r3gN2oaQKR/size_m_1583219687.jpg" alt="">
				</a>
				<h4>Repellat illo</h4>
				
			</div>
			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster" data-switch="2">
					<img src="https://a10.gaanacdn.com/images/albums/90/25690/crop_175x175_25690.jpg" alt="">
				</a>
				<h4>adipisicing elit</h4>
				
			</div>

			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster" data-switch="3">
					<img src="https://a10.gaanacdn.com/images/albums/39/1498939/crop_175x175_1498939.jpg" alt="">
				</a>
				<h4>Aaoge Tum Kabhi</h4>
				
			</div>
			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster" data-switch="4">
					<img src="https://a10.gaanacdn.com/images/albums/2/3307302/crop_175x175_3307302.jpg" alt="">
				</a>
				<h4>Bahana</h4>
				
			</div>
			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster" data-switch="5">
					<img src="https://a10.gaanacdn.com/images/albums/16/3288916/crop_175x175_3288916.jpg" alt="">
				</a>
				<h4>Ek Tarfa Songs</h4>
				
			</div>
			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster" data-switch="6">
					<img src="https://a10.gaanacdn.com/images/albums/99/3320299/crop_175x175_3320299.jpg" alt="">
				</a>
				<h4>G.O.A.T</h4>
				
			</div>
			<div class="col-md-3">
				<a onclick="alert('Please Login/Register to continue!');" class="album-poster">
					<img src="https://a10.gaanacdn.com/gn_img/albums/21GWwrR3pk/1GWw8e4zbp/size_m.webp" alt="">
				</a>
				<h4>Senorita</h4>
				
			</div>
			
		</div>
		
		</div>
</div>
<script>
$(function(){
    // Enables popover
    $("#example-popover").popover({
        html : true, 
        content: function() {
          return $("#example-popover-content").html();
        },
        title: function() {
          return $("#example-popover-title").html();
        }
    });
});

</script>
</body>
</html>