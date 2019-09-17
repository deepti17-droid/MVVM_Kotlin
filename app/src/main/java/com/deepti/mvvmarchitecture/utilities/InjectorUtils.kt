package com.deepti.mvvmarchitecture.utilities

import com.deepti.mvvmarchitecture.data.FakeDatabase
import com.deepti.mvvmarchitecture.data.QuoteRepository
import com.deepti.mvvmarchitecture.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory():QuotesViewModelFactory{
        val quoteRepository =  QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}