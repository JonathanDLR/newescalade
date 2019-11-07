/* MODULE TO SHOW SEARCH TAB */

const SEARCH = {
		searchBut: document.getElementById("searchBut"),
		searchBar: document.getElementById("searchBar"),
		
		init: function() {
			//ADD OR REMOVE SEARCH BAR AND ENVENT LISTENER DEPEND ON WINDOW SIZE
			if (window.matchMedia("(max-width: 813px)").matches) {
				document.getElementById("searchBar").style.display = "none";
				
				SEARCH.searchBut.addEventListener("click", SEARCH.appear);
				document.body.addEventListener("click", SEARCH.disappear, false);
				SEARCH.searchBar.addEventListener("click", function(e) {
					e.stopPropagation();
				}, true);
			} else if (window.matchMedia("(min-width: 813px)").matches) {
				document.getElementById("searchBar").style.display = "flex";
				
				SEARCH.searchBut.removeEventListener("click", SEARCH.appear);
				document.body.removeEventListener("click", SEARCH.disappear, false);
				SEARCH.searchBar.removeEventListener("click", function(e) {
					e.stopPropagation();
				}, true);
			}	
			
		},
		
		appear: function() {
			document.getElementById("searchBar").style.display = "flex";
		},
		
		disappear: function(e) {
			if (e.target.id != "searchBut") {
				SEARCH.searchBar.style.display = "none";
			}		
		}
}

window.onload = SEARCH.init();
window.onresize = SEARCH.init;