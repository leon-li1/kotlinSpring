package com.example.kotlinSpring.dataSource.mock

import com.example.kotlinSpring.dataSource.BankDataSource
import com.example.kotlinSpring.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 1.0, 1),
        Bank("2222", 2.0, 1),
        Bank("3333d", 3.0, 1),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Couldn't find a bank with account number: $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber })
            throw IllegalArgumentException("Bank with account number: ${bank.accountNumber} already exists")

        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Bank with account number: ${bank.accountNumber} does not exist")
        val indexToChange = banks.indexOf(currentBank)
        banks[indexToChange] = bank
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Bank with account number: $accountNumber does not exist")
        banks.remove(currentBank)
    }
}