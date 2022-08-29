# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable
-keepattributes Signature

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#-keepclassmembers class com.cencosud.cl.jumboahora.utils.** { *; }
#-keep class com.cencosud.frameworks.commonsv1.user.data.entity.response.ResponseUser
#-printmapping outputfile.txt

# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions*

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# Default PV proguard file - use it and abuse it if its useful.
# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclassmembers
-verbose
# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some of these optimisations on its own).
# -dontoptimize #Only uncomment this if you are addressing Android 2.X or lower)
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this one from your
# project.properties file.
##########
# Maintain all attributes:
# To avoid having to add each in several different places
# below.
#
# You may need to keep Exceptions if using dynamic proxies
# (e. g. Retrofit), Signature and *Annotation* if using reflection
# (e. g. Gson's ReflectiveTypeAdapterFactory).
##########
-keepattributes Exceptions,InnerClasses,Signature,Deprecated, SourceFile,LineNumberTable,*Annotation*,EnclosingMethod
##########
# Android:
##########
##########
# Those are no longer required as this will force ProGuard to keep
# not only real app components and views, but also stuff like
# BaseFragmentActivityApi16, BaseFragmentActivityApi14,
# SupportActivity etc from being merged or removed.
# AAPT generates rules for all classes which were mentioned in XMLs.
##########
#-keep public class * extends android.app.Activity
#-keep public class * extends android.app.Application
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#-keep public class * extends android.app.backup.BackupAgentHelper
#-keep public class * extends android.preference.Preference
# Data Binding
-dontwarn android.databinding.**
-keep class android.databinding.** { *; }
#This is used if you are using onClick on the XML.. you shouldn't :-)
-keepclassmembers class * extends android.content.Context {
   public void *(android.view.View);
   public void *(android.view.MenuItem);
}
##########
# View - Gets and setters - keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
##########
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
##########
#Enums - For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
##########
-keepclassmembers enum * { *; }
##########
# Parcelables: Mantain the parcelables working
##########
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
}
-keepclassmembers class **.R$* {
    public static <fields>;
}
#############
# Serializables
#############
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
##########
# Kotlin
##########
-dontwarn kotlin.**
-dontnote kotlin.**
-keepclassmembers class **$WhenMappings {
    <fields>;
}
#Ignore null checks at runtime
-assumenosideeffects class kotlin.jvm.internal.Intrinsics {
    static void checkParameterIsNotNull(java.lang.Object, java.lang.String);
}
#############
# BottomBar (Needed to call methods via reflection to customize it)
#############
-keep class android.support.design.internal.** { *; }
#############
# WebViews
#############
# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep class android.support.v8.renderscript.** { *; }
########################################
# External Libraries
########################################
#############
# Google Play Services
#############
-keep class com.google.android.gms.* {  *; }
-dontwarn com.google.android.gms.**
-dontnote **ILicensingService
-dontnote com.google.android.gms.gcm.GcmListenerService
-dontnote com.google.android.gms.**
-dontwarn com.google.android.gms.ads.**
#############
# Android Support Lib
#############
#############
# Firebase
#############
-dontnote com.google.firebase.**
-dontwarn com.google.firebase.crash.**
##########
#############
# Retrofit
#############
-dontnote okio.**
#############
# HttpClient Legacy (Ignore) - org.apache.http legacy
#############
-dontnote android.net.http.*
-dontnote org.apache.commons.codec.**
-dontnote org.apache.http.**
##########
# Glide
##########
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}
-dontnote com.bumptech.glide.**
##########
# RxJava 2
##########
#############
# Stetho
#############
-dontnote com.facebook.stetho.**
##########
# Crashlytics:
# Adding this in to preserve line numbers so that the stack traces can be remapped
##########
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
##########
# Airbnb: Deep Linking Dispatch
##########
-keep class com.airbnb.deeplinkdispatch.** { *; }
-keep interface your.package.deeplinks.** { *; }
-keepclasseswithmembers class * {
    @your.package.deeplinks.* <methods>;
}
-dontnote com.airbnb.deeplinkdispatch.**
#############
# Carousel View
#############
-dontnote com.synnapps.carouselview.**
##########
# BlurView
##########
-dontnote eightbitlab.com.blurview.**
##########
# cwac-netsecurity
##########
-keep class com.commonsware.cwac.netsecurity.** { *; }
# Add this global rule
-keepattributes Signature
# This rule will properly ProGuard all the model classes in
# the package com.yourcompany.models. Modify to fit the structure
# of your app.
-keepclassmembers class com.app.cl.movies.utils.HandlerEntity { *; }
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}
-dontwarn org.ini4j.** # Ignore warning for missing classes in ini4j
-dontwarn javax.**
# Retrofit
-dontwarn okhttp3.**
-dontwarn okio.**
-dontnote retrofit2.Platform
-dontwarn retrofit2.PlatformJava8
-keepattributes Signature
-keepattributes Exceptions
##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
# For using GSON @Expose annotation
-keepattributes *Annotation*
# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class br.com.adley.ipubg.data.** { *; }
-keep class br.com.adley.ipubg.wrapper.** { *; }
# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
##---------------End: proguard configuration for Gson  ----------

#REALM
-keep public class * extends io.realm.RealmObject { *; }
-keepnames public class * extends io.realm.RealmObject

#MODELOS
-keep class com.cencosud.**.model.** { *; }
-keepnames class com.cencosud.**.model.**
-keep class com.cencosud.**.entity.** { *; }
-keepnames class com.cencosud.**.entity.**

#EVENTBUS
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

#CAROUSEL
-keep class com.synnapps.carouselview.** { *; }