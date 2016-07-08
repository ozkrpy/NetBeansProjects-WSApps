/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ozkrp
 */
@WebService(serviceName = "add")
public class add {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addOperation")
    public int addOperation(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        int c = a + b;
        return c;
    }
}
