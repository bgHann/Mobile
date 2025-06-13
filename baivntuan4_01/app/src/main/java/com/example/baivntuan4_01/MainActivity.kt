package com.example.baivntuan4_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baivntuan4_01.ui.theme.Baivntuan4_01Theme
import com.example.baivntuan4_01.ui.theme.ManHinhQuanLyThuVien
import com.example.baivntuan4_01.ui.theme.ThanhDieuHuong

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Baivntuan4_01Theme {
                HomeCreen()
            }
        }
    }
}

@Composable
fun HomeCreen() {
    var sinhVienHienTai by remember { mutableStateOf("Nguyen Van A") }
    var danhSachSach by remember { mutableStateOf(listOf("Sách 01", "Sách 02")) }
    var tabDuocChon by remember { mutableStateOf("quanly") }

    Scaffold(
        bottomBar = {
            ThanhDieuHuong(tabDuocChon) { tabDuocChon = it }
        }
    ) { paddingValues ->
        ManHinhQuanLyThuVien(
            tenSinhVien = sinhVienHienTai,
            sachDaMuon = danhSachSach,
            onDoiSinhVien = { tenMoi ->
                sinhVienHienTai = tenMoi
                danhSachSach = when (tenMoi) {
                    "Nguyen Van A" -> listOf("Sách 01", "Sách 02")
                    "Nguyen Thi B" -> listOf("Sách 01")
                    "Nguyen Van C" -> emptyList()
                    else -> emptyList()
                }
            },
            onThemSach = {
                danhSachSach = danhSachSach + "Sách %02d".format(danhSachSach.size + 1)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Baivntuan4_01Theme {
        HomeCreen()
    }
}
