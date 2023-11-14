package com.android.myrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailHeroActivity : AppCompatActivity() {
    private lateinit var btnShare: ImageView
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        btnShare = findViewById(R.id.btn_share)
        var hero = intent.getParcelableExtra<Hero>("key_hero")
        if (hero != null) {
            val image: ImageView = findViewById(R.id.imageView)
            val name: TextView = findViewById(R.id.nama_pahlawan)
            val description: TextView = findViewById(R.id.description)

            image.setImageResource(hero.photo)
            name.text = hero.name
            description.text = hero.description

            val message = "${name.text}\\n\\n${description.text}"

            btnShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plan"
                intent.putExtra(Intent.EXTRA_TEXT, message)
                val chooser = Intent.createChooser(intent, "Share using...")
                startActivity(chooser)
            }
        }
    }
}