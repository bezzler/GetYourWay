package com.qa.controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qa.paymentPlans.PaymentPlanService;
import com.qa.userAccounts.MongoUserDetails;
import com.qa.userAccounts.MongoUserService;

@Controller
public class SearchController {

	MongoUserService mongoUserService;
	PaymentPlanService paymentPlanService;

	@Autowired
	public SearchController(MongoUserService mongoUserService,
			PaymentPlanService paymentPlayService) {
		System.out.println("main_controller_init");
		this.mongoUserService = mongoUserService;
		this.paymentPlanService = paymentPlayService;
	}

	@RequestMapping(value = "/Search.uspr")
	public void search(HttpServletRequest request,
			HttpServletResponse response,
			@AuthenticationPrincipal MongoUserDetails activeUser)
			throws Exception {

		if (mongoUserService.checkUserInDate(activeUser)) {

			if (request.getParameter("mode").equals("DrivingResults")) {
				RequestDispatcher rd = request.getRequestDispatcher("drivingResults.jsp");
				rd.forward(request, response);
				
			} else if (request.getParameter("mode").equals("Flights")) {
				RequestDispatcher rd = request.getRequestDispatcher("flightResults.jsp");
				rd.forward(request, response);
				
			} else {
				throw new Exception("Bad flight mode: "
						+ request.getParameter("mode"));
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("choosePlan.spr");
			rd.forward(request, response);
		}
	}
}
