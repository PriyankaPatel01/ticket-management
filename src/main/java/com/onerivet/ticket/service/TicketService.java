package com.onerivet.ticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onerivet.ticket.model.entity.Agent;
import com.onerivet.ticket.model.entity.Ticket;
import com.onerivet.ticket.repository.AgentRepository;
import com.onerivet.ticket.repository.TicketRepository;

@Service
public class TicketService 
{
	private TicketRepository ticketRepo;
	private AgentRepository agentRepo;
	
	public TicketService(TicketRepository ticketRepo, AgentRepository agentRepo)
	{
		this.agentRepo = agentRepo;
		this.ticketRepo = ticketRepo;
	}
	
	public String addTicket(Ticket ticket)
	{
		Agent agent  = agentRepo.findById(ticket.getAgent().getAgentId()).orElse(null);
		ticket.setAgent(agent);
		int id  = ticketRepo.save(ticket).getTicketId();
		if(id>0)
			return "Ticket added with id: " + id;
		else
			return "Could not add ticket";
	}
	
	public Ticket findById(Integer id)
	{
		return ticketRepo.findById(id).orElse(null);
	}
	
	public List<Ticket> findAll()
	{
		return ticketRepo.findAll();
	}
	
	public Ticket updateTicket(Ticket updatedTicket, Integer id)
	{
		Ticket ticket = ticketRepo.findById(id).orElse(null);
		if(ticket!=null)
		{
			ticket.setTitle(updatedTicket.getTitle());
			ticket.setDescription(updatedTicket.getDescription());
			ticket.setPriority(updatedTicket.getPriority());
			Agent agent = agentRepo.findById(updatedTicket.getAgent().getAgentId()).orElse(null);
			ticket.setAgent(agent);
			return ticketRepo.save(ticket);
		}
		else
		{
			return null;
		}
		
	}
	
	public String deleteTicket(Integer id)
	{
		if(ticketRepo.findById(id) != null)
		{
			ticketRepo.deleteById(id);
			return "Ticket deleted";
		}
		else
		{
			return "Ticket id not present in database";
		}
	}
	
	public List<Ticket> findAllTicketById(Integer id)
	{
		return ticketRepo.findAllTicketById(id);
	}
	
	
	public int countTicket(Integer id) 
	{
		return ticketRepo.countTicket(id);
	}
	
	

}
