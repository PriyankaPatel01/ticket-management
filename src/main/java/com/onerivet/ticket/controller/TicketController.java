package com.onerivet.ticket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.ticket.model.entity.Ticket;
import com.onerivet.ticket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController 
{
	private TicketService service;
	
	public TicketController(TicketService service)
	{
		this.service = service;
	}
	
	@PostMapping
	public String addTicket(@RequestBody Ticket ticket)
	{
		return service.addTicket(ticket);
	}
	
	@GetMapping("/{id}")
	public Ticket findById(@PathVariable Integer id)
	{
		return service.findById(id);
	}
	
	@GetMapping("/view-all")
	public List<Ticket> findAll()
	{
		return service.findAll();
	}
	
	@PutMapping("/{id}")
	public Ticket updateTicket(@PathVariable Integer id, @RequestBody Ticket ticket)
	{
		return service.updateTicket(ticket, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTicket(@PathVariable Integer id)
	{
		return service.deleteTicket(id);
	}
	
	@GetMapping("/all-tickets/{id}")
	public List<Ticket> findAllTicketById(@PathVariable Integer id)
	{
		return service.findAllTicketById(id);
	}
	
	@GetMapping("/count-tickets/{id}")
	public int countTicket(@PathVariable Integer id)
	{
		return service.countTicket(id);
	}
}
