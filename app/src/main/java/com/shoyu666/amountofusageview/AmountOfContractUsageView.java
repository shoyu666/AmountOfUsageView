package com.shoyu666.amountofusageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
/**
 * Created by n on 2016/11/17.
 */

public class AmountOfContractUsageView extends View {
    private static final int RoundRectColor = 0xFF9dbbf6;
    private static final int ProcessRectColor = 0xFFe4edff;
    private static final int VerticalLineColor = 0xFFb6cbf3;
    private static final int VerticalLineColor2 = RoundRectColor;
    private static final int VerticalLineStrokeWidth = MDP_PX.dip2px(1);
    private static final int VerticalLineStrokeWidth2 = MDP_PX.dip2px(2);
    private static final int RectLineStrokeWidth = MDP_PX.dip2px(1);
    private static final int Round = MDP_PX.dip2px(30);
    private static final int PaddingLeft = MDP_PX.dip2px(28);
    private static final int PaddingRight = MDP_PX.dip2px(28);
    private static final int PaddingTop = MDP_PX.dip2px(20);
    private static final int PaddingBottom = MDP_PX.dip2px(10);
    private static final int InerRectPadding = MDP_PX.dip2px(4);
    private static final int VerticalLinePadding = MDP_PX.dip2px(10);
    private static final int VerticalLineSpace = MDP_PX.dip2px(8);
    private static final int VerticalLineHeight = MDP_PX.dip2px(5);
    private static final int VerticalLineHeight2 = MDP_PX.dip2px(7);
    private float VerticalLineTopYStop;
    private float VerticalLineTopYStop2;
    private float VerticalLineBootomYStart;
    private float VerticalLineBootomYStart2;
    private Paint roundRectPaint;
    private Paint VerticalLinePaint;
    private Paint VerticalLinePaint2;
    private Paint roundRectPercentPaint;
    private Paint repair;
    private RectF roundRectOutF;
    private RectF roundRectInF;
    private RectF RectPercentRightF;
    private RectF repairRectF;

    public void setPercent(final float percent) {
        if(this.getWidth()==0){
            this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
                @Override
                public void onGlobalLayout() {
                    initRectPercentF(percent,false);
                }
            });
        }else{
            initRectPercentF(percent,true);
        }
    }

    public void initRectPercentF(float percent,boolean inva){
        RectPercentRightF.left = PaddingLeft + InerRectPadding;
        RectPercentRightF.right = (this.getWidth() - PaddingRight - InerRectPadding) * percent;
        RectPercentRightF.top = PaddingTop + InerRectPadding;
        RectPercentRightF.bottom = this.getHeight() - PaddingBottom - InerRectPadding;
        if(inva)
        this.invalidate();
    }

    public AmountOfContractUsageView(Context context) {
        super(context);
        init();
    }

    public AmountOfContractUsageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AmountOfContractUsageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public AmountOfContractUsageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public void init() {
        roundRectPaint = new Paint();
        roundRectPaint.setColor(RoundRectColor);
        roundRectPaint.setAntiAlias(true);
        roundRectPaint.setStrokeWidth(RectLineStrokeWidth);
        roundRectPaint.setStyle(Paint.Style.STROKE);
        //
        roundRectPercentPaint = new Paint();
        roundRectPercentPaint.setColor(ProcessRectColor);
        roundRectPercentPaint.setAntiAlias(true);
        roundRectPercentPaint.setStrokeWidth(RectLineStrokeWidth);
        roundRectPercentPaint.setStyle(Paint.Style.FILL);
        //
        repair = new Paint();
        repair.setColor(Color.WHITE);
        repair.setAntiAlias(true);
        repair.setStyle(Paint.Style.STROKE);
        //
        VerticalLinePaint = new Paint();
        VerticalLinePaint.setColor(VerticalLineColor);
        VerticalLinePaint.setAntiAlias(true);
        VerticalLinePaint.setStrokeWidth(VerticalLineStrokeWidth);
        VerticalLinePaint.setStyle(Paint.Style.FILL);
        //
        VerticalLinePaint2 = new Paint();
        VerticalLinePaint2.setColor(VerticalLineColor2);
        VerticalLinePaint2.setAntiAlias(true);
        VerticalLinePaint2.setStrokeWidth(VerticalLineStrokeWidth2);
        VerticalLinePaint2.setStyle(Paint.Style.FILL);
        //
        roundRectOutF = new RectF();
        roundRectInF = new RectF();
        RectPercentRightF = new RectF();
        repairRectF = new RectF();
    }

    public void initRoundRectF() {
        roundRectOutF.left = PaddingLeft;
        roundRectOutF.right = this.getWidth() - PaddingRight;
        roundRectOutF.top = PaddingTop;
        roundRectOutF.bottom = this.getHeight() - PaddingBottom;
        //
        roundRectInF.left = PaddingLeft + InerRectPadding;
        roundRectInF.right = this.getWidth() - PaddingRight - InerRectPadding;
        roundRectInF.top = PaddingTop + InerRectPadding;
        roundRectInF.bottom = this.getHeight() - PaddingBottom - InerRectPadding;
        //
        repairRectF.left = roundRectOutF.left + RectLineStrokeWidth;
        repairRectF.right = roundRectOutF.right - RectLineStrokeWidth;
        repairRectF.top = roundRectOutF.top + RectLineStrokeWidth;
        repairRectF.bottom = roundRectOutF.bottom - RectLineStrokeWidth;
        //
        repair.setStrokeWidth(InerRectPadding - RectLineStrokeWidth);
        //
        VerticalLineTopYStop = VerticalLineHeight + roundRectInF.top;
        VerticalLineBootomYStart = roundRectInF.bottom - VerticalLineHeight;
        //
        VerticalLineTopYStop2 = VerticalLineHeight2 + roundRectInF.top;
        VerticalLineBootomYStart2 = roundRectInF.bottom - VerticalLineHeight2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (roundRectOutF.isEmpty()) {
            initRoundRectF();
        }
        if (RectPercentRightF.left > 0) {
            canvas.drawRect(RectPercentRightF, roundRectPercentPaint);
        }
        canvas.drawRoundRect(repairRectF, Round, Round, repair);
        //
        canvas.drawRoundRect(roundRectInF, Round, Round, roundRectPaint);
        canvas.drawRoundRect(roundRectOutF, Round, Round, roundRectPaint);
        //
        drawTopBottomLine(canvas);
    }

    private void drawTopBottomLine(Canvas canvas) {
        float start = roundRectInF.left + 2 * VerticalLinePadding;
        float end = roundRectInF.right - VerticalLinePadding;
        int count = 1;
        while (start < end) {
            if (count % 10 == 0) {
                canvas.drawLine(start, roundRectInF.top, start, VerticalLineTopYStop2, VerticalLinePaint2);
            } else {
                canvas.drawLine(start, roundRectInF.top, start, VerticalLineTopYStop, VerticalLinePaint);
            }
            if (count % 20 == 0) {
                canvas.drawLine(start, VerticalLineBootomYStart2, start, roundRectInF.bottom, VerticalLinePaint2);
            } else {
                canvas.drawLine(start, VerticalLineBootomYStart, start, roundRectInF.bottom, VerticalLinePaint);
            }
            start = start + VerticalLineSpace;
            count++;
        }
    }
}
