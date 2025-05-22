package com.example.venhatuan02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edit_Tuoi = findViewById<EditText>(R.id.edit_tuoi)
        val Kiemtra = findViewById<Button>(R.id.button)
        Kiemtra.setOnClickListener {
            val tuoi = edit_Tuoi.text.toString().toIntOrNull() ?: 0
            if (tuoi <= 0 || tuoi >= 2) {
                val hoithoai = AlertDialog.Builder(this)
                hoithoai.setTitle("Thông tin cá nhân")
                hoithoai.setMessage("Em bé")
                hoithoai.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss() // Đóng hộp thoại khi bấm nút OK

                }
            } else if (tuoi > 2 || tuoi <= 6) {
                val hoithoai = AlertDialog.Builder(this)
                hoithoai.setTitle("Thông tin cá nhân")
                hoithoai.setMessage("Trẻ em")
                hoithoai.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss() // Đóng hộp thoại khi bấm nút OK

                }

            } else if (tuoi > 6 || tuoi <= 66) {
                val hoithoai = AlertDialog.Builder(this)
                hoithoai.setTitle("Thông tin cá nhân")
                hoithoai.setMessage("Người lớn")
                hoithoai.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss() // Đóng hộp thoại khi bấm nút OK


                }
            } else if (tuoi < 0) {
                val hoithoai = AlertDialog.Builder(this)
                hoithoai.setTitle("Thông tin cá nhân")
                hoithoai.setMessage("Nhập sai")
                hoithoai.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss() // Đóng hộp thoại khi bấm nút OK

                }
            } else {
                val hoithoai = AlertDialog.Builder(this)
                hoithoai.setTitle("Thông tin cá nhân")
                hoithoai.setMessage("Người lớn")
                hoithoai.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss() // Đóng hộp thoại khi bấm nút OK


                }
            }
        }

    }
}
