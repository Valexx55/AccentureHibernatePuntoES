function enviarEmail (correo)
{
	
	var datos_usuario = {
		    mail: correo
		};
	
	//TODO Opción de estudiar una sóla función parametrizada que a su vez use jQuery
	//TODO ¿que el mensaje del servidor devuelva el nombre de la función a ejecutar?¿?¿
	//EJEMPLO DE PETICIÓN CON POST

	var datos_str = JSON.stringify(datos_usuario);
	
	$.ajax({
        data:  datos_str,
        url:   urlProperties ('../olvido'),
        contentType: 'application/json',
        type:  'post',
        success:  function (response) {
                        respuesta (response);
                },
        error: function (request, status, errorc) {
    	   			location='../html/error.html';
    	    }
});
	
	//EJEMPLO DE PETICIÓN CON GET /*'../loginget?idioma=es',*/
	//dejamos este eejmplo, pero se usará post
/*
	$.ajax({
        data:  datos_usuario,
        url:   urlProperties ('../loginget'), 
        contentType: 'application/json',
        type:  'get',
        success:  function (response) {
                        respuesta (response);
                }
	});*/
}



function validarEmail ()
{
	
	
	//alert (jQuery("#usuario").val());
	//jQuery("#usuario").val();
	
	var correo = $("#email").val();
	
	//var patron = new RegExp(/^\w{6,}$/);//al menos 6 números o letras o guiones
	
	var patron = new RegExp(EXPRESION_REGULAR_EMAIL);//al menos 6 números o letras o guiones
	var correo_val = patron.test(correo);
	
	if (correo_val)
		{
			console.log ("CORREO OK");
			enviarEmail(correo);
					
		}
	else 
		{
		
		console.log ("CORREO KO");
		$("p").remove();
		var myNewElement = $( "<p>Introduzca un email correcto </p>" );
		myNewElement.insertAfter($("#boton_ir"));
		
		}
}