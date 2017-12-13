package rn.yann.com.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View

class KotlinActivity : AppCompatActivity() ,View.OnKeyListener{

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }

    override fun onPause() {
        super.onPause()
    }

    inner class Inner {
        fun foo(){
            println("addjda")
        }
    }

    interface MyInterface{
        fun bar()
        fun foo(){
            println("foo")
        }
    }
}
