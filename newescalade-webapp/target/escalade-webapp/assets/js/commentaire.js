/* COMMENT MANAGING MODULE */

const COMMENTAIRE = {
		showbuttons: document.querySelectorAll(".showcom"),
		
		init: function() {
			COMMENTAIRE.showbuttons.forEach(function (button) {
				button.addEventListener("click", COMMENTAIRE.show);
			});
		},
		
		show: function(e) {
			var DIVcom = e.target.parentElement.nextElementSibling;
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
	                	
	                	var responseArray = JSON.parse(xhr.response);
	                	                  
	                   // RECONSTRUCT COMM ITEM WITH RESPONSE
	                	var newDivCom = document.createElement("div");
	                	newDivCom.classList.add("DIVcomm");
	                	newDivCom.id = responseArray[2];
	 	                var newP = document.createElement("p");
	 	                var newSpan = document.createElement("span");
	 	                newSpan.classList.add("commentaire");
	 	                newSpan.innerHTML = responseArray[0];
	 	                newP.append(newSpan);
	 	                var newSpanCom = document.createElement("span");
	 	                newSpanCom.classList.add("theCom");
	 	                newSpanCom.innerHTML = ": " + com;
	 	                newP.append(newSpanCom);
	 	               
	 	               
	 	               // ADD ADMION BUTTON IF USER IS ADMIN
	 	               if (responseArray[1] == "admin") {
	 	            	   // CREATION DIV ADMCOM
	 	            	   var newDiv = document.createElement("div");
	 	            	   newDiv.classList.add("admcom");
		 	               var newUpd = document.createElement("button");
		 	               newUpd.classList.add("showModal");
		 	               newUpd.innerHTML = "Modifier";
		 	               var newDel = document.createElement("button");
		 	               newDel.classList.add("showModal");
		 	               newDel.innerHTML = "Supprimer";
		 	               newUpd.addEventListener("click", COMMENTAIRE.showModal);
		 	               newDel.addEventListener("click", COMMENTAIRE.showModal);
		 	               
		 	               // CREATION UPDATE MODAL
		 	              var newDivModalUpd = document.createElement("div");
		 	               newDivModalUpd.classList.add("modal");
		 	               var newPModalUpd = document.createElement("p");
		 	               newPModalUpd.setAttribute("contenteditable", "true");
		 	               newPModalUpd.innerHTML = com;
		 	               var newDivUpdBut = document.createElement("div");
		 	               var newUpdButton = document.createElement("button");
		 	               newUpdButton.innerHTML = "Modifier";
		 	               newUpdButton.classList.add("comUpd");
		 	               newUpdButton.addEventListener("click", COMMENTAIRE.upd);
		 	               var newUpdHideButton = document.createElement("button");
		 	               newUpdHideButton.innerHTML = "Annuler";
		 	               newUpdHideButton.classList.add("hideModal");
		 	               newUpdHideButton.addEventListener("click", COMMENTAIRE.hideModal);
		 	               newDivUpdBut.append(newUpdButton);
		 	               newDivUpdBut.append(newUpdHideButton);
		 	               
		 	               newDivModalUpd.append(newPModalUpd);
		 	               newDivModalUpd.append(newDivUpdBut);
		 	               
		 	               // CREATION DELETE MODAL
		 	               var newDivModalDel = document.createElement("div");
		 	               newDivModalDel.classList.add("modal");
		 	               var newPModalDel = document.createElement("p");
		 	               newPModalDel.innerHTML = "Êtes vous sûr de vouloir supprimer ce commentaire?";
		 	               var newDivDelBut = document.createElement("div");
		 	               var newDelButton = document.createElement("button");
		 	               newDelButton.innerHTML = "Oui";
		 	               newDelButton.classList.add("comDel");
		 	               newDelButton.addEventListener("click", COMMENTAIRE.del);
		 	               var newDelHideButton = document.createElement("button");
		 	               newDelHideButton.innerHTML = "Non";
		 	               newDelHideButton.classList.add("hideModal");
		 	               newDelHideButton.addEventListener("click", COMMENTAIRE.hideModal);
		 	               newDivDelBut.append(newDelButton);
		 	               newDivDelBut.append(newDelHideButton);
		 	               
		 	               newDivModalDel.append(newPModalDel);
		 	               newDivModalDel.append(newDivDelBut);
		 	               
		 	               newDiv.append(newUpd);
		 	               newDiv.append(newDivModalUpd);
		 	               newDiv.append(newDel);
		 	               newDiv.append(newDivModalDel);
	 	               }
	 	               
	 	               newDivCom.append(newP);
	 	               
	 	               if (responseArray[1] == "admin") {
	 	            	  newDivCom.append(newDiv);
	 	               }
	 	               
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
    		   buttonUpdate.addEventListener("click", COMMENTAIRE.upd);
    	   }
    	   buttonHide.addEventListener("click", COMMENTAIRE.hideModal);
       },
       
       // HIDE VALIDATION MODAL
       hideModal: function(e) {
    	   var modalToHide = e.target.parentElement.parentElement;
    	   var buttonDelete = e.target.parentElement.querySelector(".comDel");
    	   var buttonUpdate = e.target.parentElement.querySelector(".comUpd");
    	   
    	   // REMOVE UPDATE AND DELETE EVENT
    	   if (buttonDelete != null) {
    		   buttonDelete.removeEventListener("click", COMMENTAIRE.del);
    	   } else {
    		   buttonUpdate.removeEventListener("click", COMMENTAIRE.upd);
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
               } else {
               	// e.target.previousElementSibling.innerHTML = "";
               }
           };
       },
       
       // UPDATE COMM
       upd: function(e) {
    	   var DIVtoUpd = e.target.parentElement.parentElement.parentElement.parentElement;
    	   var comToUpdate = DIVtoUpd.id;  	
    	   var newCom = e.target.parentElement.parentElement.querySelector("p").innerText;

    	// AJAX
           var xhr = new XMLHttpRequest();
          
           xhr.open('POST', 'updcom.html');
           xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
           xhr.send("comToUpdate=" + comToUpdate + "&newCom=" + newCom);

           xhr.onreadystatechange = function() {
               if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {                
                  
            	   // RECONSTRUCT COMM ITEM WITH RESPONSE	 	                    
	               DIVtoUpd.querySelector(".theCom").innerHTML = ": " + newCom;
	               
	               // HIDE MODAL
	               COMMENTAIRE.hideModal(e);
               } else {
               	// e.target.previousElementSibling.innerHTML = "";
               }
           };
       }
}

window.onload = COMMENTAIRE.init();