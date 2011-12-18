jQuery(document).ready(function(){
	$(".kasten_extended").hide();
	
	 $('.chart_extend').click(function(){
		$(this).toggleClass("chart_extend_active").parent().next('.kasten_extended').slideToggle('normal');
	 });
	 
	 $('#iuser').focus(function() {
  		$(this).select();
	 });
	 
	 $('#ipass').focus(function() {
  		$(this).select();
	 });
	 
	 $('#isenter').focus(function() {
  		$(this).select();
	 });
	 
	  var triggers = jQuery(".modalInput").overlay({
		mask: {
			color: '#113d2b',
			loadSpeed: 200,
			opacity:0.7
		},
		closeOnClick: true
	});

});