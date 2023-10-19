@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jsonapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jsonapi.api.TweetsyAPI
import com.example.jsonapi.screens.CategoryScreen
import com.example.jsonapi.screens.DetailScreen
import com.example.jsonapi.ui.theme.JsonApiTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var tweetsyAPI: TweetsyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        GlobalScope.launch{
//            var response = tweetsyAPI.getCategories()
//            Log.d("ApI Testing", response.body()!!.distinct().toString())
//
//        }

        setContent {
            JsonApiTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "JsonApi")
                        }, colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Color.Black,
                            titleContentColor = Color.White,
                        ),
                        )
                    }
                ){
                    Box (modifier = Modifier.padding((it))){
                        App()
                    }
                }

            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route ="category") {
            CategoryScreen{
                navController.navigate("detail/${it}")
            }
        }
        composable(route ="detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )){
            DetailScreen()
        }
    }
}

