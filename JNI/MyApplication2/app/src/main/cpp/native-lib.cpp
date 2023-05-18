#include <jni.h>
#include <string>



extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_MainActivity_add(JNIEnv *, jobject , jdouble a, jdouble b) {
    return a+b;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_MainActivity_sub(JNIEnv *, jobject , jdouble a, jdouble b) {

    return a-b;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_MainActivity_mul(JNIEnv *, jobject , jdouble a, jdouble b) {

    return a*b;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_MainActivity_div(JNIEnv *, jobject , jdouble a, jdouble b) {

    return a/b;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_overloading_add__DDD(JNIEnv *, jobject , jdouble a, jdouble b,jdouble c=7) {
    return a+b+c;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_overloading_add__DD(JNIEnv *, jobject , jdouble a, jdouble b) {
    return a+b;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_myapplication_overloading_add__D(JNIEnv *, jobject , jdouble a) {
    return a;
}

