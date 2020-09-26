<%@page import="in.entity.AddTrack"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="javax.servlet.http.HttpUtils.*" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <!--  APlayer CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://localhost:8080/Music_Streamer/resources/css/homeTrackDisplay.css">
<style>
div.play {
  color: #ddd;
  width: 50px;
  height: 50px;
  text-align: center;
  line-height: 50px;
  font-size: 14px;
  cursor: pointer;
  position: relative;
  background-color: #3498db;
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
  border-radius: 50%;
  -webkit-box-shadow: inset 0 0 0 1px #ddd, inset 0 0 0 3px #fff, inset 0 0 0 4px #ddd;
  box-shadow: inset 0 0 0 1px #ddd, inset 0 0 0 3px #fff, inset 0 0 0 4px #ddd;
  -webkit-transition: all .2s ease;
  transition: all .2s ease;
}

div.play:hover,
div.play.active {
  -webkit-box-shadow: inset 0 0 0 0 #CD391F, inset 0 0 0 0 #fff, inset 0 0 0 0px #cd3920;
  -moz-box-shadow: inset 0 0 0 0 #CD391F, inset 0 0 0 0 #fff, inset 0 0 0 0px #cd3920;
  box-shadow: inset 0 0 0 0 #CD391F, inset 0 0 0 0 #fff, inset 0 0 0 0px #cd3920;
  color: #fff;
  background-color: #CD391F;
}
#aplayer{
			position: fixed;
			bottom: -100%;
			left: 0;
			width: 100%;
			margin: 0;
			box-shadow: 0 -2px 2px #dadada;
			background-color: #fff;
			transition: all ease 0.5s;
		}
		#aplayer.showPlayer{
			bottom: 0;
		}
	span{
			color: #000 !important;
			font-size: 16px;
		}
		.aplayer .aplayer-info .aplayer-controller .aplayer-bar-wrap .aplayer-bar .aplayer-loaded{
			background: #e0e0e0;
    		height: 4px;
		}
		.aplayer .aplayer-info .aplayer-controller .aplayer-bar-wrap .aplayer-bar .aplayer-played{
			height: 4px;
			background-color: #2196F3 !important;
		}
		.aplayer .aplayer-info .aplayer-controller .aplayer-bar-wrap .aplayer-bar .aplayer-played .aplayer-thumb{
			background-color: #2196F3 !important;
		}

		.aplayer .aplayer-icon{
			width: 20px;
			height: 20px;
		}
		.aplayer .aplayer-info .aplayer-controller .aplayer-time .aplayer-icon path {
		    fill: #000;
		}
		.aplayer .aplayer-info .aplayer-music{
			margin-bottom: 5px;
		}
</style>
</head>

<body>

<!-- Background image with blurr -->

  <div class="bg-image"></div>
 <header class="headd">
        <h1><a>MUSIC</a></h1>
        <h5 class="headerele"><a href="AlbAndAlbTypeController?action=HOME">Home</a></h5>
        <h5 class="headerele2"><a href="AlbAndAlbTypeController?action=HOME">Discover</a></h5>
        <h5 class="headerele3"><a href="AlbAndAlbTypeController?action=HOME">Browse</a></h5>
        <h5 class="headerele4"><a href="FavoritesController">Favorites</a></h5>
</header>
 <div class="container">

  <div class="row">
  <div class="column" >
      
    </div>
    <div class="columnimage">
      <img src="./TrackAlbumRetrieve?album_name=${albuminfo.album_name}" height="180" width="160" class="trackpageimage">
    </div>
    <div class="columndata">
       <br><br>
      <h2>${albuminfo.album_name}</h2>
      <h4>${albuminfo.album_description}</h4>
      
    </div>
    
    
    <div class="columnfav">
    <a href="${pageContext.request.contextPath}/TrackDisplayController?action=SaveFav&id=${albuminfo.album_id}">
      <i></i>
      <span>Added to Favorites!</span>
      
      </a> 
    </div>
   
  
  </div>
 </div>

 <table class="center">
 <tr> 
    <th style="text-align: left;">SONG</th>
    <th>TITLE</th>
    <th>ARTIST</th>
   <th><span class="glyphicon glyphicon-time" style="color:grey;"></span></th>
 </tr>
 
 <c:set var="count" value="0" scope="page" />
 <c:forEach  items="${tracklist}" var="track">

  <td><a href="#" class="album-poster" data-switch="${count}" data-value= "${track.track_no}" >
          play
      </a>
  </td>
  <td>${track.track_name}</td>
  <td>${track.track_performer}</td>
  <td>${track.track_duration}</td>
  <td></td>
  </tr>
  <c:set var="count" value="${count + 1}" scope="page"/>
</c:forEach> 

</table>


<input type="hidden" id="trnum" name="trnum" >


<div id="aplayer"></div>
<!-- <button id="rough" onclick="call()"></button> -->

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Bootstrap Link -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <!-- APlayer Jquery link -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>  

  <script>
  $(function() {
	    $( "i" ).click(function() {
	      $( "i,span" ).toggleClass( "press", 1000 );
	    });
	  });

    var audio=[];
    
    <c:forEach  items="${tracklist}" var="track">

    audio.push({
      name: '${track.track_name}',
      artist: '${track.track_performer}',
      url: './TrackRetrieve?track_no=${track.track_no}',
    });
     
    </c:forEach> 
    
    // NOW I CLICK album-poster TO GET CURRENT SONG ID
    $(".album-poster").on('click', function(e){
      var dataSwitchId = $(this).attr('data-switch');
      var datavalue = $(this).attr('data-value');
      
      $('#trnum').val(datavalue);
      console.log($('#trnum').val());

      if( datavalue != null){ 
        $.ajax({ 
        url : "DoGetErrorRecover",
        type : "GET", 
        data : { trnum : datavalue },
        success:function(data){ 
          console.log("done"); 
          } 
        }); 
      }     
      // and now i use aplayer switch function see
      ap.list.switch(dataSwitchId); //this is static id but i use dynamic  
      // aplayer play function
      // when i click any song to play
      ap.play();
      // click to slideUp player see
      $("#aplayer").addClass('showPlayer');
    });

    const ap = new APlayer({
        container: document.getElementById('aplayer'),
        listFolded: true,
        audio: audio
    });
  </script>
  
    <!--  APlayer JQuery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    
</body>
</html>