package com.example.nettyhttp2bug

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component
import org.springframework.util.unit.DataSize
import reactor.netty.http.server.HttpServer

//@Component
class NettyWebServerFactoryPortCustomizer(
  @Value("\${server.max-http-request-header-size}") val maxSize: DataSize
) : WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    override fun customize(serverFactory: NettyReactiveWebServerFactory) {
        serverFactory.addServerCustomizers(Http2Customizer(maxSize.toBytes()))
    }
}


private class Http2Customizer(val maxSize: Long) : NettyServerCustomizer {
    override fun apply(httpServer: HttpServer): HttpServer {
        return httpServer.http2Settings{b -> b.maxHeaderListSize(maxSize)}
    }
}
