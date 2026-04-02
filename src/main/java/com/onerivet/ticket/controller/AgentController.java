package com.onerivet.ticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.ticket.model.entity.Agent;
import com.onerivet.ticket.service.AgentService;

@RestController
@RequestMapping("/agent")
public class AgentController 
{
	private AgentService service;	
	public AgentController(AgentService service)
	{
		this.service = service;
	}
	@PostMapping
	public String addAgent(@RequestBody Agent agent)
	{
		return service.addAgent(agent);
	}

	@GetMapping
	public String getAgentList()
	{
		return "This is agent list";
	}
}
