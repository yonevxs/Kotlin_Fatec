package br.edu.fatecpg.apptelas_pdm_fatec.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.apptelas_pdm_fatec.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)
        val nome = "Lucas"
        fabAvanca.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
        // Compatibilidade entre telas diferentes
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}