/**
 * TemperatureServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube;

public class TemperatureServiceLocator extends org.apache.axis.client.Service implements com.metacube.TemperatureService {

    public TemperatureServiceLocator() {
    }


    public TemperatureServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TemperatureServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Temperature
    private java.lang.String Temperature_address = "http://localhost:8080/TemperatureServer/services/Temperature";

    public java.lang.String getTemperatureAddress() {
        return Temperature_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TemperatureWSDDServiceName = "Temperature";

    public java.lang.String getTemperatureWSDDServiceName() {
        return TemperatureWSDDServiceName;
    }

    public void setTemperatureWSDDServiceName(java.lang.String name) {
        TemperatureWSDDServiceName = name;
    }

    public com.metacube.Temperature getTemperature() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Temperature_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTemperature(endpoint);
    }

    public com.metacube.Temperature getTemperature(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.TemperatureSoapBindingStub _stub = new com.metacube.TemperatureSoapBindingStub(portAddress, this);
            _stub.setPortName(getTemperatureWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTemperatureEndpointAddress(java.lang.String address) {
        Temperature_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.Temperature.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.TemperatureSoapBindingStub _stub = new com.metacube.TemperatureSoapBindingStub(new java.net.URL(Temperature_address), this);
                _stub.setPortName(getTemperatureWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Temperature".equals(inputPortName)) {
            return getTemperature();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://metacube.com", "TemperatureService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://metacube.com", "Temperature"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Temperature".equals(portName)) {
            setTemperatureEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
