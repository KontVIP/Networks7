package com.example.networks7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networks7.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.buildService(Api::class.java)

        binding.generateButton.setOnClickListener {
            val randomNumber = Random.nextInt(1, 100)
            CoroutineScope(Dispatchers.IO).launch {
                val response = retrofit.getData(randomNumber)
                val data = response.body()
                data?.applyUi(binding)
            }
        }


    }
}