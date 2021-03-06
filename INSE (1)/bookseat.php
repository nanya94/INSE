<!DOCTYPE html>
<html>
<link href="log-in_1.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300" rel="stylesheet">
<head>
  <title>
    BOOK SEAT
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
  <nav>
    <ul>
      <li><a href="index.php">Home</a></li>
      <li class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Make Booking</a>
        <div class="dropdown-content">
          <a href="bookseat.php">Book Seat</a>
          <a href="bookseat.php">Book Group of Seats</a>
        </div>
      </li>
      <li><a href="bookreserving.php">Reserved Book</a></li>
      <li class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Maps</a>
        <div class="dropdown-content">
          <a href="floor1.php">Ground Floor Floor</a>
          <a href="floor2.php">First Floor</a>
          <a href="floor3.php">Second Floor</a>
        </div>
      </li>
      <li style="float:right; text-decoration: none;"><a class="active" href="logout.php">Log Out</a></li>
    </ul>
  </nav>
  <div class="book-seat">
    <form method="post" action="bmade.php" id="book-seat">
        <h3 class="register"> Book Seat </h3>
        <label for="type"> Seat Type: </label>
        <select name="stype">
          <option value="any">Any</option>
          <option value="computer">Computer</option>
          <option value="Table">Table</option>
          <option value="stand-up-computer">Stand-Up Computer</option>
          <option value="booth">Booth</option>
        </select>
        <br><br>
        <label for='floor' >Floor Preference:</label>
        <select name="cars">
          <option value="any">Any</option>
          <option value="groundfl">Ground Floor</option>
          <option value="firstfl">First Floor</option>
          <option value="secondfl">Second Floor</option>
        </select>
        <br><br>
        <label for='start-date' >Star Date*:</label>
        <input type="date" name="startdate">
        <label for='end-date' >End Date*:</label>
        <input type="date" name="bday">
        <br><br>
        <label for="start-time">Start Time</label>
        <input type="time" name="time" />
        <label for="end-time">End Time</label>
        <input type="time" name="time" />
        <br><br>
        <input type='submit' name='Submit' value='Book' class="_1on88 _7k49n" />
      </fieldset>
    </form>




  </div>
  <footer>
    <p>All right reservered 2017</p>
  </footer>
</body>
</html>
