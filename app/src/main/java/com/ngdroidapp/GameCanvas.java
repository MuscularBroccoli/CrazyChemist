package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Utils;


/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */


public class GameCanvas extends BaseCanvas {

    static int FIRSTELEMENT = 0, SECONDELEMENT = 1, THIRDELEMENT = 2, FOURTHELEMENT = 3, FIFTHELEMENT = 4; //Array Element Sequence
    static int NULL = -1, TOUCHDOWN = 0, TOUCHUP = 1, TOUCHMOVE = 2;
    static int X = 0, Y = 1;

    private Object backgraund, chemist;
    private Bitmap[] idle, run;
    private int[][] touchPoint; //Touch Activites Points and Id
    private int[] index;
    private int id;

    private ActionButton rightJoystick, leftJoystick, upJoystick, downJoystick;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        initializeVariables();
    }

    public void update() {
        moveChemist();
    }

    public void draw(Canvas canvas) {
        backgraund.draw(canvas);
        chemist.draw(canvas);
        rightJoystick.drawButton(canvas);
        leftJoystick.drawButton(canvas);
        upJoystick.drawButton(canvas);
        downJoystick.drawButton(canvas);
        root.gui.drawText(canvas, "FPS: " + root.appManager.getFrameRate() + " / " + root.appManager.getFrameRateTarget(), getWidth()/10, getHeight()/15, 0);
    }

    /**
     * This method move chemist.
     *
     */
    public void moveChemist(){
        if(rightJoystick.touch(touchPoint)[SECONDELEMENT] == TOUCHDOWN || rightJoystick.touch(touchPoint)[SECONDELEMENT] == TOUCHMOVE && chemist.getVelocityX() > 0) {
            Log.i("GameCanvas", "id: " + rightJoystick.touch(touchPoint)[0] + "index: " + rightJoystick.touch(touchPoint)[1]);
            index[X] = 1;
            chemist.move(index,run);
        } else if(leftJoystick.touch(touchPoint)[SECONDELEMENT] == TOUCHDOWN || leftJoystick.touch(touchPoint)[SECONDELEMENT] == TOUCHMOVE && chemist.getVelocityX() > 0) {
            Log.i("GameCanvas", "id: " + leftJoystick.touch(touchPoint)[0] + "index: " + leftJoystick.touch(touchPoint)[1]);
            index[X] = -1;
            chemist.move(index,run);
        } else if(downJoystick.touch(touchPoint)[SECONDELEMENT] == TOUCHDOWN && chemist.getVelocityX() > 0) {
            index[Y] = 1;
            id = downJoystick.touch(touchPoint)[0];
            chemist.move(index,run);
            touchPoint[id][FIRSTELEMENT] = NULL;
            touchPoint[id][SECONDELEMENT] = NULL;
            touchPoint[id][THIRDELEMENT] = NULL;
        } else if(upJoystick.touch(touchPoint)[SECONDELEMENT] == TOUCHDOWN && chemist.getVelocityX() > 0) {
            index[Y] = -1;
            id = upJoystick.touch(touchPoint)[0];
            chemist.move(index,run);
            touchPoint[id][FIRSTELEMENT] = NULL;
            touchPoint[id][SECONDELEMENT] = NULL;
            touchPoint[id][THIRDELEMENT] = NULL;
        } else {
            index[X] = 0;
            index[Y] = 0;
            chemist.move(index,idle);
        }
    }

    /**
     * This method assigns initial values, called from setup method.
     *
     */
    public void initializeVariables() {
        //Touch Point Id
        id = 0;
        //Index Variables
        index = new int[3];

        //TouchPoint Variables
        touchPoint = new int[3][3];
        for (int i = 0; i < touchPoint.length; i++) {
            touchPoint[i][FIRSTELEMENT] = -1;
            touchPoint[i][SECONDELEMENT] = -1;
            touchPoint[i][THIRDELEMENT] = -1;
        }

        //Rigt ActionButton
        rightJoystick = new ActionButton(root);
        rightJoystick.setButton(Utils.loadImage(root,"arrowRight.png"));
        rightJoystick.setSourceW(rightJoystick.getButton().getWidth());
        rightJoystick.setSourceH(rightJoystick.getButton().getHeight());
        rightJoystick.setDestinationX(192);
        rightJoystick.setDestinationY(945);
        rightJoystick.setDestinationW(rightJoystick.getSourceW());
        rightJoystick.setDestinationH(rightJoystick.getSourceH());
        rightJoystick.setSource();
        rightJoystick.setDestination();

        //Left ActionButton
        leftJoystick = new ActionButton(root);
        leftJoystick.setButton(Utils.loadImage(root,"arrowLeft.png"));
        leftJoystick.setSourceW(leftJoystick.getButton().getWidth());
        leftJoystick.setSourceH(leftJoystick.getButton().getHeight());
        leftJoystick.setDestinationX(192 - 80);
        leftJoystick.setDestinationY(945);
        leftJoystick.setDestinationW(leftJoystick.getSourceW());
        leftJoystick.setDestinationH(leftJoystick.getSourceH());
        leftJoystick.setSource();
        leftJoystick.setDestination();

        //Up ActionButton
        upJoystick = new ActionButton(root);
        upJoystick.setButton(Utils.loadImage(root,"arrowUp.png"));
        upJoystick.setSourceW(upJoystick.getButton().getWidth());
        upJoystick.setSourceH(upJoystick.getButton().getHeight());
        upJoystick.setDestinationX(152);
        upJoystick.setDestinationY(865);
        upJoystick.setDestinationW(upJoystick.getSourceW());
        upJoystick.setDestinationH(upJoystick.getSourceH());
        upJoystick.setSource();
        upJoystick.setDestination();

        //Down ActionButton
        downJoystick = new ActionButton(root);
        downJoystick.setButton(Utils.loadImage(root,"arrowDown.png"));
        downJoystick.setSourceW(downJoystick.getButton().getWidth());
        downJoystick.setSourceH(downJoystick.getButton().getHeight());
        downJoystick.setDestinationX(152);
        downJoystick.setDestinationY(1025);
        downJoystick.setDestinationW(downJoystick.getSourceW());
        downJoystick.setDestinationH(downJoystick.getSourceH());
        downJoystick.setSource();
        downJoystick.setDestination();

        //Background Variables
        backgraund = new Object(root);
        backgraund.setObject(Utils.loadImage(root,"background2.png"));
        backgraund.setSourceW(backgraund.getObject().getWidth());
        backgraund.setSourceH(backgraund.getObject().getHeight());
        backgraund.setDestinationW(1920);
        backgraund.setDestinationH(1080);
        backgraund.setSource();
        backgraund.setDestination();

        //Chemist Variables
        chemist = new Object(root);
        chemist.setObject(Utils.loadImage(root,"Run1.png"));
        chemist.setSourceW(chemist.getObject().getWidth());
        chemist.setSourceH(chemist.getObject().getHeight());
        chemist.setDestinationW(1920/19);
        chemist.setDestinationH(1080/11);
        chemist.setDestinationX(0);
        chemist.setDestinationY(0);
        chemist.setSource();
        chemist.setDestination();
        chemist.setVelocityX(15);
        chemist.setVelocityY(15);

        //Idle Animation
        idle = new Bitmap[10];
        idle[0] = Utils.loadImage(root,"Idle1.png");
        idle[1] = Utils.loadImage(root,"Idle2.png");
        idle[2] = Utils.loadImage(root,"Idle3.png");
        idle[3] = Utils.loadImage(root,"Idle4.png");
        idle[4] = Utils.loadImage(root,"Idle5.png");
        idle[5] = Utils.loadImage(root,"Idle6.png");
        idle[6] = Utils.loadImage(root,"Idle7.png");
        idle[7] = Utils.loadImage(root,"Idle8.png");
        idle[8] = Utils.loadImage(root,"Idle9.png");
        idle[9] = Utils.loadImage(root,"Idle10.png");

        //Run Animation
        run = new Bitmap[10];
        run[0] = Utils.loadImage(root,"Run1.png");
        run[1] = Utils.loadImage(root,"Run2.png");
        run[2] = Utils.loadImage(root,"Run3.png");
        run[3] = Utils.loadImage(root,"Run4.png");
        run[4] = Utils.loadImage(root,"Run5.png");
        run[5] = Utils.loadImage(root,"Run6.png");
        run[6] = Utils.loadImage(root,"Run7.png");
        run[7] = Utils.loadImage(root,"Run8.png");
        run[8] = Utils.loadImage(root,"Run9.png");
        run[9] = Utils.loadImage(root,"Run10.png");
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
        touchPoint[id][THIRDELEMENT] = TOUCHDOWN;
    }

    public void touchMove(int x, int y, int id) {
        touchPoint[id][FIRSTELEMENT] = x;
        touchPoint[id][SECONDELEMENT] = y;
        touchPoint[id][THIRDELEMENT] = TOUCHMOVE;
    }

    public void touchUp(int x, int y, int id) {
        touchPoint[id][FIRSTELEMENT] = x;
        touchPoint[id][SECONDELEMENT] = y;
        touchPoint[id][THIRDELEMENT] = TOUCHUP;
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
