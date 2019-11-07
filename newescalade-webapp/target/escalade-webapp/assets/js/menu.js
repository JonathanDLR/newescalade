MENU = {
	init: function() {
		document.getElementById("DIVaccount").addEventListener("mouseover", MENU.show);
		document.getElementById("DIVaccdeco").addEventListener("mouseleave", MENU.hide);
	},
	
	show: function() {
		document.getElementById("DIVaccsite").style.display = "flex";
		document.getElementById("DIVdeco").style.display = "flex";
	},
	
	hide: function() {
		document.getElementById("DIVaccsite").style.display = "none";
		document.getElementById("DIVdeco").style.display = "none";
	}
}

window.onload = MENU.init();