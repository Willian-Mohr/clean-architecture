package com.wohr.infrastructure.entites;

import com.wohr.core.domain.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fromWallet")
    private WalletEntity fromWallet;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWallet;

    @Column(name = "TransactionValue", nullable = false)
    private BigDecimal value;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    public TransactionEntity(WalletEntity fromWallet, WalletEntity toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}