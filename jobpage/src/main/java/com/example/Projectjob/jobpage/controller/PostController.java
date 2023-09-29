package com.example.Projectjob.jobpage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Projectjob.jobpage.dow.PostRepo;
import com.example.Projectjob.jobpage.dow.SearchRepo;
import com.example.Projectjob.jobpage.model.Post;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	//redirect to swagger page
	@Autowired
	PostRepo repo;
	@Autowired
	SearchRepo searchrepo;
	
	@Hidden
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response)throws IOException
	{
		response.sendRedirect("/swagger-ui.html");
	}
	@GetMapping(path="/allPosts")
	  @CrossOrigin
	public List<Post>getAllPost()
	{
		return repo.findAll();
		
	}
	@GetMapping(path="/posts/{text}")
	  @CrossOrigin
	public List<Post>searchpost(@PathVariable String text )
	{
		return searchrepo.findBytext(text);
		
	}
	
	
	
	@PostMapping("/post")
	  @CrossOrigin
	public Post addpost(@RequestBody Post post)
	{
		return repo.save(post);
		
	}

}
