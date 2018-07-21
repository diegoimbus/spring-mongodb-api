package com.co.intrasoft.services;

import java.util.List;

import com.co.intrasoft.documents.Asset;
/**
 * Defines basic methods for a persistance service
 * @author Diego Imbus <dsn.imbus01@gmail.com>
 */
public interface AssetService {
	
	List<Asset> listAll();
	
	Asset create(Asset asset);
	
	Asset update(Asset asset);

}
