import { CHECKUSER } from './checkuser.js';

/* CHECK VALUE IN INSCRIPTION FORM */
const INSCRIPTION = {
	submit: document.getElementById("checkSubmit"),
		
	init: function() {
		INSCRIPTION.submit.addEventListener("click", INSCRIPTION.check);
	},
		
	check: function(e) {
		const pseudo = document.getElementById("pseudo");
		const regexPseudo = /^[A-zÀ-ÖØ-öø-ÿ0-9_\-]+$/;
		if (pseudo.value == "") {
			e.preventDefault();
			pseudo.nextElementSibling.innerText = "Veuillez renseigner votre pseudo.";
		} else if (!regexPseudo.test(pseudo.value)) {
			e.preventDefault();
			pseudo.nextElementSibling.innerText = "Votre pseudo ne peut contenir que des caractères alphanumériques, des _ et des -";
		}
		else {
			pseudo.nextElementSibling.innerText = "";
		}
		
		CHECKUSER.check(e);
	}
}

window.onload = INSCRIPTION.init();