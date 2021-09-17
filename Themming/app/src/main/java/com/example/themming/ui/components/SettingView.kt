package com.example.themming.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.themming.ui.AppTheme
import com.example.themming.ui.JetpackComposeMaterialTheme


@Composable
fun SettingView(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    darkMode: MutableState<Boolean>,
    themeType: ThemeType
) {
    Surface(modifier = modifier.fillMaxWidth()) {
        Column {
            DarkModeCheckBox(darkMode)
            SmallSpacer()
            ThemePickRadioGroup(themeType,navHostController)
            LargeSpacer()
        }
    }
}

@Composable
fun DarkModeCheckBox(darkMode: MutableState<Boolean>) {
    Row {
        Checkbox(
            checked = darkMode.value,
            onCheckedChange = { checked -> darkMode.value = checked },
        )
        SmallSpacer()
        Text(text = "Dark mode")
    }
}

@Composable
fun ThemePickRadioGroup(themeType: ThemeType, navHostController: NavHostController) {

    Column {
        Text(text = "Select theme")
        TinySpacer()
        Row {
            TinySpacer()
            RadioButton(selected = themeType == ThemeType.PINK, onClick = {
                navHostController.navigate("pink"){
                    launchSingleTop = true
                }
            })
            Text(
                text = ThemeType.PINK.name,
                modifier = Modifier
                    .padding(start = AppTheme.sizes.smaller)
            )
            TinySpacer()
            RadioButton(selected = themeType == ThemeType.CUSTOM, onClick = {
                navHostController.navigate("customTheme"){
                    launchSingleTop = true
                }
            })
            Text(
                text = ThemeType.CUSTOM.name,
                modifier = Modifier
                    .padding(start = AppTheme.sizes.smaller)
            )
            TinySpacer()
            RadioButton(selected = themeType == ThemeType.BLUE, onClick = {
                navHostController.navigate("blue"){
                    launchSingleTop = true
                }
            })
            Text(
                text = ThemeType.BLUE.name,
                modifier = Modifier
                    .padding(start = AppTheme.sizes.smaller)
            )
        }
    }
}

enum class ThemeType {
    CUSTOM,
    BLUE,
    PINK
}
