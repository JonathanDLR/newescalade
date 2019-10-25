/* MODULE TO SEARCH SITE */

const SEARCHSITE = {
		submit: document.getElementById("search"),
		
		init: function() {
			SEARCHSITE.submit.addEventListener("click", SEARCHSITE.search)
		},
		
		search: function(e) {
			e.preventDefault();
			
			const lieu = document.querySelector("#locselect").value;
			const cotation = document.querySelector("#cotselect").value;
			const secteur = document.querySelector("#secteur").value;
			
			// AJAX
            var xhr = new XMLHttpRequest();
           
            xhr.open('POST', 'search.html');
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("lieu=" + lieu + "&cotation=" + cotation + "&secteur=" + secteur);

            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
                   
                   // RECONSTRUCT SELECT ITEM WITH RESPONSE
                   
                   try {
                   	 var arraySite = JSON.parse(xhr.response); 
                   	 var divTab = document.getElementById("DIVtab");
                   	 
                   	 
	                    
	                    divTab.innerHTML = "";
	                    if (arraySite.length > 0) {
	                    	arraySite.forEach(function (site) {
		                        var newDiv = document.createElement("div");
		                        var newH3 = document.createElement("h3");
		                        newH3.innerHTML = site.nom;
		                        newDiv.append(newH3);
		                        var pLoc = document.createElement("p");
		                        pLoc.innerHTML = "Localisation: " + site.lieu.name;
		                        newDiv.append(pLoc);
		                        var pCot = document.createElement("p");
		                        pCot.innerHTML = "Cotation: " + site.cotation.cot;
		                        newDiv.append(pCot);
		                        var pSecteur = document.createElement("p");
		                        pSecteur.innerHTML = site.nbreSecteur + " secteur(s)";
		                        newDiv.append(pSecteur);
		                        var newBr = document.createElement("br");
		                        newDiv.append(newBr);
		                        
		                        divTab.append(newDiv);
		                    });
	                    } else {
	                    	divTab.innerHTML = "Aucun site ne correspond à vos critères."
	                    }
	                    
                   } catch(e) {
                   	document.getElementById("spanerror").innerText = xhr.responseText;
                   }
                  
                   
                } else {
                	// document.getElementById("spanerror").innerText = xhr.responseText;
                }
            };
       }
}

window.onload = SEARCHSITE.init();