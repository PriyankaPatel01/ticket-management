package com.onerivet.ticket.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agentId;
	private String agentName;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	@JsonIgnore
	private List<Ticket> tickets;
	
	public Agent(int agentId)
	{
		this.agentId = agentId;
	}
	
}







