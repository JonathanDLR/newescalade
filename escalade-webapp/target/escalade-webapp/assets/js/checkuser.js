export {CHECKUSER};

/**
 * MODULE FOR CHECK THE VALUE IN USER FORM
 */
const CHECKUSER = {
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
		} else {
			login.nextElementSibling.innerText = "";
		}
		if (pswd.value == "") {
			e.preventDefault();
			pswd.nextElementSibling.innerText = "Veuillez renseigner votre mot de passe.";
		} else if (!regexMdp.test(pswd.value)) {
			e.preventDefault();
			pswd.nextElementSibling.innerText = "Votre mot de passe doit contenir au minimum une lettre minuscule, une lettre majuscule, un chiffre et 6 caractères.";
		} else {
			pswd.nextElementSibling.innerText = "";
		}
	}
}
