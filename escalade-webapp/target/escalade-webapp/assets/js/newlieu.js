/* MODULE TO CREATE A NEW LIEU */

const NEWLIEU = {
		init: function() {
	        document.getElementById("subnewlieu").addEventListener("click", NEWLIEU.create);
	    },

	    create: function(e) {
	    	e.preventDefault();
	    	
	        const selectLieu =  document.getElementById("selectlieu");
	        const newLieu = document.getElementById("newlieu").value;
	        const newLieuError = document.getElementById("newlieuerror");

	        if (newLieu == "") {
	            newLieuError.innerText = "Renseigner un lieu";
	        } else {
	             // AJAX
	             var xhr = new XMLHttpRequest();
	            
	             xhr.open('POST', 'newlieu.html');
	             xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	             xhr.send("newlieu=" + newLieu);
	 
	             xhr.onreadystatechange = function() {
	                 if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
	                    document.getElementById("newlieu").value == "";
	                    document.getElementById("newlieuerror").value == "";
	                    
	                    // RECONSTRUCT SELECT ITEM WITH RESPONSE
	                    selectLieu.innerHTML = "";
	                    var arrayLieu = JSON.parse(xhr.response);                  

	                    arrayLieu.forEach(function (item) {
	                        var newOption = document.createElement("option");
	                        selectLieu.append(newOption);
	                        newOption.setAttribute("value", item.id);	                        
	                        newOption.innerHTML = item.name;
	                    });
	                    
	                 } else {
	                    document.getElementById("newlieu").value == "";
	                    document.getElementById("newlieuerror").value == "";
	                 }
	             };
	        }
	    }	
}

window.onload = NEWLIEU.init();