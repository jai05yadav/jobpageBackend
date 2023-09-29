package com.example.Projectjob.jobpage.dow;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Projectjob.jobpage.model.Post;

public interface PostRepo extends MongoRepository<Post,String> {

}
