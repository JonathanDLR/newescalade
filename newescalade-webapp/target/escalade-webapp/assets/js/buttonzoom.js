/* MODULE FOR BUTTON ZOOM */

const BUTTONZOOM = {
		buttons: document.querySelectorAll(".zoom"),
		
		init: function() {
			BUTTONZOOM.buttons.forEach(function (button) {
				button.addEventListener("click", BUTTONZOOM.zoomin);
			});
		},
		
		zoomin: function(e) {
			e.target.style.transform = "scale(1.2)";
			setTimeout(function() {
				e.target.style.transform = "scale(1)";
			}, 500);
		}
}

window.onload = BUTTONZOOM.init();