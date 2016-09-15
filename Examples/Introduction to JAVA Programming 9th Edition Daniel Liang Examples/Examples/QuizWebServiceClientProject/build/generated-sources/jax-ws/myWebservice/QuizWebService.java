package myWebservice;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.3-b01-
 * Generated source version: 2.2
 */
@WebServiceClient(name = "QuizWebService", targetNamespace = "http://chapter45/", wsdlLocation = "http://localhost:8080/WebServiceProject/QuizWebService?WSDL")
public class QuizWebService
    extends Service {

  private final static URL QUIZWEBSERVICE_WSDL_LOCATION;
  private final static WebServiceException QUIZWEBSERVICE_EXCEPTION;
  private final static QName QUIZWEBSERVICE_QNAME = new QName("http://chapter45/", "QuizWebService");

  static {
    URL url = null;
    WebServiceException e = null;
    try {
      url = new URL("http://localhost:8080/WebServiceProject/QuizWebService?WSDL");
    } catch (MalformedURLException ex) {
      e = new WebServiceException(ex);
    }
    QUIZWEBSERVICE_WSDL_LOCATION = url;
    QUIZWEBSERVICE_EXCEPTION = e;
  }

  public QuizWebService() {
    super(__getWsdlLocation(), QUIZWEBSERVICE_QNAME);
  }

  public QuizWebService(WebServiceFeature... features) {
    super(__getWsdlLocation(), QUIZWEBSERVICE_QNAME, features);
  }

  public QuizWebService(URL wsdlLocation) {
    super(wsdlLocation, QUIZWEBSERVICE_QNAME);
  }

  public QuizWebService(URL wsdlLocation, WebServiceFeature... features) {
    super(wsdlLocation, QUIZWEBSERVICE_QNAME, features);
  }

  public QuizWebService(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
  }

  public QuizWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
    super(wsdlLocation, serviceName, features);
  }

  /**
   * @return returns QuizService
   */
  @WebEndpoint(name = "QuizServicePort")
  public QuizService getQuizServicePort() {
    return super.getPort(new QName("http://chapter45/", "QuizServicePort"), QuizService.class);
  }

  /**
   * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
   * @return returns QuizService
   */
  @WebEndpoint(name = "QuizServicePort")
  public QuizService getQuizServicePort(WebServiceFeature... features) {
    return super.getPort(new QName("http://chapter45/", "QuizServicePort"), QuizService.class, features);
  }

  private static URL __getWsdlLocation() {
    if (QUIZWEBSERVICE_EXCEPTION != null) {
      throw QUIZWEBSERVICE_EXCEPTION;
    }
    return QUIZWEBSERVICE_WSDL_LOCATION;
  }

}