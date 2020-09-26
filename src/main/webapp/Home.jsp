<%@ page import="com.google.common.collect.ArrayListMultimap"%>
<%@ page import="com.google.common.collect.Multimap"%>
<%@page import="in.entity.AlbumAndAlbumType"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en" dir="ltr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- style -->
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    
  <!--  APlayer CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.css"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Home</title>
<style >
  
  html,body {
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
	}
	
	#base{
	
	
	margin-top:25px;
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
  top: -51px;
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
  top: -78px;
  text-decoration: none;
}
.headerele3 a:hover{
color: white;
	text-decoration: none;
}
.headerele4 a{
 color: white;
  position:relative;
  right: -575px;
  top: -103px;
  text-decoration: none;
}
.headerele4 a:hover{
color: white;
	text-decoration: none;
}

.headerele5 a{
  color: white;
  position:relative;
  right: -1255px;
  top: -133px;
  text-decoration: none;
}
.headerele5 a:hover{
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
.register a{
	color: #fc4a1a;

}
.register a:hover{
	color: #fc4a1a;
}
 .carousel-cell {
    width: 33%;
    padding: 8px;
    border-radius: 25px;
    }

    /* cell number */
    .carousel-cell: before {
      display: block;
    }
    .image{
       border-radius: 20px;
       border: 1px solid white;
       height:225px;
       width: 400px;
    }
    img{
        width: 60%;
        min-height: 175px;
        border-radius: 20px;
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
      
      h4{
        font-size: 24px;
        margin-bottom: 24px;
        /* border-bottom: 4px solid #e6e6e6; */
        padding-bottom: 15px;
        text-transform: capitalize;
        color:white;
       /*  #909090; */
      }
      
      h5{
        font-size: 16px;
        text-transform: uppercase;
        margin-top: 5px;
        font-weight: 700;
        color:#909090;
      }
      .dropbtn {
  position: relative;
 
  background-color: black;
  color: white;
  font-size: 16px;
  border: none;
}

.dropdown {
  display: inline-block;
   margin-left: 1250px;
   top: -132px;
}

.dropdown-content {
  border-radius:10px;
  display: none;
  position: absolute;
  background-color: black;
  
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: white;
  position: relative;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

 .dropdown-content a : hover {background-color: #ddd;}

 .dropdown:hover .dropdown-content {display: block;}

 .dropdown:hover .dropbtn {background-color: black;}
</style> 
</head>
<body>
	<%-- <% String email = (String)session.getAttribute("email"); 
		if(email != null ){
			
			response.sendRedirect("Home.jsp");
		}
	%> --%>
    <header>
        <h1><a>MUSIC</a></h1>
        <h5 class="headerele"><a href="AlbAndAlbTypeController?action=HOME">Home</a></h5>
        <h5 class="headerele2"><a href="Discover.jsp">Discover</a></h5>
        <h5 class="headerele3"><a href="AlbAndAlbTypeController?action=BROWSE">Browse</a></h5>
        <h5 class="headerele4"><a href="FavoritesController">Favorites</a></h5>
        <%-- <div class="headerele5" class="float-right"><a href="${pageContext.request.contextPath}/logout.jsp">Logout</a></div> --%>
    	<div class="dropdown">
  			<button class="dropbtn">Settings</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="HistoryController">Recently Played</a>
    <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
  </div>
</div>
    </header>
    
<!--  <div id="example-popover-title" class="hidden"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <div class="blue-square" onclick="location.href='#';" style="cursor: pointer;" ><a href="login.jsp">Sign In</a></div><br><br>
 <div style="font-weight: 4px;" class="register">New User? <a href="UserRegister.jsp">Start Here</a></div>
 </div>
 <div id="example-popover-content" class="hidden">
 </div> -->

<div class="carousel" data-flickity='{ "wrapAround": true, "autoPlay": true }' id="base">
                
                    
          <% Multimap<String, AlbumAndAlbumType> topalbums=(Multimap<String, AlbumAndAlbumType>)request.getAttribute("topalbums");
            Set<String> keys = topalbums.keySet();
          
            for(String key:keys){
              request.setAttribute("key",key);
           %>
                
                          <%Collection<AlbumAndAlbumType> values=topalbums.get(key);
                    for(AlbumAndAlbumType value:values){
                      request.setAttribute("album",value);
                  %>
                  <div class="carousel-cell">
                                    <a href="${pageContext.request.contextPath}/TrackDisplayController?action=trackDisplay&id=${album.album_id}">
                                        <img src="./AlbandAlbTypeRetrieve?album_name=${album.album_name}"  class="image" >
                        </a>
                              </div>  
                            <%}%>
          <% }%> 
          
       </div>
     <div class="main">        
       <div class="container">
                 
            
                 <% Multimap<String, AlbumAndAlbumType> allalbums=(Multimap<String, AlbumAndAlbumType>)request.getAttribute("allalbums");
            Set<String> keys1 = allalbums.keySet();
          
            for(String key:keys1){
              request.setAttribute("key",key);
           %>
                  <h4>${key}</h4>
                      <div class="row">
                          <%Collection<AlbumAndAlbumType> values=allalbums.get(key);
                    for(AlbumAndAlbumType value:values){
                      request.setAttribute("album",value);
                      
                  %>
                  
                  
        
                              <div class="col-md-3">
                                    <a href="${pageContext.request.contextPath}/TrackDisplayController?action=trackDisplay&id=${album.album_id}" class="album-poster">
                                        <img src="./AlbandAlbTypeRetrieve?album_name=${album.album_name}">
                        </a>
                                    <br>
                                    <h5>${album.album_name}</h5>
                
                        
                              </div>
                            <%}%>
                      </div>
                      
          
          
          <% }%>
                    
             </div> </div>










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
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <!--  APlayer JQuery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
</body>
</html>