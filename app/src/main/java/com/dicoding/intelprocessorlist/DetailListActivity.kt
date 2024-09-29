package com.dicoding.intelprocessorlist

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailListActivity : AppCompatActivity() {

    companion object {
        const val KEY_INTEL_LIST = "key_intel_list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_list)

        val detailTitle: TextView = findViewById(R.id.detail_title)

        val intelList = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Intel>(KEY_INTEL_LIST, Intel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Intel>(KEY_INTEL_LIST)
        }

        if (intelList != null) {
            detailTitle.text = intelList.title
        }
    }
}