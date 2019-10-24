/* MODULE FOR CREATING NEW RESERVATION */

const NEWRESA = {
	submits: document.querySelectorAll("button"),
	conf: document.getElementById("newResaConf"),
	
	init: function() {
		NEWRESA.submits.forEach(function (submit) {
			submit.addEventListener("click", NEWRESA.send);
		});		
	},
	
	send: function(e) {
		e.preventDefault();
		var newResa = e.target.id;
		
		// AJAX
        var xhr = new XMLHttpRequest();
       
        xhr.open('POST', 'topos.html');
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("newResa=" + newResa);

        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
               // RECONSTRUCT THE LIST
            	var divToDelete = e.target.parentNode;
            	divToDelete.parentNode.removeChild(divToDelete);
            	
               // SHOW RESPONSE
               NEWRESA.conf.innerText = xhr.responseText;
               
            } else {
            	// NEWRESA.conf.innerText = "Erreur";
            }
        };
	}	
}

window.onload = NEWRESA.init();