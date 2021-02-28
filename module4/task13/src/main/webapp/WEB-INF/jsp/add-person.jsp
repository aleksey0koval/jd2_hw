<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>add-person</title>
</head>

<body>

<h1>Add New Person</h1>

<div class="container-fluid">
    <a class="navbar-brand" href="/task13">Look Person</a>
</div>

<form action="/task13/add-person/add" method="post">
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon1">Person Name</span>
      <input type="text" class="form-control" placeholder="person name"
      aria-label="person name" aria-describedby="basic-addon1" name="name">
    </div>

    <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon2">Person Surname</span>
          <input type="text" class="form-control" placeholder="person surname"
          aria-label="person surname" aria-describedby="basic-addon2" name="surname">
    </div>


    <button class="btn btn-outline-success" type="submit">Submit</button>

</form>


<form action="/task13" method="get">
    <button class="btn btn-outline-success" type="submit">Cancel</button>
</form>

 <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    -->

</body>
</html>