package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.google.firebase.database.DatabaseReference;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;
import istanbul.gamelab.ngdroid.util.VirtualJoystick;


/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */


public class GameCanvas extends BaseCanvas {
    //Array Variables

    static int FIRSTELEMENT = 0, SECONDELEMENT = 1, THIRDELEMENT = 2, FOURTHELEMENT = 3, FIFTHELEMENT = 4; //Array Element Sequence
    static int IDLE = 0, WALK = 1, RUN = 2, TOTAL_ANIMATIONNUM = 3;
    static int RIGHT = 0, LEFT = 1, UP = 2, DOWN = 3, ALL = 4, TOTAL_DIRECTION = 5;

    private Object backgraund, chemist;
    private Bitmap[][] animations;
    private int[][] touchPoint; //Touch Activites Points and Id

    private VirtualJoystick virtualJoystick;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        initializeVariables();
    }

    public void update() {
        chemist.move(virtualJoystick.move(touchPoint), 0);
    }

    public void draw(Canvas canvas) {
        backgraund.draw(canvas);
        chemist.draw(canvas);
        virtualJoystick.drawJoystick(canvas, root, RIGHT);
        virtualJoystick.drawJoystick(canvas, root, LEFT);
        root.gui.drawText(canvas, "FPS: " + root.appManager.getFrameRate() + " / " + root.appManager.getFrameRateTarget(), getWidth()/10, getHeight()/15, 0);
    }

    /**
     * This method assigns initial values, called from setup method.
     *
     */
    public void initializeVariables() {
        //TouchPoint Variables
        touchPoint = new int[3][3];

        //Animations
        animations = new Bitmap[TOTAL_ANIMATIONNUM][10];

        //VirtualJoystick Variables
        virtualJoystick = new VirtualJoystick();

        //Background Variables
        backgraund = new Object();
        backgraund.setObject(Utils.loadImage(root,"background2.png"));
        backgraund.setSourceW(backgraund.getObject().getWidth());
        backgraund.setSourceH(backgraund.getObject().getHeight());
        backgraund.setDestinationW(getWidth());
        backgraund.setDestinationH(getHeight());
        backgraund.setSource();
        backgraund.setDestination();

        //Chemist Variables
        chemist = new Object();
        chemist.setObject(Utils.loadImage(root,"Run1.png"));
        chemist.setSourceW(chemist.getObject().getWidth());
        chemist.setSourceH(chemist.getObject().getHeight());
        chemist.setDestinationW(root.proportionWidth(64));
        chemist.setDestinationH(root.proportionHeight(64));
        chemist.setDestinationY((getHeight() / 11) - chemist.getDestinationH());
        chemist.setSource();
        chemist.setDestination();
        chemist.setVelocityX(15);

        //Run Animation
        animations[RUN][0] = Utils.loadImage(root,"Run1.png");
        animations[RUN][1] = Utils.loadImage(root,"Run2.png");
        animations[RUN][2] = Utils.loadImage(root,"Run3.png");
        animations[RUN][3] = Utils.loadImage(root,"Run4.png");
        animations[RUN][4] = Utils.loadImage(root,"Run5.png");
        animations[RUN][5] = Utils.loadImage(root,"Run6.png");
        animations[RUN][6] = Utils.loadImage(root,"Run7.png");
        animations[RUN][7] = Utils.loadImage(root,"Run8.png");
        animations[RUN][8] = Utils.loadImage(root,"Run9.png");
        animations[RUN][9] = Utils.loadImage(root,"Run10.png");

        //Idle Animation
        animations[IDLE][0] = Utils.loadImage(root,"Idle1.png");
        animations[IDLE][1] = Utils.loadImage(root,"Idle2.png");
        animations[IDLE][2] = Utils.loadImage(root,"Idle3.png");
        animations[IDLE][3] = Utils.loadImage(root,"Idle4.png");
        animations[IDLE][4] = Utils.loadImage(root,"Idle5.png");
        animations[IDLE][5] = Utils.loadImage(root,"Idle6.png");
        animations[IDLE][6] = Utils.loadImage(root,"Idle7.png");
        animations[IDLE][7] = Utils.loadImage(root,"Idle8.png");
        animations[IDLE][8] = Utils.loadImage(root,"Idle9.png");
        animations[IDLE][9] = Utils.loadImage(root,"Idle10.png");

        //Set Object Animations
        chemist.setAnimations(animations);
    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y, int id) {
        touchPoint[id][FIRSTELEMENT] = x;
        touchPoint[id][SECONDELEMENT] = y;
        touchPoint[id][THIRDELEMENT] = 0;
    }

    public void touchMove(int x, int y, int id) {
        touchPoint[id][FIRSTELEMENT] = x;
        touchPoint[id][SECONDELEMENT] = y;
        touchPoint[id][THIRDELEMENT] = 0;
    }

    public void touchUp(int x, int y, int id) {
        touchPoint[id][FIRSTELEMENT] = x;
        touchPoint[id][SECONDELEMENT] = y;
        touchPoint[id][THIRDELEMENT] = 1;
    }


    public void pause() {

    }


    public void resume() {

    }


    public void reloadTextures() {

    }


    public void showNotify() {
    }

    public void hideNotify() {
    }

}
