package com.onerivet.ticket.service;

import org.springframework.stereotype.Service;

import com.onerivet.ticket.model.entity.Agent;
import com.onerivet.ticket.repository.AgentRepository;

@Service
public class AgentService 
{
	private AgentRepository repo;
	
	public AgentService( AgentRepository repo)
	{
		this.repo = repo;
	}
	
	public String addAgent(Agent agent)
	{
		int id =  repo.save(agent).getAgentId();
		if(id>0)
			return "Agent Information saved with id: " + id;
		else
			return "Could not save Agent Information";
	}
	
	

}
