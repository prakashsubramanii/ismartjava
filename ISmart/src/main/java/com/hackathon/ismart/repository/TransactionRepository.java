package com.hackathon.ismart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hackathon.ismart.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{

	public List<Transaction> findByCustomerId(Long customerid);

	public List<Transaction> findFirst10ByCustomerIdOrderByDateDesc(Long customerid);

}
