package com.example.PutJson;

// En estas líneas, estamos importando las clases necesarias de Spring Boot para ejecutar la aplicación y enviar una solicitud HTTP.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.*;
import org.springframework.web.client.*;

@SpringBootApplication
public class PutJsonApplication {

	public static void main(String[] args)
	{


		// Ejecuta una aplicación Spring Boot. Se asume que PutJsonApplication es la clase principal que inicia la aplicación.
		SpringApplication.run(PutJsonApplication.class, args);

		// Crea una instancia de RestTemplate, que es una clase proporcionada por Spring que se utiliza para hacer solicitudes HTTP a un servidor.
		RestTemplate restTemplate = new RestTemplate();

		// Establece la URL de la API RESTful que se desea consumir.
		// En este caso, se especifica que se desea actualizar la entrada de blog con el id 1.
		String url = "https://jsonplaceholder.typicode.com/posts/1";

		//Crea una instancia de HttpHeaders, que es una clase que representa el encabezado de una solicitud HTTP.
		// Se utiliza para establecer los encabezados de la solicitud HTTP.
		HttpHeaders headers = new HttpHeaders();

		// Establece el tipo de contenido de la solicitud HTTP como JSON.
		// Esto se utiliza para informar al servidor que se está enviando una carga útil JSON en el cuerpo de la solicitud.
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Crea una carga útil JSON que se utilizará en el cuerpo de la solicitud PUT.
		// En este caso, se actualiza la entrada de blog con el título y el cuerpo actualizados.
		String requestBody = "{\"id\": 1, \"title\": \"Updated Title\", \"body\": \"Updated Body\", \"userId\": 1}";

		// Crea una instancia de HttpEntity que contiene la carga útil JSON y los encabezados de la solicitud HTTP.
		// Esta instancia se utiliza para enviar la solicitud PUT al servidor.
		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
            //captura la informacion de las cabeceras
		// Realiza una solicitud PUT al servidor especificado en la URL con la carga útil JSON y los encabezados especificados.
		// La respuesta del servidor se almacena en una instancia de ResponseEntity.
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
         //muestre la respuesta de lo almacenado en el sevidor
		// Imprime el código de estado de la respuesta HTTP recibida desde el servidor.
		System.out.println("Response status code: " + response.getStatusCode());
         //muestra la respuesta si es errror 401 0 200
		// Imprime el cuerpo de la respuesta HTTP recibida desde el servidor.
		// En este caso, debería ser la entrada de blog actualizada en formato JSON.
		System.out.println("Response body: " + response.getBody());
	}

}
