package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_a).setOnClickListener {
            val intent = Intent(this, FragmentAActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn_b).setOnClickListener {
            val intent = Intent(this, FragmentBActivity::class.java)
            startActivity(intent)
        }
    }


}