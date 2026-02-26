package br.edu.fatecpg.apptelas_pdm_fatec.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.apptelas_pdm_fatec.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nome = intent.getStringExtra("nome")
        //Toast.makeText(this, "Olá $nome", Toast.LENGTH_SHORT).show()
        val txvText = findViewById<TextView>(R.id.txt_2)
        txvText.text = getString(R.string.info_second, nome)



        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)
        fabVolta.setOnClickListener {
            finish()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}