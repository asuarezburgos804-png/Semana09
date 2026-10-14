package com.example.semana09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.semana09.ui.theme.Semana09Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



@Composable
fun Registro() {

    var PersonasAdentro by remember {mutableStateOf(0)}
    var PersonaRegistrada by remember {mutableStateOf("Ninguno")}
    var UltimoRegistrado by remember { mutableStateOf("")}

    Column() {
        Text("Control de Aforo")
        Text("Personas adentro: $PersonasAdentro ")


        TextField(
            value = PersonaRegistrada,
            onValueChange = {PersonaRegistrada = it}
            )

        Button(onClick = {
            if (PersonaRegistrada.startsWith("A"))
                {
                    PersonasAdentro = PersonasAdentro + 1
                    UltimoRegistrado = PersonaRegistrada
                    PersonaRegistrada = ""
                }

        }) {
            Text("Registrar e Ingresar")
        }
        Text("Ultimo registrado: $UltimoRegistrado")

        Row() {
            Button(onClick = {
                if(PersonasAdentro > 0){
                    PersonasAdentro = PersonasAdentro - 1
                }
            }) {
                Text("Salida(-1)")
            }
            Button(onClick = {
                PersonasAdentro = 0
                UltimoRegistrado = "Ninguno"
            }) {
                Text("Reiniciar")
            }
        }
    }

}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Semana09Theme {

                Scaffold(modifier = Modifier.fillMaxSize()) {innerPading ->
                    Registro()
                }
            }
        }
    }
}
