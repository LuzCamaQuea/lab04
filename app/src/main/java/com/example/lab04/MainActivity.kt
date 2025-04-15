package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                BotonConDialogo()
            }
        }
    }
}
@Composable
fun BotonConDialogo() {
    var mostrarDialogo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)

    ) {
        Button(onClick = { mostrarDialogo = true }) {
            Text(text = "Mostrar Diálogo")
        }

        if (mostrarDialogo) {
            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text("Título del Diálogo") },
                text = { Text("Este es el contenido del diálogo.") },
                confirmButton = {
                    TextButton(onClick = { mostrarDialogo = false }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { mostrarDialogo = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Composable
fun MiContenedor() {
    LazyColumn {
        items(5) { index ->
            Text(text = "Ítem $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun MiBoton() {
    Button(onClick = { /* Acción */ }) {
        Text(text = "Haz clic aquí")
    }
}

