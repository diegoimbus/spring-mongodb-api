package com.co.intrasoft.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.intrasoft.documents.Asset;
/**
 * Interface to work with the domain of the API
 * using MongoDb
 * <p>
 * The domain type of the repository is {@link Asset}
 * and the ID is String
 * <p>
 * Extends of {@link MongoRepository}
 * 
 * @author Diego Imbus <dsn.imbus01@gmai.com>
 *
 */
public interface AssetRepository extends MongoRepository<Asset, String> {
	
}
