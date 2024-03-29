package com.fundatec.gamecenter

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.fundatec.gamecenter.adapter.SectionsPagerAdapterComunidade
import com.fundatec.gamecenter.ui.main.SectionsPagerAdapter

class ComunidadeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunidade)

        val sectionsPagerAdapter = SectionsPagerAdapterComunidade(this, supportFragmentManager, intent.getStringExtra("idComunidade"), intent.getStringExtra("pesquisa"))

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }
}