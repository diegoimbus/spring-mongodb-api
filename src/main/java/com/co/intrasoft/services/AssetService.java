package com.co.intrasoft.services;

import java.util.List;

import com.co.intrasoft.documents.Asset;

public interface AssetService {
	
	List<Asset> listAll();
	
	Asset create(Asset asset);
	
	Asset update(Asset asset);

}
