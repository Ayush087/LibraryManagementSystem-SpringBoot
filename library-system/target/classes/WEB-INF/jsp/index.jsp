<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Library Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">LMS</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">All Books</a></li>
				<li><a href="newBook">New Book</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<c:choose>
			<c:when test="${mode=='BOOK_VIEW'}">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Book ID</th>
							<th>Book Name</th>
							<th>Author</th>
							<th>Purchase Date</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="b" items="${bookObj }">
							<tr>
								<td>${b.id}</td>
								<td>${b.bookName}</td>
								<td>${b.author}</td>
								<td>${b.purDate}</td>
								<td><a href="updateBook?id=${b.id}"
									class="glyphicon glyphicon-pencil"> </a></td>
								<td><a href="delete?id=${b.id}"
									class="glyphicon glyphicon-minus-sign"> </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode=='BOOK_EDIT' || mode=='BOOK_NEW'}">
				<form action="save" method="POST">
					<label class="control-label col-sm-2 value="
						${bookObjU.id}" id="id"></label>

					<div class="form-group">
						<label class="control-label col-sm-2" for="bookName">Book
							Name :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="${bookObjU.bookName}" id="bookName"
								placeholder="Book Name" name="bookName">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="author">Author
							:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="${bookObjU.author}" id="author"
								placeholder="Author's Name" name="author">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="purDate">Purchase
							Date :</label>
						<div class="col-sm-10">
							<input type="date" class="form-control"
								value="${bookObjU.purDate}" id="purDate"
								placeholder="Date of Purchase" name="purDate">
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>
		</c:choose>

	</div>

</body>
</html>
