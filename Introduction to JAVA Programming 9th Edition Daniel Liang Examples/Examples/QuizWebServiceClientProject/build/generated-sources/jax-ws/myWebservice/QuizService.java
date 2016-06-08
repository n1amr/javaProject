
package myWebservice;

import java.util.List;
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
@WebService(name = "QuizService", targetNamespace = "http://chapter45/")
@XmlSeeAlso({
				ObjectFactory.class
})
public interface QuizService {


	/**
	 *
	 */
	@WebMethod
	@RequestWrapper(localName = "generateQuiz", targetNamespace = "http://chapter45/", className = "myWebservice.GenerateQuiz")
	@ResponseWrapper(localName = "generateQuizResponse", targetNamespace = "http://chapter45/", className = "myWebservice.GenerateQuizResponse")
	@Action(input = "http://chapter45/QuizService/generateQuizRequest", output = "http://chapter45/QuizService/generateQuizResponse")
	public void generateQuiz();

	/**
	 * @return returns java.util.List<java.lang.String>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "getQuestions", targetNamespace = "http://chapter45/", className = "myWebservice.GetQuestions")
	@ResponseWrapper(localName = "getQuestionsResponse", targetNamespace = "http://chapter45/", className = "myWebservice.GetQuestionsResponse")
	@Action(input = "http://chapter45/QuizService/getQuestionsRequest", output = "http://chapter45/QuizService/getQuestionsResponse")
	public List<String> getQuestions();

	/**
	 * @param arg0
	 * @return returns java.util.List<java.lang.Boolean>
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "gradeQuiz", targetNamespace = "http://chapter45/", className = "myWebservice.GradeQuiz")
	@ResponseWrapper(localName = "gradeQuizResponse", targetNamespace = "http://chapter45/", className = "myWebservice.GradeQuizResponse")
	@Action(input = "http://chapter45/QuizService/gradeQuizRequest", output = "http://chapter45/QuizService/gradeQuizResponse")
	public List<Boolean> gradeQuiz(
					@WebParam(name = "arg0", targetNamespace = "")
									List<Boolean> arg0);

}