package com.example.nettyhttp2bug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NettyHttp2BugApplication

fun main(args: Array<String>) {
	runApplication<NettyHttp2BugApplication>(*args)
}
