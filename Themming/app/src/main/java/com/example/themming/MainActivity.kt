package com.example.themming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposematerial.ui.theme.attr.CustomTypography
import com.example.themming.ui.*
import com.example.themming.ui.components.OverallView
import com.example.themming.ui.components.ThemeType

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            AppTheme {
                AppNavigator(navHostController )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AppNavigator(navHostController: NavHostController){
    val darkMode = remember { mutableStateOf(false) }
    val isVisible = remember { mutableStateOf(true) }
    NavHost(
        navController = navHostController,
        startDestination = "customTheme"
    ) {
        composable("customTheme") {
            ExpandVerticalyAnimation(isVisible = isVisible.value) {
                AppTheme(
                    colors = if (darkMode.value) CustomDarkColorPalette() else CustomLightColorPalette(),
                    typography = CustomTypography()
                ){
                    OverallView(darkMode = darkMode ,themeType =  ThemeType.CUSTOM,navHostController = navHostController)
                }
            }
        }
        composable("pink") {
            ExpandVerticalyAnimation(isVisible = isVisible.value) {
                PinkTheme(darkMode.value){
                    OverallView(darkMode = darkMode ,themeType =  ThemeType.PINK,navHostController = navHostController)
                }

            }
        }
        composable("blue") {
            ExpandVerticalyAnimation(isVisible = isVisible.value) {
                BlueTheme(darkMode.value){
                    OverallView(darkMode = darkMode ,themeType =  ThemeType.BLUE,navHostController = navHostController)
                }

            }
        }
    }
}
