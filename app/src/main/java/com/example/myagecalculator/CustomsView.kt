package com.example.myagecalculator

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
//    private var shapeWidth = 100
//    private var shapeHeight = 100

    // private val pointPosition: PointF = PointF(0.0f, 0.0f)

//    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
//        style = Paint.Style.FILL_AND_STROKE
//        textAlign = Paint.Align.CENTER
//        textSize = 55.0f
//        typeface = Typeface.create("", Typeface.NORMAL)
//        color = Color.WHITE
//    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 5000
        val desiredHeight = 5000

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.UNSPECIFIED -> desiredWidth
            else -> widthSize.coerceAtMost(desiredWidth)
        }

        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.UNSPECIFIED -> desiredHeight
            else -> heightSize.coerceAtMost(desiredHeight)
        }

        setMeasuredDimension(width, height)
    }


    private val grayPaint = Paint().also { it.color = Color.GRAY }
    private val redPaint = Paint().also { it.color = Color.RED }
    var percent: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    private val rects = listOf(
        RectF(0F, 0F, 100F, 100F),
        RectF(105F, 0F, 205F, 100F),
        RectF(210F, 0F, 310F, 100F),
        RectF(315F, 0F, 415F, 100F),
        RectF(420F, 0F, 520F, 100F),
        RectF(525F, 0F, 625F, 100F),
        RectF(630F, 0F, 730F, 100F),
        RectF(735F, 0F, 835F, 100F),
        RectF(840F, 0F, 940F, 100F),
        RectF(945F, 0F, 1045F, 100F),
        RectF(0F, 105F, 100F, 200F),
        RectF(105F, 105F, 205F, 200F),
        RectF(210F, 105F, 310F, 200F),
        RectF(315F, 105F, 415F, 200F),
        RectF(420F, 105F, 520F, 200F),
        RectF(525F, 105F, 625F, 200F),
        RectF(630F, 105F, 730F, 200F),
        RectF(735F, 105F, 835F, 200F),
        RectF(840F, 105F, 940F, 200F),
        RectF(945F, 105F, 1045F, 200F),
        RectF(0F, 205F, 100F, 300F),
        RectF(105F, 205F, 205F, 300F),
        RectF(210F, 205F, 310F, 300F),
        RectF(315F, 205F, 415F, 300F),
        RectF(420F, 205F, 520F, 300F),
        RectF(525F, 205F, 625F, 300F),
        RectF(630F, 205F, 730F, 300F),
        RectF(735F, 205F, 835F, 300F),
        RectF(840F, 205F, 940F, 300F),
        RectF(945F, 205F, 1045F, 300F),
        RectF(0F, 305F, 100F, 400F),
        RectF(105F, 305F, 205F, 400F),
        RectF(210F, 305F, 310F, 400F),
        RectF(315F, 305F, 415F, 400F),
        RectF(420F, 305F, 520F, 400F),
        RectF(525F, 305F, 625F, 400F),
        RectF(630F, 305F, 730F, 400F),
        RectF(735F, 305F, 835F, 400F),
        RectF(840F, 305F, 940F, 400F),
        RectF(945F, 305F, 1045F, 400F),
        RectF(0F, 405F, 100F, 500F),
        RectF(105F, 405F, 205F, 500F),
        RectF(210F, 405F, 310F, 500F),
        RectF(315F, 405F, 415F, 500F),
        RectF(420F, 405F, 520F, 500F),
        RectF(525F, 405F, 625F, 500F),
        RectF(630F, 405F, 730F, 500F),
        RectF(735F, 405F, 835F, 500F),
        RectF(840F, 405F, 940F, 500F),
        RectF(945F, 405F, 1045F, 500F),
        RectF(0F, 505F, 100F, 600F),
        RectF(105F, 505F, 205F, 600F),
        RectF(210F, 505F, 310F, 600F),
        RectF(315F, 505F, 415F, 600F),
        RectF(420F, 505F, 520F, 600F),
        RectF(525F, 505F, 625F, 600F),
        RectF(630F, 505F, 730F, 600F),
        RectF(735F, 505F, 835F, 600F),
        RectF(840F, 505F, 940F, 600F),
        RectF(945F, 505F, 1045F, 600F),
        RectF(0F, 605F, 100F, 700F),
        RectF(105F, 605F, 205F, 700F),
        RectF(210F, 605F, 310F, 700F),
        RectF(315F, 605F, 415F, 700F),
        RectF(420F, 605F, 520F, 700F),
        RectF(525F, 605F, 625F, 700F),
        RectF(630F, 605F, 730F, 700F),
        RectF(735F, 605F, 835F, 700F),
        RectF(840F, 605F, 940F, 700F),
        RectF(945F, 605F, 1045F, 700F),
        RectF(0F, 705F, 100F, 800F),
        RectF(105F, 705F, 205F, 800F),
        RectF(210F, 705F, 310F, 800F),
        RectF(315F, 705F, 415F, 800F),
        RectF(420F, 705F, 520F, 800F),
        RectF(525F, 705F, 625F, 800F),
        RectF(630F, 705F, 730F, 800F),
        RectF(735F, 705F, 835F, 800F),
        RectF(840F, 705F, 940F, 800F),
        RectF(946F, 705F, 1045F, 800F),
        RectF(0F, 805F, 100F, 900F),
        RectF(105F, 805F, 205F, 900F),
        RectF(210F, 805F, 310F, 900F),
        RectF(315F, 805F, 415F, 900F),
        RectF(420F, 805F, 520F, 900F),
        RectF(525F, 805F, 625F, 900F),
        RectF(630F, 805F, 730F, 900F),
        RectF(735F, 805F, 835F, 900F),
        RectF(840F, 805F, 940F, 900F),
        RectF(946F, 805F, 1045F, 900F),
        RectF(0F, 905F, 100F, 1000F),
        RectF(105F, 905F, 205F, 1000F),
        RectF(210F, 905F, 310F, 1000F),
        RectF(315F, 905F, 415F, 1000F),
        RectF(420F, 905F, 520F, 1000F),
        RectF(525F, 905F, 625F, 1000F),
        RectF(630F, 905F, 730F, 1000F),
        RectF(735F, 905F, 835F, 1000F),
        RectF(840F, 905F, 940F, 1000F),
        RectF(946F, 905F, 1045F, 1000F),
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let { canva ->
            rects.forEachIndexed { index, rectF ->
                canva.drawRect(rectF, if (index < percent) redPaint else grayPaint)
            }
        }
    }
}