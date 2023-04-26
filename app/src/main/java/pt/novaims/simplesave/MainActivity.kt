package pt.novaims.simplesave

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var text1: String? = ""
    private var text2: String? = ""
    private var text3: String? = ""
    private val preferenceFileKey = "myTexts"
    private lateinit var text1ET: EditText
    private lateinit var text2ET:EditText
    private lateinit var text3ET:EditText
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = getSharedPreferences(preferenceFileKey,
            Context.MODE_PRIVATE)
        text1ET = findViewById(R.id.editText1)
        text2ET = findViewById(R.id.editText2)
        text3ET = findViewById(R.id.editText3)

        readSP()

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener { saveSP() }
    }

    fun readSP(){
        text1 = sharedPref.getString("text1sp", "write here 1")
        text2 = sharedPref.getString("text2sp", "write here 2")
        text3 = sharedPref.getString("text3sp", "write here 3")
        text1ET.setText(text1)
        text2ET.setText(text2)
        text3ET.setText(text3)
    }

    fun saveSP(){
        text1 = text1ET.text.toString()
        text2 = text2ET.text.toString()
        text3 = text3ET.text.toString()
        var editor = sharedPref.edit()
        editor.putString("text1sp",text1)
        editor.putString("text2sp",text2)
        editor.putString("text3sp",text3)
        editor.commit()
    }
}