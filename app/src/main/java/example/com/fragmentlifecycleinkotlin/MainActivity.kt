package example.com.fragmentlifecycleinkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentLoaded = true
    lateinit var btn_change: Button
    val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_change = findViewById(R.id.btn_change) as Button


        btn_change.setOnClickListener({
            //check FragmentOne is loaded or not
            if (isFragmentLoaded) {//is loaded
                changeFragmentTwo() //load second Fragment
            } else { // is not loaded
                changeFragmentOne()  //load second Fragment
            }
        })
    }

    override fun onResume() {
        super.onResume()
        //call FragmentOne
        changeFragmentOne()
    }

    fun changeFragmentOne() {
        //create transition
        val transition = manager.beginTransaction()
        // Declare fragment
        var fragment = FragmentOne()
        //Declare frameLayout id with fragment
        transition.replace(R.id.fragment_change, fragment)
        transition.addToBackStack(null)
        transition.commit()
        isFragmentLoaded = true
    }

    fun changeFragmentTwo() {
        //create transition
        val transition = manager.beginTransaction()
        // Declare fragment
        var fragment = FragmentTwo()
        //Declare frameLayout id with fragment
        transition.replace(R.id.fragment_change, fragment)
        transition.addToBackStack(null)
        transition.commit()
        isFragmentLoaded = false
    }
}
