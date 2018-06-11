var displayedImage = document.querySelector('.displayed-img');
/*'#displayed-img-1'*/
var thumbBar = document.querySelector('.thumb-bar');

btn = document.querySelector('button');
var overlay = document.querySelector('.overlay');


/* Looping through images */

   for(i = 1; i <= 5; i++){
	  var newImage = document.createElement('img');
	  var path='images/pic'+i+'.jpg';
	  newImage.setAttribute('src', path);
	  thumbBar.appendChild(newImage);
	  newImage.onclick = function(e) {
	  var srcvalue = e.target.getAttribute('src');
	  showImage(srcvalue);
  }
}

function showImage(srcvalue) {
	displayedImage.setAttribute('src',srcvalue);
}
   
/* Wiring up the Darken/Lighten button */

	btn.onclick = function() {
	var btncolor = btn.getAttribute('class');
	if ( btncolor === 'dark'){
		btn.setAttribute('class','light');
		btn.textContent = 'Lighten';
		overlay.style.backgroundColor = 'rgba(0,0,0,0.5)';
	}
	else{
		btn.setAttribute('class', 'dark');
		btn.textContent = 'Darken';
		overlay.style.backgroundColor = 'rgba(0,0,0,0)';
	}
}	