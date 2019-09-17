package com.deepti.mvvmarchitecture.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.deepti.mvvmarchitecture.R
import com.deepti.mvvmarchitecture.data.Quote
import com.deepti.mvvmarchitecture.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {
            quotes -> val stringBuilder = StringBuilder()
            quotes.forEach { quotes ->
                stringBuilder.append("$quotes\n\n")
            }
            displayTv.text = stringBuilder.toString()
        })

        submit.setOnClickListener {
            val quote = Quote(etQuote.text.toString(),etAuthor.text.toString())
            viewModel.addQuote(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }
    }
}
