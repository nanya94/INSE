<!doctype html><!DOCTYPE html>
<html>
<link href="log-in_1.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300" rel="stylesheet">
<head>
  <title>
    LOG IN
  </title>
</head>
<body>
  <header>
    <div class="logo">
      <a href="log-in_1.php">
        <img src="img/UoPlogo.png" alt="Portsmouth University"/>
      </a>
    </div>
  </header>
  <div class="form">
    <form method="post" action="i.php">
      <label for="uni-email"> Email </label>
      <input type="text" name="e-mail" id="email">
      <label for="password"> Password </label>
      <input type="password" name="psw" id="password" style="border-bottom: 0px;">
      <label for ="recover" id="recover"><a href="recover.php"> Recover Password </a></label>
      <input type="submit" value="Log In">
    </form>
  </div>
  <div class="legal">
    <p class="rights">
      <a href="register.php">
        Don't have an account. Register Now
      </a>
    </p>
  </div>
  <footer>
    <p>All right reservered 2017</p>
  </footer>
</body>
</html>
