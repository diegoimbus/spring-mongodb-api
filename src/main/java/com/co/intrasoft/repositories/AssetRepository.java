package com.co.intrasoft.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.intrasoft.documents.Asset;

public interface AssetRepository extends MongoRepository<Asset, String> {

}
