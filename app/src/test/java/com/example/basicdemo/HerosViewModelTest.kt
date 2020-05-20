package com.example.basicdemo

import com.example.mydemosample.Hero
import com.example.mydemosample.HeroesViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.inject

class HerosViewModelTest : BaseTest(){

    val heroesViewModel: HeroesViewModel by inject()

    @Before
    override fun before() {
        super.before()
    }

    @Test
    fun setValTest() {
        with(heroesViewModel) {
            Assert.assertTrue(setValue(1))
        }

    }

    @Test
    fun setItemClickTest() {
        with(heroesViewModel) {
            var hero = Hero("Name" , "Real Name", "Team", "First", "Created", "Publisher", "Image", "bio")
            setItemClick(hero)

        }
    }

}