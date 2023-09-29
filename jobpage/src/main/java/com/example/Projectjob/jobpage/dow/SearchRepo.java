package com.example.Projectjob.jobpage.dow;

import java.util.List;

import com.example.Projectjob.jobpage.model.Post;


public interface SearchRepo {
	List<Post>findBytext(String string);

}
