package com.example.baivntuan04

import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baivntuan04.ui.theme.Baivntuan04Theme
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient

@Composable

fun LoginScreen(
    navController: NavController,
    oneTapClient: SignInClient,
    signInRequest: BeginSignInRequest,
    launcher: ActivityResultLauncher<IntentSenderRequest> // 👈 PHẢI CÓ DÒNG NÀY
)
 {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("SmartTasks", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener { result ->
                    launcher.launch(IntentSenderRequest.Builder(result.pendingIntent).build())
                }
                .addOnFailureListener {
                    Log.e("Login", "Sign in failed", it)
                }

        }) {
            Text("Sign in with Google")
        }

    }
}
