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
<title>HISTORY</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://localhost:8080/Music_Streamer/resources/css/history.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="http://localhost:8080/Music_Streamer/resources/script/history.js"></script>
</head>
<body>
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>History</h2>
					</div>
					<div class="col-sm-6">
					<button class="btn btn-primary" onclick="window.location.href='#'">Clear History</button>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>ID</th>
						<th>Track Name</th>
						<th>Track Performer</th>
						<th>Duration</th>
						<th>Actions</th>
						
					</tr>
				</thead>
				<c:forEach  items="${histories}" var="history">				
				<tbody>

					<tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>						
						<td>${history.trackid}</td>
						<td>${history.track_name}</td>
						<td>${history.performer_name}</td>
						<td>${history.track_duration}</td>
						<td>
						<%-- <%-- <input type="hidden" name="id" value="${alb.album_id}"> --%>
<%--   						<a href="${pageContext.request.contextPath}/HistoryController?action=DELETE&id=${history.track_id}">DELETE</a> 		
 --%>						</td>
					</tr>

		</tbody>	
		</c:forEach>			
			</table>
		</div>
	</div>        
</div>
</body>
</html>