package edu.temple.imageswapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = ImageFragment.newInstance(intArrayOf(
            R.drawable.cat1,
            R.drawable.cat2,
            R.drawable.cat3,
            R.drawable.cat4,
            R.drawable.cat5
        ))

        val fragment2 = ImageFragment.newInstance(intArrayOf(
            R.drawable.dog1,
            R.drawable.dog2,
            R.drawable.dog3,
            R.drawable.dog4,
            R.drawable.dog5,
        ))

        supportFragmentManager.beginTransaction()
            .add(R.id.container1, fragment1)
            .add(R.id.container2, fragment2)
            .commit()

        //fragment1.changeImage()
        //fragment2.changeImage()

        findViewById<Button>(R.id.changeButton).setOnClickListener {
            fragment1.changeImage()
            fragment2.changeImage()
        }
    }
}