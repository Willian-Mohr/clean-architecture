package com.wohr.infrastructure.repositories;

import com.wohr.infrastructure.entites.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}