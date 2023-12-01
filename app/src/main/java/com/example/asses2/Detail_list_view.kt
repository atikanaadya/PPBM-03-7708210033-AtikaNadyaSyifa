package com.example.asses2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.asses2.databinding.ActivityMainBinding

class Detail_list_view : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail_list_view)

        val title_name = intent.getStringExtra("title")
        val body_post = intent.getStringExtra("desc")
        val photo = intent.getIntExtra("imgid", R.drawable.kumparan_3)


        val detailTitleTextView: TextView = findViewById(R.id.titledetaill)
        val detailDescriptionTextView: TextView = findViewById(R.id.descdetail)
        val lvCsImage: ImageView = findViewById(R.id.fotodetail)

        detailTitleTextView.text = title_name
        detailDescriptionTextView.text = body_post
        lvCsImage.setImageResource(photo)


        val back_from_detail = findViewById<ImageView>(R.id.back_from_detail_post_custom)

        back_from_detail.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}