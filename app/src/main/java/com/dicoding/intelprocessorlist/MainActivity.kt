package com.dicoding.intelprocessorlist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var intelList = arrayListOf<Intel>()
    private lateinit var rvIntel: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //setting
        rvIntel = findViewById(R.id.rv_intel)
        rvIntel.setHasFixedSize(true)

        intelList.addAll(getListIntel()) //menjalankan fungsi untuk memasukkan data ke list intel
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvIntel.layoutManager = LinearLayoutManager(this)
        val intelAdapter =IntelAdapter()
        intelAdapter.IntelList = intelList
        rvIntel.adapter = intelAdapter
    }

    private fun getListIntel(): ArrayList<Intel> {
        val dataTitle =resources.getStringArray(R.array.data_title)
        val dataDesc =resources.getStringArray(R.array.data_description)
        val dataImage =resources.getStringArray(R.array.data_image)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataSegment = resources.getStringArray((R.array.data_segment))
        val dataSpec = resources.getStringArray((R.array.data_spesification))
        val intels = ArrayList<Intel>()

        //memasukkkan ke data class
        for (i in dataTitle.indices) {
            val intel = Intel(dataTitle[i], dataDesc[i], dataImage[i], dataPrice[i], dataSegment[i], dataSpec[i])
            intels.add(intel)
        }
        return intels
    }

//    menampilkan menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

//    hanlde menu saat di klik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val profileIntent =Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(profileIntent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}