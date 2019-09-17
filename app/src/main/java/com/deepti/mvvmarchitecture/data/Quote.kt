package com.deepti.mvvmarchitecture.data

data class Quote(val quote: String ,  val author: String) {

    override fun toString(): String {
        return "$quote - $author"
    }
}