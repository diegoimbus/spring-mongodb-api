package com.co.intrasoft.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.intrasoft.services.AssetService;
import com.co.intrasoft.documents.Asset;
import com.co.intrasoft.responses.Response;

@RestController
@RequestMapping(path ="/api/assets")
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	@GetMapping
	public ResponseEntity<Response<List<Asset>>> listAll() {
		return ResponseEntity.ok(new Response<List<Asset>>(this.assetService.listAll()));
	}
	
	@PostMapping
	public ResponseEntity<Response<Asset>> create(@Valid @RequestBody Asset asset, BindingResult result) {
		if (result.hasErrors() ) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Asset>(errors));
		}
		
		return ResponseEntity.ok(new Response<Asset>(this.assetService.create(asset)));
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Response<Asset>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Asset asset, BindingResult result) {
		if (result.hasErrors() ) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Asset>(errors));
		}
		
		asset.setId(id);
		return ResponseEntity.ok(new Response<Asset>(this.assetService.update(asset)));
	}
	
}
