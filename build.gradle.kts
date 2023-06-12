plugins{
    java
    idea
}
repositories {
    mavenCentral()
}


dependencies{
    implementation("org.redisson:redisson:3.22.0")
    runtimeOnly("io.netty:netty-resolver-dns-native-macos:4.1.93.Final:osx-aarch_64")
    implementation ("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0")
    implementation ("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation ("org.apache.logging.log4j:log4j-core:2.20.0")
}