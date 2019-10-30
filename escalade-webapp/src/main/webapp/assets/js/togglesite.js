/* MODULE TO TOGGLE SITE OFFICIAL LES AMIS DE L'ESCALADE */

const TOGGLESITE = {
		toggleButtons: document.querySelectorAll(".toggleTag"),
		
		init: function() {
			TOGGLESITE.toggleButtons.forEach(function (button) {
				button.addEventListener("click", TOGGLESITE.toggle);
			});
		},
		
		toggle: function(e) {
			e.preventDefault();
			var site = e.target.parentElement.getAttribute("data-name");
			
			// AJAX
	        var xhr = new XMLHttpRequest();
	       
	        xhr.open('POST', 'togglesite.html');
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	        xhr.send("site=" + site);

	        xhr.onreadystatechange = function() {
	            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {

	               // CHANGE BUTTON INNERHTML AND ADD OR DELETE OFFICIAL SPAN
	               if (e.target.innerHTML.trim() == "Enlever le tag") {
	            	   var spanToDelete = e.target.parentElement.previousElementSibling.querySelector(".official");
	            	   spanToDelete.parentElement.removeChild(spanToDelete);
	            	   e.target.innerHTML = "Ajouter le tag";
	               } else {
	            	   var newOff = document.createElement("span");
	            	   newOff.classList.add("official");
	            	   newOff.innerHTML = "Officiel les amis de l'escalade";
	            	   
	            	   var elementBefore = e.target.parentElement.previousElementSibling.querySelector("h3");
	            	   elementBefore.insertAdjacentElement("afterend", newOff);
	            	   
	            	   e.target.innerHTML = "Enlever le tag";
	               }
	               
	            } else {
	            	// e.target.nextElementSibling.innerText = xhr.responseText;
	            }
	        };
		}
}

window.onload = TOGGLESITE.init();