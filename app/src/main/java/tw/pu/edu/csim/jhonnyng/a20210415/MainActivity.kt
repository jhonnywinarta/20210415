package tw.pu.edu.csim.jhonnyng.a20210415

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener,
    View.OnTouchListener {

    lateinit var gDetector: GestureDetector
    var PictureNo: Int = 0  //目前顯示第幾張圖
    var TotalPictures: Int = 4 //總共幾張圖片(假設僅顯示pu0-pu3)

    fun ShowPicture() {
        /*
        when (PictureNo){
            0 -> img.setImageResource(R.drawable.pu0)
            1 -> img.setImageResource(R.drawable.pu1)
            2 -> img.setImageResource(R.drawable.pu2)
            3 -> img.setImageResource(R.drawable.pu3)
        }
        */
        var res: Int = getResources().getIdentifier(
            "pu" + (PictureNo),
            "drawable", getPackageName()
        )
        img.setImageResource(res)

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gDetector = GestureDetector(this, this)
        img.setOnTouchListener(this)

        var res: Int = -1
        var countDrawables: Int = -1
        while (res != 0) {
            countDrawables++;
            res = getResources().getIdentifier(
                "pu" + (countDrawables),
                "drawable", getPackageName()
            );
        }
        TotalPictures = countDrawables
    }
        override fun onDown(
            p0: MotionEvent?
        ): Boolean {
            /*txv.text = "Press Down"*/
            return true
        }

        override fun onSingleTapUp(
            p0: MotionEvent?
        ): Boolean {
            /*txv.text = "Single Tap"*/
            return true
        }

        override fun onLongPress(
            p0: MotionEvent?
        ) {
            /*txv.text = "Long Press"*/
            PictureNo = TotalPictures - 1
            ShowPicture()

        }

        override fun onShowPress(p0: MotionEvent?) {
            //txv.text = "Show Press"
        }

        override fun onScroll(
            e1: MotionEvent,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            /*txv.text = "Scroll\nx1y1: " +  e1.getX().toString() + ", " + e1.getY().toString() +
                    "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString()*/
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            /*txv.text = "FastSlide\nx1y1: " + e1.getX().toString() + ", " + e1.getY().toString() +
                    "\nx2y2: " + e2.getX().toString() + ", " + e2.getY().toString() +
                    "\nX-axis Y-axis speed:" + velocityX.toString() + ", " +  velocityY.toString()*/
            if (e1.getX() < e2.getX()) {  //向右快滑
                PictureNo++
                if (PictureNo == TotalPictures) {
                    PictureNo = 0
                }
            } else {     //向左快滑
                PictureNo--;
                if (PictureNo < 0) {
                    PictureNo = TotalPictures - 1
                }
            }
            ShowPicture()
            return true
        }

        override fun onDoubleTap(p0: MotionEvent?): Boolean {
            return true
        }

        override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
            /*txv.text = "Double Tap"*/
            return true
        }

        override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
            return true
        }

}

/*override fun onTouchEvent(event: MotionEvent?): Boolean {
   tvx.text = "作者:黃裕洳
    if (txv.text == "靜宜之美"){
        txv.text = "螢幕觸控"
    }
    else{
        txv.text = "靜宜之美"
    }
    txv.text = "x=" + event?.x.toString() + "\ny=" + event?.y.toString()
    gDetector.onTouchEvent(event)
    return true
}
*/



