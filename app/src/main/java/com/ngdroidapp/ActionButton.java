package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

public class ActionButton {

    static int NULL = -1, TOUCHDOWN = 0, TOUCHUP = 1, TOUCHMOVE = 2;

    private Bitmap Button;
    private Rect source, destination;
    private int sourceX, sourceY, sourceW, sourceH, destinationX, destinationY, destinationW, destinationH;
    private int firstElement, secontElement, thirdElement;
    private int firstFrameNum, lastFrameNum, frameNum;
    private int[] touchIndex;

    protected NgApp root;

    public ActionButton(NgApp ngApp) {
        root = ngApp;
        source = new Rect();
        destination = new Rect();
        touchIndex = new int[2];
        sourceX = 0;
        sourceY = 0;
        sourceW = 0;
        sourceH = 0;
        destinationX = 0;
        destinationY = 0;
        destinationW = 0;
        destinationH = 0;
        firstElement = 0;
        secontElement = 1;
        thirdElement = 2;
        firstFrameNum = 0;
        lastFrameNum = 0;
        frameNum = 0;
    }

    public Bitmap getButton() {
        return Button;
    }

    public void setButton(Bitmap actionButton) {
        this.Button = actionButton;
    }

    public Rect getSource() {
        return source;
    }

    public void setSource() {
        source.set(sourceX, sourceY, sourceX + sourceW, sourceY + sourceH);
    }

    public Rect getDestination() {
        return destination;
    }

    public void setDestination() {
        destination.set(root.proportionWidth(destinationX), root.proportionHeight(destinationY), root.proportionWidth(destinationX + destinationW), root.proportionHeight(destinationY + destinationH));
    }

    public int getSourceX() {
        return sourceX;
    }

    public void setSourceX(int sourceX) {
        this.sourceX = sourceX;
    }

    public int getSourceY() {
        return sourceY;
    }

    public void setSourceY(int sourceY) {
        this.sourceY = sourceY;
    }

    public int getSourceW() {
        return sourceW;
    }

    public void setSourceW(int sourceW) {
        this.sourceW = sourceW;
    }

    public int getSourceH() {
        return sourceH;
    }

    public void setSourceH(int sourceH) {
        this.sourceH = sourceH;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    public int getDestinationW() {
        return destinationW;
    }

    public void setDestinationW(int destinationW) {
        this.destinationW = destinationW;
    }

    public int getDestinationH() {
        return destinationH;
    }

    public void setDestinationH(int destinationH) {
        this.destinationH = destinationH;
    }

public int[] touch(int[][] touchPoint){
    for (int i = 0; i < touchPoint.length; i++) {
        if (touchPoint[i][firstElement] >= destinationX && touchPoint[i][firstElement] <= destinationX + destinationW && touchPoint[i][thirdElement] == TOUCHDOWN) {
            if (touchPoint[i][secontElement] >= destinationY && touchPoint[i][secontElement] <= destinationY + destinationH) {
                touchIndex[firstElement] = i;
                touchIndex[secontElement] = TOUCHDOWN;
                return touchIndex;
            }
        } else if (touchPoint[i][firstElement] >= destinationX && touchPoint[i][firstElement] <= destinationX + destinationW && touchPoint[i][thirdElement] == TOUCHUP) {
            if (touchPoint[i][secontElement] >= destinationY && touchPoint[i][secontElement] <= destinationY + destinationH) {
                touchIndex[firstElement] = i;
                touchIndex[secontElement] = TOUCHUP;
                return touchIndex;
            }
        } else if (touchPoint[i][firstElement] >= destinationX && touchPoint[i][firstElement] <= destinationX + destinationW && touchPoint[i][thirdElement] == TOUCHMOVE) {
            if (touchPoint[i][secontElement] >= destinationY && touchPoint[i][secontElement] <= destinationY + destinationH) {
                touchIndex[firstElement] = i;
                touchIndex[secontElement] = TOUCHMOVE;
                return touchIndex;
            }
        }
    }
    touchIndex[firstElement] = NULL;
    touchIndex[secontElement] = NULL;
    return touchIndex;
}
    public void drawButton(Canvas canvas) {
        canvas.drawBitmap(Button, source, destination, null);
    }

    public void playAnimation(Bitmap[] animation) {
        lastFrameNum = animation.length;
        if(frameNum >= lastFrameNum) {
            frameNum = firstFrameNum;
        }
        Button = animation[frameNum];
        frameNum++;
    }
}
