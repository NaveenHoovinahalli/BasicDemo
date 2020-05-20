package com.example.mydemosample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HeroesViewModel(val requestServer: RequestData) : ViewModel() {
    private var heroList = MutableLiveData<List<Hero>>()
    var myPosition = MutableLiveData<String>()
    val heroes: LiveData<List<Hero>>
        get() = this.heroList

    fun fetchData() {
        requestServer.loadHeroes {
            heroList.value = it
        }
    }

    fun setItemClick(hero: Hero) {
        Log.d("NaveenTesting", "MyPosition" + hero.name)
        myPosition.value = hero.name
    }

    fun setValue(nuber: Int) : Boolean {
        return true
    }
}