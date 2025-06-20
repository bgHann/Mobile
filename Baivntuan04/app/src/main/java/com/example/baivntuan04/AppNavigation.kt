import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baivntuan04.LoginScreen
import com.example.baivntuan04.ProfileScreen
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun AppNavigation(
    launcher: ActivityResultLauncher<IntentSenderRequest>, // 👈 THÊM dòng này
    oneTapClient: SignInClient,
    signInRequest: BeginSignInRequest
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                navController = navController,
                oneTapClient = oneTapClient,
                signInRequest = signInRequest,
                launcher = launcher
            )
        }

        composable("profile") {
            val user = FirebaseAuth.getInstance().currentUser
            val name = user?.displayName ?: "Unknown"
            val email = user?.email ?: "Unknown"
            val photoUrl = user?.photoUrl?.toString() ?: ""

            ProfileScreen(
                navController = navController,
                name = name,
                email = email,
                photoUrl = photoUrl
            )
        }
    }
}
