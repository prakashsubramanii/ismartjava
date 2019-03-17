package com.hackathon.ismart.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackathon.ismart.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{

	public List<Transaction> findByCustomerId(Long customerid);

	public List<Transaction> findFirst10ByCustomerIdOrderByDateDesc(Long customerid);
	
	@Query("SELECT t FROM Transaction t where customerId = ?1 AND (date BETWEEN ?2 AND ?3)")
    public List<Transaction> findByPeriod(Long customerId,Date startDate, Date endDate);


}
