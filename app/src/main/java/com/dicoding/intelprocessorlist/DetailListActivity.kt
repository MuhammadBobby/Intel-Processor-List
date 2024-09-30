package com.dicoding.intelprocessorlist

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailListActivity : AppCompatActivity() {

    companion object {
        const val KEY_INTEL_LIST = "key_intel_list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_list)

//        inisialisasi
        val detailTitle: TextView = findViewById(R.id.text_detail_title)
        val detailImage: ImageView = findViewById(R.id.img_detail_image)
        val detailDesc: TextView = findViewById(R.id.text_detail_desc)
        val detailSegment: TextView = findViewById(R.id.text_detail_segment)
        val detailSpec: TextView = findViewById(R.id.text_detail_spec)
        val detailPrice: TextView = findViewById(R.id.text_detail_price)
        val buttonWeb: Button = findViewById(R.id.button_website)


        val intelList = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Intel>(KEY_INTEL_LIST, Intel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Intel>(KEY_INTEL_LIST)
        }

        if (intelList != null) {
            detailTitle.text = intelList.title
            Glide.with(this)
                .load(intelList.image)
                .into(detailImage)
            detailDesc.text = intelList.description
            detailSegment.text = intelList.segment
            detailSpec.text = intelList.spesification
            detailPrice.text = intelList.price
        }


        //set button web
        buttonWeb.setOnClickListener {
            val url = "https://www.intel.co.id/content/www/id/id/products/details/processors.html" // Ganti dengan URL yang diinginkan
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

}