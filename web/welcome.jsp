<%@ page import="org.tmi.pojo.User" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title> Title </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/website.css">

<style>
.pagination {
    display: inline-block;
    padding: 0;
    margin: 0;
}

.pagination li {display: inline;}

.pagination li a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
}

.pagination li a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

.pagination li a:hover:not(.active) {background-color: #ddd;}

.center {text-align: center;}
</style>
</head>
<body>

<div class="header" style="background-image: url('img/3.jpg');" >
    <h1>TMI LLC</h1>
    <% User user = (User)request.getSession().getAttribute("user"); out.write("<h3>Welcome ! "+user.getUserName()+"</h3>");%>
</div>

<div class="navbar">
    <a href="#">All</a>
    <a href="#">Price Sort</a>
    <a href="#">Best Selling</a>
    <a href="#">New Designs</a>
    <a href="#">Floor Lamps</a>
    <a href="#">Table Lamps</a>
    <a href="#" class="right">Search</a>
</div>

<div class="row">
    <div class="side">
        <h2>TMI LLC Profile</h2>
        <div> <img src="img/TMI.jpg" width="180" > </div>

        <p>TMI Introduction</p>
        <h3>More Information</h3>
        <p>Category</p>
        <div class="leftCover" style="height:60px;"> <a href="products.html">Products</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href=" ">Cart</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">Customers</a></div><br>
       <div class="leftCover" style="height:60px;"> <a href="#">Factories</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">Orders</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">Project</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">TMI Warehouse</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">New Designs</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">Employees</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">Annual Benefit</a></div><br>
        <div class="leftCover" style="height:60px;"> <a href="#">Employees</a></div><br>

    </div>
    <div class="main">
        <h2>TMI Brand </h2>
        <div class="fakeimg" style="height:120px;"><img onlick="product_info1()"src="img/Brand.jpg" width="400" > </div>
        <h2>TMI Lamps Display </h2>
        <div class="fakeimg" style="height:200px;">
            <a href="product_info1.html"><img src="img/1288431.jpg" width="200"  height="200"></a>
            &emsp;&emsp;
            <img src="img/1472450.jpg" width="200"  height="200">
            <h2>add to cart</h2>
        </div>

        <br>
        <div class="fakeimg" style="height:200px;">
            <img src="img/1441878.jpg" width="200" height="200" >
            &emsp;&emsp;
            <img src="img/1518188.jpg" width="200" height="200" >
        </div>
        <br>
        <div class="fakeimg" style="height:200px;">
            <img src="img/1900120.jpg" width="200" height="200" >
            &emsp;&emsp;
            <img src="img/2001064.jpg" width="200" height="200" >
        </div>
        <br>
        <br>
        <h2>Home Decoration Taste And Life</h2>
        <p>The light in your eyes, light up my heart.</p>
        <p>Let us make things better.</p>
        <p>A light, a point less electric energy</p>

        <br>
        <h2>Package Recycling </h2>
        <p>going green and environmental protection</p>
        <p> Should you have interests in us, please don't hesitate to get in touch with us.</p>
        <div class="fakeimg" style="height:200px;">
            <img src="img/sgs.jpg" width="130" height="100" >
            &emsp;&emsp;
            <img src="img/recircle.jpg" width="410" height="90" >

        </div>
        <div class="center">
          <ul class="pagination">

            <li><a href="#"><<</a></li>
            <li><a class="active" href="#">1</a></li>
            <li><a href="page2.html">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li><a href="#">7</a></li>
            <li><a href="#">>></a></li>
          </ul>
        </div>
    </div>
</div>

<div class="footer">
    <h2>TMI, LLC</h2>
    <h2> 2324 Barton Creek Blvd, The Colony, TX 75056, USA</h2>

    <p> For assistance with assembly or installation, parts and customer service, call US or Canada
    800-390-0199 (English),</p>
    <p> 8:00am-9:00pm, Monday-Friday, Central Time or email customer service:
    tmillc.customerservice@gmail.com</p>
</div>

</body>
</html>