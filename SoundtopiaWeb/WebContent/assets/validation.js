jQuery(document)
		.ready(
				function() {

					$("#validRegistrationForm")
							.validate(
									{
										rules : {
											passwordR : {
												required : true,
												minlength : "6"
											},
											checkR : {
												required : true,
												equalTo : "#passwordR"
											},
											emailR : {
												required : true,
												email : true
											},
										},
										messages : {
											passwordR : {
												required : "Bitte f&uuml;llen Sie dieses Feld aus.",
												minlength : "Ihr Kennwort muss mindestens 6 Zeichen lang sein."
											},
											checkR : {
												required : "Bitte f&uuml;llen Sie dieses Feld aus.",
												equalTo : "Dieses Kennwort stimmt nicht mit Ihrem &uuml;berein."
											},
											emailR : {
												required : "Bitte f&uuml;llen Sie dieses Feld aus.",
												email : "Bitte geben Sie eine g&uuml;ltige Emailadresse an."
											},
										},
										errorPlacement : function(error,
												element) {
											error.appendTo(element.parent("td")
													.next("td"));
										},
										success : "valid"
									});

				});