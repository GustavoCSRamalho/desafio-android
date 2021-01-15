package com.gustavo.desafio_android.ui.main.activity.interf

interface ChangePageInterf<T> {

    fun changePage(fragment: Int, repositoryRef: T)


}