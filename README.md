#setup

=======================================================

 1. install java 1.8
 2. install Maven `brew install maven`
 3. cd into packages and run `mvn clean install`
 4. install Junit
 5. Install java IDE - IntelliJ

#Install packages

=======================================================

1. `brew upgrade`
2. `brew install node`
3. `brew install selenium-server-standalone -g`
4. `npm install backbone.marionette -g`
5. `npm installselenium-standaldone@latest -g`
6. `selenium-standalone install`
7. `npm install appium -g`

#mobile

=======================================================

1. install android adb using brew cask
2. install android emulator
3. run adb devices
4. run adb shell then `dumpsys window windows | grep -E 'mCurrentFocus'` (http://www.automationtestinghub.com/apppackage-and-appactivity-name/) Bird app package co.bird.android app activity co.bird.android.app.feature.magiclink.activity.MagicLinkIntroActivity