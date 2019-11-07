/* MODULE TO TOGGLE DISPONIBILITY OF TOPO */

const TOGGLETOPO = {
		checkboxes: document.querySelectorAll(".topocheck"),
		
		init: function() {
			TOGGLETOPO.checkboxes.forEach(function (checkbox) {
				checkbox.addEventListener("change", TOGGLETOPO.send);
			})
		},
		
		send: function(e) {
			e.preventDefault();
			var topoName = e.target.previousElementSibling.id;
			
			// AJAX
	        var xhr = new XMLHttpRequest();
	       
	        xhr.open('POST', 'toggletopo.html');
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	        xhr.send("topoName=" + topoName);

	        xhr.onreadystatechange = function() {
	            if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
	            	
	               // SHOW RESPONSE
	               e.target.nextElementSibling.innerText = xhr.responseText;
	               
	            } else {
	            	e.target.nextElementSibling.innerText = xhr.responseText;
	            }
	        };
		}
}

window.onload = TOGGLETOPO.init();