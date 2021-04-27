package com.example.kotlinSpring.dataSource.mock

import com.example.kotlinSpring.dataSource.BankDataSource
import com.example.kotlinSpring.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource{

    val banks = listOf(
        Bank("1234", 1.0, 1),
        Bank("2222", 2.0, 1),
        Bank("3333d", 3.0, 1),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}