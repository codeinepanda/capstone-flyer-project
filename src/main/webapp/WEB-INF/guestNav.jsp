<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
      		<a class="navbar-brand" href="#">Flyers Corner</a>
    	</div>
    	<ul class="nav navbar-nav">
     	 	<li class="active"><a href="#">Home</a></li>
     	 	<c:url var="toSearch" value="/searchFlyers"/>
      		<li><a href="${toSearch}">Search Flyers</a></li>
      		<c:url var="toFeatured" value="/viewFeatured"/>
      		<li><a href="${toFeatured}">View Featured Flyers</a></li> 
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
    		<c:url var="toRegistration" value="/registration"/>
      		<li><a href="${toRegistration}"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      		<c:url var="toLogin" value="/loginPage"/>
      		<li><a href="${toLogin}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    	</ul>
  	</div>
</nav>