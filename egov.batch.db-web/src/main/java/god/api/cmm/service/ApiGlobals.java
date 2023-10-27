package god.api.cmm.service;

import org.springframework.core.env.Environment;

public class ApiGlobals {

    private static String serverPort;

    private static String springApplicationName;

    public static void createApiGlobals(final Environment environment) {
        serverPort = environment.getProperty("server.port");

        springApplicationName = environment.getProperty("spring.application.name");
    }

    public static String getServerPort() {
        return serverPort;
    }

    public static String getSpringApplicationName() {
        return springApplicationName;
    }

}
