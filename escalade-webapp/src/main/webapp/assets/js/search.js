/* MODULE TO SHOW SEARCH TAB */

const SEARCH = {
		searchBut: document.getElementById("searchBut"),
		searchBar: document.getElementById("searchBar"),
		
		init: function() {
			SEARCH.searchBut.addEventListener("click", SEARCH.appear);
			document.body.addEventListener("click", SEARCH.disappear, false);
			SEARCH.searchBar.addEventListener("click", function(e) {
				e.stopPropagation();
			}, true);
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