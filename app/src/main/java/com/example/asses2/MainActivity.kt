package com.example.asses2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.asses2.databinding.ActivityMainBinding
import com.example.asses2.dataclass.Userpost
import com.example.listview.adapterlist.CustomAdaptor
import com.example.listview.adapterlist.ListAdaptor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postArrayList: ArrayList<Userpost>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nama = arrayOf<String>(
            "Kumparan",
            "Detikdotcom",
            "CNN"
        )

        val desc = arrayOf<String>(
            "platform media berita kolaboratif, terkini Indonesia hari ini yang menyajikan informasi news, sepak bola, ekonomi, politik, showbiz, lifestyle, otomotif,dll",
            "Info berita terbaru hari ini baik peristiwa, kecelakaan, kriminal, hukum, berita unik, Politik, dan liputan khusus di Indonesia dan Internasional.",
            "Cable News Network Indonesia (known as CNN Indonesia and abbreviated as CNN ID) is a 24-hour Indonesian free-to-air television news channel owned by Trans Media in collaboration with Warner Bros."
        )

        val gambar = arrayOf<Int>(
            R.drawable.kumparan_3,
            R.drawable.detik_2,
            R.drawable.cnn_1
        )

        postArrayList = ArrayList()

        // definisi list view
        val _list = findViewById<ListView>(R.id.custom_list_view)
        _list.adapter = CustomAdaptor(this, nama, desc, gambar)

        binding.customListView.isClickable = true
        binding.customListView.adapter = CustomAdaptor(this, nama, desc, gambar)
        binding.customListView.setOnItemClickListener { adapterView, view, position, id ->

            val title = nama[position]
            val deskripsi = desc[position]
            val imgid = gambar[position]

            val i = Intent(this, Detail_list_view::class.java)
            i.putExtra("title", title)
            i.putExtra("desc", deskripsi)
            i.putExtra("imgid", imgid)

            startActivity(i)


        }

        val _reglist = findViewById<ListView>(R.id.list_view_biasa)
        _reglist.adapter = ListAdaptor(this, nama,desc)

        binding.listViewBiasa.isClickable = true
        binding.listViewBiasa.adapter = ListAdaptor(this, nama, desc)
        binding.listViewBiasa.setOnItemClickListener { adapterView, view, position, id ->

            val title = nama[position]
            val deskripsi = desc[position]

            val i = Intent(this, Detail_list_view::class.java)
            i.putExtra("title", title)
            i.putExtra("desc", deskripsi)

            startActivity(i)


        }
    }
}