package com.bancopichincha.api.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancopichincha.api.model.Client;
import com.bancopichincha.api.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientRest {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping 
	private ResponseEntity<List<Client>> getAllClients(){
		return ResponseEntity.ok(clientService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Client> saveClient (@RequestBody Client client){
		try {
			Client savedClient = clientService.save(client);		
		return ResponseEntity.created(new URI("/client/"+savedClient.getId())).body(savedClient);
		} catch (Exception e) {
			System.out.println("Error " + e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
