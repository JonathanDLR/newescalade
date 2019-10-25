/**
 * MODULE FOR CHECK THE VALUE IN USER FORM
 */
const NEWSITE = {
		submit: document.getElementById("siteSubmit"),
		
		init: function() {
			NEWSITE.submit.addEventListener("click", NEWSITE.create);
		},
		
		create: function(e) {
		const name = document.getElementById("nom");
		const nbreSecteur = document.getElementById("nbreSecteur");
		
		if (name.value == "") {
			e.preventDefault();
			name.nextElementSibling.innerText = "Veuillez renseigner le nom du site.";
		} else {
			name.nextElementSibling.innerText = "";
		}
		if (parseInt(nbreSecteur.value) < 1) {
			e.preventDefault();
			nbreSecteur.nextElementSibling.innerText = "Veuillez renseigner un nombre supérieur à zéro.";
		} else {
			nbreSecteur.nextElementSibling.innerText = "";
		}
	}
}

window.onload = NEWSITE.init();