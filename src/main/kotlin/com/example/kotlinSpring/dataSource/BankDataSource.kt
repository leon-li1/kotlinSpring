package com.example.kotlinSpring.dataSource

import com.example.kotlinSpring.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>

}