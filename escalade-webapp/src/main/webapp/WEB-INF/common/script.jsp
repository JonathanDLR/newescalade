	<c:choose>
		<c:when test="${title == 'Amis Escalade: Inscription'}">
			<script type="module" src="<c:url value="/assets/js/inscription.js" />"></script>
		</c:when>
		<c:when test="${title == 'Amis Escalade: Connexion' }">
			<script type="module" src="<c:url value="/assets/js/connexion.js" />"></script>
		</c:when>
	</c:choose>
</body>
</html>