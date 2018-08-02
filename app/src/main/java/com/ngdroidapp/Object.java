package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */

public class Object {
    private Bitmap object;
    private Rect source, destination;
    private int sourceX, sourceY, sourceW, sourceH, destinationX, destinationY, destinationW, destinationH;
    private int iX,iY, velocityX, velocityY;
    private int firstFrameNum, lastFrameNum, frameNum;

    protected NgApp root;

    public Object(NgApp ngApp) {
        root = ngApp;
        source = new Rect();
        destination = new Rect();
        sourceX = 0;
        sourceY = 0;
        sourceW = 0;
        sourceH = 0;
        destinationX = 0;
        destinationY = 0;
        destinationW = 0;
        destinationH = 0;
        iX = 0;
        iY = 1;
        velocityX = 0;
        velocityY = 0;
        firstFrameNum = 0;
        lastFrameNum = 0;
        frameNum = 0;
    }

    public Bitmap getObject() {
        return object;
    }

    public void setObject(Bitmap object) {
        this.object = object;
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

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velecityX) {
        this.velocityX = velecityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(object, source, destination, null);
    }

    public void move(int[] index, Bitmap[] animation) {
        destinationX += velocityX * index[iX];
        destinationY += velocityY * index[iY];
        setDestination();
        playAnimation(animation);
    }

    public void playAnimation(Bitmap[] animation) {
        lastFrameNum = animation.length;
        if(frameNum >= lastFrameNum) {
            frameNum = firstFrameNum;
        }
        object = animation[frameNum];
        frameNum++;
    }
}
