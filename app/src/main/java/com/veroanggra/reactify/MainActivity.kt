package com.veroanggra.reactify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.veroanggra.reactify.gooey.GooeyRenderers
import com.veroanggra.reactify.ui.theme.ReactifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val renderer = when (intent.getStringExtra("renderer")) {
            "path" -> GooeyRenderers.path()
            "plain" -> GooeyRenderers.plain()
            else -> GooeyRenderers.auto()
        }
        setContent {
            ReactifyTheme {
                InviteFriendsScreen(renderer = renderer)
            }
        }
    }
}
