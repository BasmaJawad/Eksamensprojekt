package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class dataController {

  DataService dataService = new DataService();

  @PostMapping("/addContract")
  public String addContract(WebRequest req) {
     dataService.addContract(req);
    return "dataHomepage";
  }


}
