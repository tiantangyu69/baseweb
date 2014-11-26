/**
 * 
 */
package org.jgenerator.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author LIZHITAO
 * 
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface IComplexUserService {
	int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b);
}
