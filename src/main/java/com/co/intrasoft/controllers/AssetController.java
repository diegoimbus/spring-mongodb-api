package com.co.intrasoft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.intrasoft.services.AssetService;
import com.co.intrasoft.documents.Asset;

@RestController
@RequestMapping(path ="/api/assets")
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	@GetMapping
	public ResponseEntity<List<Asset>> listAll() {
		return ResponseEntity.ok(this.assetService.listAll());
	}
	
	@PostMapping
	public ResponseEntity<Asset> create(@RequestBody Asset asset) {
		return ResponseEntity.ok(this.assetService.create(asset));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Asset> update(@PathVariable(name = "id") String id, @RequestBody Asset asset) {
		asset.setId(id);
		return ResponseEntity.ok(this.assetService.update(asset));
	}
	
}
