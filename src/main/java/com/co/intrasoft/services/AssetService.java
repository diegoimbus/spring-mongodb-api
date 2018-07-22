package com.co.intrasoft.services;

import java.util.List;

import com.co.intrasoft.documents.Asset;
/**
 * Defines basic methods for a persistance service in this API
 * 
 * @author Diego Imbus <dsn.imbus01@gmail.com>
 */
public interface AssetService {
	
	/**
	 * This method show all the documents in the database
	 * 
	 * @return Returns all elements in the database
	 */
	List<Asset> listAll();
	
	/**
	 * This method save a new asset in the database
	 * 
	 * @param New asset to save in the database.
	 * @return Returns the object created 
	 */
	Asset create(Asset asset);
	
	/**
	 * This method update an element of the database  
	 * 
	 * @param asset Asset to be updated.
	 * @return Returns the object updated
	 */
	Asset update(Asset asset, String value);

}
