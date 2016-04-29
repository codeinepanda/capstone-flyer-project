<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty currentUser}">
	<div class="container-fluid">
		<div class="row" id="header">
			<div class="col-xs-2 logo">
        		<img class="img-circle img-responsive" src="img/logo.jpg">
        	</div>
        	<div class="col-xs-8 title">
        		<h1>FLYERS CORNER</h1>
           	 	<h4>Welcome back, <c:out value="${currentUser.firstName}"/>!</h4>
        	</div>
        	<div class="col-md-2 points">
        		<h3>Your Redemption Points:</h3>
        		<c:if test="${not empty points}">
        			<p><strong><c:out value="${points}"/></strong></p>
        		</c:if>
        		<c:if test="${empty points}">
        			<p><strong>0</strong></p>
        		</c:if>
        	</div>
		</div>
	</div>
	
	<nav class="navbar navbar-inverse bs-docs-nav">
		<div class="container-fluid">
	   		<div class="navbar-header">
	      		<a class="navbar-brand" href="#">Flyers Corner</a>
	    	</div>
	    	<ul class="nav navbar-nav">
	    		<c:url var="toHome" value="/"/>
	     	 	<li><a href="${toHome}">Home</a></li>
	     	 	<c:url var="toSearch" value="/searchFlyers"/>
	      		<li><a href="${toSearch}">Search Flyers</a></li>
	      		<c:url var="toFeatured" value="/featured"/>
	      		<li><a href="${toFeatured}">Today's Featured Flyers</a></li>
	      		<c:url var="toRecommended" value="/recommendedFlyers"/>
	      		<li><a href="${toRecommended}">Recommended Flyers</a></li>
	      		<c:url var="toFlyerForm" value="/flyerForm"/>
	      		<li><a href="${toFlyerForm}">Publish a Flyer</a></li> 
	    	</ul>
	    	<ul class="nav navbar-nav navbar-right">
	    		<c:url var="toUserFlyers" value="/userFlyers"/>
	      		<li><a href="${toUserFlyers}"><span class="glyphicons glyphicons-list-alt"></span> Your Published Flyers</a></li>
	    		<c:url var="toTabs" value="/viewTabs"/>
	      		<li><a href="${toTabs}"><span class="glyphicons glyphicons-ticket"></span> Your Tabs</a></li>
	      		<c:url var="toLogout" value="/logout"/>
	      		<c:url var="toPreferences" value="/preferences"/>
	      		<li><a href="${toPreferences}"><span class="glyphicons glyphicons-list-alt"></span> Preferences</a></li>
	      		<li><a href="${toLogout}"><span class="glyphicons glyphicons-door"></span> Logout</a></li>
	    	</ul>
	  	</div>
	</nav>
</c:if>

<c:if test="${empty currentUser}">
	<div class="container-fluid">
		<div class="row" id="header">
			<div class="col-xs-2 logo">
        		<img class="img-circle img-responsive" src="img/logo.jpg">
        	</div>
        	<div class="col-xs-10 title">
        		<h1>FLYERS CORNER</h1>
           	 	<h4>Welcome!</h4>
        	</div>
		</div>
	</div>
        	
	<nav class="navbar navbar-inverse bs-docs-nav">
	<div class="container-fluid">
   		<div class="navbar-header">
      		<a class="navbar-brand" href="#">Flyers Corner</a>
    	</div>
    	<ul class="nav navbar-nav">
    		<c:url var="toHome" value="/"/>
     	 	<li class="active"><a href="${toHome}">Home</a></li>
     	 	<c:url var="toSearch" value="/searchFlyers"/>
      		<li><a href="${toSearch}">Search Flyers</a></li>
      		<c:url var="toFeatured" value="/featured"/>
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
</c:if>