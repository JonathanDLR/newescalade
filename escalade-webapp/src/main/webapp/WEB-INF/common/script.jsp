	<c:choose>
		<c:when test="${title == 'Amis Escalade: Inscription'}">
			<script type="module" src="<c:url value="/assets/js/inscription.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Connexion' }">
			<script type="module" src="<c:url value="/assets/js/connexion.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Les Sites' }">
			<script src="<c:url value="/assets/js/togglesite.js" />"></script>
			<script src="<c:url value="/assets/js/commentaire.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Les Topos' }">
			<script src="<c:url value="/assets/js/newresa.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Votre Compte' }">
			<script src="<c:url value="/assets/js/newlieu.js" />"></script>
			<script src="<c:url value="/assets/js/newtopo.js" />"></script>
			<script src="<c:url value="/assets/js/processedresa.js" />"></script>
			<script src="<c:url value="/assets/js/toggletopo.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Creation Site' }">
			<script src="<c:url value="/assets/js/newsite.js" />"></script>
			<script src="<c:url value="/assets/js/newlieu.js" />"></script>
		</c:when>
	</c:choose>
	<c:if test="${ !empty user }">
		<script src="<c:url value="/assets/js/menu.js" />"></script>
	</c:if>
</body>
</html>