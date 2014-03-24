package com.haos.service.server;

import javax.xml.ws.Endpoint;

import com.haos.service.server.order.impl.OrderInfoWebServiceImpl;
public class Server {
    protected Server() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        //EmployeeInfoServiceImpl implementor = new EmployeeInfoServiceImpl();
        OrderInfoWebServiceImpl implementor = new OrderInfoWebServiceImpl();
        //SendInfoServiceImpl implementor = new SendInfoServiceImpl();
        String address = "http://www.haos.com:8080/haos";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }
    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");
        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}