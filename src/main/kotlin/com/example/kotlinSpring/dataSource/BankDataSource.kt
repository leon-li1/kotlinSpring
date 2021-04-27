package com.example.kotlinSpring.dataSource

import com.example.kotlinSpring.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun createBank(bank: Bank): Bank

}