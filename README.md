# EagleEye
Live internet check via EagleEye.

[![](https://jitpack.io/v/SumonHub/EagleEye.svg)](https://jitpack.io/#SumonHub/EagleEye)

# Gradle Dependency
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

      allprojects {
          repositories {
            ...
            maven { url 'https://jitpack.io' }
          }
        }
Step 2. Add the dependency
      
      dependencies {
                implementation 'com.github.SumonHub:EagleEye:latest-version'
        }
        
# To-do

## Enable EagleEye
      
* If you do not override the Application class, edit your manifest file to set android:name in the <application> tag as follows:

      <?xml version="1.0" encoding="utf-8"?>
      <manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="com.example.myapp">
          <application
                  android:name="org.sumon.eagleeye.EagleEyeApp" >
              ...
          </application>
      </manifest>

* If you do override the Application class, change it to extend EagleEyeApplication (if possible) as follows:

      public class MyApplication extends App { ... }

## Use

* In your activity/fragment get status like below

      EagleEye.getStatus(this, new OnChangeConnectivityListener() {
                  @Override
                  public void onChanged(boolean status) {
                      Log.d(TAG, "onChanged status: " + status);
                  }
              });
      
## Check out example code: [Example](https://github.com/SumonHub/EagleEye/tree/master/app)

# Demo
![](https://github.com/SumonHub/EagleEye/blob/master/preview/demo.gif)
