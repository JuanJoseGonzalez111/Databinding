package com.example.tiradadedados

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiradadedados.databinding.ActivityRollDiceBinding
import com.google.android.material.snackbar.Snackbar

class RollDiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRollDiceBinding

    val diceface = listOf(
        R.drawable.area_1,
        R.drawable.area_2,
        R.drawable.area_3,
        R.drawable.area_4,
        R.drawable.area_5,
        R.drawable.area_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityRollDiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Roll dice"

        // Inicializamos la imagen del dado
        binding.diceFaceImage.setImageResource(diceface[1])

        // Asignamos el click listener con data binding
        binding.roolDiceButton2.setOnClickListener {
            binding.diceFaceImage.setImageResource(diceface.random())
            Snackbar.make(binding.diceFaceImage, "Dice rolled", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
