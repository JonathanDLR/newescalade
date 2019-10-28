/* COMMENT MANAGING MODULE */

const COMMENTAIRE = {
		showbuttons: document.querySelectorAll(".showcom"),
		
		init: function() {
			COMMENTAIRE.showbuttons.forEach(function (button) {
				button.addEventListener("click", COMMENTAIRE.show);
			});
		},
		
		show: function(e) {
			var DIVcom = e.target.nextElementSibling;

			if ((DIVcom.style.display == "none") || (DIVcom.style.display == "")) {
				DIVcom.style.display = "block";
			} else {
				DIVcom.style.display = "none";
			}
		}
}

window.onload = COMMENTAIRE.init();