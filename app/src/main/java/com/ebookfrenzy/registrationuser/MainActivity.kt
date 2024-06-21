package com.ebookfrenzy.registrationuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebookfrenzy.registrationuser.ui.theme.RegistrationUserTheme


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.configureAmplify(this)

        setContent {
            RegistrationUserTheme {
                AppNavigator()
            }
        }
    }

    @Composable
    private fun AppNavigator() {
        val navController = rememberNavController()
        viewModel.navigateTo = {
            navController.navigate(it)
        }

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginScreen(viewModel = viewModel)
            }
            composable("signUp") {
                SignUpScreen(viewModel = viewModel)
            }
            composable("verify") {
                VerificationCodeScreen(viewModel = viewModel)
            }
            composable("session") {
                SessionScreen(viewModel = viewModel)
            }
        }
    }
}


