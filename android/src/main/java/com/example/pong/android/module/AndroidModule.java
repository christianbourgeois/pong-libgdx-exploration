package com.example.pong.android.module;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.pong.android.MainActivity;

import org.example.pong.core.module.PongModule;

import dagger.Module;
import dagger.Provides;

@Module(includes = PongModule.class, injects = MainActivity.class, library = true)
public class AndroidModule {

    @Provides
    public AndroidApplicationConfiguration provideConfiguration() {
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGL20 = true;
        config.useAccelerometer = false;
        config.useCompass = false;
        return config;
    }
}
