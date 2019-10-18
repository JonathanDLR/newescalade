import { CHECKUSER } from './checkuser.js';

/* CHECK VALUE IN INSCRIPTION FORM */
const INSCRIPTION = {
	submit: document.getElementById("checkSubmit"),
		
	init: function() {
		INSCRIPTION.submit.addEventListener("click", INSCRIPTION.check);
	},
		
	check: function(e) {
		const pseudo = document.getElementById("pseudo");	
		if (pseudo.value == "") {
			e.preventDefault();
			pseudo.nextElementSibling.innerText = "Veuillez renseigner votre pseudo.";
		} else {
			pseudo.nextElementSibling.innerText = "";
		}
		
		CHECKUSER.check(e);
	}
}

window.onload = INSCRIPTION.init();