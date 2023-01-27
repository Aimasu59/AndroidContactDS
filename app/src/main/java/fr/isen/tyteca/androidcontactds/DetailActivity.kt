package fr.isen.tyteca.androidcontactds

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.tyteca.androidcontactds.databinding.ActivityDetailBinding
import fr.isen.tyteca.androidcontactds.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var contact: Results
    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_detail)

        actionBar?.title = "AndroidContactDS"
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF9800")))
        contact = intent.getSerializableExtra("detail") as Results

        binding.textNameView.text = contact.name?.first.toString()
    }
}