package com.co.intrasoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.co.intrasoft.documents.Asset;
import com.co.intrasoft.repositories.AssetRepository;
import com.co.intrasoft.services.AssetService;


/**
 * Implements from {@link AssetService}}
 * @author Diego Imbus <dsn.imbus01@gmail.com>
 *
 */
@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	private AssetRepository assetRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Asset> listAll() {
		return this.assetRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Asset create(Asset asset) {
		return this.assetRepository.save(asset);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Asset update(Asset asset, String sr) {
		
		Query query = new Query(Criteria.where("id").is(asset.getId()));
		Update update = new Update();
		update.set("serial", sr);
		mongoTemplate.updateFirst(query, update, Asset.class);
		
		return this.assetRepository.findOne(asset.getId());
	}

}
