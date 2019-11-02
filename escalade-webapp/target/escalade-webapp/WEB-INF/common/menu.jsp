
    <div id="menu">
    	<div><a href="/escalade-webapp"><img src="<c:url value="/assets/img/logo.png" />" id="logoAcc" alt="logo"/></a></div>
    	<div><a href="site">Les Sites</a></div>   	
    	<c:choose>
    		<c:when test="${ !empty user }">
    			<div><a href="topos">Les Topos</a></div>
    			<div>
    				<div id="DIVaccdeco">
	    				<a id="DIVaccount" href="account">Votre Compte</a>
	    				<a id="DIVaccsite" href="newsite">Créer un site</a>
	    				<a id="DIVdeco" href="deco">Se Deconnecter</a>
	    			</div>
    			</div>			
    		</c:when>
    		<c:otherwise>
    			<div><a href="connexion">Connexion/Inscription</a></div>
    		</c:otherwise>
    	</c:choose>
    </div>
    
    <div id="menuMobile">
    	<c:if test="${title == 'Amis Escalade: Les Sites' }">
    		<img src="<c:url value="/assets/img/search.png" />" id="searchBut" alt="search"/>
    	</c:if>
    	<img src="<c:url value="/assets/img/logo.png" />" id="logo" alt="logo"/>
    	<img src="<c:url value="/assets/img/menu.png" />" id="menuBut" alt="menu"/>
    </div>
    
    <div id="menuMob">
    	<div><a href="/escalade-webapp">Accueil</a></div>
    	<div><a href="site">Sites</a></div>   	
    	<c:choose>
    		<c:when test="${ !empty user }">
    			<div><a href="topos">Topos</a></div>
    			<div><a href="account">Votre Compte</a></div>
	    		<div><a href="newsite">Créer un site</a></div>
	    		<div><a href="deco">Se Deconnecter</a></div>		
    		</c:when>
    		<c:otherwise>
    			<div><a href="connexion">Connexion/Inscription</a></div>
    		</c:otherwise>
    	</c:choose>
    </div>