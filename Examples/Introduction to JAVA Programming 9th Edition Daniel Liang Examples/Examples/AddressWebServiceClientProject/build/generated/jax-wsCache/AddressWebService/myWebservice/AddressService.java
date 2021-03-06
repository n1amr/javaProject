package myWebservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.3-b01-
 * Generated source version: 2.2
 */
@WebService(name = "AddressService", targetNamespace = "http://chapter45/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AddressService {


  /**
   * @param arg1
   * @param arg0
   * @return returns myWebservice.Address
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(localName = "getAddress", targetNamespace = "http://chapter45/", className = "myWebservice.GetAddress")
  @ResponseWrapper(localName = "getAddressResponse", targetNamespace = "http://chapter45/", className = "myWebservice.GetAddressResponse")
  @Action(input = "http://chapter45/AddressService/getAddressRequest", output = "http://chapter45/AddressService/getAddressResponse")
  public Address getAddress(
      @WebParam(name = "arg0", targetNamespace = "")
          String arg0,
      @WebParam(name = "arg1", targetNamespace = "")
          String arg1);

  /**
   * @param arg0
   */
  @WebMethod
  @RequestWrapper(localName = "storeAddress", targetNamespace = "http://chapter45/", className = "myWebservice.StoreAddress")
  @ResponseWrapper(localName = "storeAddressResponse", targetNamespace = "http://chapter45/", className = "myWebservice.StoreAddressResponse")
  @Action(input = "http://chapter45/AddressService/storeAddressRequest", output = "http://chapter45/AddressService/storeAddressResponse")
  public void storeAddress(
      @WebParam(name = "arg0", targetNamespace = "")
          Address arg0);

  /**
   *
   */
  @WebMethod
  @RequestWrapper(localName = "initializeJdbc", targetNamespace = "http://chapter45/", className = "myWebservice.InitializeJdbc")
  @ResponseWrapper(localName = "initializeJdbcResponse", targetNamespace = "http://chapter45/", className = "myWebservice.InitializeJdbcResponse")
  @Action(input = "http://chapter45/AddressService/initializeJdbcRequest", output = "http://chapter45/AddressService/initializeJdbcResponse")
  public void initializeJdbc();

}
