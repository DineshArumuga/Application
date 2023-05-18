#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jintArray JNICALL Java_com_example_myapplication_MainActivity_setarray(JNIEnv *env,jobject,jint start,jint end,jint num)
{
    //Step 1: Create a new jintArray java Array
    jintArray  jarray = env->NewIntArray(num);
    //Step 2: Create a new c++ array
    jint array[] = {1,2,3,4,5};
    //Step 3: To copy the value from C++ to Java array
    env->SetIntArrayRegion(jarray,start,end,array);
    return jarray;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_myapplication_MainActivity_getarray(JNIEnv *env, jobject , jintArray array) {
   //Step 1: Lenght of the java array
   jint len = env->GetArrayLength(array);
   jint sum = 0;
    //Step 2: Create a new c++ array
    jint carray[5];
    //step 3: To copy the value from Java array to C++ array
    env->GetIntArrayRegion(array,0,len,carray);
    for(jint i =0;i<len;i++)
    {
        sum = sum + carray[i];
    }
    return sum;
}