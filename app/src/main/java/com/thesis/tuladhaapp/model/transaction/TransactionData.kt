package com.thesis.tuladhaapp.model.transaction

data class TransactionData(
    val token: String?,
    val redirectUrl: String?,
    val transactionDetail: TransactionDetail?
)
