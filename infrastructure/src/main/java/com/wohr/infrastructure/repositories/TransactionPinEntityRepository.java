package com.wohr.infrastructure.repositories;

import com.wohr.infrastructure.entites.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
