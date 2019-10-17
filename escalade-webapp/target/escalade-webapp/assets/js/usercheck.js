/**
 * CHECK VALUE IN USER FORM
 */
USERCHECK = {
	submit: document.getElementById("checkSubmit"),
	
	init: function() {
		USERCHECK.submit.addEventListener("click", USERCHECK.check);
	},
	
	check: function(e) {
		const login = document.getElementById("login");
		const pswd = document.getElementById("pswd");
		const regexMail = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
		const regexMdp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})/;
		
		if (login.value == "") {
			e.preventDefault();
			login.nextElementSibling.innerText = "Veuillez renseigner votre mail.";
		} else if (!regexMail.test(login.value)) {
			e.preventDefault();
			login.nextElementSibling.innerText = "Veuillez renseigner un mail valide.";
		} else if (pswd.value == "") {
			e.preventDefault();
			pswd.nextElementSibling.innerText = "Veuillez renseigner votre mot de passe.";
		} else if (!regexMdp.test(pswd.value)) {
			e.preventDefault();
			pswd.nextElementSibling.innerText = "Votre mot de passe doit contenir au minimum une lettre minuscule, une lettre majuscule, un chiffre et 6 caractères.";
		}
	}
}

window.onload = USERCHECK.init();