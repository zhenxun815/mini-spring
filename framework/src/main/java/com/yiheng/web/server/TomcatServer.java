package com.yiheng.web.server;

import com.yiheng.web.servlet.TestServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Yiheng
 * @since 2021/12/27 10:54
 */
public class TomcatServer {
    private Tomcat tomcat;
    private String[] args;

    public TomcatServer(String[] args) {
        this.args = args;
    }

    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(8899);
        tomcat.start();

        StandardContext context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        TestServlet testServlet = new TestServlet();
        Tomcat.addServlet(context, "testServlet", testServlet).setAsyncSupported(true);

        context.addServletMappingDecoded("/test", "testServlet");
        tomcat.getHost().addChild(context);

        Thread awaitThread = new Thread("") {
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };

        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
