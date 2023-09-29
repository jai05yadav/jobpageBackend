package com.example.Projectjob.jobpage.dow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.Projectjob.jobpage.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@Component
public class SearchRepositoryimpl implements SearchRepo{
	@Autowired
	MongoClient mongoclient;
	@Autowired
	MongoConverter converter;
	@Override
	public List<Post> findBytext(String string) {
		// TODO Auto-generated method stub
		final List<Post>post = new ArrayList<>();
		
			MongoDatabase database = mongoclient.getDatabase("jobs");
			MongoCollection<Document> collection = database.getCollection("Jobpost");
			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("text", 
			    new Document("query", string)
			    .append("path",Arrays.asList ("techs","desc","profile")))), 
			    new Document("$sort", 
			    	    new Document("exp", 1L)), 
			    	    new Document("$limit", 5L)));
			result.forEach(doc -> post.add(converter.read(Post.class, doc)));

		return post;
	}

}
