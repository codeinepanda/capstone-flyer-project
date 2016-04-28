<div class="container-fluid">
	<div class="row">
		<div class="col-xs-4 logo">
        	<img src="">
        </div>
        <div class="col-xs-8 title">
        	<h1>FLYERS CORNER</h1>
            <h4>Welcome back, <c:out value="${currentUser.firstName}"/>!</h4>
        </div>
        <div class="col-md-4 points">
        	<h3>Your Redemption Points:</h3>
        	<p><strong><c:out value="${points}"/></strong></p>
        </div>


<nav class="navbar navbar-inverse">
	<div class="container-fluid">
   		<div class="navbar-header">
      		<a class="navbar-brand" href="#">Flyers Corner</a>
    	</div>
    	<ul class="nav navbar-nav">
    		<c:url var="toHome" value="/"/>
     	 	<li><a href="${toHome}">Home</a></li>
     	 	<c:url var="toSearch" value="/searchFlyers"/>
      		<li><a href="${toSearch}">Search Flyers</a></li>
      		<c:url var="toFeatured" value="/viewFeatured"/>
      		<li><a href="${toFeatured}">Today's Featured Flyers</a></li>
      		<c:url var="toRecommended" value="/viewRecommended"/>
      		<li><a href="${toRecommended}">Your Recommended Flyers</a></li>
      		<c:url var="toFlyerForm" value="/flyerForm"/>
      		<li><a href="${toFlyerForm}">Publish a Flyer</a></li> 
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
    		<c:url var="toTabs" value="/userFlyers"/>
      		<li><a href="${toUserFlyers}"><span class="glyphicons glyphicons-list-alt"></span> Your Published Flyers</a></li>
    		<c:url var="toTabs" value="/viewTabs"/>
      		<li><a href="${toTabs}"><span class="glyphicons glyphicons-ticket"></span> Your Tabs</a></li>
      		<c:url var="toLogout" value="/logout"/>
      		<c:url var="toPreferences" value="/preferences"/>
      		<li><a href="${toPreferences}"><span class="glyphicons glyphicons-list-alt"></span> Preferences</a></li>
      		<li><a href="${toLogout}"><span class="glyphicons glyphicons-door"></span> Logout</a></li>
      		</form>
    	</ul>
  	</div>
</nav>