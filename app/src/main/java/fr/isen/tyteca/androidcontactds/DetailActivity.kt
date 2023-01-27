package fr.isen.tyteca.androidcontactds

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
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

        if (contact.picture?.large!!.isNotEmpty()) {
            Picasso.get().load(contact.picture?.large).into(binding.photo)
        }

        binding.textNameView.text = contact.name?.first +" "+ contact.name?.last
        binding.addresse.text = contact.location?.street?.number.toString() + " " + contact.location?.street?.name + " " + contact.location?.state + " " + contact.location?.city
        binding.phoneNumber.text= contact.phone
        binding.registerDate.text = contact.registered?.date
    }
}