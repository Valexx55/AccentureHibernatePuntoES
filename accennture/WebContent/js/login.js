
function enviarLogin (user, pass)
{
	
	var datos_usuario = {
		    nombre:user,
		    pwd:pass 
		};
	
	//TODO Opción de estudiar una sóla función parametrizada que a su vez use jQuery
	//EJEMPLO DE PETICIÓN CON POST

	var datos_str = JSON.stringify(datos_usuario);
	
	$.ajax({
		
        data:  datos_str,
        url:   urlProperties ('../login'),
        contentType: 'application/json',
        type:  'post',
        success:  function (response) {
                        respuesta (response);
                },
        error: function (request, status, errorc) {
	        location='../html/error.html';
	    		}
});
	
}


function validarFormLogin ()
{
	
	
	var usuario = $("#usuario").val();
	var pwd = $("#contrasenia").val();
	
	var patron = new RegExp(EXPRESION_REGULAR_USUARIO_MAIL);//al menos 6 números o letras o guiones
	
	var usuario_val = patron.test(usuario);
	var contrasenia_val = patron.test(pwd);
	
	if ((usuario_val))
		{
		console.log ("USUARIO OK");
		if (!contrasenia_val)
			{
			console.log ("PASSWORD KO");
			$("p").remove();
			var myNewElement = $( "<p>Clave de al menos 6 caracteres (entre letras, numeros y guiones) </p>" );
			myNewElement.insertAfter($("#boton_ir"));
			
			
			} else 
					{ 
						$("p").remove(); 
						console.log ("USER Y PASSWORD OK");
						enviarLogin(usuario, pwd);
					}
		}
	else 
		{
		
		console.log ("USUARIO KO");
		$("p").remove();
		var myNewElement = $( "<p>Nombre de al menos 6 caracteres. (entre letras, numeros y/o guiones) </p>" );
		myNewElement.insertAfter($("#boton_ir"));
		
		}
}