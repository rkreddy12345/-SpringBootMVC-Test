package com.bootmvc.controller;

import com.bootmvc.entity.Employee;
import com.bootmvc.service.EmpCRUDServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class EmpCRUDOperationsController {
    @Autowired
    private EmpCRUDServiceImpl crudService;

    @GetMapping ( "/" )
    public String showHome ( ) {
        return "homePage";
    }

    @GetMapping ( "/data" )
    public String showAllEmployees ( Map < String, Object > map ) {
        List < Employee > employeeList = (List < Employee >) crudService.getAllEmployees ();
        map.put("empCount", employeeList.size ());
        map.put ( "empList", employeeList );
        return "empDetailsPage";
    }

    @GetMapping("/add")
    public String launchForm(@ModelAttribute("employee") Employee emp){
        return "addEmpForm";
    }

    @PostMapping("/save")
    public String saveEmployee( @ModelAttribute("emp") Employee employee, RedirectAttributes attributes ){
        attributes.addFlashAttribute( "message", crudService.saveEmployee ( employee ) );
        return "redirect:data";
    }
    @GetMapping("/updateForm")
    public String getEmployeeForUpdate( @RequestParam("idNo") Integer id, @ModelAttribute("emp") Employee employee ){
        BeanUtils.copyProperties ( crudService.getEmployeeByID ( id ), employee );
        return "updateEmpForm";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("emp") Employee employee, RedirectAttributes attributes){
        attributes.addFlashAttribute ( "message",crudService.updateEmployee ( employee ) );
        return "redirect:data";
    }

    @GetMapping("/delete")
    public  String deleteEmployee(@RequestParam("idNo") Integer id, RedirectAttributes attributes){
        attributes.addFlashAttribute ( "message", crudService.deleteEmployeeByID ( id )  );
        return "redirect:data";
    }


}
