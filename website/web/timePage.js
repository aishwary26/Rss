var time=1;

function timeHere() {
  time = time + 1;
  finalTime = time / 10;
/* Remove the "//" below to display in the title bar
  the amount of time the visitor has been on the site.
  Be aware though, that it does tend to be a bit distracting. */
 document.title = finalTime+" seconds you been here for!";
 function sayTime() {
	  finalTime = time / 10;
	  alert("Thank you for coming to my site! \n You have been here " + finalTime + " seconds!");
	}

}
