package com.n1amr;

import java.awt.Color;
import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class JavaDoc {
	/**
	 * <h1>Hello, World!</h1> The HelloWorld program implements an application
	 * that simply displays "Hello World!" to the standard output.
	 * <p>
	 * Describtion This method is used to add two integers. This is a the
	 * simplest form of a class method, just to show the usage of various
	 * javadoc Tags.
	 *
	 * @author Zara Ali
	 * @version 1.0
	 * @since 2014-03-31
	 * 
	 * @param numA
	 *            This is the first paramter to addNum method
	 * @param numB
	 *            This is the second parameter to addNum method
	 * @return int This returns sum of numA and numB.
	 * @throws JavaDoc
	 *             <p>
	 *             CodeFont: {@code JavaApp m = new JavaApp();}
	 * 
	 * @deprecated deprecated-text
	 * @exception class
	 *                -name description
	 *                <p> * {@docRoot}
	 * @see reference {@link com.n1amr.JavaDoc#addNum(int, int) addNum()}
	 *      {@linkplain} com.n1amr.JavaApp#addNum(int, int) addNum()}
	 * @serial field-description | include | exclude
	 * @serialData data-description
	 * @serialField
	 *                  field-name field-type field-description
	 */
	public int addNum(int numA, int numB) {
		return numA + numB;
	}

	final int x = 1;

	public static void main(String[] args) {
		JavaDoc m = new JavaDoc();
	}
}