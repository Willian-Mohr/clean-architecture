package com.wohr.infrastructure.repositories;

import com.wohr.infrastructure.entites.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}