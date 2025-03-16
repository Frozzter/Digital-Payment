package com.example.digitalpaymentnfc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var balance: Int = 0
    private lateinit var tvBalance: TextView
    private lateinit var etAmount: EditText
    private lateinit var btnTopUp: Button
    private lateinit var btnPay: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvBalance = findViewById(R.id.tv_balance)
        etAmount = findViewById(R.id.et_amount)
        btnTopUp = findViewById(R.id.btn_topup)
        btnPay = findViewById(R.id.btn_pay)

        btnTopUp.setOnClickListener { topUp() }
        btnPay.setOnClickListener { pay() }
    }

    private fun topUp() {
        val amount = etAmount.text.toString().toIntOrNull()
        if (amount != null && amount > 0) {
            balance += amount
            updateBalance()
            Toast.makeText(this, "Top Up berhasil!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Masukkan jumlah yang valid", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pay() {
        val amount = etAmount.text.toString().toIntOrNull()
        if (amount != null && amount > 0 && balance >= amount) {
            balance -= amount
            updateBalance()
            Toast.makeText(this, "Pembayaran berhasil!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Saldo tidak cukup atau jumlah tidak valid", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateBalance() {
        tvBalance.text = "Saldo: Rp $balance"
    }
}