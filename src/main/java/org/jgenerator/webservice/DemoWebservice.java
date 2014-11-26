/**
 * 
 */
package org.jgenerator.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.stereotype.Repository;

/**
 * @author LIZHITAO
 * 
 */
@WebService
@SOAPBinding(style = Style.RPC)
@Repository
public class DemoWebservice {

	public int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
		return a + b;
	}
}