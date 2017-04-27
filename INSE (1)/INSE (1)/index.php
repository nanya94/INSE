<!doctype html><!DOCTYPE html>
<html>
<link href="log-in_1.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300" rel="stylesheet">
<head>
  <title>
    BOOKING
  </title>
</head>
<body>
  <header>
    <div class="logo">
      <a href="index.html">
        <img src="img/UoPlogo.png" alt="Portsmouth University"/>
      </a>
    </div>
  </header>
  <article class="content">
    <nav>
      <ul>
        <li><a href="index.php">Home</a></li>
        <li><a href="bookseat.html" class="dropbtn">Book Seat</a></li>
        <li><a href="bookreserving.html">Reserved Book</a></li>
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
    <div class="datagrid">
      <table>
        <thead>
          <tr>
            <th>Booking Number</th>
            <th>Booking Floor</th>
            <th>Booking Date</th>
            <th>Booking Time</th>
            <th>Booking Duration</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Any Floor</td>
            <td>0:00</td>
            <td>09:00</td>
            <td>2 h</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Second Floor</td>
            <td>25/03/2017</td>
            <td>11:05</td>
            <td>1 h</td>
          </tr>
          <tr>
            <td>3</td>
            <td>Ground Floor</td>
            <td>30/03/2017</td>
            <td>15:00</td>
            <td>30 m</td>
          </tr>
          <tr>
            <td>4</td>
            <td>Ground Floor</td>
            <td>01/04/2017</td>
            <td>23:00</td>
            <td>1 h</td>
          </tr>
        
        </tbody>
      </table>
    </div>
  </article>
  <footer>
    <p>For any enquires or to cancel or amend booking makde, please click here</p>
    <p>All right reservered 2017</p>
  </footer>
</body>
</html>
