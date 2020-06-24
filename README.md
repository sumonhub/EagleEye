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
                implementation 'com.github.SumonHub:EagleEye:1.0.0'
        }
        
# To-do

## Enable EagleEye
      
* If you do not override the Application class, edit your manifest file to set android:name in the <application> tag as follows:

      <?xml version="1.0" encoding="utf-8"?>
      <manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="com.example.myapp">
          <application
                  android:name="org.sumon.eagleeye.EagleEyeApplication" >
              ...
          </application>
      </manifest>

* If you do override the Application class, change it to extend EagleEyeApplication (if possible) as follows:

      public class MyApplication extends EagleEyeApplication { ... }

## Use

* In youre activity/fragment get status like below

      EagleEyeObserver.setConnectivityListener(new OnChangeConnectivityListener() {
          @Override
          public void onChanged(boolean status) {
              Toast.makeText(MainActivity.this, "" + status, Toast.LENGTH_SHORT).show();
          }
      });
      
## Check out example code: [Example](https://github.com/user/repo/blob/branch/other_file.md)

# Demo
![](https://github.com/SumonHub/EagleEye/blob/master/preview/demo.gif)
