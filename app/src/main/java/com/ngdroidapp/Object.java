package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */

public class Object {

    static int IDLE = 0, WALK = 1, RUN = 2, TOTAL_ANIMATION = 3, TOTAL_FRAMENUM = 10;

    private Bitmap object;
    private Bitmap[][] animations;
    private Rect source, destination;
    private int sourceX, sourceY, sourceW, sourceH, destinationX, destinationY, destinationW, destinationH;
    private int indexX, indexY, velocityX, velocityY;
    private int firstFrameNum, lastFrameNum, frameNum;

    public Object() {
        source = new Rect();
        destination = new Rect();
        animations = new Bitmap[TOTAL_ANIMATION][10];
        sourceX = 0;
        sourceY = 0;
        sourceW = 0;
        sourceH = 0;
        destinationX = 0;
        destinationY = 0;
        destinationW = 0;
        destinationH = 0;
        indexX = 0;
        indexY = 0;
        velocityX = 0;
        velocityY = 0;
        firstFrameNum = 0;
        lastFrameNum = 0;
        frameNum = 0;
    }

    public Bitmap[][] getAnimations() {
        return animations;
    }

    public void setAnimations(Bitmap[][] animations) {
        this.animations = animations;
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
        destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
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

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
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

    public void move(int indexX, int indexY) {
        if(indexX == 0 && indexY == 0) {
            playAnimation(IDLE);
        }

        if(indexX == 1) {
            destinationX += velocityX * indexX;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
            playAnimation(RUN);
        } else if(indexX == -1) {
            destinationX += velocityX * indexX;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
            playAnimation(RUN);
        }

        if(indexY == 1) {
            destinationY += velocityY * indexY;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
            playAnimation(RUN);
        } else if(indexY == -1) {
            destinationY += velocityY * indexY;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
            playAnimation(RUN);
        }
    }

    public void move(int velocityX, int velocityY, int indexX, int indexY) {
        if(indexX == 1) {
            destinationX += velocityX * indexX;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
        } else if(indexX == -1) {
            destinationX += velocityX * indexX;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
        }

        if(indexY == 1) {
            destinationY += velocityY * indexY;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
        } else if(indexY == -1) {
            destinationY += velocityY * indexY;
            destination.set(destinationX, destinationY, destinationX + destinationW, destinationY + destinationH);
        }
    }

    public void playAnimation(int animation) {
        lastFrameNum = animations[animation].length;
        frameNum++;
        if(frameNum >= TOTAL_FRAMENUM) {
            frameNum = firstFrameNum;
        }
        object = animations[animation][frameNum];
    }
}
