package dm.daniel.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    var height: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull() ?: 0.0f
        }

    var weight: Int = 0
        get() {
            return weightInput.toIntOrNull() ?: 0
        }

    fun changeheightInput(value: String) {
        heightInput = value
    }

    fun changeweightInput(value: String) {
        weightInput = value
    }

    fun result(): Any {
        return calculation()
    }

    private fun calculation(): Any {
        var bmi = if (weight > 0 && height > 0 ) weight / (height * height) else 0.0
        return bmi
    }
}