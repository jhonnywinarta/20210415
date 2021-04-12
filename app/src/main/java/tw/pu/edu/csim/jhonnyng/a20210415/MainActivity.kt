package tw.pu.edu.csim.jhonnyng.a20210415

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    lateinit var gDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
       /*tvx.text = "作者:黃裕洳
        if (txv.text == "靜宜之美"){
            txv.text = "螢幕觸控"
        }
        else{
            txv.text = "靜宜之美"
        }
        txv.text = "x=" + event?.x.toString() + "\ny=" + event?.y.toString()*/
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(
        p0: MotionEvent?
    ): Boolean {
        txv.text = "Press Down"
        return true
    }

    override fun onSingleTapUp(
        p0: MotionEvent?
    ): Boolean {
        txv.text = "Single Tap"
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        txv.text = "Long Press"
    }

    override fun onShowPress(p0: MotionEvent?) {
        txv.text = "Show Press"
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        txv.text = "Scroll\nx1y1: " +  e1.getX().toString() + ", " + e1.getY().toString() +
                "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString()
        return true
    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        txv.text = "FastSlide\nx1y1: " + e1.getX().toString() + ", " + e1.getY().toString() +
                "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString() +
                "\nX-axis Y-axis speed:" + velocityX.toString() + ", " +  velocityY.toString()
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        txv.text = "Double Tap"
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        return true
    }

}