package com.handmark.pulltorefresh.library.widget.listslidedelete;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class ListViewCompatMyPaper extends ListView implements OnGestureListener{

    private static final String TAG = "ListViewCompatMyPaper";

    private SlideView mFocusedItemView;

    public ListViewCompatMyPaper(Context context) {
        super(context);
    }

    public ListViewCompatMyPaper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewCompatMyPaper(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void shrinkListItem(int position) {
        View item = getChildAt(position);

        if (item != null) {
            try {
                ((SlideView) item).shrink();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN: {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int position = pointToPosition(x, y);
            Log.e(TAG, "postion=" + position);
            if (position != INVALID_POSITION) {
                MyPaperItem data = (MyPaperItem) getItemAtPosition(position);
                mFocusedItemView = data.slideView;
                Log.e(TAG, "FocusedItemView=" + mFocusedItemView);
            }
        }
        default:
            break;
        }

        if (mFocusedItemView != null) {
            mFocusedItemView.onRequireTouchEvent(event);
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub
        
    }

    final int RIGHT = 0;  
    final int LEFT = 1;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,  
            float velocityY) {  
        float x = e2.getX() - e1.getX();  
//        float y = e2.getY() - e1.getY();  

        if (x > 0) {  
            doResult(RIGHT);  
        } else if (x < 0) {  
            doResult(LEFT);  
        }  
        return true;  
    }  
    
    public void doResult(int action) {  
        
        switch (action) {  
        case RIGHT:  
            System.out.println("go right");  
            
            break;  
  
        case LEFT:  
            System.out.println("go right");  
            break;  
  
        }  
    } 
    

}
