package org.springframework.samples.mvc.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * View Rendering class
 *
 */

@Controller
@RequestMapping("/views/*")
public class ViewsController {
	/**
	 * HTML generated by JSP template
	 * @param model
	 * @return
	 */
	@RequestMapping(value="html", method=RequestMethod.GET)
	public String prepare(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		return "views/html";
	}

	/**
	 * DefaultRequestToViewNameTranslator convention
	 * 响应后跳转的页面：http://localhost:8080/views/viewName
	 * @param model
	 */
	@RequestMapping(value="/viewName", method=RequestMethod.GET)
	public void usingRequestToViewNameTranslator(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
	}

	/**
	 *
	 * 响应后跳转的页面：http://localhost:8080/views/pathVariables/bar/apple
	 * @param foo
	 * @param fruit
	 * @return
	 */
	@RequestMapping(value="pathVariables/{foo}/{fruit}", method=RequestMethod.GET)
	public String pathVars(@PathVariable String foo, @PathVariable String fruit) {
		// No need to add @PathVariables "foo" and "fruit" to the model
		// They will be merged in the model before rendering
		return "views/html";
	}

	/**
	 * 对象绑定方式：Data binding with URI variables
	 * @param javaBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="dataBinding/{foo}/{fruit}", method=RequestMethod.GET)
	public String dataBinding(@Valid JavaBean javaBean, Model model) {
		// JavaBean "foo" and "fruit" properties populated from URI variables 
		return "views/dataBinding";
	}

}
