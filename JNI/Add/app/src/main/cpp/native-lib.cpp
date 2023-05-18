#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_add_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */,jint a) {

    return a;
}