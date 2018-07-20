package com.co.intrasoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.intrasoft.documents.Asset;
import com.co.intrasoft.repositories.AssetRepository;
import com.co.intrasoft.services.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public List<Asset> listAll() {
		return this.assetRepository.findAll();
	}

	@Override
	public Asset create(Asset asset) {
		return this.assetRepository.save(asset);
	}

	@Override
	public Asset update(Asset asset) {
		return this.assetRepository.save(asset);
	}

}
