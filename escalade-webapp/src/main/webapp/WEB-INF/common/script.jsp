	<c:choose>
		<c:when test="${title == 'Amis Escalade: Inscription'}">
			<script type="module" src="<c:url value="/assets/js/inscription.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Connexion' }">
			<script type="module" src="<c:url value="/assets/js/connexion.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Les Topos' }">
			<script type="module" src="<c:url value="/assets/js/newresa.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Votre Compte' }">
			<script type="module" src="<c:url value="/assets/js/newlieu.js" />"></script>
			<script type="module" src="<c:url value="/assets/js/newtopo.js" />"></script>
		</c:when>
	</c:choose>
	<c:if test="${ !empty user }">
		<script src="<c:url value="/assets/js/menu.js" />"></script>
	</c:if>
</body>
</html>