package dm.daniel.bmiviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dm.daniel.bmiviewmodel.ui.theme.BmiViewmodelTheme

class BodyMassIndex : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiViewmodelTheme {
                BodyMassIndexApp()
            }
        }
    }
}

@Composable
fun BodyMassIndexApp(viewmodel: BMIViewModel = viewModel() ) {
    val reusableModifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = reusableModifier
    ) {
        Text(
            text = stringResource(R.string.BMIViewmodel_title),
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = reusableModifier)
        OutlinedTextField(
            value = viewmodel.heightInput,
            onValueChange = { viewmodel.changeheightInput(it) },
            label = { Text(text = stringResource(R.string.BMIViewmodel_Height)) },
            modifier = reusableModifier
        )
        OutlinedTextField(
            value = viewmodel.weightInput,
            onValueChange = { viewmodel.changeweightInput(it) },
            label = { Text(text = stringResource(R.string.BMIViewmodel_Weight)) },
            modifier = reusableModifier
        )
        Text(
            text = stringResource(R.string.BMIViewmodel_result, String.format("%.2f", viewmodel.result()).replace(',', '.')),
            modifier = reusableModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    BmiViewmodelTheme {

    }
}
