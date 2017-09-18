package com.example.recyclerviewmore;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class MyItemDecoration extends ItemDecoration{
	
	private int orientation;
	
	private static final int VERTICAL=LinearLayoutManager.VERTICAL;
	private static final int HORIZONTAL=LinearLayoutManager.HORIZONTAL;
	private Drawable mdivider;
	private int[] attrs=new int[]{android.R.attr.listDivider};

	public MyItemDecoration(Context context,int orientation){
		this.orientation=orientation;
		TypedArray ta=context.obtainStyledAttributes(attrs);
		mdivider=ta.getDrawable(0);
	}

	@Override
	public void onDraw(Canvas c, RecyclerView parent) {
		// TODO Auto-generated method stub
		if(orientation==VERTICAL){
			drawVertical(c, parent);
		}
		if(orientation==HORIZONTAL){
			drawHorizotal(c, parent);
		}
		super.onDraw(c, parent);
	}
	
	
	@Override
	public void getItemOffsets(Rect outRect, int itemPosition,
			RecyclerView parent) {
		// TODO Auto-generated method stub
		
		if(orientation==VERTICAL){
			outRect.set(0, 0, 0, mdivider.getIntrinsicHeight());
		}
		if(orientation==HORIZONTAL){
			outRect.set(0, 0, mdivider.getIntrinsicWidth(),0);

		}
		super.getItemOffsets(outRect, itemPosition, parent); 
	}
	
	
	public void drawVertical(Canvas c, RecyclerView parent){
		int left=parent.getPaddingLeft();
		int right=parent.getWidth()-parent.getPaddingRight();
		int count=parent.getChildCount();
		for(int i=0;i<count;i++){
			
			View child=parent.getChildAt(i);
			LayoutParams params=(LayoutParams) child.getLayoutParams();
			int top=child.getBottom()+params.bottomMargin;
			
			int bottom=top+mdivider.getIntrinsicHeight();
			mdivider.setBounds(left, top, right, bottom);
			mdivider.draw(c);
		}
	}
    public void drawHorizotal(Canvas c, RecyclerView parent){
		int top=parent.getPaddingTop();
		int bottom=parent.getHeight()-parent.getPaddingBottom();
		
		int count=parent.getChildCount();
		for(int i=0;i<count;i++){
			View child=parent.getChildAt(i);
			LayoutParams params=(LayoutParams) child.getLayoutParams();
            
			int left=child.getRight()+params.rightMargin;
			int right=left+mdivider.getIntrinsicWidth();
			mdivider.setBounds(left, top, right, bottom);
			mdivider.draw(c);
		}
	}
    
	
	
    
}
