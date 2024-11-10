package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccalculator.ui.theme.BasicCalculatorTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCalculatorTheme {
                Calculatorlayout()

            }
        }
    }

}

@Composable

fun Calculatorlayout(modifier: Modifier = Modifier) {
    var previousinput by remember {
        mutableStateOf("")
    }
    var currentinput by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableStateOf<String?>(null)
    }
    var operator by remember {
        mutableStateOf<Char?>(null)
    }

    fun onDigitPressed(digit: Char) {

        if (result != null) {
            currentinput = digit.toString()
            result = null
        } else {
            currentinput += digit
        }


    }

    fun onclear() {

        currentinput = ""
        previousinput = ""
        result = null
        operator = null

    }

    fun onequalpressed() {
        if (operator != null && currentinput.isNotEmpty() && previousinput.isNotEmpty()) {
            val num1 = previousinput.toDoubleOrNull()
            val num2 = currentinput.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                result = when (operator) {
                    '+' -> (num1 + num2).toString()
                    '-' -> (num1 - num2).toString()
                    '*' -> (num1 * num2).toString()
                    '/' -> if (num2 != 0.0) (num1 / num2).toString() else "Error"
                    'E'-> num1.pow(num2).toString()
                    else -> {
                        null
                    }
                }
currentinput = ""
                previousinput = ""
                operator = null

            }
        }
    }

    Column(
       // horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(19.dp)

    ) {
        Row(
           // verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$previousinput   $operator $currentinput ", modifier = Modifier.padding(top = 45.dp), fontWeight = FontWeight.Bold, fontSize = 30.sp,
            )
            Spacer(modifier = Modifier.width(30.dp))
        Text(text =result?: "",  modifier = Modifier.padding(top = 45.dp), fontWeight = FontWeight.Bold, fontSize = 30.sp)
        }
Spacer(modifier = Modifier.height(25.dp))
        Row() {
            Button(onClick = { onclear() },
                modifier = Modifier.size(80.dp),
                ) {
                Text(text = "AC")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                previousinput = currentinput
                currentinput = ""
                operator = 'E'
            },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "E")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                previousinput = currentinput
                currentinput = ""
                operator = '+' },
                shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFFFA500) // Set background color here
                    ),
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "+")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                previousinput = currentinput
                currentinput = ""
                operator = '-' },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFA500) // Set background color here
                ),
                modifier = Modifier.size(80.dp)
                ) {
                Text(text = "-")


            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Button(onClick = {
                onDigitPressed(
                    '1',
                )
            },
                shape = CircleShape, modifier = Modifier.size(80.dp)) { Text(text = "1") }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                onDigitPressed(
                    '2',
                )
            },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) { Text(text = "2") }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = { onDigitPressed('3') },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "3")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                previousinput = currentinput
                currentinput = ""
                operator = '*' },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFFFA500) // Set background color here
                ),
                modifier = Modifier.size(80.dp)
                ) {
                Text(text = "*")

            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Button(onClick = {
                onDigitPressed('4')
            },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "4")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                onDigitPressed('5')
            },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "5")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = { onDigitPressed('6') },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "6")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                previousinput = currentinput
                currentinput = ""
                operator = '/' },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFFFA500) // Set background color here
                ),
                modifier = Modifier.size(80.dp)
                ) {
                Text(text = "/")

            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Button(onClick = {
                onDigitPressed('7')
            },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)
                ) {
                Text(text = "7")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = {
                onDigitPressed('8')
            },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "8")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = { onDigitPressed('9') },
                shape = CircleShape,
                modifier = Modifier.size(80.dp)) {
                Text(text = "9")

            }
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Button(onClick = { onequalpressed() },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFFFA500) // Set background color here
                ),
                modifier = Modifier.size(80.dp)
                ) {
                Text(text = "=")

            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicCalculatorTheme {
        Calculatorlayout()
    }
}