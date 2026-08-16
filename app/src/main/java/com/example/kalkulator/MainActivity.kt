package com.example.kalkulator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etAngka1 = findViewById<EditText>(R.id.etAngka1)
        val etAngka2 = findViewById<EditText>(R.id.etAngka2)
        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnKurang = findViewById<Button>(R.id.btnKurang)
        val btnKali = findViewById<Button>(R.id.btnKali)
        val btnBagi = findViewById<Button>(R.id.btnBagi)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        fun hitung(operasi: (Double, Double) -> Double) {
            val str1 = etAngka1.text.toString()
            val str2 = etAngka2.text.toString()

            if (str1.isEmpty() || str2.isEmpty()) {
                Toast.makeText(this, "Harap isi kedua angka!", Toast.LENGTH_SHORT).show()
                return
            }

            val num1 = str1.toDouble()
            val num2 = str2.toDouble()
            val hasil = operasi(num1, num2)

            tvHasil.text = "Hasil: $hasil"
        }

        btnTambah.setOnClickListener { hitung { a, b -> a + b } }
        btnKurang.setOnClickListener { hitung { a, b -> a - b } }
        btnKali.setOnClickListener { hitung { a, b -> a * b } }
        btnBagi.setOnClickListener {
            val str2 = etAngka2.text.toString()
            if (str2 == "0") {
                Toast.makeText(this, "Tidak bisa dibagi dengan nol!", Toast.LENGTH_SHORT).show()
            } else {
                hitung { a, b -> a / b }
            }
        }
    }
}
