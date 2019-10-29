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
			var buttonsShow = document.querySelectorAll(".showModal");
			

			if ((DIVcom.style.display == "none") || (DIVcom.style.display == "")) {
				DIVcom.style.display = "block";

				if (buttonCreate != null) {
					buttonCreate.addEventListener("click", COMMENTAIRE.create);
				}	
				if (buttonsShow != null) {
					buttonsShow.forEach(function (button) {
						button.addEventListener("click", COMMENTAIRE.showModal);
					});
				}
			} else {
				if (buttonCreate != null) {
					buttonCreate.removeEventListener("click", COMMENTAIRE.create);
				}	
				if (buttonsShow != null) {
					buttonsShow.forEach(function (button) {
						button.removeEventListener("click", COMMENTAIRE.showModal);
					});
				}
				DIVcom.style.display = "none";
			}
		},
		
		// CREATING COMMENTAIRE
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
	                	var newDivCom = document.createElement("div");
	                	newDivCom.classList.add("DIVcomm");
	 	               var newP = document.createElement("p");
	 	               var newSpan = document.createElement("span");
	 	               newSpan.classList.add("commentaire");
	 	               newSpan.innerHTML = xhr.responseText;
	 	               newP.append(newSpan);
	 	               var newSpanCom = document.createElement("span");
	 	               newSpanCom.innerHTML = ": " + com;
	 	               newP.append(newSpanCom);
	 	               var newDiv = document.createElement("div");
	 	               newDiv.classList.add("admcom");
	 	               var newUpd = document.createElement("button");
	 	               newUpd.classList.add("showModal");
	 	               newUpd.innerHTML = "Modifier";
	 	               var newDel = document.createElement("button");
	 	               newDel.classList.add("showModal");
	 	               newDel.innerHTML = "Supprimer";
	 	               newDiv.append(newUpd);
	 	               newDiv.append(newDel);
	 	               newDivCom.append(newP);
	 	               newDivCom.append(newDiv);
	 	               document.getElementById(site).append(newDivCom);   
	 	               
	 	               // RESET COM INPUT
	 	               e.target.previousElementSibling.innerHTML = "";
	                } else {
	                	e.target.previousElementSibling.innerHTML = "";
	                }
	            };
			}
       },
       
       // SHOW VALIDATION MODAL
       showModal: function(e) {
    	   var modalToShow = e.target.nextElementSibling;
    	   modalToShow.style.display = "block";
    	   var buttonDelete = modalToShow.querySelector(".comDel");
    	   var buttonUpdate = modalToShow.querySelector(".comUpd");
    	   var buttonHide = modalToShow.querySelector(".hideModal");
    	   
    	   // ADD UPDATE AND DELETE EVENT
    	   if (buttonDelete != null) {
    		   buttonDelete.addEventListener("click", COMMENTAIRE.del);
    	   } else {
    		   
    	   }
    	   buttonHide.addEventListener("click", COMMENTAIRE.hideModal);
       },
       
       // HIDE VALIDATING MODAL
       hideModal: function(e) {
    	   var modalToHide = e.target.parentElement.parentElement;
    	   var buttonDelete = e.target.parentElement.querySelector(".comDel");
    	   var buttonUpdate = e.target.parentElement.querySelector(".comUpd");
    	   
    	   // REMOVE UPDATE AND DELETE EVENT
    	   if (buttonDelete != null) {
    		   buttonDelete.removeEventListener("click", COMMENTAIRE.del);
    	   } else {
    		   
    	   }
    	   e.target.removeEventListener("click", COMMENTAIRE.hideModal);
    	   modalToHide.style.display = "none";
       },
       
       // DELETE COMM
       del: function(e) {
    	   var comToDeleteDIV = e.target.parentElement.parentElement.parentElement.parentElement;
    	   var comToDelete = comToDeleteDIV.id;
    	// AJAX
           var xhr = new XMLHttpRequest();
          
           xhr.open('POST', 'delcom.html');
           xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
           xhr.send("comToDelete=" + comToDelete);

           xhr.onreadystatechange = function() {
               if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {                
                  
            	   // RECONSTRUCT COMM ITEM WITH RESPONSE	 	                    
	               comToDeleteDIV.parentElement.removeChild(comToDeleteDIV);
	               
	               // HIDE MODAL
	               COMMENTAIRE.hideModal;
               } else {
               	// e.target.previousElementSibling.innerHTML = "";
               }
           };
       }
}

window.onload = COMMENTAIRE.init();