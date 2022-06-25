package com.example.recyclerview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerview.adapter.AdapterTeamBola
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Nadeo Argawinata",R.drawable.nadeo, "Penajaga Gawang", "200cm","Kediri","9 Maret 1997"))
        listPemain.add(Pemain("Evan Dimas",R.drawable.evandimas, "Penyerang", "184cm","Surabaya","13 Maret 1995"))
        listPemain.add(Pemain("Pratama Arhan",R.drawable.arhan, "Belakang", "175cm","Blora","21 Desember 2001"))
        listPemain.add(Pemain("Alfeandra Dewangga",R.drawable.dewangga, "Belakang", "185cm","Semarang"," 28 Juni 2001"))
        listPemain.add(Pemain("Shin Thae Yong",R.drawable.shintaeyong, "Pelatih", "185cm","Korea Selatan"," 23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this, listPemain,object : AdapterTeamBola.OnClikListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.textDataDiri)

                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"


                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }

        })
    }
}