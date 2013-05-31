var FillDatalist = function(rawTags, inputFieldId, dataListId){
	var rawTags = rawTags;
	var inputFieldId = inputFieldId;
	var inputField = document.getElementById(inputFieldId);
	var initInputFieldValue = inputField.value;
	var dataList = document.getElementById(dataListId);
	var initNbVirgules = (initInputFieldValue.match(/,/g)||[]).length;
	
	var fillDatalist = function (prefix) {
		var nbRawList = rawTags.length;
		var usedTag = prefix.split(", ")
		// vide la liste initiale (pas utile si elle est vide au début) // FIXME
		while(dataList.childNodes.length > 0) {
			dataList.removeChild(dataList.childNodes[0]);
		}
		// la recréé avec les tags de l’array
		for (i=0; i < nbRawList; i++ ) {
			if (usedTag.indexOf(rawTags[i])==-1){
				var nOpt = document.createElement("option");
				nOpt.value = prefix+rawTags[i];
				dataList.appendChild(nOpt);
			}
		}
	}
	
	var mainLoop = function () {
		var currInputFieldValue = inputField.value;
		var currInputFieldValueTrimed = inputField.value.replace(/^\s+|\s+$/g, "");
		var currNbVirgules = (currInputFieldValue.match(/,/g)||[]).length;
	
		// renouvelle les "option" uniquement si le contenu de l’input à changé.
		if (currInputFieldValueTrimed != initInputFieldValue) {
			// renouvelle que si on a tout juste ajouté ou retiré une virgule depuis le dernier passage.
			if (initNbVirgules != currNbVirgules) {
				// récupère l’emplacement de la dernière virgule
				var lsIndex = currInputFieldValueTrimed.lastIndexOf(",");
				// récupère la chaine contenant jusqu’au dernier tag entier dans le contenu du champ
				var str = (lsIndex != -1) ? currInputFieldValueTrimed.substr(0, lsIndex)+", " : "";
				fillDatalist(str);
				initNbVirgules = currNbVirgules;
			}
			initInputFieldValue = currInputFieldValueTrimed;
		}
		//setTimeout(mainLoop, 100); // la fonction se redéclenchera dans 0,1s
		return true;
	}
	
	fillDatalist("");
	setInterval(mainLoop, 100);
}
