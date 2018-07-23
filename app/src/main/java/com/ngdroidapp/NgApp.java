package com.ngdroidapp;

import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseActivity;
import istanbul.gamelab.ngdroid.core.AppManager;
import istanbul.gamelab.ngdroid.base.BaseApp;
import istanbul.gamelab.ngdroid.util.Log;


/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */

public class NgApp extends BaseApp {

    public NgApp(BaseActivity nitraBaseActivity, AppManager appManager) {
        super(nitraBaseActivity, appManager);
    }


    public void setup() {
        MenuCanvas mc = new MenuCanvas(this);
        canvasManager.setCurrentCanvas(mc);
        android.util.Log.i("NgApp", "setup: ");
    }


    public void update() {

    }

    public void draw(Canvas canvas) {

    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void touchDown(int x, int y, int id) {

    }

    public void touchMove(int x, int y, int id) {

    }

    public void touchUp(int x, int y, int id) {

    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void pause() {
        Log.i("NGAPP", "pause");
    }

    public void resume() {
        Log.i("NGAPP", "resume");
    }

    public void reloadTextures() {
        Log.i("NGAPP", "reloadTextures");
    }
}
