package com.example.tiradadedados

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiradadedados.databinding.ActivityFlipCoinBinding
import com.google.android.material.snackbar.Snackbar

class FlipCoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlipCoinBinding
    private val diceface = listOf(R.drawable.cross, R.drawable.face)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityFlipCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar4)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Flip coin"


        binding.imageView3.setImageResource(diceface[1])


        binding.button2.setOnClickListener {
            binding.imageView3.setImageResource(diceface.random())
            Snackbar.make(binding.imageView3, "Coin flipped", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
