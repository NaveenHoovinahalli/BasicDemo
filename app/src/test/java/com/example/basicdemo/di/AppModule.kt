package com.example.basicdemo.di

import com.example.mydemosample.HeroesViewModel
import com.example.mydemosample.RequestData
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { RequestData() }

    viewModel { HeroesViewModel(get()) }
}