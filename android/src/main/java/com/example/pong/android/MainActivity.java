package com.example.pong.android;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.pong.android.module.AndroidModule;

import android.os.Bundle;

import org.example.pong.core.SimplePong;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class MainActivity extends AndroidApplication {

    @Inject
    SimplePong pong;

    @Inject
    AndroidApplicationConfiguration configuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObjectGraph objectGraph = ObjectGraph.create(AndroidModule.class);

        this.initialize(this.pong, this.configuration);
    }
}