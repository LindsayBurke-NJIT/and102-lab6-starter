package com.codepath.lab6

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailImageView: ImageView = findViewById(R.id.detailImage)
        val detailTitleTextView: TextView = findViewById(R.id.detailTitle)
        val detailDescriptionTextView: TextView = findViewById(R.id.detailDescription)

        // Retrieve data passed via Intent (Parcelable is preferred over Serializable)
        val park = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(PARK_EXTRA, Park::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Park>(PARK_EXTRA)
        }

        val campground = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(CAMPGROUND_EXTRA, Campground::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Campground>(CAMPGROUND_EXTRA)
        }

        // Populate UI based on type
        when {
            park != null -> {
                detailTitleTextView.text = park.fullName
                detailDescriptionTextView.text = park.description
                Glide.with(this).load(park.imageUrl).into(detailImageView)
            }
            campground != null -> {
                detailTitleTextView.text = campground.name
                detailDescriptionTextView.text = campground.description
                Glide.with(this).load(campground.imageUrl).into(detailImageView)
            }
        }
    }
}
