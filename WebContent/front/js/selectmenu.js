$(function(){
			
			$('select#speedA').selectmenu();
			$('select#speedE').selectmenu();
			$('select#speedF').selectmenu();
			$('select#speedG').selectmenu();
			$('select#speedH').selectmenu();
			$('select#speedI').selectmenu();
			$('select#speedJ').selectmenu();
			$('select#speedK').selectmenu();
			$('select#speedL').selectmenu();
			$('select#speedM').selectmenu();
			$('select#speedN').selectmenu();
			$('select#speedO').selectmenu();
			$('select#speedP').selectmenu();
			$('select#speedQ').selectmenu();
			$('select#speedR').selectmenu();
			$('select#speedS').selectmenu();
			$('select#speedT').selectmenu();
			$('select#speedU').selectmenu();
			$('select#speedV').selectmenu();
			$('select#speedW').selectmenu();
			$('select#speedX').selectmenu();
			$('select#speedY').selectmenu();
			$('select#speedZ').selectmenu();
			$('select#speedA').selectmenu();
			$('select#speedAa').selectmenu({maxHeight: 150});
			
			$('select#speedB').selectmenu({
				width: 300,
				format: addressFormatting
			});
			
			$('select#speedC').selectmenu({style:'dropdown'});
			
			$('select#speedD').selectmenu({
				style:'dropdown', 
				menuWidth: 400,
				format: addressFormatting
			});
			
			$('select#files, select#filesC').selectmenu({
				icons: [
					{find: '.script', icon: 'ui-icon-script'},
					{find: '.image', icon: 'ui-icon-image'}
				]
			});
			
			$('select#filesB').selectmenu({
				icons: [
					{find: '.video'},
					{find: '.podcast'},
					{find: '.rss'}
				]
			});
			
			
		});
		
		
		//a custom format option callback
		var addressFormatting = function(text){
			var newText = text;
			//array of find replaces
			var findreps = [
				{find:/^([^\-]+) \- /g, rep: '<span class="ui-selectmenu-item-header">$1</span>'},
				{find:/([^\|><]+) \| /g, rep: '<span class="ui-selectmenu-item-content">$1</span>'},
				{find:/([^\|><\(\)]+) (\()/g, rep: '<span class="ui-selectmenu-item-content">$1</span>$2'},
				{find:/([^\|><\(\)]+)$/g, rep: '<span class="ui-selectmenu-item-content">$1</span>'},
				{find:/(\([^\|><]+\))$/g, rep: '<span class="ui-selectmenu-item-footer">$1</span>'}
			];
			
			for(var i in findreps){
				newText = newText.replace(findreps[i].find, findreps[i].rep);
			}
			return newText;
		}