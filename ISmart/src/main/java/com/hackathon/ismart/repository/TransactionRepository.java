package com.hackathon.ismart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.ismart.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Long, Transaction>{

}
