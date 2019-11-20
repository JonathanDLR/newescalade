/* MODULE OF MOBILE MENU TOGGLE */

const MENUMOBILE = {
		buttonToToggle: document.getElementById("menuBut"),
		
		init: function() {
			MENUMOBILE.buttonToToggle.addEventListener("click", MENUMOBILE.open);
		},
		
		open: function() {
			document.getElementById("menuMob").style.width = "75vw";
			MENUMOBILE.buttonToToggle.addEventListener("click", MENUMOBILE.close);
			MENUMOBILE.buttonToToggle.removeEventListener("click", MENUMOBILE.open);
		},
		
		close: function() {
			document.getElementById("menuMob").style.width = "0";
			MENUMOBILE.buttonToToggle.removeEventListener("click", MENUMOBILE.close);
			MENUMOBILE.buttonToToggle.addEventListener("click", MENUMOBILE.open);
		}
}

window.onload = MENUMOBILE.init();