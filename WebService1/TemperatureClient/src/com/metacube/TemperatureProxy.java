package com.metacube;

public class TemperatureProxy implements com.metacube.Temperature {
  private String _endpoint = null;
  private com.metacube.Temperature temperature = null;
  
  public TemperatureProxy() {
    _initTemperatureProxy();
  }
  
  public TemperatureProxy(String endpoint) {
    _endpoint = endpoint;
    _initTemperatureProxy();
  }
  
  private void _initTemperatureProxy() {
    try {
      temperature = (new com.metacube.TemperatureServiceLocator()).getTemperature();
      if (temperature != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)temperature)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)temperature)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (temperature != null)
      ((javax.xml.rpc.Stub)temperature)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.Temperature getTemperature() {
    if (temperature == null)
      _initTemperatureProxy();
    return temperature;
  }
  
  public double tempConverter(double fahrenheit) throws java.rmi.RemoteException{
    if (temperature == null)
      _initTemperatureProxy();
    return temperature.tempConverter(fahrenheit);
  }
  
  
}