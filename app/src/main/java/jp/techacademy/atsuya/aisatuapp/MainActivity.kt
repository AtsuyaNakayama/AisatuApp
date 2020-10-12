package jp.techacademy.atsuya.aisatuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timepickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener{view, hour, minute ->
                    Log.d("ktlog", "${hour}:${minute}")
                    if(hour >= 2 && hour <= 9) {
                        textView.text = "おはよう"
                    } else if (hour >= 10 && hour <= 17) {
                        textView.text = "こんにちは"
                    } else if ((hour >= 18 && hour <= 24) || (hour >= 0 && hour <= 1)) {
                        textView.text = "こんばんは"
                    } else {
                        textView.text = "時間が正しくありません。"
                    }
                },
                13, 0, true
        )
        timepickerDialog.show()
    }
}
