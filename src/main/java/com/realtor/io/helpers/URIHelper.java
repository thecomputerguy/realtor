package com.realtor.io.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

@Component
@AllArgsConstructor
@Builder
public class URIHelper {

    Environment environment;
    public URI getUri(String protocol, String path) throws UnknownHostException {
        StringBuilder builder = new StringBuilder();
        builder.append(protocol)
                .append(InetAddress.getLocalHost().getHostName())
                .append(environment.getProperty("server.port"))
                .append(environment.getProperty("server.servlet.context-path"))
                .append(path);
        return URI.create(builder.toString());
    }
}
