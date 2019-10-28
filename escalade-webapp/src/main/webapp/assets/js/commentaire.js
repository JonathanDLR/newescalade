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
			var buttonCreate = DIVcom.querySelector(".postcom");

			if ((DIVcom.style.display == "none") || (DIVcom.style.display == "")) {
				DIVcom.style.display = "block";
				if (buttonCreate != null) {
					buttonCreate.addEventListener("click", COMMENTAIRE.create);
				}			
			} else {
				if (buttonCreate != null) {
					buttonCreate.removeEventListener("click", COMMENTAIRE.create);
				}			
				DIVcom.style.display = "none";
			}
		},
		
		create: function(e) {
			var com = e.target.previousElementSibling.innerHTML;
			const site = e.target.getAttribute("data-class");
			
			if (com.innerHTML = "") {
				e.target.nextElementSibling.innerText = "Veuillez renseigner votre commentaire";
			} else {
				// AJAX
	            var xhr = new XMLHttpRequest();
	           
	            xhr.open('POST', 'createcom.html');
	            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	            xhr.send("com=" + com + "&site=" + site);

	            xhr.onreadystatechange = function() {
	                if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
	                   
	                   
	                   // RECONSTRUCT COMM ITEM WITH RESPONSE	 	                    
	 	               var newP = document.createElement("p");
	 	               newP.innerHTML = "Commentaire de " + xhr.responseText;
	 	               var newCom = document.createElement("p");
	 	               newCom.innerHTML = com;
	 	               var newDiv = document.createElement("div");
	 	               var newUpd = document.createElement("button");
	 	               newUpd.classList.add("comUpd");
	 	               newUpd.innerHTML = "Modifier";
	 	               var newDel = document.createElement("button");
	 	               newDel.classList.add("comDel");
	 	               newDel.innerHTML = "Supprimer";
	 	               newDiv.append(newUpd);
	 	               newDiv.append(newDel);
	 	               document.getElementById(site).append(newP);
	 	               document.getElementById(site).append(newCom);
	 	               document.getElementById(site).append(newDiv);   
	 	               
	 	               // RESET COM INPUT
	 	               e.target.previousElementSibling.innerHTML = "";
	                } else {
	                	e.target.previousElementSibling.innerHTML = "";
	                }
	            };
			}
			
			
       }
}

window.onload = COMMENTAIRE.init();