<%@ include file="../common/head.jsp" %>	
<body>
	<%@ include file="../common/menu.jsp" %>
	<h1>Inscription</h1>
	
	<form method="post" action="inscription">
		<label for="login">Enter your login</label>
        <input id="login" name="login" type="text" />
        <label for="pswd">Enter your password</label>
        <input id="pswd" name="pswd" type="password" />	
        
        <input id="sendInscription" type="submit" value="Inscription" />
	</form>
	
	<%@ include file="../common/footer.jsp" %>	
</body>
</html>