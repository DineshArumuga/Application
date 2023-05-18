#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}



extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_process(
        JNIEnv* env,
        jobject mainActivityInstance/* this */) {
    const jclass mainActivityCls = env->GetObjectClass(mainActivityInstance);
    const jmethodID jmethodId = env->GetMethodID(mainActivityCls,"processInJava",
                                                 "()Ljava/lang/String;");
    if(jmethodId == nullptr){
        return env->NewStringUTF("");
    }

    const jobject result = env->CallObjectMethod(mainActivityInstance,jmethodId);
    const std::string java_msg = env->GetStringUTFChars((jstring) result,JNI_FALSE);
    const std::string c_msg = "Result from Java => ";
    const std::string strCat_msg = c_msg + java_msg;

    return env->NewStringUTF(strCat_msg.c_str());
}


