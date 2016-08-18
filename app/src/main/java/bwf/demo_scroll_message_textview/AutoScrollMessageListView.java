package bwf.demo_scroll_message_textview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/8/13.
 */
public class AutoScrollMessageListView extends ListView{

    public AutoScrollMessageListView(Context context) {
        super(context);
    }

    public AutoScrollMessageListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    private Timer timer;
    private TimerTask task;
    public void startTask(long delay,long period,final int duration){
        if(task == null){
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    post(new Runnable() {
                        @Override
                        public void run() {
                            smoothScrollBy(getChildAt(0).getHeight(),duration);
                        }
                    });
                }
            };
            timer.schedule(task,delay,period);
        }
    }
    public void stopTask(){
        if(task != null){
            task.cancel();
            task = null;
            timer.cancel();
            timer = null;
        }
    }
}
