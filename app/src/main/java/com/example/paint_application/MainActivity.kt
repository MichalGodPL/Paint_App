package com.example.paint_application

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.paint_application.PaintView.Companion.colorList
import com.example.paint_application.PaintView.Companion.currentBrush
import com.example.paint_application.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val greenBtn = findViewById<ImageButton>(R.id.greenColor)
        val pinkBtn = findViewById<ImageButton>(R.id.pinkColor)

        val eraser = findViewById<ImageButton>(R.id.whiteColor)

        redBtn.setOnClickListener {
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)

        }

        blueBtn.setOnClickListener {

            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)

        }

        greenBtn.setOnClickListener {

            paintBrush.color = Color.GREEN
            currentColor(paintBrush.color)

        }

        pinkBtn.setOnClickListener {

            paintBrush.color = Color.YELLOW
            currentColor(paintBrush.color)

        }

        eraser.setOnClickListener {

            pathList.clear()
            colorList.clear()
            path.reset()

        }
    }

    private fun currentColor(color: Int){

        currentBrush = color
        path = Path()
    }
}