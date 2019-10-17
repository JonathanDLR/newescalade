import { CHECKUSER } from './checkuser.js';

/**
 * CHECK VALUE IN CONNEXION FORM
 */
const CONNEXION = {
	submit: document.getElementById("checkSubmit"),
	
	init: function() {
		CONNEXION.submit.addEventListener("click", CONNEXION.check);
	},
	
	check: function(e) {
		CHECKUSER.check(e);
	}
}

window.onload = CONNEXION.init();