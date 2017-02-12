
<!DOCTYPE html>
<html>
<link href="log-in_1.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300" rel="stylesheet">
<head>
  <title>
    REGISTER
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
    <form method="post" action="register.php" id="register">
        <h3 class="register"> Register </h3>
        <label for="name"> Your Full Name*: </label>
        <input type='text' name='name' id='name' maxlength="50" />
        <label for='email' >Email Address*:</label>
        <input type='text' name='email' id='email' maxlength="50" />
        <label for='username' >UserName*:</label>
        <input type='text' name='username' id='username' maxlength="50" />
        <label for='password' >Password*:</label>
        <div class="passowrd">
          <input type='password' name='password' id='password' maxlength="50" />
        </div>
        <input type='submit' name='Submit' value='Sign Up' class="_1on88 _7k49n" />
        <label for ="legal-rights" id="legal"><a href="register.html"> By signing up, you agree to our Terms & Privacy Policy.</a></label>
      </fieldset>
    </form>
    <div class="legal">
      <p class="rights">
        <!--react-text:131 -->
        Have an account?
        <a class="copy" href="log-in_1.html">Log In</a>
      </p>
  </div>
  <footer>
    <p>All right reservered 2017</p>
  </footer>
</body>
</html>
