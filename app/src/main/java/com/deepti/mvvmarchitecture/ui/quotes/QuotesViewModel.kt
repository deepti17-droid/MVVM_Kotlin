package com.deepti.mvvmarchitecture.ui.quotes

import androidx.lifecycle.ViewModel
import com.deepti.mvvmarchitecture.data.Quote
import com.deepti.mvvmarchitecture.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote : Quote) = quoteRepository.addQuote(quote)
}