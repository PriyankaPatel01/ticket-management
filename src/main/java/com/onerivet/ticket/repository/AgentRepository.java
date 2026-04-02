package com.onerivet.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onerivet.ticket.model.entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer>
{
	

}
