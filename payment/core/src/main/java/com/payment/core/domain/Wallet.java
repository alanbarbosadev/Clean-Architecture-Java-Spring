package com.payment.core.domain;

import com.payment.core.domain.enums.UserType;
import com.payment.core.exception.TransferException;
import com.payment.core.exception.enums.ErrorCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {
    private Long id;
    private User user;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, User user, BigDecimal balance, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(User user, BigDecimal balance) {
        this.user = user;
        this.balance = balance;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getUserType() == UserType.SHOPKEEPER) throw new TransferException(ErrorCode.TR0001.getMessage(), ErrorCode.TR0001.getCode());

        if (this.balance.compareTo(value) < 0) throw new TransferException(ErrorCode.TR0002.getMessage(), ErrorCode.TR0002.getCode());

        this.balance = this.balance.subtract(value);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Wallet(Long id, User user, BigDecimal balance, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.createdAt = createdAt;
    }
}
