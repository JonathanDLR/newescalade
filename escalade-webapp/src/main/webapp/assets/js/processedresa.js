/* MODULE TO PROCESS RESA */

const PROCESSEDRESA = {
		submits: document.querySelectorAll(".submitresa"),
		
		init: function() {
			PROCESSEDRESA.submits.forEach(function (submit) {
				submit.addEventListener("click", PROCESSEDRESA.send);
			});
		},
		
		send: function(e) {
			e.preventDefault();
			var procResa = e.target.id;
			var procTopo = e.target.getAttribute("data-topo");
			
			console.log(procTopo);
			
			// AJAX
	        var xhr = new XMLHttpRequest();
	       
	        xhr.open('POST', 'procresa.html');
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	        xhr.send("procResa=" + procResa + "&procTopo=" + procTopo);

	        xhr.onreadystatechange = function() {
	            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
	            	// DELETE THE RESA
	            	var divToDelete = e.target.parentElement;
	            	divToDelete.parentElement.removeChild(divToDelete);
	            	
	            	// UNCHECK TOPO IN LIST
	            	document.getElementById(procTopo).nextElementSibling.removeAttribute("checked");
	            	
	               // SHOW RESPONSE
	               document.getElementById("resarep").innerText = xhr.responseText;
	               
	            } else {
	            	// NEWRESA.conf.innerText = "Erreur";
	            }
	        };
		}	
}

window.onload = PROCESSEDRESA.init();