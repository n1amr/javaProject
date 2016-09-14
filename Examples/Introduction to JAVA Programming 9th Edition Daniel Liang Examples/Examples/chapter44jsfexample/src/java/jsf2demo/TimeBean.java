package jsf2demo;

@ManagedBean
@RequestScoped
public class TimeBean {
  public String getTime() {
    return new java.util.Date().toString();
  }
}
