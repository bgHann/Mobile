package com.example.baivntuan4_01.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ManHinhQuanLyThuVien(
    tenSinhVien: String,
    sachDaMuon: List<String>,
    onDoiSinhVien: (String) -> Unit,
    onThemSach: () -> Unit
) {
    var tenMoi by remember { mutableStateOf(tenSinhVien) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Tiêu đề
        Text(
            text = "Hệ thống\nQuản lý Thư viện",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(70.dp))

        // Nhập tên sinh viên
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = tenMoi,
                onValueChange = { ten -> tenMoi = ten },
                label = { Text("Sinh viên") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { onDoiSinhVien(tenMoi) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Thay đổi")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Danh sách sách đã mượn
        Text("Danh sách sách", fontWeight = FontWeight.Bold)

// Bọc toàn bộ danh sách trong Box nền xám
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            if (sachDaMuon.isEmpty()) {
                Text(
                    text = "Bạn chưa mượn quyển sách nào\nNhấn 'Thêm' để bắt đầu hành trình đọc sách!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Column {
                    sachDaMuon.forEach { sach ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            Checkbox(
                                checked = true,
                                onCheckedChange = null,
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.Red,
                                    uncheckedColor = Color.Red.copy(alpha = 0.3f),
                                    checkmarkColor = Color.White
                                )
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(sach)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Nút Thêm
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { onThemSach() },
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            )  {
                Text("Thêm")
            }
        }
    }
}
