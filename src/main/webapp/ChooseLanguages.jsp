<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="in.dao.LogAndAuditDAO"  %>
<%@ page import="in.dao.LogAndAuditDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
	<title>CHOOSE</title>
	<style>
		body{
			background-color: black;
		}
	.filter {
		
		color: white;
    width: 850px;
    padding: 25px;
    border: 1px solid white;
    margin: 25px;
}
.filterr {
		color: white;
    width: 850px;
    padding: 25px;
    border: 1px solid white;
    margin: 25px;
}
ul.checkbox {
	color: white;
    margin: 0;
    padding: 0;
    margin-left: 20px;
    list-style: none;
}
ul.checkbox li input {
	color: white;
    margin-right: .25em;
}
ul.checkbox li {
	padding: 5px;
	padding-bottom: 10px;
	color: white;
    border: 1px transparent solid ;
    display:inline-block;
    width:12em;
}
ul.checkbox li label {
	color: white;
    margin-left:;
}
ul.checkbox li:hover, ul.checkbox li.focus {
	padding: 5px;
    background: linear-gradient(to right, #fc4a1a, #ee0979);
    border: 1px gray solid;
    width: 12em;
}
.lf--submit {

  display: block;
  padding: 1em;
  width: 25%;
  background: -webkit-gradient(linear, left top, right top, from(#35c3c1), to(#00d6b7));
  background: linear-gradient(to right, #fc4a1a, #ee0979);
  border: 0;
  color: #fff;
  cursor: pointer;
  font-size: 0.75em;
  font-weight: 600;
  text-shadow: 0 1px 0 rgba(0, 0, 0, 0.2);
}
.lf--submit:focus {
  outline: none;
  -webkit-transition: -webkit-transform 0.15s ease;
  transition: -webkit-transform 0.15s ease;
  transition: transform 0.15s ease;
  transition: transform 0.15s ease, -webkit-transform 0.15s ease;
  -webkit-transform: scale(1.1);
          transform: scale(1.1);
}
	</style>


</head>
<body>
	<form action="AlbAndAlbTypeController" method="post">
	<center>
	<div style="margin-top: 25px;" class="filter">
    <h2 style="text-align: center;">Choose Language[s]</h2>
    <br>
    <ul class="checkbox">
        <li>
            <input type="checkbox" name="lang" value="TELUGU" />
            <label>TELUGU</label>
        </li>
        <li>
            <input type="checkbox" name="lang" value="HINDI"/>
            <label>HINDI</label>
        </li>
        <li>
            <input type="checkbox" name="lang" value="TAMIL" />
            <label>TAMIL</label>
        </li>
        <li>
            <input type="checkbox" name="lang" value="ENGLISH" />
            <label>ENGLISH</label>
        </li>

        <li>
            <input type="checkbox" name="lang" value="MALYALAM" />
            <label>MALYALAM</label>
        </li>
        <li>
            <input type="checkbox" name="lang" value="PUNJABI" />
            <label >PUNJABI</label>
        </li>
        <li>
            <input type="checkbox" name="lang"  value="KANADA" />
            <label >KANADA</label>
        </li>
        
    </ul>
    <br>
</div>
<div style="margin-top: 45px;" class="filterr">
    <h2 style="text-align: center;">Choose Category</h2>
    <br>
    <ul class="checkbox">
        <li>
            <input type="checkbox" name="albtype" value="Vocal" />
            <label>VOCAL</label>
        </li>
        <li>
            <input type="checkbox" name="albtype" value="TOP PICKS"/>
            <label>TOP PICKS</label>
        </li>
        <li>
            <input type="checkbox" name="albtype" value="Tollywood Movie Albums" />
            <label>TELUGU ALBUMS</label>
        </li>
        <li>
            <input type="checkbox" name="albtype" value="Retro Covers" />
            <label>RETRO</label>
        </li>

        <li>
            <input type="checkbox" name="albtype" value="Remix Albums" />
            <label>REMIX</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Private English Albums" />
            <label>PRIVATE ENGLISH</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Live albums" />
            <label>LIVE ALBUMS</label>
        </li>
        
        <li>
            <input type="checkbox" name="albtype"  value="Gazals" />
            <label>GAZALS</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Instrumental" />
            <label>INSTRUMENTAL</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="FOLK"/>
            <label>FOLK</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Devotional Songs"/>
            <label>DEVOTIONAL</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Cover Albums"/>
            <label>COVER ALBUMS</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Canticle"/>
            <label>CANTICLE'S</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Aria"/>
            <label>ARIA</label>
        </li>
        <li>
            <input type="checkbox" name="albtype" value="Private Telugu Albums"/>
            <label for="cb6>">PRIVATE TELUGU</label>
        </li>
        <li>
            <input type="checkbox" name="albtype"  value="Kollywood Private Albums"/>
            <label>KOLLYWOOD PRIVATE</label>
        </li>
        
    </ul>
    <br>
</div>
<br>
<input class='lf--submit' type='submit' value='Choose'>
</center>
</form>
<% 
String email = (String) session.getAttribute("email");
LogAndAuditDAO logAndAuditDAO = null;
logAndAuditDAO = new LogAndAuditDAOImpl();
if(logAndAuditDAO.save("Choose Languages and Category", "User", email)) {
	System.out.println("Choosing Languages and Category event inserted");
}
%>
</body>
</html>