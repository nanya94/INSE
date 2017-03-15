<!doctype html><!DOCTYPE html>
<html>
<link href="log-in_1.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300" rel="stylesheet">
<head>
  <title>
    RECOVER PASSWORD
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
  <h2 class="subtitle">Reset Password</h2>
  <p class="rvb-instc">
    We can help you reset your password using your
    University username or
    the email address linked to your account.
  </p>
  <iframe src="about:blank" style="height: 0px; width: 0px; visibility: hidden; border: none; display: none;">
    This frame prevents back/forward cache problems in Safari.
  </iframe>
  <div class="form">
    <form method="post" action="sent.php">
      <label for="uni-email"> Email or Username</label>
      <input type="text" name="e-mail" id="email">
      <input type="submit" value="Reset Password">
    </form>
  </div>
  <footer>
    <p>All right reservered 2017</p>
  </footer>
</body>
</html>
