package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var mainActivityViewModel:MainActivityViewModel
    private var mList =  ArrayList<ViewItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.txt1)
        var fab:FloatingActionButton =findViewById(R.id.btn1)
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        var count:LiveData<Int> = mainActivityViewModel.getInitialcount()
        count.observe(this, Observer {

            txt1.setText("Count is "+it)

        })

        fab.setOnClickListener {
            mainActivityViewModel.getCurrentCount()
        }

        val student = Student("Le Thanh Hai", 1," Ahi")
        val student1 = Student("Le Thanh Hai 2", 4," Chi")
        val student2 = Student("Le Thanh Hai 3", 5," Bhi")
        val student3 = Student("Le Thanh Hai 4", 3," Ehi")
        mList.add(student)
        mList.add(student1)
        mList.add(student2)
        mList.add(student3)
        test(mList)

    }

    private fun test(data:MutableList<ViewItem>) {

        val data2 = data.filter {
            it.type == 1
        }.sortedBy {
            it.imageUrl
        }

        data2.forEach {
            Log.d("hailpt", " ~~ ${it.nameByLanguage}")
        }
    }
}
