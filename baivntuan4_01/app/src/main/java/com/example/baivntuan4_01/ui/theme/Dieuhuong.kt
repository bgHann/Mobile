package com.example.baivntuan4_01.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ThanhDieuHuong(tabDangChon: String, onTabChon: (String) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Quản lý") },
            label = { Text("Quản lý") },
            selected = tabDangChon == "quanly",
            onClick = { onTabChon("quanly") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "DS Sách") },
            label = { Text("DS Sách") },
            selected = tabDangChon == "dssach",
            onClick = { onTabChon("dssach") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Sinh viên") },
            label = { Text("Sinh viên") },
            selected = tabDangChon == "sinhvien",
            onClick = { onTabChon("sinhvien") }
        )
    }
}
