package com.onerivet.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onerivet.ticket.model.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> 
{
	@Query("""
			select t from Ticket t where  t.agent.id=:id
			""")
	public List<Ticket> findAllTicketById(@Param("id") Integer id);
	
	@Query("""
			select count(t.id) from Ticket t where t.agent.id = :id
			""")
	public int countTicket(@Param("id") Integer id);

}
