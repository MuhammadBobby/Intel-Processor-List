package com.dicoding.intelprocessorlist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        val intels = ArrayList<Intel>()

        //memasukkkan ke data class
        for (i in dataTitle.indices) {
            val intel = Intel(dataTitle[i], dataDesc[i], dataImage[i], dataPrice[i])
            intels.add(intel)
        }
        return intels
    }
}