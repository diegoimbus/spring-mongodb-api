package com.co.intrasoft.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.intrasoft.services.AssetService;
import com.co.intrasoft.documents.Asset;
import com.co.intrasoft.documents.Assignment;
import com.co.intrasoft.responses.Response;
import com.co.intrasoft.parsers.DateParser;
/**
 * Controller class of the Spring project, make the HTTP requests 
 * and validations of the data
 * 
 * @author <a href="mailto:dsn.imbus01.gmail.com">Diego Imbus</a>
 */
@RestController
@RequestMapping(path ="/api/assets")
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	/**
	 * Method to make a GET request to show all the data in storage
	 * 
	 * @return Returns a List with all the data
	 */
	@GetMapping
	public ResponseEntity<Response<List<Asset>>> listAll() {
		return ResponseEntity.ok(new Response<List<Asset>>(this.assetService.listAll()));
	}
	
	/**
	 * Method to make a POST request to save data in storage
	 * <p>
	 * When an error happens it shows its default message,
	 * and here validate the Dates and the states of the 
	 * assignment
	 * 
	 * @param asset Data to be saved.
	 * @param result Argument to validate method.
	 * @return Returns a confirmation or an error message about the request
	 */
	@PostMapping
	public ResponseEntity<Response<Asset>> create(@Valid @RequestBody Asset asset, BindingResult result) {
		
		DateParser dp = new DateParser();
		
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new Response<Asset>(erros));
		}
		
		if(dp.parseDate(asset.getpDate()).after(dp.parseDate(asset.getdDate()))) 
			return ResponseEntity.badRequest().body(new Response(""));
		
		if(asset.getAssignment().getState() == Assignment.ACTIVO || 
				asset.getAssignment().getState() == Assignment.ASIGNADO || 
				asset.getAssignment().getState() == Assignment.DADO_DE_BAJA ||
				asset.getAssignment().getState() == Assignment.DISPONIBLE ||
				asset.getAssignment().getState() == Assignment.EN_REPARACION) 
			return ResponseEntity.ok(new Response<Asset>(this.assetService.create(asset)));
		
		else 
			return ResponseEntity.badRequest().body(new Response(""));
		
	}
	
	/**
	 * Method to make a PATCH request to update an object in storage
	 * <p>
	 * Validates if there is an error and show its default message
	 * 
	 * @param id ID of the object to update.
	 * @param asset Object to update.
	 * @param result Argument to validate method.
	 * @return Returns a confirmation or an error message about the request
	 */
	@PatchMapping(path = "/updateSerial/{id}")
	public ResponseEntity<Response<Asset>> update(@PathVariable(name = "id") String id, @RequestBody Asset asset, BindingResult result) {
		if (result.hasErrors() ) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new Response<Asset>(errors));
		}
		
		asset.setId(id);

		return ResponseEntity.ok(new Response<Asset>(this.assetService.update(asset, asset.getSerial())));
	}
	
}
