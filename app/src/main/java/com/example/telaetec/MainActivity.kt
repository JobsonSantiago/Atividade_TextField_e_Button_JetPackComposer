package com.example.telaetec

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telaetec.ui.theme.NotaBButtonColors
import com.example.telaetec.ui.theme.NotaIButtonColors
import com.example.telaetec.ui.theme.NotaMBButtonColors
import com.example.telaetec.ui.theme.NotaRButtonColors
import com.example.telaetec.ui.theme.TelaETECTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaETECTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                    cadastro()
                }
            }
        }
    }
}

@Composable
fun cadastro(){
    var nome by remember { mutableStateOf("") }

    Column(Modifier
        .fillMaxWidth(),
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(text = "Atividade de PAM 2",
                fontSize = 20.sp
            )
        }
        Row(
            Modifier
            .fillMaxWidth(),
            Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.eteczl),
                contentDescription = "Etec"
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
        )

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = nome, //Variavel var nome by remember {mutableStateOf("")}
                onValueChange = {novoValor -> nome = novoValor},
                label = { Text("Digite seu nome: ")}

            )
        }

        Spacer(modifier = Modifier.height(16.dp)) //Adiciona espaço na vertical
    }
}

@Composable
@Preview(showBackground = true)
fun cadastroPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Image(
                painter = painterResource(R.drawable.eteczl),
                contentDescription = "Etec"
            )
        }
        cadastro()
    }
}


@Composable
private fun App(){
    Surface (
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
       Column(
           verticalArrangement = Arrangement.SpaceEvenly,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {

           Spacer(modifier = Modifier.height(80.dp)) //Adiciona espaço na vertical entre a caixa de texto e os botões

           ActionButton(
               text = "Nota I",
               buttonColors = NotaIButtonColors(),
               modifier = Modifier.fillMaxWidth(0.5f)
           ){
               /* Ação no Botão */
               Log.e(TAG, "App: Clicou na nota I")
           }
           ActionButton(
               text = "Nota R",
               buttonColors = NotaRButtonColors(),
               modifier = Modifier.fillMaxWidth(0.5f)
           ){
               /* Ação no Botão */
               Log.w(TAG, "App: Clicou na nota R")
           }
           ActionButton(
               text = "Nota B",
               buttonColors = NotaBButtonColors(),
               modifier = Modifier.fillMaxWidth(0.5f)
           ){
               /* Ação no Botão */
               Log.i(TAG, "App: Clicou na nota B")
           }
           ActionButton(
               text = "Nota MB",
               buttonColors = NotaMBButtonColors(),
               modifier = Modifier.fillMaxWidth()
           ) {
               try {
                   throw RuntimeException("App: Clicou na nota MB")
               }catch(ex: Exception){
                   Log.d(TAG, "App: Clicou na nota MB")
               }
           }
       }
    }
}
@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = Modifier
    )
    {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TelaETECTheme {
        Greeting("Android")
    }
}
