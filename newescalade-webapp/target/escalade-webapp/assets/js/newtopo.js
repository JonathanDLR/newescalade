/* MODULE TO VALIDATE NEW TOPO FORM */

const NEWTOPO = {
	submit: document.getElementById("topoSubmit"),
	
	init: function() {
		NEWTOPO.submit.addEventListener("click", NEWTOPO.check);
	},
	
	check: function(e) {
		const name = document.getElementById("name");
		const description = document.getElementById("description");
		const dateParution = document.getElementById("dateParution");
		
		if (name.value == "") {
			e.preventDefault();
			name.nextElementSibling.innerText = "Veuillez renseigner le nom du topo.";
		} 
		if (description.value == "") {
			e.preventDefault();
			description.nextElementSibling.innerText = "Veuillez renseigner la description du topo.";
		} 
		if (dateParution.value == "") {
			e.preventDefault();
			dateParution.nextElementSibling.innerText = "Veuillez renseigner la date de parution.";
		}
	}
}

window.onload = NEWTOPO.init();