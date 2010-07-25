//Master Javascript file
//version:   4.0
//author:    Paul Boag
//email:     paul.boag@headscape.co.uk
//website:   http://www.headscape.co.uk


// Loads up the various functions we are going to use
$(document).ready(function(){
	csLinks("#csMenu a");
	tooltips();
	jsEnabled();
	popup('a[rel]');
	tagCorners();
	formCorners();
	newwindow();
	validateForm("#tfa_Name");
	validateForm("#tfa_Email");
	validateForm("#tfa_Organisation");
	validateForm("#tfa_Howcanwehelp");
});

// Adds a class to the body so I can style differently depending on whether Javascript is enabled.
function jsEnabled() {
	$("body").addClass("jsenabled");	
}

// Swaps the case studies in and out
function csLinks(linkLoc) {
$(linkLoc).click(function(){
	clickFire(this);
	return false;
});
};

function clickFire(h) {
	jQuery(document).trigger('close.facebox');
	var addr = (h.href + " #caseStudies > *");
	$(".current").removeClass("current");
	$("#caseStudies").wrapInner("<span id='caseInner'></span>");
	$("#caseInner").fadeOut(300, function() {
		$("#caseStudies").load(addr, function() {
			$("#caseInner").hide();
			$("#caseInner").fadeIn(300);
			tooltips();
			popup('#caseStudies a[rel]');
			tagCorners();
		});				
	});
	h.parentNode.className = "current";
};

//Displays the tooltips on the case study tags
function tooltips() {
$("#caseStudies dt").toggle(
		function() {
		var descr = $(this).next().text();
		$("#caseStudies dt div").animate({ "bottom": "1em", "opacity": 0 }, 500,  function() {
		$(this).remove();
		});
		$(this).append("<div><span class='messageTR'><span class='messageTL'>" + descr + "</span></span><span class='messageBR'><span class='messageBL'><img src='/images/arrow.gif' /></span></span></div>");
		var theWidth = (($(this).width()/2) - ($("#caseStudies dt div").width()/2));
		if (($("#caseStudies dt div").width()/2) > ($("#caseStudies dt div").offset().left)) {
			$(".messageBL img").addClass("arrowPos");	
		}
		else {
			$("#caseStudies dt div").css({ left: theWidth + "px" });	
		}
		$(this).children("div").animate({ "bottom": "2em", "opacity": 1 }, 500,  function() {		
		});
		},
		function() {
		$("#caseStudies dt div").animate({ "bottom": "1em", "opacity": 0 }, 500,  function() {
		$(this).remove();
		});
		}
	);


};

//Manages all of the popup windows using facebox
function popup(Elem) {
	$(Elem).click(function(){
			var theUrl = this.href.split("#")
			var addr = (theUrl[0] + " #" + theUrl[1] + " > *");
			if (this.rel == "screenshot") {
				var c = $("<div id='" + theUrl[1] + "'><div  style='text-align:center;'><img src='/facebox/loading.gif' /></div></div>");
			};
			if (this.rel == "allClients") {
				var c = $("<div id='allClients'><div  style='text-align:center;'><img src='/facebox/loading.gif' /></div></div>");
			};
			if (this.rel == "cv") {
				var c = $("<div class='cv'><div  style='text-align:center;'><img src='/facebox/loading.gif' /></div></div>");
			};
			if (this.rel == "clients") {
				var c = $("<div id='clientList'><div  style='text-align:center;'><img src='/facebox/loading.gif' /></div></div>");
			};
			if (this.rel == "service") {
				var c = $("<div class='services'><div  style='text-align:center;'><img src='/facebox/loading.gif' /></div></div>");
			};
			$(c).load(addr, function(){
				jQuery.facebox(c);
				csLinks("#facebox li a");
			});
			return false;
	});
};


//Creates the curved corners on the tags
function tagCorners() {
	$("#caseStudies dt").wrapInner('<span class="TR"><span class="BL"><span class="BR"></span></span></span>');
};

//Creates the curved corners on form elements
function formCorners() {
	$("input, textarea").wrap('<span class="TL"><span class="TR"><span class="BL"><span class="BR"></span></span></span></span>');
};

//Opens links to email subscription in a new window 

function newwindow() {
	$(".email a").click(function(){
			window.open (this.href, "mywindow","resizable=1,width=550,height=450"); 	
			return false;
	});
};

//Validates the contact us form

function validateForm(i) {
	$(i + "L").append(" <em>(This is a required field)</em>");
	$(i + "L em").hide();
	$("#id2342994").submit(function() {
		$(i + "L em").fadeOut();
		if ($(i).val() == "") { 
		$(i + "L em").fadeIn();
		return false; 
		}						   
	});
};